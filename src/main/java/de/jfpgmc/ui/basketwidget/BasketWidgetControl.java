package de.jfpgmc.ui.basketwidget;

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

import de.jfpgmc.dto.Basket;
import de.jfpgmc.dto.BasketEntry;
import de.jfpgmc.ui.FomShopApplication;
import de.jfpgmc.util.I18n;
import de.jfpgmc.util.PropertyOfNestedObject;

/**
 * Control of BasketWidget component.
 * 
 * @author Patrick Giezen
 *
 */
public class BasketWidgetControl extends CustomComponent implements IBasketWidget, Observer {

	private static final long serialVersionUID = 4455815902794678970L;
	private IBasketWidgetDelegate delegate;
	private BasketWidgetView view;
	private BasketWidgetModel model;
	private ViewDelegate viewDelegate;
	
	
	/**
	 * Constructor for BasketWidgetControl.
	 * 
	 * @param delegate
	 */
	public BasketWidgetControl(IBasketWidgetDelegate delegate) {
		this.delegate = delegate;
		setCompositionRoot(getView());
	}
	
	/**
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
	 * {@inheritDoc}
	 */
	@Override
	public void detach() {
		super.detach();
		FomShopApplication.getInstance().getBasketContext().deleteObserver(this);
	}
	
	/**
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
	 * Synchronizes the basket content and shows a totalSum of all basket entries
	 * 
	 */
	private void syncronizeBasket() {
		getModel().getBasketContainer().removeAllItems();
		Basket basket = FomShopApplication.getInstance().getBasketContext().getBasket();
		getModel().getBasketContainer().addAll(basket.getBasketEntries());

		// calculate totalSum of basket and set into footer
		double totalSum = 0;
		for (BasketEntry basketEntry : basket.getBasketEntries()) {
			totalSum += (basketEntry.getAmount() * basketEntry.getArticleVariant().getNetPrice());
		}
		getView().getBasket().setColumnFooter("sum", String.valueOf(totalSum));
	}
	
	/**
	 * Get view, build if null.
	 * 
	 * @return the view
	 */
	private BasketWidgetView getView() {
		if (view == null) {
			view = new BasketWidgetView();
			view.setWidth("100%");
			view.getBasket().setContainerDataSource(getModel().getBasketContainer());
			view.getOpenBasketViewer().addListener(getViewDelegate());
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
			
		}
		return view;
	}
	
	/**
	 * Get model, build if null.
	 * 
	 * @return the model
	 */
	private BasketWidgetModel getModel() {
		if (model == null) {
			model = new BasketWidgetModel();
			model.setBasketContainer(new BeanItemContainer<BasketEntry>(BasketEntry.class));
			syncronizeBasket();
		}
		return model;
	}
	
	/**
	 * Get delegate.
	 * 
	 * @return the delegate
	 */
	private IBasketWidgetDelegate getDelegate() {
		return delegate;
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
	 * shows a button to open Basket
	 * 
	 *
	 */
	private class ViewDelegate implements Serializable, ClickListener {
		private static final long serialVersionUID = 7573521608137675022L;
		@Override
		public void buttonClick(ClickEvent event) {
			getDelegate().processShowBasketDetails();
		}
	}
}
