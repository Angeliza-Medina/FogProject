package web.commands;

import business.entities.ContanctInfo;
import business.entities.CustomCarportInquiry;
import business.entities.ToolInfo;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarportStCommand extends CommandUnprotectedPage{
    CustomCarportFacade customCarportFacade;

    public CarportStCommand(String pageToShow) {
        super(pageToShow);
        customCarportFacade = new CustomCarportFacade(database);
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        // - User info-
        // Tilføj en int som skal indeholde et evt. userId. Hvis kunden ikke er logget på skal den sættes til null
        // userId hentes fra request.getSession, som bliver sat når brugeren logger ind (har vi ikke lavet endnu)
        // Indtil videre så bare sæt den til null. Når vi får lavet login, kan vi justere den :)
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

        CustomCarportInquiry cpi = new CustomCarportInquiry(carportWidth, carportLength, carportHeight, carportRoof, roofAngle, contanctInfo, toolInfo);

        // Tror den brokker sig, fordi metoden ikke er statisk (hvilket den heller ikke skal være)
        // Men her kalder du den som en statisk metode, fordi du kalder den på selve klassen
        // Hvis du i stedet kalder metoden på den instans af CustomCarportFacade (den du laver i constructor), burde den være glad :)
        customCarportFacade.sendInquiryToDB(cpi);

        // God idé at pakke det hele ind i en try/catch for at fange en evt. UserException
        // Se evt. på LoginCommand for at se et eksempel

        String pageToShow =  "customCarportST";
        return REDIRECT_INDICATOR + pageToShow;
    }

}

