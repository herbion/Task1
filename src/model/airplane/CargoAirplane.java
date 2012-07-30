package model.airplane;

public class CargoAirplane extends Airplane {
    private static final long serialVersionUID = -1815361638619330292L;

    public static class CargoAirplaneBuilder extends
	    Airplane.AbstractBuilder {
	@Override
	public CargoAirplane build() {
	    return new CargoAirplane(this);
	}

    }

    public CargoAirplane(CargoAirplaneBuilder builder) {
	super(builder);
    }

    @Override
    public void flightTo(String coordinates) {
	System.out.println("Flying to: " + coordinates);
    }

    public void loadCargo(int kg) {
	System.out.println("Loading cargo to plane. Weight " + kg + "kg.");
    }
}
