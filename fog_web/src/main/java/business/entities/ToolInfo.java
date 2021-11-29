package business.entities;

public class ToolInfo {
    private  int toolshedWidth;
    private  int toolshedLength;

    public ToolInfo(int toolshedWidth, int toolshedLength) {
        this.toolshedWidth = toolshedWidth;
        this.toolshedLength = toolshedLength;
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
}
