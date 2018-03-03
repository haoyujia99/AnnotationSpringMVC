package com.hao.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * com.hao
 *
 * @author Hao
 * @version v1.0
 * @since 2018/2/10 12:15
 */
public class ApplicationInit implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(BeanConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        servlet.setAsyncSupported(true);
    }
}
