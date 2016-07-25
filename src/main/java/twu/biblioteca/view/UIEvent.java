package twu.biblioteca.view;

/**
 * Created by xsu on 16/7/25.
 * it's the ui event. it's can give ui thread and update ui.
 */
public class UIEvent {

    private String message;

    public UIEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
