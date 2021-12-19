package web.commands;

import business.entities.CustomCarportInquiry;
import business.exceptions.UserException;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

public class SearchInquiryCommand extends CommandUnprotectedPage {
    CustomCarportFacade customCarportFacade;

    public SearchInquiryCommand(String pageToShow) {
        super(pageToShow);
        customCarportFacade = new CustomCarportFacade(database);
    }


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {

        String searchCategory = request.getParameter("searchCategory");
        String search_input = request.getParameter("search_input");
        ArrayList<CustomCarportInquiry> ccpiArr = new ArrayList<CustomCarportInquiry>();
        HttpSession session =   request.getSession();

        try {

            if (searchCategory.equals("ccpiId")) {
                customCarportFacade.getSearchInquiryById(search_input);
            }
            if (searchCategory.equals("date")) {

            }

            if (searchCategory.equals("lastName")) {

            }


        } catch (UserException ex) {
            session.setAttribute("cppiId", ccpiArr);
        }

        return search_input;
    }
}
