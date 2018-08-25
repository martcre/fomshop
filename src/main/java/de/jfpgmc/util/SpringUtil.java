package de.jfpgmc.util;

import java.io.Serializable;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.WebApplicationContext;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Utility to lookup spring beans in the current context.
 * 
 * @author Martin Cremer
 *
 */
public class SpringUtil implements Serializable {

	private static final long serialVersionUID = -5112403890612128009L;
	private ApplicationContext context;

	/**
	 * Constructor for SpringUtil.
	 * Initialize and fetch the current context from the vaadin application.
	 * 
	 * @param application the current application instance
	 */
    public SpringUtil(Application application) {
        ServletContext servletContext = ((WebApplicationContext) application.getContext()).getHttpSession().getServletContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    /**
     * Fetch the bean for ref beanRef.
     * 
     * @param beanRef the name of the reference
     * @return the bean
     */
    public Object getBean(final String beanRef) {
        return context.getBean(beanRef);
    }    
}
