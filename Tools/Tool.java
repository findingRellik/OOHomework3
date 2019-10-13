import java.util.ArrayList;

public abstract class Tool implements ToolInterface{
  String name = "";
  public ArrayList<String> options = new ArrayList<String>();
  public ArrayList<String> returnOptions(){
    return options;
  }
  public String getName(){
    return name;
  }
  public String getToolName(){
    return name;
  }
  public Tool returnTool(){
    return this;
  }
}