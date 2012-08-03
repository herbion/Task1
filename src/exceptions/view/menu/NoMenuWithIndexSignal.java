package exceptions.view.menu;

public class NoMenuWithIndexSignal extends Signal {

    private static final long serialVersionUID = 1L;

    public NoMenuWithIndexSignal(String message) {
	super("[?] " + message);
    }

}
