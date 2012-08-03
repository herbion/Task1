package contoller.util.input;

import java.util.Scanner;

import contoller.util.input.enums.SupportedInputTypesEnum;

public class UserInput {
    private static int DEFAULT_TRIES_COUNT = 3;
    private static Scanner scanner = new Scanner(System.in);

    public static String getChoice(String greeting) {
	System.out.print(greeting);
	return scanner.next();
    }

    public static <T extends Number> T getChoice(String greeting,
	    SupportedInputTypesEnum type) {
	return getChoise(greeting, type, DEFAULT_TRIES_COUNT);
    }

    // TODO: Its safe or not?
    @SuppressWarnings("unchecked")
    private static <T extends Number> T getChoise(String greeting,
	    SupportedInputTypesEnum type, int tries) {
	T retValue = null;
	Class<? extends Number> cls = type.getEncapsulatedType();
	System.out.println(greeting);

	while (tries > 0) {
	    System.out.print("Type of input {" + cls.getSimpleName() + "}: ");
	    String next = scanner.next();

	    if (next.toLowerCase().startsWith("q"))
		return null;
	    try {
		if (Double.class == cls) {
		    retValue = (T) cls.cast(Double.parseDouble(next));
		    break;
		}
		if (Integer.class == cls) {
		    retValue = (T) cls.cast(Integer.parseInt(next));
		    break;
		}
	    } catch (ClassCastException e) {
		System.out.println("This is not: " + cls.getCanonicalName());
	    } catch (NumberFormatException e) {
		System.out.println("This is not: " + cls.getCanonicalName());
	    }
	    System.out.println("Tries left: " + --tries);
	}
	return retValue;
    }
}
