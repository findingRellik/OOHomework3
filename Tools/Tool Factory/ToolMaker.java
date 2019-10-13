//Concrete Tool factory (factory pattern)

public class ToolMaker extends ToolFactory{
  public Store store = null;
  public ToolMaker(Store s){
    store = s;
  }
  public Tool createTool(String type, String name){
    if(type.equals("painting")){
      Tool n = new PaintingTool(name);
      store.tools.add(n);
      return n;
    }
    else if(type.equals("concrete")){
      Tool n = new ConcreteTool(name);
      store.tools.add(n);
      return n;
    }
    else if(type.equals("plumbing")){
      Tool n = new PlumbingTool(name);
      store.tools.add(n);
      return n;
    }
    else if(type.equals("woodwork")){
      Tool n = new WoodworkTool(name);
      store.tools.add(n);
      return n;
    }
    else if(type.equals("yardwork")){
      Tool n = new YardworkTool(name);
      store.tools.add(n);
      return n;
    }
    return null;
  }
}