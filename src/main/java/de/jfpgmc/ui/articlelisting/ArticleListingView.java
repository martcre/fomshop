package de.jfpgmc.ui.articlelisting;

import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ChameleonTheme;

import de.jfpgmc.util.I18n;

/**
 * View of AcrticleListing component
 * 
 * @author Patrick Giezen
 */
public class ArticleListingView extends CustomComponent{
	
	private static final long serialVersionUID = -7477724109596783642L;
	
			private VerticalLayout mainLayout;
			private Label componentTitle;
			private Button refreshProcessList;
			private Table articleTable;
			private Table articleVariants;
			
			/**
			 * Constructor for ArticleListingView
			 */
			public ArticleListingView() {
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
					
					mainLayout.addComponent(getComponentTitle());
					mainLayout.addComponent(getRefreshProcessList());
					mainLayout.addComponent(getArticleTable());
				}
				return mainLayout;	
			}
			/**
			 * Get componentTitle, build if null.
			 * 
			 * @return the componentTitle
			 */
			public Label getComponentTitle() {
				if (componentTitle == null) {
					componentTitle = new Label();
					componentTitle.addStyleName(ChameleonTheme.LABEL_H3);
				}
				return componentTitle;
			}
			/**
			 * Get refreshProcessList, build if null.
			 * 
			 * @return the refreshProcessList
			 */
			public Button getRefreshProcessList() {
				if (refreshProcessList == null) {
					refreshProcessList = new Button(I18n.getString("REFRESH_PROCESS_LIST"));
				}
				return refreshProcessList;
			}
			
			/**
			 * Get articleTable, build if null.
			 * 
			 * @return the articleTable
			 */
			public Table getArticleTable() {
				if (articleTable == null) {
					articleTable = new Table();
					articleTable.setWidth("100%");
					articleTable.setHeight("200px");
					articleTable.addStyleName(ChameleonTheme.TABLE_STRIPED);
				}
				return articleTable;
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
					articleVariants.setHeight("200px");
					articleVariants.addStyleName(ChameleonTheme.TABLE_STRIPED);
				}
				return articleVariants;
			}
		}