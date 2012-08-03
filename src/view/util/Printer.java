package view.util;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import model.aircompany.AirplaneCompany;
import model.aircompany.Raise;
import model.airplane.Airplane;
// TODO: Ugly. Think about how to let user Customize format.
// TODO: add functionality that prints only several fields from Raise.

public class Printer {
    public static final String RAISE_TITLE_FORMAT = "%-5s%-25s%-5s%-7s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n";
    public static final String RAISE_DETAILED_DATA_FORMAT = "%-5d%-25s%-5d%-7d%-10s%-10d%-10.2f%-10.2f%-10.2f%-10.2f%-10d%-10d%-10d%-10d\n";

    public static void print(Collection<Entry<Long, Raise>> raises) {
	System.out.printf(RAISE_TITLE_FORMAT, "ID", "ModelTitle", "Pers",
		"Cargo", "Engine", "Thrust", "Wing", "Overall", "Tail",
		"Cabin", "Fuel", "TakeOff", "Speed", "Range");

	for (Entry<Long, Raise> raise : raises) {
	    Airplane airPlane = raise.getValue().getAirplane();
	    System.out.printf(RAISE_DETAILED_DATA_FORMAT, 
		    raise.getKey(),
		    airPlane.getModelTitle(), 
		    airPlane.getPassengersCount(),
		    airPlane.getCargoWeight(), 
		    airPlane.getEngine().getEngineModelName(), 
		    airPlane.getEngine().getMaximumEngineThrust(), 
		    airPlane.getDimensions().getWingSpan(), 
		    airPlane.getDimensions().getOverallLength(), 
		    airPlane.getDimensions().getTailHeight(), 
		    airPlane.getDimensions().getInteriorCabinWidth(), 
		    airPlane.getMaximumFuelCapacity(), 
		    airPlane.getMaximumTakeoffWeight(), 
		    airPlane.getTypicalCruiseSpeed(), 
		    airPlane.getMaximumRange());
	}
    }

    public static void print(Map<Long, Raise> raises) {
	print(raises.entrySet());
    }

    public static void printById(AirplaneCompany company, Long id) {
	System.out.println(company.getRaiseDataBase().get(id));
    }
}
