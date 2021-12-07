package web.commands;

import business.entities.ContactInfo;
import business.entities.CustomCarportInquiry;
import business.entities.ToolshedInfo;
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
            ContactInfo contactInfo = new ContactInfo(firstName,lastName, address, postalCode, city, email, phoneNum, note);
            ToolshedInfo toolshedInfo = new ToolshedInfo(toolshedWidth, toolshedLength, toolshedCladdingID);
            CustomCarportInquiry cpi = new CustomCarportInquiry(
                   userID, carportWidth, carportLength, carportHeight,
                   roofTypeID, roofAngle, roofMaterialID, contactInfo, toolshedInfo, note
            );

            customCarportFacade.sendInquiryToDB(cpi);

            String pageToShow =  pageToGoTo;

            return REDIRECT_INDICATOR + pageToShow;
        }catch (UserException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("error", "Wrong input");
            return pageToGoTo;
        }

    }


}

