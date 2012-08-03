package view.menu;

import model.aircompany.AirplaneCompany;

public interface MenuEntry {
    void execCommand(AirplaneCompany arg);

    String getTitle();
}
