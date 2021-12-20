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
        ArrayList<CustomCarportInquiry> ccpiList = new ArrayList<>();
        HttpSession session = request.getSession();

        try {
            if(searchCategory.equals("ccpiId")) {
                int searchId = Integer.parseInt(search_input);
                ccpiList = customCarportFacade.getSearchInquiryById(searchId);
            } else if (searchCategory.equals("date")) {

            } else if (searchCategory.equals("lastName")) {

            }

            session.setAttribute("error", null);
            session.setAttribute("ccpiList", ccpiList);

            return REDIRECT_INDICATOR + super.pageToShow;
        } catch (UserException ex) {
            session.setAttribute("ccpiList", ccpiList);
            session.setAttribute("error", ex.getMessage());
            return super.pageToShow;
        }

    }
}
