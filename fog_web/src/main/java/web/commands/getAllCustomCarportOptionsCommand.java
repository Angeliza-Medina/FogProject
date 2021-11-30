package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class getAllCustomCarportOptionsCommand extends CommandUnprotectedPage{
   CustomCarportFacade customCarportFacade;

   public getAllCustomCarportOptionsCommand(String pageToShow){
      super(pageToShow);
      customCarportFacade = new CustomCarportFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      try {
         customCarportFacade.getAllCustomCarportOptions();

         HttpSession session = request.getSession();

//         session.setAttribute("user", user);

         // test
         String lastPage = request.getHeader("Referer");
         System.out.println(lastPage);

         String pageToShow =  "customCarportST"; // Change later
         return REDIRECT_INDICATOR + pageToShow;
      } catch (UserException ex) {
         request.setAttribute("error", "Could not load data from our database...");
         return "error";
      }
   }

}
