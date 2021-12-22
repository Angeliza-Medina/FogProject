package web.commands;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchInquiryCommand extends CommandProtectedPage{
   CustomCarportFacade customCarportFacade;

   public SearchInquiryCommand(String pageToShow, String role) {
      super(pageToShow, role);
      customCarportFacade = new CustomCarportFacade(database);
   }


   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response){

      String searchCategory = request.getParameter("searchCategory");
      String search_input = request.getParameter("search_input");
      ArrayList<CustomCarportInquiry> ccpiArr = new ArrayList<>();
      HttpSession session = request.getSession();

      try {
         if(searchCategory.equals("ccpiId")) {
            try{
               int searchId = Integer.parseInt(search_input);

               ccpiArr = customCarportFacade.getSearchInquiryById(searchId);
            }catch (NumberFormatException ex){
               throw new UserException("Det indtastede input var ikke gyldigt");
            }

         } else if (searchCategory.equals("date")) {
            LocalDate searchDate = LocalDate.parse(search_input);

            ccpiArr = customCarportFacade.getSearchInquiryByDate(searchDate);

         }else if (searchCategory.equals("lastName")) {
            String searchLastName = search_input;

            ccpiArr = customCarportFacade.getSearchInquiryByLastName(searchLastName);
         }

         session.removeAttribute("error");
         session.setAttribute("ccpiList", ccpiArr);

         return REDIRECT_INDICATOR + super.pageToShow;
      } catch (UserException ex) {
         session.setAttribute("ccpiList", ccpiArr);
         session.setAttribute("error", ex.getMessage());

         return super.pageToShow;
      }

   }
}
