package twu.biblioteca.view;

/**
 * Created by xsu on 16/7/25.
 * it's the ui event. it's can give ui thread and update ui.
 */
public class UIEvent {

    private String message;
    private UIEventCallBack uiEventCallBack;

    public UIEvent(String message) {
        this.message = message;
    }

    public UIEvent(String message, UIEventCallBack uiEventCallBack) {
        this.message = message;
        this.uiEventCallBack = uiEventCallBack;
    }

    public String getMessage() {
        return message;
    }

    public UIEventCallBack getUiEventCallBack() {
        return uiEventCallBack;
    }

    public void afterShowMessage() {
        if (uiEventCallBack != null) {
            uiEventCallBack.action();
        }
    }
}
