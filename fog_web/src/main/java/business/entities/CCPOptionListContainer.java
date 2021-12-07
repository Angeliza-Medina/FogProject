package business.entities;

import java.util.ArrayList;

public class CCPOptionListContainer {
   private ArrayList<RoofTypeOption> roofTypeOptions;
   private ArrayList<Integer> roofAngleOptions;
   private ArrayList<RoofMaterialOption> roofMaterialOptions;
   private ArrayList<Integer> ccpWidthOptions;
   private ArrayList<Integer> ccpLengthOptions;
   private ArrayList<Integer> ccpHeightOptions;
   private ArrayList<Integer> ctsWidthOptions;
   private ArrayList<Integer> ctsLengthOptions;
   private ArrayList<CTSCladdingOption> ctsCladdingOptions;


   public CCPOptionListContainer(ArrayList<RoofTypeOption> roofTypeOptions,
                                 ArrayList<Integer> roofAngleOptions,
                                 ArrayList<RoofMaterialOption> roofMaterialOptions,
                                 ArrayList<Integer> ccpWidthOptions,
                                 ArrayList<Integer> ccpLengthOptions,
                                 ArrayList<Integer> ccpHeightOptions,
                                 ArrayList<Integer> ctsWidthOptions,
                                 ArrayList<Integer> ctsLengthOptions,
                                 ArrayList<CTSCladdingOption> ctsCladdingOptions)
   {
      this.roofTypeOptions = roofTypeOptions;
      this.roofAngleOptions = roofAngleOptions;
      this.roofMaterialOptions = roofMaterialOptions;
      this.ccpWidthOptions = ccpWidthOptions;
      this.ccpLengthOptions = ccpLengthOptions;
      this.ccpHeightOptions = ccpHeightOptions;
      this.ctsWidthOptions = ctsWidthOptions;
      this.ctsLengthOptions = ctsLengthOptions;
      this.ctsCladdingOptions = ctsCladdingOptions;
   }


   public ArrayList<RoofTypeOption> getRoofTypeOptions() {
      return roofTypeOptions;
   }

   public void setRoofTypeOptions(ArrayList<RoofTypeOption> roofTypeOptions) {
      this.roofTypeOptions = roofTypeOptions;
   }

   public ArrayList<Integer> getRoofAngleOptions() {
      return roofAngleOptions;
   }

   public void setRoofAngleOptions(ArrayList<Integer> roofAngleOptions) {
      this.roofAngleOptions = roofAngleOptions;
   }

   public ArrayList<RoofMaterialOption> getRoofMaterialOptions() {
      return roofMaterialOptions;
   }

   public void setRoofMaterialOptions(ArrayList<RoofMaterialOption> roofMaterialOptions) {
      this.roofMaterialOptions = roofMaterialOptions;
   }

   public ArrayList<Integer> getCcpWidthOptions() {
      return ccpWidthOptions;
   }

   public void setCcpWidthOptions(ArrayList<Integer> ccpWidthOptions) {
      this.ccpWidthOptions = ccpWidthOptions;
   }

   public ArrayList<Integer> getCcpLengthOptions() {
      return ccpLengthOptions;
   }

   public void setCcpLengthOptions(ArrayList<Integer> ccpLengthOptions) {
      this.ccpLengthOptions = ccpLengthOptions;
   }

   public ArrayList<Integer> getCcpHeightOptions() {
      return ccpHeightOptions;
   }

   public void setCcpHeightOptions(ArrayList<Integer> ccpHeightOptions) {
      this.ccpHeightOptions = ccpHeightOptions;
   }

   public ArrayList<Integer> getCtsWidthOptions() {
      return ctsWidthOptions;
   }

   public void setCtsWidthOptions(ArrayList<Integer> ctsWidthOptions) {
      this.ctsWidthOptions = ctsWidthOptions;
   }

   public ArrayList<Integer> getCtsLengthOptions() {
      return ctsLengthOptions;
   }

   public void setCtsLengthOptions(ArrayList<Integer> ctsLengthOptions) {
      this.ctsLengthOptions = ctsLengthOptions;
   }

   public ArrayList<CTSCladdingOption> getCtsCladdingOptions() {
      return ctsCladdingOptions;
   }

   public void setCtsCladdingOptions(ArrayList<CTSCladdingOption> ctsCladdingOptions) {
      this.ctsCladdingOptions = ctsCladdingOptions;
   }
}
