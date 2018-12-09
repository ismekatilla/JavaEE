package org.ismek.example;

import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;

import components.AddButton;

public class BodyLayout extends VerticalLayout {

	public BodyLayout() {
		setWidth(100, Unit.PERCENTAGE);
		
		FormLayout formLayout = new FormLayout();
		TextField txtIsim = new TextField();
    	txtIsim.setCaption("İsim");
    	formLayout.addComponent(txtIsim);
    	
    	TextField txtTelefon = new TextField();
    	txtTelefon.setCaption("Telefon");
    	formLayout.addComponent(txtTelefon);
    	
    	AddButton btnKaydet = new AddButton();
    	btnKaydet.setCaption("Kaydet");
    	btnKaydet.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				Notification.show("KAYDEDİLDİ");
			}
		});
    	formLayout.addComponent(btnKaydet);
    	addComponent(formLayout);
	}
}
