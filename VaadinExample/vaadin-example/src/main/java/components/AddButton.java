package components;

import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;

public class AddButton extends Button {

	public AddButton() {
		setCaption("EKLE");
		setWidth(120, Unit.PERCENTAGE);
		addStyleName(ValoTheme.BUTTON_DANGER);
	}
}