package ru.urscorp.web.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


/**
 * Базовый класс для всех GWT сервлетов приложения. Реализован для того, что бы
 * спринговые бины подгружались в GWT-шные сервлеты.
 * 
 * @author Станислав Федецов 28.10.2011
 */
@SuppressWarnings("serial")
public class BaseServiceServlet extends RemoteServiceServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		AutowireCapableBeanFactory autowireFactory = ctx.getAutowireCapableBeanFactory();
		autowireFactory.autowireBean(this);
	}

}
