package model.airplane;

import java.io.Serializable;

public class Engine implements Serializable {
    private static final long serialVersionUID = -4384434381989971953L;
    private String modelName = "Defaulf engine model";
    private int maximumEngineThrust = 0;

    public String getEngineModelName() {
	return modelName;
    }

    public void setEngineModelName(String modelName) {
	this.modelName = modelName;
    }

    public int getMaximumEngineThrust() {
	return maximumEngineThrust;
    }

    public void setMaximumEngineThrust(int maximumEngineThrust) {
	if (maximumEngineThrust > 0)
	    this.maximumEngineThrust = maximumEngineThrust;
	else
	    throw new IllegalArgumentException(
		    "maxThrust can\'t be less than zero.");
    }

    public Engine() {
	super();
    }

    public Engine(String modelName, int maximumEngineThrust) {
	super();
	this.modelName = modelName;
	this.maximumEngineThrust = maximumEngineThrust;
    }

    @Override
    public String toString() {
	return "Engine" + "[" + "modelName=" + modelName
		+ ", maximumEngineThrust=" + maximumEngineThrust + "lb" + "]";
    }
}
