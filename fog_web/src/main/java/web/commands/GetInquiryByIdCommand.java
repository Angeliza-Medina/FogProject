package web.commands;

import business.entities.*;
import business.exceptions.UserException;
import business.services.CCPOptionFacade;
import business.services.CustomCarportFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class GetInquiryByIdCommand extends CommandProtectedPage{
   public String pageToShow;
   private CustomCarportFacade customCarportFacade;
   private CCPOptionFacade ccpOptionFacade;

   public GetInquiryByIdCommand(String pageToShow, String role) {
      super(pageToShow, role);
      customCarportFacade = new CustomCarportFacade(database);
      ccpOptionFacade = new CCPOptionFacade(database);
   }

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      int inquiryId = Integer.parseInt(request.getParameter("ccpiId"));

      try{
         // Get requested inquiry by id
         CustomCarportInquiry customCarportInquiry = customCarportFacade.getInquiryById(inquiryId);

         // Get calculator settings
         ArrayList<RoofTypeOption> roofTypeOptions = ccpOptionFacade.getCCPRoofTypeOptions();
         ArrayList<Integer> roofAngleOptions = ccpOptionFacade.getCCPRoofAngleOptions();
         ArrayList<RoofMaterialOption> roofMaterialOptions = ccpOptionFacade.getCCPRoofMaterialOptions();
         ArrayList<Integer> ccpRafterSpacingOptions = ccpOptionFacade.getCCPRafterSpacingOptions();
         ArrayList<Integer> ccpWidthOptions = ccpOptionFacade.getCCPWidthOptions();
         ArrayList<Integer> ccpLengthOptions = ccpOptionFacade.getCCPLengthOptions();
         ArrayList<Integer> ccpHeightOptions = ccpOptionFacade.getCCPHeightOptions();
         ArrayList<Integer> ctsWidthOptions = ccpOptionFacade.getCTSWidthOptions();
         ArrayList<Integer> ctsLengthOptions = ccpOptionFacade.getCTSLengthOptions();
         ArrayList<CTSCladdingOption> ctsCladdingOptions = ccpOptionFacade.getCladdingOptions();

         CCPOptionListContainer ccpOptionListContainer = new CCPOptionListContainer(
                roofTypeOptions,
                roofAngleOptions,
                roofMaterialOptions,
                ccpRafterSpacingOptions,
                ccpWidthOptions,
                ccpLengthOptions,
                ccpHeightOptions,
                ctsWidthOptions,
                ctsLengthOptions,
                ctsCladdingOptions);

         HttpSession session = request.getSession();

         session.setAttribute("inquiryById", customCarportInquiry);
         session.setAttribute("ccpOptionListContainer", ccpOptionListContainer);

         pageToShow = "ccpiMaterialCalculator";

         return REDIRECT_INDICATOR + pageToShow;
      } catch (UserException ex) {
         request.setAttribute("error", ex.getMessage());
         return "ccpiList";
      }
   }
}
