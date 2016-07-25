package twu.biblioteca.control;

/**
 * Created by xsu on 16/7/25.
 * it's the exit logic
 */
public class ExitLogic implements LogicNode {
    @Override
    public void action() throws Exception {
        System.exit(0);
    }
}
