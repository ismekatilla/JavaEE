package org.ismek.example;

import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;

import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import components.AddButton;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("org.ismek.vaadin_example.MyAppWidgetset")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
    	VerticalLayout verticalLayout = new VerticalLayout();
    	verticalLayout.setSizeFull();

    	HeaderLayout headerLayout = new HeaderLayout();
    	BodyLayout bodyLayout = new BodyLayout();
		
    	verticalLayout.addComponent(headerLayout);
		verticalLayout.addComponent(bodyLayout);
    	verticalLayout.setExpandRatio(headerLayout, 1f);
    	verticalLayout.setExpandRatio(bodyLayout, 9f);
    	setContent(verticalLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
