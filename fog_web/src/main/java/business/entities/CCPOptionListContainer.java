package business.entities;

import java.util.ArrayList;

public class CCPOptionListContainer {
   private ArrayList<RoofTypeOption> roofTypeOptions;
   private ArrayList<RoofAngleOption> roofAngleOptions;
   private ArrayList<RoofMaterialOption> roofMaterialOptions;
   private ArrayList<CCPWidthOption> cCPWidthOptions;
   private ArrayList<CCPLengthOption> cCPLengthOptions;
   private ArrayList<CCPHeightOption> cCPHeightOptions;
   private ArrayList<CTSWidthOption> cTSWidthOptions;
   private ArrayList<CTSLengthOption> cTSLengthOptions;


   public CCPOptionListContainer(ArrayList<RoofTypeOption> roofTypeOptions,
                                 ArrayList<RoofAngleOption> roofAngleOptions,
                                 ArrayList<RoofMaterialOption> roofMaterialOptions,
                                 ArrayList<CCPWidthOption> cCPWidthOptions,
                                 ArrayList<CCPLengthOption> cCPLengthOptions,
                                 ArrayList<CCPHeightOption> cCPHeightOptions,
                                 ArrayList<CTSWidthOption> cTSWidthOptions,
                                 ArrayList<CTSLengthOption> cTSLengthOptions)
   {
      this.roofTypeOptions = roofTypeOptions;
      this.roofAngleOptions = roofAngleOptions;
      this.roofMaterialOptions = roofMaterialOptions;
      this.cCPWidthOptions = cCPWidthOptions;
      this.cCPLengthOptions = cCPLengthOptions;
      this.cCPHeightOptions = cCPHeightOptions;
      this.cTSWidthOptions = cTSWidthOptions;
      this.cTSLengthOptions = cTSLengthOptions;
   }


   public ArrayList<RoofTypeOption> getRoofTypeOptions() {
      return roofTypeOptions;
   }

   public void setRoofTypeOptions(ArrayList<RoofTypeOption> roofTypeOptions) {
      this.roofTypeOptions = roofTypeOptions;
   }

   public ArrayList<RoofAngleOption> getRoofAngleOptions() {
      return roofAngleOptions;
   }

   public void setRoofAngleOptions(ArrayList<RoofAngleOption> roofAngleOptions) {
      this.roofAngleOptions = roofAngleOptions;
   }

   public ArrayList<RoofMaterialOption> getRoofMaterialOptions() {
      return roofMaterialOptions;
   }

   public void setRoofMaterialOptions(ArrayList<RoofMaterialOption> roofMaterialOptions) {
      this.roofMaterialOptions = roofMaterialOptions;
   }

   public ArrayList<CCPWidthOption> getcCPWidthOptions() {
      return cCPWidthOptions;
   }

   public void setcCPWidthOptions(ArrayList<CCPWidthOption> cCPWidthOptions) {
      this.cCPWidthOptions = cCPWidthOptions;
   }

   public ArrayList<CCPLengthOption> getcCPLengthOptions() {
      return cCPLengthOptions;
   }

   public void setcCPLengthOptions(ArrayList<CCPLengthOption> cCPLengthOptions) {
      this.cCPLengthOptions = cCPLengthOptions;
   }

   public ArrayList<CCPHeightOption> getcCPHeightOptions() {
      return cCPHeightOptions;
   }

   public void setcCPHeightOptions(ArrayList<CCPHeightOption> cCPHeightOptions) {
      this.cCPHeightOptions = cCPHeightOptions;
   }

   public ArrayList<CTSWidthOption> getcTSWidthOptions() {
      return cTSWidthOptions;
   }

   public void setcTSWidthOptions(ArrayList<CTSWidthOption> cTSWidthOptions) {
      this.cTSWidthOptions = cTSWidthOptions;
   }

   public ArrayList<CTSLengthOption> getcTSLengthOptions() {
      return cTSLengthOptions;
   }

   public void setcTSLengthOptions(ArrayList<CTSLengthOption> cTSLengthOptions) {
      this.cTSLengthOptions = cTSLengthOptions;
   }

}
