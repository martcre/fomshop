package de.jfpgmc.ui.articleviewer;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of ArticleViewer component.
 * 
 * @author Patrick Giezen
 *
 */
public class ArticleViewerView extends CustomComponent {

	private static final long serialVersionUID = -1428885985739149333L;
	private VerticalLayout mainLayout;
	
	private Label articleTitle;
	private Label articleDescription;
	
	private Table articleVariants;
	
	/**
	 * Constructor for ArticleViewerView.
	 *
	 */
	public ArticleViewerView() {
		setCompositionRoot(getMainLayout());
	}
	
	/**
	 * Get mainLayout, build if null.
	 * 
	 * @return the mainLayout
	 */
	private VerticalLayout getMainLayout() {
		if (mainLayout == null) {
			mainLayout = new VerticalLayout();
			mainLayout.setWidth("100%");
			mainLayout.setSpacing(true);
			
			mainLayout.addComponent(getArticleTitle());
			mainLayout.addComponent(getArticleDescription());
			
			Label articleVariantsCaption = new Label(I18n.getString("ARTICLE_VARIANTS"));
			articleVariantsCaption.addStyleName(ChameleonTheme.LABEL_H3);
			mainLayout.addComponent(articleVariantsCaption);
			mainLayout.addComponent(getArticleVariants());
		}
		return mainLayout;
	}
	
	/**
	 * Get articleTitle, build if null.
	 * 
	 * @return the articleTitle
	 */
	public Label getArticleTitle() {
		if (articleTitle == null) {
			articleTitle = new Label();
			articleTitle.addStyleName(ChameleonTheme.LABEL_H1);
		}
		return articleTitle;
	}
	
	/**
	 * Get articleDescription, build if null.
	 * 
	 * @return the articleDescription
	 */
	public Label getArticleDescription() {
		if (articleDescription == null) {
			articleDescription = new Label();
		}
		return articleDescription;
	}
	
	/**
	 * Get articleVariants, build if null.
	 * 
	 * @return the articleVariants
	 */
	public Table getArticleVariants() {
		if (articleVariants == null) {
			articleVariants = new Table();
			articleVariants.setWidth("100%");
			articleVariants.setHeight("100px");
		}
		return articleVariants;
	}

}
