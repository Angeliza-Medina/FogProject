package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.CCPOptionFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetCCPOptionsCommand extends CommandUnprotectedPage{
   CCPOptionFacade ccpOptionFacade;

   public GetCCPOptionsCommand(String pageToShow){
      super(pageToShow);
      ccpOptionFacade = new CCPOptionFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response){
      String pageToGo = request.getParameter("pageToGo");

      try {
         ArrayList<RoofTypeOption> roofTypeOptions = ccpOptionFacade.getCCPRoofTypeOptions();
         ArrayList<Integer> roofAngleOptions = ccpOptionFacade.getCCPRoofAngleOptions();
         ArrayList<RoofMaterialOption> roofMaterialOptions = ccpOptionFacade.getCCPRoofMaterialOptions();
         ArrayList<Integer> ccpWidthOptions = ccpOptionFacade.getCCPWidthOptions();
         ArrayList<Integer> ccpLengthOptions = ccpOptionFacade.getCCPLengthOptions();
         ArrayList<Integer> ccpHeightOptions = ccpOptionFacade.getCCPHeightOptions();
         ArrayList<Integer> ctsWidthOptions = ccpOptionFacade.getCTSWidthOptions();
         ArrayList<Integer> ctsLengthOptions = ccpOptionFacade.getCTSLengthOptions();
         ArrayList<CTSCladdingOption> ctsCladdingOptions = ccpOptionFacade.getCladdingOptions();

         CCPOptionListContainer cCPOptionListContainer = new CCPOptionListContainer(
                roofTypeOptions,
                roofAngleOptions,
                roofMaterialOptions,
                ccpWidthOptions,
                ccpLengthOptions,
                ccpHeightOptions,
                ctsWidthOptions,
                ctsLengthOptions,
                ctsCladdingOptions);

         HttpSession session = request.getSession();

         session.setAttribute("ccpOptionListContainer", cCPOptionListContainer);

         return REDIRECT_INDICATOR + pageToGo;
      } catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return "index";
      }
   }

}
