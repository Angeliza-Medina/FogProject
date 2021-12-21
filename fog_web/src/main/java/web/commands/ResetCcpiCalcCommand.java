package web.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ResetCcpiCalcCommand extends CommandProtectedPage {

   public ResetCcpiCalcCommand(String pageToShow, String role) {
      super(pageToShow, role);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();

      session.removeAttribute("inquiryById");
      session.removeAttribute("materialList");
      session.removeAttribute("totalPrice");
      session.removeAttribute("recommendedPrice");
      session.removeAttribute("sketchInfo");

      return REDIRECT_INDICATOR + super.pageToShow;
   }
}
