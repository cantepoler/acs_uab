package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  protected final String id;
  protected final String name;
  protected final Area parent;

  public Area(String id, String name, Area parent) {
    this.id = id;
    this.name = name;
    this.parent = parent;
  }

  public String getId() {
    return id;
  }

  public abstract ArrayList<Space> getSpaces();

  public abstract void acceptVisitor(Visitor visitor);
}
