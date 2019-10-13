//Tool decorator is an implementation of the decorator pattern, adding to the Tools add ons and accessories.

import java.util.ArrayList;

public abstract class ToolDecorator extends Tool{
  public abstract double cost();
  public abstract String getName();
  public abstract String getToolName();
}