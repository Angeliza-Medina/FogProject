package business.entities;

public class Toolshed {
    private int cts_id;
    private int toolshedWidth;
    private int toolshedLength;
    private int toolshedCladdingId;

    private String placement;

    // Constructor used for sending data to db + Calc. method
    public Toolshed(int toolshedWidth, int toolshedLength, int toolshedCladdingId) {
        this.toolshedWidth = toolshedWidth;
        this.toolshedLength = toolshedLength;
        this.toolshedCladdingId = toolshedCladdingId;
        this.placement = "left";
    }

    // Constructor used for getting ccpi by id from db
    public Toolshed(int cts_id, int ctsWidth, int ctsLength, int ctsCladding_id){
        this.cts_id = cts_id;
        this.toolshedWidth = ctsWidth;
        this.toolshedLength = ctsLength;
        this.toolshedCladdingId = ctsCladding_id;
        this.placement = "left";
    }


    public int getCts_id() {
        return cts_id;
    }

    public void setCts_id(int cts_id) {
        this.cts_id = cts_id;
    }

    public int getToolshedWidth() {
        return toolshedWidth;
    }

    public void setToolshedWidth(int toolshedWidth) {
        this.toolshedWidth = toolshedWidth;
    }

    public int getToolshedLength() {
        return toolshedLength;
    }

    public void setToolshedLength(int toolshedLength) {
        this.toolshedLength = toolshedLength;
    }

    public int getToolshedCladdingId() {
        return toolshedCladdingId;
    }

    public void setToolshedCladdingId(int toolshedCladdingId) {
        this.toolshedCladdingId = toolshedCladdingId;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

}
