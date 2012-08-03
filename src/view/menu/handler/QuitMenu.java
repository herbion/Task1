package view.menu.handler;

import java.io.IOException;

import model.aircompany.AirplaneCompany;
import view.menu.MenuEntry;
import contoller.util.input.UserInput;
import exceptions.view.menu.QuitSignal;

public class QuitMenu implements MenuEntry {

    private String fileName = "aircompany.dump";

    @Override
    public void execCommand(AirplaneCompany arg) {
	String choice;
	do {
	    choice = UserInput.getChoice("Save before quit? [yes/no] ")
		    .toLowerCase();
	} while (!choice.matches("^[yn].*"));
	if (choice.startsWith("y")) {
	    try {
		arg.saveInstance(fileName);
	    } catch (IOException e) {
		throw new RuntimeException(e);
	    }
	    System.out.println("Save in: " + fileName);
	}
	System.out.println("Good-bye.");
	throw new QuitSignal("0");
    }

    @Override
    public String getTitle() {
	return "Quit application.";
    }

}
