package org.ismek.example;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class HeaderLayout extends VerticalLayout {

	public HeaderLayout() {
		setWidth(100, Unit.PERCENTAGE);
		
		Label label = new Label();
		label.setValue("TEST HEADER");
		addComponent(label);
	}
}
