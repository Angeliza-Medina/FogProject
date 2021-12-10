package web.commands;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetInquiryByIdCommand extends CommandProtectedPage{
   public String pageToShow;
   private CustomCarportFacade customCarportFacade;

   public GetInquiryByIdCommand(String pageToShow, String role) {
      super(pageToShow, role);
      customCarportFacade = new CustomCarportFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      int inquiryId = Integer.parseInt(request.getParameter("ccpiId"));

      try{
         CustomCarportInquiry customCarportInquiry = customCarportFacade.getInquiryById(inquiryId);

         HttpSession session = request.getSession();

         session.setAttribute("inquiryById", customCarportInquiry);
         pageToShow = "ccpiMaterialCalculator";

         return REDIRECT_INDICATOR + pageToShow;
      } catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return "index";
      }
   }
}
