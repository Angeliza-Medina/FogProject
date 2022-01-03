package web.commands;

import business.entities.ContactInfo;
import business.entities.CustomCarport;
import business.entities.CustomCarportInquiry;
import business.entities.Toolshed;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendInquiryCommand extends CommandUnprotectedPage{
   CustomCarportFacade customCarportFacade;

   public SendInquiryCommand(String pageToShow) {
      super(pageToShow);
      customCarportFacade = new CustomCarportFacade(database);
   }


   public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
      // - User info-
      int userID = Integer.parseInt(request.getParameter("userId"));
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String address = request.getParameter("address");
      int postalCode = Integer.parseInt(request.getParameter("postalCode"));
      String city = request.getParameter("city");
      String email = request.getParameter("email");
      String phoneNum = request.getParameter("phoneNum");
      String note = request.getParameter("note");

      // - Carport info -
      int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
      int carportLength = Integer.parseInt(request.getParameter("carportLength"));
      int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
      int roofTypeID = Integer.parseInt(request.getParameter("roofType"));
      int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));
      int roofMaterialID = Integer.parseInt(request.getParameter("roofMaterial"));

      // - Toolshed info -
      int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
      int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));
      int toolshedCladdingID = Integer.parseInt(request.getParameter("toolshedCladding"));

      String pageToGoTo = request.getParameter("pageToGoTo");

      try {
         ContactInfo contactInfo = new ContactInfo(firstName,lastName, address, postalCode, city, email, phoneNum);
         Toolshed toolshed = new Toolshed(toolshedWidth, toolshedLength, toolshedCladdingID);
         CustomCarport customCarport = new CustomCarport(carportWidth, carportLength, carportHeight, roofTypeID, roofAngle, roofMaterialID, toolshed);
         CustomCarportInquiry cpi = new CustomCarportInquiry(userID, customCarport, contactInfo, note);

         HttpSession session = request.getSession();
         String statusMsg = "Din forespørgsel er nu blevet sendt!";

         if(cpi.getCustomCarport().getToolshed().getToolshedLength() == 0){
            // When no toolshed was incl.
            customCarportFacade.sendInquiryToDB2(cpi);
            session.setAttribute("statusMsg", statusMsg);
         }else{
            // When a toolshed was incl.
            customCarportFacade.sendInquiryToDB1(cpi);
            session.setAttribute("statusMsg", statusMsg);
         }

         String pageToShow =  pageToGoTo;

         return REDIRECT_INDICATOR + pageToShow;
      }catch (UserException ex) {
         System.out.println(ex.getMessage());
         request.setAttribute("error", ex.getMessage());
         return pageToGoTo;
      }

   }


}

