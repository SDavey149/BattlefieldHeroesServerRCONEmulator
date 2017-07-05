package commands;

/**
 * Created by Scott Davey on 05/07/2017.
 */
public class LoginCommand implements Command {
    private static final String SUCCESS_REPLY = "Authentication successful, rcon ready.\n";

    private String[] args;

    public LoginCommand(String[] args) {
        this.args = args;
    }

    @Override
    public String handle() {
        if (args.length != 1) {
            return CommandUtils.getEmptyReply();
        }
        return getReply(args[0]);
    }

    private String getReply(String token) {
        if (!token.equals("f9ec0dfd471beab21e4ca0bd072711a1")) {
            return CommandUtils.getEmptyReply();
        }
        return SUCCESS_REPLY;
    }
}
