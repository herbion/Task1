package model.airplane;

import java.io.Serializable;

// TODO: Implement HashCode method.
public abstract class Airplane implements Serializable {
    private static final long serialVersionUID = 3563389091880868027L;

    public abstract static class AbstractBuilder {
	protected String modelTitle;
	protected int passengers;
	protected int cargo;
	protected int maximumFuelCapacity;
	protected int maximumTakeoffWeight;
	protected int typicalCruiseSpeed;
	protected long maximumRange;
	protected Engine engine = new Engine();
	protected Carcas dimensions = new Carcas();

	public AbstractBuilder() {
	}

	public abstract Airplane build();

	public void setCargo(int cargo) {
	    this.cargo = cargo;
	}

	public void setDimensions(Carcas dimensions) {
	    this.dimensions = dimensions;
	}

	public void setEngine(Engine engine) {
	    this.engine = engine;
	}

	public void setEngineModelName(String modelName) {
	    engine.setEngineModelName(modelName);
	}

	public void setInteriorCabinWidth(double interiorCabinWidth) {
	    dimensions.setInteriorCabinWidth(interiorCabinWidth);
	}

	public void setMaximumEngineThrust(int maximumEngineThrust) {
	    engine.setMaximumEngineThrust(maximumEngineThrust);
	}

	public void setMaximumFuelCapacity(int maximumFuelCapacity) {
	    this.maximumFuelCapacity = maximumFuelCapacity;
	}

	public void setMaximumRange(long maximumRange) {
	    this.maximumRange = maximumRange;
	}

	public void setMaximumTakeoffWeight(int maximumTakeoffWeight) {
	    this.maximumTakeoffWeight = maximumTakeoffWeight;
	}

	public void setModelTitle(String modelTitle) {
	    this.modelTitle = modelTitle;
	}

	public void setOverallLength(double overallLength) {
	    dimensions.setOverallLength(overallLength);
	}

	public void setPassengersCount(int passengers) {
	    this.passengers = passengers;
	}

	public void setTailHeight(double tailHeight) {
	    dimensions.setTailHeight(tailHeight);
	}

	public void setTypicalCruiseSpeed(int typicalCruiseSpeed) {
	    this.typicalCruiseSpeed = typicalCruiseSpeed;
	}

	public void setWingSpan(double wingSpan) {
	    dimensions.setWingSpan(wingSpan);
	}

    }

    private String modelTitle;
    private final int passengersCount;
    private final int cargoWeight;
    private final int maximumFuelCapacity;
    private final int maximumTakeoffWeight;
    private final int typicalCruiseSpeed;

    protected final Engine engine;
    protected final Carcas dimensions;

    private long maximumRange;
    // TODO: public or package visibility? 
    Airplane(AbstractBuilder builder) {
	modelTitle = builder.modelTitle;
	engine = builder.engine;
	dimensions = builder.dimensions;
	cargoWeight = builder.cargo;
	passengersCount = builder.passengers;
	maximumFuelCapacity = builder.maximumFuelCapacity;
	maximumRange = builder.maximumRange;
	maximumTakeoffWeight = builder.maximumTakeoffWeight;
	typicalCruiseSpeed = builder.typicalCruiseSpeed;
    }

    protected Airplane(String modelTitle, int passengersCount,
	    int cargoWeight, int maximumFuelCapacity, int maximumTakeoffWeight,
	    int typicalCruiseSpeed, Engine engine, Carcas dimensions,
	    long maximumRange) {
	super();
	this.modelTitle = modelTitle;
	this.passengersCount = passengersCount;
	this.cargoWeight = cargoWeight;
	this.maximumFuelCapacity = maximumFuelCapacity;
	this.maximumTakeoffWeight = maximumTakeoffWeight;
	this.typicalCruiseSpeed = typicalCruiseSpeed;
	this.engine = engine;
	this.dimensions = dimensions;
	this.maximumRange = maximumRange;
    }

    public abstract void flightTo(String coordinates);

    public int getCargoWeight() {
	return cargoWeight;
    }

    public Carcas getDimensions() {
	return dimensions;
    }

    public Engine getEngine() {
	return engine;
    }

    public int getMaximumFuelCapacity() {
	return maximumFuelCapacity;
    }

    public long getMaximumRange() {
	return maximumRange;
    }

    public int getMaximumTakeoffWeight() {
	return maximumTakeoffWeight;
    }

    public String getModelTitle() {
	return modelTitle;
    }

    public int getPassengersCount() {
	return passengersCount;
    }

    public int getTypicalCruiseSpeed() {
	return typicalCruiseSpeed;
    }

    public abstract void loadCargo(int weight);

    @Override
    public String toString() {
	return /*"Airplane"*/ 
		getClass().getSimpleName() + "\n[" + "\n* modelTitle=" + modelTitle
		+ "\n* passengersCount=" + passengersCount
		+ "\n* cargoWeight=" + cargoWeight + "cu ft" + "\n* engine="
		+ engine + "\n* dimensions=" + dimensions
		+ "\n* maximumFuelCapacity=" + maximumFuelCapacity + "L"
		+ "\n* maximumTakeoffWeight=" + maximumTakeoffWeight + "kg"
		+ "\n* typicalCruiseSpeed=" + typicalCruiseSpeed + "kmph"
		+ "\n* maximumRange=" + maximumRange + "km" + "\n]";
    }
}
