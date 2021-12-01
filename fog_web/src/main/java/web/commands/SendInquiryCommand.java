package web.commands;

import business.entities.ContactInfo;
import business.entities.CustomCarportInquiry;
import business.entities.ToolInfo;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendInquiryCommand extends CommandUnprotectedPage{
    CustomCarportFacade customCarportFacade;

    public SendInquiryCommand(String pageToShow) {
        super(pageToShow);
        customCarportFacade = new CustomCarportFacade(database);
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        // - User info-
        int userID = 2; // todo change from hardcode to dynamic later
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        int postalCode = Integer.parseInt(request.getParameter("postalCode"));
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String note = request.getParameter("note");

        // - Carport dimensions -
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int roofType = Integer.parseInt(request.getParameter("roofType"));
        int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));
        int roofMaterial = Integer.parseInt(request.getParameter("roofMaterial"));

        // - Toolshed dimensions -
        int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
        int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));
        String pageToGoTo = request.getParameter("pageToGoTo");

        try {
            ContactInfo contactInfo = new ContactInfo(firstName,lastName, address, postalCode, town, email, phoneNum, note);
            ToolInfo toolInfo = new ToolInfo(toolshedWidth, toolshedLength);

            CustomCarportInquiry cpi = new CustomCarportInquiry(
                   userID, carportWidth, carportLength, carportHeight,
                   roofType, roofAngle, roofMaterial, contactInfo, toolInfo, note);

            customCarportFacade.sendInquiryToDB(cpi);
            System.out.println("HERE5!!!");
            String pageToShow =  pageToGoTo;
            return REDIRECT_INDICATOR + pageToShow;
        }catch (UserException ex) {
            System.out.println("HERE6!!!");
            System.out.println(ex.getMessage());
            request.setAttribute("error", "Wrong input");
            return pageToGoTo;
        }

    }


}

