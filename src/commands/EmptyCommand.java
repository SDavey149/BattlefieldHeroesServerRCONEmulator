package commands;

/**
 * Created by Scott Davey on 05/07/2017.
 */
public class EmptyCommand implements Command {
    @Override
    public String handle() {
        return CommandUtils.getEmptyReply();
    }
}
