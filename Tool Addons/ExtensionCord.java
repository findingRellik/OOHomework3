import java.util.ArrayList;

public class ExtensionCord extends ToolDecorator{
  Tool tool;
  String name = "Extension Cord";
  public ExtensionCord(Tool t){
    tool = t;
  }
  public double cost(){
    return tool.cost() + 1.99;
  }
  public ArrayList<String> returnOptions(){
    ArrayList<String> newOptions = tool.returnOptions();
    newOptions.add(name);
    return newOptions;
  }
  public String getName(){
    return tool.getName() + " + " + name;
  }
  public String getToolName(){
    return tool.getToolName();
  }
  public Tool returnTool(){
    return tool.returnTool();
  }
}