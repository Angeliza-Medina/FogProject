package business.entities;

public class Toolshed {
    private int cts_id;
    private int toolshedWidth;
    private int toolshedLength;
    private int toolshedCladdingId;

    // Constructor used for sending data to db
    public Toolshed(int toolshedWidth, int toolshedLength, int toolshedCladdingId) {
        this.toolshedWidth = toolshedWidth;
        this.toolshedLength = toolshedLength;
        this.toolshedCladdingId = toolshedCladdingId;
    }

    // Constructor used for getting ccpi by id from db
    public Toolshed(int cts_id, int ctsWidth, int ctsLength, int ctsCladding_id){
        this.cts_id = cts_id;
        this.toolshedWidth = ctsWidth;
        this.toolshedLength = ctsLength;
        this.toolshedCladdingId = ctsCladding_id;
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

}
