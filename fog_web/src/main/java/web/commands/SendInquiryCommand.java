package web.commands;

import business.entities.ContactInfo;
import business.entities.CustomCarport;
import business.entities.CustomCarportInquiry;
import business.entities.Toolshed;
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
        System.out.println("1");
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
        System.out.println("2");

        // - Carport info -
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        System.out.println(carportWidth);
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        System.out.println(carportLength);
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        System.out.println(carportHeight);
        int roofTypeID = Integer.parseInt(request.getParameter("roofType"));
        System.out.println(roofTypeID);
        int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));
        System.out.println(roofAngle);
        int roofMaterialID = Integer.parseInt(request.getParameter("roofMaterial"));
        System.out.println(roofMaterialID);
        System.out.println("3");

        // - Toolshed info -
        System.out.println("Before toolshed options");
        int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
        int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));
        int toolshedCladdingID = Integer.parseInt(request.getParameter("toolshedCladding"));
        System.out.println("After toolshed options");

        // Temp. solution
        if(toolshedLength == 0){
            toolshedCladdingID = 1;
        }

        String pageToGoTo = request.getParameter("pageToGoTo");

        try {
            ContactInfo contactInfo = new ContactInfo(firstName,lastName, address, postalCode, city, email, phoneNum, note);
            Toolshed toolshed = new Toolshed(toolshedWidth, toolshedLength, toolshedCladdingID);
            CustomCarport customCarport = new CustomCarport(carportWidth, carportLength, carportHeight, roofTypeID, roofAngle, roofMaterialID, toolshed);
            CustomCarportInquiry cpi = new CustomCarportInquiry(userID, customCarport, contactInfo, toolshed, note);

            customCarportFacade.sendInquiryToDB(cpi);

            String pageToShow =  pageToGoTo;

            return REDIRECT_INDICATOR + pageToShow;
        }catch (UserException ex) {
            System.out.println(ex.getMessage());
            request.setAttribute("error", ex.getMessage());
            return pageToGoTo;
        }

    }


}

