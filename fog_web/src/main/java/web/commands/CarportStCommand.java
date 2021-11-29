package web.commands;

import business.entities.ContanctInfo;
import business.entities.CustomCaportInquiry;
import business.entities.ToolInfo;
import business.exceptions.UserException;
import business.services.CarportFacade;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarportStCommand extends CommandUnprotectedPage{


    public CarportStCommand(String pageToShow) {
        super(pageToShow);
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        // - User info-
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        int postalCode =Integer.parseInt(request.getParameter("postalCode"));
        String town = request.getParameter("town");
        String email = request.getParameter("email");
        int phoneNum = Integer.parseInt(request.getParameter("phoneNum"));
        String note = request.getParameter("note");



        // - Carport dimensions -
        int carportWidth = Integer.parseInt(request.getParameter("carportWidth"));
        int carportLength = Integer.parseInt(request.getParameter("carportLength"));
        int carportHeight = Integer.parseInt(request.getParameter("carportHeight"));
        int carportRoof = Integer.parseInt(request.getParameter("carportRoof"));
        int roofAngle = Integer.parseInt(request.getParameter("roofAngle"));

        // - Toolshed dimensions -
        int toolshedWidth = Integer.parseInt(request.getParameter("toolshedWidth"));
        int toolshedLength = Integer.parseInt(request.getParameter("toolshedLength"));

        ContanctInfo contanctInfo = new ContanctInfo(firstName,lastName, address, postalCode, town, email, phoneNum, note);
        ToolInfo toolInfo = new ToolInfo(toolshedWidth, toolshedLength);

        CustomCaportInquiry cpi = new CustomCaportInquiry(carportWidth, carportLength, carportHeight, carportRoof, roofAngle, contanctInfo, toolInfo);

        CustomCarportFacade.sendInquiryToDatabase(cpi);
    }

}

