package exceptions.view.menu;

public class WrongIndexSignal extends Signal {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public WrongIndexSignal(String message) {
	super("[!] " + message);
    }

}
