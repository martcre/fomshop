package de.jfpgmc.ui.articlebrowser;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

/**
 * View of ArticleBrowser component
 * 
 * @author Patrick Giezen
 *
 */
public class ArticleBrowserView extends CustomComponent {

	private static final long serialVersionUID = -4998667473754220732L;
	private VerticalLayout mainLayout;
	private VerticalLayout articles;

	private Label title;
	
	/**
	 * Constructor for ArticleBrowserView.
	 */
	public ArticleBrowserView() {
		setCompositionRoot(getMainLayout());
	}
	
	/**
	 * Get mainLayout, build if null.
	 * 
	 * @return the mainLayout
	 */
	public VerticalLayout getMainLayout() {
		if (mainLayout == null) {
			mainLayout = new VerticalLayout();
			mainLayout.setWidth("100%");
			
			mainLayout.addComponent(getTitle());
			
			/**
			 * Referenz zu ArticleItemView
			 */
			mainLayout.addComponent(getArticles());

		}
		return mainLayout;
		}
		
	/**
	 * Get Title, build if null.
	 * 
	 * @return the Title
	 */
	public Label getTitle() {
		if (title == null) {
			title = new Label();
			title.addStyleName(ChameleonTheme.LABEL_H1);
		}
		return title;
	}
	/**
	 * Get articles, build if null.
	 * 
	 * @return the articles
	 */
	public VerticalLayout getArticles() {
		if (articles == null) {
			articles = new VerticalLayout();
		}
		return articles;
	}
}
