package web.commands;

import business.entities.User;
import business.services.UserFacade;
import business.exceptions.UserException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand extends CommandUnprotectedPage {
    private UserFacade userFacade;

    public LoginCommand(String pageToShow) {
        super(pageToShow);
        userFacade = new UserFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");


        try {

            if (email.trim().length() == 0 || password.trim().length() == 0) {
                throw new UserException("Begge felter skal være udfyldt!");
            }

            User user = userFacade.login(email, password);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());

            String pageToShow = "";

            if(user.getRole().equals("customer")){
                pageToShow = "index";
            }else if(user.getRole().equals("admin")){
                pageToShow = "ccpiList";
            }

            return REDIRECT_INDICATOR + pageToShow;
        } catch (UserException ex) {
            pageToShow = "index";
            request.setAttribute("error", ex.getMessage());
            return pageToShow;
        }
    }

}
