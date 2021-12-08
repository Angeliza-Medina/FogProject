package business.entities;

public class Toolshed {
    private  int toolshedWidth;
    private  int toolshedLength;
    private int toolshedCladdingId;

    public Toolshed(int toolshedWidth, int toolshedLength, int toolshedCladdingId) {
        this.toolshedWidth = toolshedWidth;
        this.toolshedLength = toolshedLength;
        this.toolshedCladdingId = toolshedCladdingId;
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
