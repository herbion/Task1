package model.aircompany;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.airplane.Airplane;
import model.airplane.factory.BoeingFactory;
import contoller.util.SerializationUtil;

public class AirplaneCompany implements Serializable {
    private static final long serialVersionUID = 2230728088365592537L;
    private long lastRaiseID = 0;
    /**
     * @param count
     *            Count of Raises to create.
     * @return Returns Instance of airplane company using BoeingFactory with
     *         default Random of factory.
     */
    public static AirplaneCompany getInstance(Long count) {
	return getInstance(count, null);
    }

    /**
     * @param count
     *            How many raises you want to create.
     * @param rand
     *            Generator of random values.
     * @return Returns random instance of airplane company created by factory.
     */
//    public static AirplaneCompany getInstance(Long count, Random rand) {
//	if (count == null)
//	    throw new NullPointerException("Count == null");
//	AirplaneCompany airCompany = new AirplaneCompany("SomeAirCompanyName");
//	BoeingFactory factory = new BoeingFactory();
//	if (rand != null)
//	    factory.setRand(rand);
//	for (Long i = 0L; i < count; i++) {
//	    Airplane airplane = factory.createRandomPassagerAirplane();
//	    airCompany.addRaise(new Raise(airplane, i));
//	}
//	return airCompany;
//    }
    public static AirplaneCompany getInstance(Long count, Random rand) {
	if (count == null)
	    throw new NullPointerException("Count == null");
	AirplaneCompany company = new AirplaneCompany("SomeAirCompanyName");
	BoeingFactory factory = new BoeingFactory();
	if (rand != null)
	    factory.setRand(rand);
	
	for (long start = company.lastRaiseID; company.lastRaiseID - start < count; company.lastRaiseID++) {
	    Airplane airplane = factory.createRandomPassagerAirplane();
	    company.addRaise(new Raise(airplane, company.lastRaiseID));
	}
	return company;
    }
    /**
     * @param fileName Path to file where airplane company objects are saved.
     * @return	Instance of Airplane company
     * @throws IOException Throws exception when something wrong :)
     */
    public static AirplaneCompany getInstance(String fileName)
	    throws IOException {
	if (fileName == null || fileName.isEmpty())
	    throw new IllegalArgumentException("Path to file cannot be null or empty");
	return SerializationUtil.<AirplaneCompany> readObject(fileName);
    }
    public void addAirplane(Airplane airplane) {
	raiseDataBase.add(new Raise(airplane, ++lastRaiseID));
    }
    public final String AirCompanyName;
    private List<Raise> raiseDataBase = new ArrayList<Raise>();

    public AirplaneCompany(String airCompanyName) {
	AirCompanyName = airCompanyName;
    }

    public AirplaneCompany(String airCompanyName, List<Raise> raiseDataBase) {
	nullCheck(raiseDataBase, "Raises cannot be null");
	this.raiseDataBase = raiseDataBase;
	AirCompanyName = airCompanyName;
    }

    public void addRaise(Raise raise) {
	nullCheck(raise, "Raise cannot be null");
	getRaiseDataBase().add(raise);
    }

    public List<Raise> getRaiseDataBase() {
	
	return raiseDataBase;
    }

    private void nullCheck(Object o, String exceptionMessage) {
	if (o == null)
	    throw new NullPointerException("Raises cannot be null");
    }

    public void saveInstance(String fileName) throws IOException {
	SerializationUtil.writeObject(fileName, this);
    }

    public void setRaiseDataBase(List<Raise> raiseDataBase) {
	nullCheck(raiseDataBase, "Raises cannot be null");
	this.raiseDataBase = raiseDataBase;
    }
}
