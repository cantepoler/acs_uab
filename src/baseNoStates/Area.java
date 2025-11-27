package baseNoStates;

import java.util.ArrayList;


// The abstract base class for everything in the building structure (rooms, floors, etc.).
//
// This is the Component in the Composite Design Pattern. It lets us treat a single room (Space)
// and a whole floor (Partition) in the same way.
//
// It also implements the Visitor Pattern. We use this so we can
// run operations like searching for an ID or listing info across the whole building structure
// without changing the code inside the Area classes.

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

  public String getName() {
    return name;
  }
}
