package model.aircompany;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import model.airplane.Airplane;
import model.airplane.factory.BoeingFactory;
import contoller.util.SerializationUtil;

public class AirplaneCompany implements Serializable {
    private static final long serialVersionUID = 2230728088365592537L;

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

    public static AirplaneCompany getInstance(Long count, Random rand) {
	if (count == null)
	    throw new NullPointerException("Count == null");
	AirplaneCompany company = new AirplaneCompany("SomeAirCompanyName");
	BoeingFactory factory = new BoeingFactory();
	if (rand != null)
	    factory.setRand(rand);

	for (long start = company.lastRaiseID; company.lastRaiseID - start < count;) {
	    Airplane airplane = factory.createRandomPassagerAirplane();
	    company.addRaise(new Raise(airplane));
	}
	return company;
    }

    /**
     * @param fileName
     *            Path to file where airplane company objects are saved.
     * @return Instance of Airplane company
     * @throws IOException
     *             Throws exception when something wrong :)
     */
    public static AirplaneCompany getInstance(String fileName)
	    throws IOException {
	if (fileName == null || fileName.isEmpty())
	    throw new IllegalArgumentException(
		    "Path to file cannot be null or empty");
	return SerializationUtil.<AirplaneCompany> readObject(fileName);
    }

    public final String AirCompanyName;

    private Long lastRaiseID = 0L;
    private Map<Long, Raise> raiseDataBase = new LinkedHashMap<Long, Raise>();

    public AirplaneCompany(String airCompanyName) {
	AirCompanyName = airCompanyName;
    }

    public AirplaneCompany(String airCompanyName, Map<Long, Raise> raiseDataBase) {
	nullCheck(raiseDataBase, "Raises cannot be null");
	this.raiseDataBase = raiseDataBase;
	AirCompanyName = airCompanyName;
    }

    public void addRaise(Raise raise) {
	nullCheck(raise, "Raise cannot be null");
	raiseDataBase.put(lastRaiseID++, raise);
    }

    public Map<Long, Raise> getRaiseDataBase() {

	return raiseDataBase;
    }

    private void nullCheck(Object o, String exceptionMessage) {
	if (o == null)
	    throw new NullPointerException(exceptionMessage);
    }

    public void saveInstance(String fileName) throws IOException {
	SerializationUtil.writeObject(fileName, this);
    }
}
