package contoller.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationUtil {
    @SuppressWarnings("unchecked")
    public static <T> T readObject(final String fileName) throws IOException {
	ObjectInputStream inputStream = null;
	Object object = null;
	try {
	    inputStream = new ObjectInputStream(new FileInputStream(fileName));
	    object = inputStream.readObject();
	} catch (final Exception e) {
	    System.err.println(e.getMessage());
	} finally {
	    inputStream.close();
	}
	return (T) object;
    }

    public static void writeObject(final String fileName, final Object o)
	    throws IOException {
	ObjectOutputStream outputStream = null;
	try {
	    outputStream = new ObjectOutputStream(
		    new FileOutputStream(fileName));
	    outputStream.writeObject(o);
	    outputStream.flush();
	} catch (final Exception e) {
	    System.err.println(e.getMessage());
	} finally {
	    if (outputStream != null)
		outputStream.close();
	}
    }

}
