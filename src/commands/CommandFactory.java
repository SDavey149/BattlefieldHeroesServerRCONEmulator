package commands;

import commands.Command;
import commands.LoginCommand;

import java.util.Arrays;

/**
 * Created by Scott Davey on 05/07/2017.
 */
public class CommandFactory {
    String[] commandItems;

    public CommandFactory(String command) {
        commandItems = getCommandItems(command);
    }

    public static Command GetCommand(String commandWithArgs) {
        String[] commandItems = getCommandItems(commandWithArgs);
        String command = getCommand(commandItems);
        String[] arguments = getArgs(commandItems);

        switch (command) {
            case "login":
                return new LoginCommand(arguments);
        }
        return new EmptyCommand();
    }

    private static String[] getCommandItems(String command) {
        return command.trim().split("\\s+");
    }

    private static String getCommand(String[] commandItems) {
        return commandItems[0];
    }

    private static String[] getArgs(String[] commandItems) {
        return Arrays.copyOfRange(commandItems, 1, commandItems.length);
    }
}
