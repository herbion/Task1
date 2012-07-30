package view.menu.handler;

import model.aircompany.AirplaneCompany;
import view.menu.MenuEntry;
import exceptions.view.menu.QuitSignal;

public class QuitMenu implements MenuEntry {

    @Override
    public void execCommand(AirplaneCompany arg) {
	System.out.println("Good-bye %%username%%.");
	throw new QuitSignal("0");
    }

    @Override
    public String getTitle() {
	return "Quit application.";
    }

}
