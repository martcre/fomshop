package de.jfpgmc.ui.core;

import java.io.Serializable;
import java.util.ArrayList;

import de.jfpgmc.dto.ArticleVariant;
import de.jfpgmc.dto.Basket;
import de.jfpgmc.dto.BasketEntry;
import de.jfpgmc.dto.Order;
import de.jfpgmc.dto.OrderEntry;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.ui.basketviewer.BasketViewerControl;
import de.jfpgmc.ui.basketviewer.IBasketViewerDelegate;
import de.jfpgmc.ui.basketwidget.IBasketWidgetDelegate;

/**
 * Delegate implementing {@link IBasketViewerDelegate}, {@link IBasketWidgetDelegate}.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
public class BasketCore implements Serializable, IBasketWidgetDelegate,
		IBasketViewerDelegate {

	private static final long serialVersionUID = 4286515656328169870L;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processSetArticleVariantAmount(ArticleVariant articleVariant, int newAmount) {
		synchronized (FomShopApplication.getInstance()) {
			Basket basket = FomShopApplication.getInstance().getBasketContext().getBasket();
			boolean added = false;
			for (BasketEntry basketEntry : basket.getBasketEntries()) {
				if (basketEntry.getArticleVariant().equals(articleVariant)) {
					basketEntry.setAmount(newAmount);
					added = true;
				}
			}
			
			if (!added) {
				BasketEntry basketEntry = new BasketEntry();
				basketEntry.setAmount(newAmount);
				basketEntry.setArticleVariant(articleVariant);
				basketEntry.setBasket(FomShopApplication.getInstance().getBasketContext().getBasket());
				FomShopApplication.getInstance().getBasketContext().getBasket().getBasketEntries().add(basketEntry);
			}
			
			FomShopApplication.getInstance().getBasketContext().basketUpdated();
			FomShopApplication.getInstance().getBasketContext().notifyObservers();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processOrderBasket() {
		synchronized (FomShopApplication.getInstance()) {
			Basket basket = FomShopApplication.getInstance().getBasketContext().getBasket();
			
			Order order = new Order();
			order.setOrderEntries(new ArrayList<OrderEntry>());
			order.setCustomer(FomShopApplication.getInstance().getUserService().findCustomerByUser(FomShopApplication.getInstance().getUserContext().getUser()));
			double netTotalPrice = 0;
			for (BasketEntry basketEntry : basket.getBasketEntries()) {
				OrderEntry orderEntry = new OrderEntry();
				orderEntry.setAmount(basketEntry.getAmount());
				orderEntry.setCaption(basketEntry.getArticleVariant().getArticle().getCaption());
				orderEntry.setDescription(basketEntry.getArticleVariant().getCaption());
				orderEntry.setNetPrice(basketEntry.getArticleVariant().getNetPrice());
				orderEntry.setNetTotalPrice(basketEntry.getAmount() * basketEntry.getArticleVariant().getNetPrice());
				orderEntry.setOrder(order);
				
				order.getOrderEntries().add(orderEntry);
				netTotalPrice += orderEntry.getNetTotalPrice();
			}
			order.setNetTotalPrice(netTotalPrice);
			
			basket.getBasketEntries().clear();
			FomShopApplication.getInstance().getBasketContext().basketUpdated();
			FomShopApplication.getInstance().getBasketContext().notifyObservers();
			
			FomShopApplication.getInstance().getOrderService().createAndSubmitOrder(order);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processDisposeBasket() {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getBasketContext().getBasket().getBasketEntries().clear();
			FomShopApplication.getInstance().getBasketContext().basketUpdated();
			FomShopApplication.getInstance().getBasketContext().notifyObservers();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processShowBasketDetails() {
		synchronized (FomShopApplication.getInstance()) {
			FomShopApplication.getInstance().getLayoutView().getMainArea().removeAllComponents();
			FomShopApplication.getInstance().getLayoutView().getMainArea().addComponent(new BasketViewerControl(this));
		}
	}
}
