package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command {
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database) {
        commands = new HashMap<>();

        /* Pages commands */
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("customCarportST", new CommandUnprotectedPage("customCarportST"));
        commands.put("customCarportFT", new CommandUnprotectedPage("customCarportFT"));
        commands.put("ccpiList", new CommandProtectedPage("ccpiList", "admin"));
        commands.put("ccpiMaterialCalculator", new CommandProtectedPage("ccpiMaterialCalculator", "admin"));

        /* Functionality commands */
        commands.put("loginCommand", new LoginCommand(""));
        commands.put("logoutCommand", new LogoutCommand(""));
        commands.put("getAllCCPOptionsCommand", new GetCCPOptionsCommand(""));
        commands.put("sendInquiryCommand", new SendInquiryCommand(""));
        commands.put("getInquiryByIdCommand", new GetInquiryByIdCommand("", "admin"));
        commands.put("resetCcpiCalc", new ResetCcpiCalcCommand("ccpiList", "admin"));
        commands.put("calcMaterialListCommand", new CalcMaterialListCommand("ccpiMaterialCalculator", "admin"));
        commands.put("searchInquiryCommand", new SearchInquiryCommand("ccpiList", "admin"));

    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null) {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
