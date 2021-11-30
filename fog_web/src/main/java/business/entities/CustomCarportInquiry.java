package business.entities;

public class CustomCarportInquiry {

    // - Carport dimensions -
  private  int carportWidth;
  private  int carportLength;
  private  int carportHeight;
  private  int carportRoof;
  private  int roofAngle;


    public CustomCarportInquiry(int carportWidth, int carportLength, int carportHeight, int carportRoof, int roofAngle, ContanctInfo contanctInfo, ToolInfo toolInfo) {

        this.carportWidth = carportWidth;
        this.carportLength = carportLength;
        this.carportHeight = carportHeight;
        this.carportRoof = carportRoof;
        this.roofAngle = roofAngle;

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

}
