package web.commands;

import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUnknown extends Command
{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException
    {
        String msg = "Ukendt ressource. Kontakt IT support for hjælp.";
        throw new UserException(msg);
    }

}
