package de.jfpgmc.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vaadin.Application;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Window;

import de.jfpgmc.service.IArticleService;
import de.jfpgmc.service.IOrderService;
import de.jfpgmc.service.IUserService;
import de.jfpgmc.service.IWorkflowService;
import de.jfpgmc.ui.articlecategorymenu.ArticleCategoryMenuControl;
import de.jfpgmc.ui.basketwidget.BasketWidgetControl;
import de.jfpgmc.ui.context.BasketContext;
import de.jfpgmc.ui.context.UserContext;
import de.jfpgmc.ui.core.AdminCore;
import de.jfpgmc.ui.core.ArticleCore;
import de.jfpgmc.ui.core.BasketCore;
import de.jfpgmc.ui.core.UserCore;
import de.jfpgmc.ui.userinfo.UserInfoControl;
import de.jfpgmc.util.SpringUtil;

/**
 * Main application class which initializes the frontend and also acts as a service provider for the
 * cores.
 * 
 * @author Patrick Giezen, Martin Cremer
 */
@SuppressWarnings("serial")
public class FomShopApplication extends Application implements HttpServletRequestListener {
	
	/**
	 * Singleton implementation of the FomShopApplication. This allows to fetch services and cores
	 * from everywhere within the frontend.
	 */
	private static ThreadLocal<FomShopApplication> threadLocal = new ThreadLocal<FomShopApplication>();
	
	/**
	 * Utility to fetch spring beans from current context, see {@link SpringUtil}.
	 */
	private SpringUtil springUtil;
	
	/**
	 * The spring service to handle all user specifics, see {@link IUserService}. 
	 */
	private IUserService userService;
	/**
	 * The spring service to handle all article specifics, see {@link IArticleService}. 
	 */
	private IArticleService articleService;
	/**
	 * The spring service to handle all order specifics, see {@link IOrderService}. 
	 */
	private IOrderService orderService;
	/**
	 * The spring service to handle all workflow specifics, see {@link IWorkflowService}.
	 */
	private IWorkflowService workflowService;
	
	/**
	 * The basic layout for the shop, defining different areas where components can be placed.
	 * See {@link StoreLayoutView}.
	 */
	private StoreLayoutView layoutView;
	
	/**
	 * Delegate for all admin* components, see {@link AdminCore}.
	 */
	private AdminCore adminCore;
	/**
	 * Delegate for all article* components, see {@link ArticleCore}.
	 */
	private ArticleCore articleCore;
	/**
	 * Delegate for all basket* components, see {@link BasketCore}.
	 */
	private BasketCore basketCore;
	/**
	 * Delegate for all user* components, see {@link UserCore}.
	 */
	private UserCore userCore;
	
	/**
	 * UserContext keeps the current user, see {@link UserContext}.
	 * Can be null, if no user is signed in.
	 */
	private UserContext userContext;
	
	/**
	 * BasketContext keeps the current basket, see {@link BasketContext}.
	 * There is always a basket.
	 */
	private BasketContext basketContext;
	
	/*
	 * +-----------------------------------------------------------------------+
	 * | INITIALIZATION                                                        |
	 * +-----------------------------------------------------------------------+
	 */
	
	/**
	 * Initialize the application by creating the window and setting the layoutView as content.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void init() {
		setInstance(this);
		Window mainWindow = new Window("shopsuey");
		setMainWindow(mainWindow);
		mainWindow.setContent(getLayoutView());
		setTheme("fomshop");
	}

	/**
	 * Get layoutView, build if null.
	 * 
	 * @return the layoutView
	 */
	public StoreLayoutView getLayoutView() {
		if (layoutView == null) {
			layoutView = new StoreLayoutView();
			
			layoutView.getHeaderArea().addComponent(new Embedded("", new ThemeResource("img/logo.png")));
			layoutView.getHeaderNavigationArea().addComponent(new UserInfoControl(getUserCore()));
			layoutView.getMenuArea().addComponent(new ArticleCategoryMenuControl(getArticleCore()));
			layoutView.getWidgetArea().addComponent(new BasketWidgetControl(getBasketCore()));
			layoutView.getMainArea().addComponent(new Label("WELCOME_AT_FOMSHOP"));
			
			MenuBar footerBar = new MenuBar();
			footerBar.addItem("Kontakt", null);
			footerBar.addItem("AGB", null);
			footerBar.addItem("Versandkosten", null);
			footerBar.addItem("Zahlungsarten", null);
			footerBar.addItem("Impressum", null);
			
			layoutView.getFooterArea().addComponent(footerBar);
		}
		return layoutView;
	}
	
	/**
	 * Get userContext, build if null.
	 * 
	 * @return the userContext
	 */
	public UserContext getUserContext() {
		if (userContext == null) {
			userContext = new UserContext();
		}
		return userContext;
	}
	
	/**
	 * Get basketContext, build if null.
	 * 
	 * @return the basketContext
	 */
	public BasketContext getBasketContext() {
		if (basketContext == null) {
			basketContext = new BasketContext();
		}
		return basketContext;
	}
	
	/*
	 * +-----------------------------------------------------------------------+
	 * | THREADLOCAL LOGIC                                                     |
	 * +-----------------------------------------------------------------------+
	 */
	
	/**
	 * Get the current, thread save, application instance.
	 * 
	 * @return the application instance
	 */
	public static FomShopApplication getInstance() {
		return threadLocal.get();
	}
	
	/**
	 * Set the current application instance.
	 * 
	 * @param application the application instance
	 */
	public static void setInstance(FomShopApplication application) {
		threadLocal.set(application);
	}
	
	/**
	 * Set the current application instance when a new request occurs.
	 */
	@Override
	public void onRequestStart(HttpServletRequest request,
			HttpServletResponse response) {
		FomShopApplication.setInstance(this);
	}

	/**
	 * Remove the current instance when the current request ends.
	 */
	@Override
	public void onRequestEnd(HttpServletRequest request,
			HttpServletResponse response) {
		threadLocal.remove();
	}
	
	/*
	 * +-----------------------------------------------------------------------+
	 * | SPRING SERVICES                                                       |
	 * +-----------------------------------------------------------------------+
	 */
	
	/**
	 * Get springUtil, build if null.
	 * 
	 * @return the springUtil
	 */
	private SpringUtil getSpringUtil() {
		if (springUtil == null) {
			springUtil = new SpringUtil(getInstance());
		}
		return springUtil;
	}
	
	/**
	 * Get userService, lookup if null.
	 * 
	 * @return the userService
	 */
	public IUserService getUserService() {
		if (userService == null) {
			userService = (IUserService) getSpringUtil().getBean("userService");
		}
		return userService;
	}
	
	/**
	 * Get articleService, lookup if null.
	 * 
	 * @return the articleService
	 */
	public IArticleService getArticleService() {
		if (articleService == null) {
			articleService = (IArticleService) getSpringUtil().getBean("articleService");
		}
		return articleService;
	}
	
	/**
	 * Get orderService, lookup if null.
	 * 
	 * @return the orderService
	 */
	public IOrderService getOrderService() {
		if (orderService == null) {
			orderService = (IOrderService) getSpringUtil().getBean("orderService");
		}
		return orderService;
	}
	
	/**
	 * Get workflowService, lookup if null.
	 * 
	 * @return the workflowService
	 */
	public IWorkflowService getWorkflowService() {
		if (workflowService == null) {
			workflowService = (IWorkflowService) getSpringUtil().getBean("workflowService");
		}
		return workflowService;
	}
	
	/*
	 * +-----------------------------------------------------------------------+
	 * | DELEGATE CORES                                                        |
	 * +-----------------------------------------------------------------------+
	 */
	
	/**
	 * Get adminCore.
	 * 
	 * @return the adminCore
	 */
	public AdminCore getAdminCore() {
		if (adminCore == null) {
			adminCore = new AdminCore();
		}
		return adminCore;
	}
	
	/**
	 * Get articleCore.
	 * 
	 * @return the articleCore
	 */
	public ArticleCore getArticleCore() {
		if (articleCore == null) {
			articleCore = new ArticleCore();
		}
		return articleCore;
	}
	
	/**
	 * Get basketCore.
	 * 
	 * @return the basketCore
	 */
	public BasketCore getBasketCore() {
		if (basketCore == null) {
			basketCore = new BasketCore();
		}
		return basketCore;
	}
	
	/**
	 * Get userCore.
	 * 
	 * @return the userCore
	 */
	public UserCore getUserCore() {
		if (userCore == null) {
			userCore = new UserCore();
		}
		return userCore;
	}

}