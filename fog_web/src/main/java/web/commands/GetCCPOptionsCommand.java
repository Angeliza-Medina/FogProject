package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.CCPOptionFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetCCPOptionsCommand extends CommandUnprotectedPage{
   CCPOptionFacade cCPOptionFacade;

   public GetCCPOptionsCommand(String pageToShow){
      super(pageToShow);
      cCPOptionFacade = new CCPOptionFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response){
      String pageToGo = request.getParameter("pageToGo");

      try {
         ArrayList<RoofTypeOption> roofTypeOptions = cCPOptionFacade.getCCPRoofTypeOptions();
         ArrayList<RoofAngleOption> roofAngleOptions = cCPOptionFacade.getCCPRoofAngleOptions();
         ArrayList<RoofMaterialOption> roofMaterialOptions = cCPOptionFacade.getCCPRoofMaterialOptions();
         ArrayList<CCPWidthOption> cCPWidthOptions = cCPOptionFacade.getCCPWidthOptions();
         ArrayList<CCPLengthOption> cCPLengthOptions = cCPOptionFacade.getCCPLengthOptions();
//         ArrayList<CCPHeightOption> cCPHeightOptions = cCPOptionFacade.getCCPHeightOptions();
//         ArrayList<CTSWidthOption> cTSWidthOptions = cCPOptionFacade.getCTSWidthOptions();
//         ArrayList<CTSLengthOption> cTSLengthOptions = cCPOptionFacade.getCTSLengthOptions();

//         CCPOptionListContainer cCPOptionListContainer = new CCPOptionListContainer(roofTypeOptions);

         HttpSession session = request.getSession();

//         session.setAttribute("cCPOptionListContainer", cCPOptionListContainer);

         return REDIRECT_INDICATOR + pageToGo;
      } catch (UserException ex) {
         request.setAttribute("error", "Something went wrong...");
         return "error";
      }
   }

}
