import java.io.IOException;

import model.aircompany.AirplaneCompany;
import view.MainMenu;

public class Launcher {
    private static final String PATH_TO_AIRCOMPANY_DUMP = "aircompany.dump";
    private static final long RANDOM_INSTANCES_COUNT = 25L;

    public static void main(String args[]) throws IOException {
	AirplaneCompany airCompany;
	try {
	    airCompany = AirplaneCompany.getInstance(PATH_TO_AIRCOMPANY_DUMP);
	} catch (Exception e) {
	    airCompany = AirplaneCompany.getInstance(RANDOM_INSTANCES_COUNT);
	}

	new MainMenu().execCommand(airCompany);
    }
}
