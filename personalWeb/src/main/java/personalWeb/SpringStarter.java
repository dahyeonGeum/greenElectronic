package personalWeb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * �����������ӿ�ũ ��������
 */
public class SpringStarter implements WebApplicationInitializer {

    /**
     * ���ؽ�Ʈ�� �����Ѵ�.
     */

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        // Root Context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(personalWeb.RootContextConfiguration.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Web Context
        AnnotationConfigWebApplicationContext dispatcherContext =  new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebContextConfiguration.class);

        // Dispatcher Servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("*.do");
    }

}

