package business.entities;

public class CustomCarportInquiry {

    // - Carport dimensions -
  private  int carportWidth;
  private  int carportLength;
  private  int carportHeight;
  private  int carportRoof;
  private  int roofAngle;
  private int roofType;
  private int roofMaterial;
  private ContanctInfo contanctInfo;
  private ToolInfo toolInfo;


    public CustomCarportInquiry(int carportWidth, int carportLength, int carportHeight, int carportRoof, int roofAngle, int roofType, int roofMaterial, ContanctInfo contanctInfo, ToolInfo toolInfo) {

        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
        this.carportRoof = carportRoof;
        this.roofAngle = roofAngle;
        this.contanctInfo = contanctInfo;
        this.toolInfo = toolInfo;
        this.roofType = roofType;
        this.roofMaterial = roofMaterial;



    }

    public int getCarportWidth() {
        return carportWidth;
    }

    public void setCarportWidth(int carportWidth) {
        this.carportWidth = carportWidth;
    }

    public int getCarportLength() {
        return carportLength;
    }

    public void setCarportLength(int carportLength) {
        this.carportLength = carportLength;
    }

    public int getCarportHeight() {
        return carportHeight;
    }

    public void setCarportHeight(int carportHeight) {
        this.carportHeight = carportHeight;
    }

    public int getCarportRoof() {
        return carportRoof;
    }

    public void setCarportRoof(int carportRoof) {
        this.carportRoof = carportRoof;
    }

    public int getRoofAngle() {
        return roofAngle;
    }

    public void setRoofAngle(int roofAngle) {
        this.roofAngle = roofAngle;
    }

    public ContanctInfo getContanctInfo() {
        return contanctInfo;
    }

    public void setContanctInfo(ContanctInfo contanctInfo) {
        this.contanctInfo = contanctInfo;
    }

    public ToolInfo getToolInfo() {
        return toolInfo;
    }

    public void setToolInfo(ToolInfo toolInfo) {
        this.toolInfo = toolInfo;
    }

    public int getRoofType() {
        return roofType;
    }

    public void setRoofType(int roofType) {
        this.roofType = roofType;
    }

    public int getRoofMaterial() {
        return roofMaterial;
    }

    public void setRoofMaterial(int roofMaterial) {
        this.roofMaterial = roofMaterial;
    }
}
