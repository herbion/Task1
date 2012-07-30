package exceptions.view.menu;

@SuppressWarnings("serial")
public abstract class Signal extends RuntimeException {
    public Signal(String message) {
	super(message);
    }
}
