package de.jfpgmc.ui.basketviewer;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.Window.Notification;

import de.jfpgmc.dto.Basket;
import de.jfpgmc.dto.BasketEntry;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.util.I18n;
import de.jfpgmc.util.PropertyOfNestedObject;

/**
 * Control of BasketViewer component.
 * 
 * @author Patrick Giezen
 *
 */
public class BasketViewerControl extends CustomComponent implements Observer {

	private static final long serialVersionUID = 4438576187724322075L;
	private IBasketViewerDelegate delegate;
	private BasketViewerView view;
	private BasketViewerModel model;
	private ViewDelegate viewDelegate;
	
	/**
	 * Constructor for ArticleViewerControl.#
	 * 
	 * @param delegate
	 */
	public BasketViewerControl(IBasketViewerDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}

	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IBasketViewerDelegate getDelegate() {
		return delegate;
	}
	/**
	 * 
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void attach() {
		FomShopApplication.getInstance().getBasketContext().addObserver(this);
		super.attach();
	}
	/**
	 * 
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void detach() {
		super.detach();
		FomShopApplication.getInstance().getBasketContext().deleteObserver(this);
	}
	/**
	 * 
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void update(Observable observable, Object param) {
		if (observable.equals(FomShopApplication.getInstance().getBasketContext())) {
			syncronizeBasket();
		}
	}
	/**
	 * Synchronize content of the basket
	 * 
	 */
	private void syncronizeBasket() {
		getModel().getBasketContainer().removeAllItems();
		Basket basket = FomShopApplication.getInstance().getBasketContext().getBasket();
		for (BasketEntry basketEntry : basket.getBasketEntries()) {
			if (!getModel().getBasketContainer().containsId(basketEntry)) {
				getModel().getBasketContainer().addBean(basketEntry);
			}
		}
		// calculate totalSum of basket and set into footer
		double totalSum = 0;
		for (BasketEntry basketEntry : basket.getBasketEntries()) {
			totalSum += (basketEntry.getAmount() * basketEntry
					.getArticleVariant().getNetPrice());
		}
		getView().getBasket().setColumnFooter("sum", String.valueOf(totalSum));
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private BasketViewerModel getModel() {
		if (model == null) {
			model = new BasketViewerModel();
			model.setBasketContainer(new BeanItemContainer<BasketEntry>(BasketEntry.class));
			syncronizeBasket();
		}
		return model;
	}
	/**
	 * Get view of basket, build if null.
	 * 
	 * @return the view
	 */
	
	private BasketViewerView getView() {
		if (view == null) {
			view = new BasketViewerView();
			view.getBasket().setContainerDataSource(getModel().getBasketContainer());
			view.getBasket().addGeneratedColumn("article", new PropertyOfNestedObject("articleVariant", "article.caption"));
			view.getBasket().addGeneratedColumn("articleVariant", new PropertyOfNestedObject("articleVariant", "caption"));
			view.getBasket().addGeneratedColumn("netPrice", new PropertyOfNestedObject("articleVariant", "netPrice"));
			view.getBasket().addGeneratedColumn("sum", new ColumnGenerator(){
				private static final long serialVersionUID = -6845883325753687320L;
				@SuppressWarnings("rawtypes")
				@Override
				public Object generateCell(Table source, Object itemId,
						Object columnId) {
					BasketEntry entry = (BasketEntry) ((BeanItem) source.getItem(itemId)).getBean();
					int amount = entry.getAmount();
					double netPrice = entry.getArticleVariant().getNetPrice();
					
					return new Label(String.valueOf(amount * netPrice));
				}});
			view.getBasket().setVisibleColumns(new String[] {"amount", "article", "articleVariant", "sum"});
			view.getBasket().setColumnHeaders(new String[]{I18n.getString("AMOUNT"), I18n.getString("ARTICLE"), I18n.getString("ARTICLE_VARIANT"), I18n.getString("SUM")});
			view.getBasket().setFooterVisible(true);
			view.getBasket().setColumnFooter("articleVariant", "Summe");
			view.getOrderButton().addListener(getViewDelegate());
			view.getDisposeButton().addListener(getViewDelegate());
		}
		return view;
	}
	/**
	 * Get viewDelegate, build if null.
	 * 
	 * @return the viewDelegate
	 */
	private ViewDelegate getViewDelegate() {
		if (viewDelegate == null) {
			viewDelegate = new ViewDelegate();
		}
		return viewDelegate;
	}
	
	/**
	 * Delegate to handle User interaction.
	 *
	 */
	private class ViewDelegate implements Serializable, ClickListener {
		private static final long serialVersionUID = -2489117285806087046L;

		/**
		 * Handle the event of buttons
		 * 
		 * {@inheritDoc}
		 */
		@Override
		public void buttonClick(ClickEvent event) {
			
			if (event.getButton().equals(getView().getOrderButton())) {
				
				if (FomShopApplication.getInstance().getUserContext().getUser() == null) {
					//show warning, if user wants to submit an order without being registered
					FomShopApplication
							.getInstance()
							.getMainWindow()
							.showNotification(
									I18n.getString("USER_SECURITY_EXCEPTION_MISSINGREGISTRATION"),
									Notification.TYPE_WARNING_MESSAGE);
				} else {
					//show warning, if user wants to submit an order with an empty basket
					if (FomShopApplication.getInstance().getBasketContext()
							.getBasket().getBasketEntries().isEmpty()) {

						FomShopApplication
								.getInstance()
								.getMainWindow()
								.showNotification(
										I18n.getString("USER_SECURITY_EXCEPTION_BASKETEMPTY"),
										Notification.TYPE_WARNING_MESSAGE);
					} else {
						//if user is registered and basket is not empty, submit order
						getDelegate().processOrderBasket();
					}
				}
				
				//show a button to dispose the content of the basket
			} else if (event.getButton().equals(getView().getDisposeButton())) {
				getDelegate().processDisposeBasket();
			}
		}
	}
}
