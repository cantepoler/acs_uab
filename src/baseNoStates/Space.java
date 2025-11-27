package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

// Represents a single unit of space, like a room or a hallway.
//
// In the Composite Design Pattern, this acts as the "Leaf" node. It can't contain other
// areas, but it holds the references to the doors. It implements 'acceptVisitor' to allow
// visitors to perform operations on it.

public class Space extends Area {
  private ArrayList<Door> doors;

  public Space(String id, String name, Area parent) {
    super(id, name, parent);
  }

  public Space(String id, String name, ArrayList<Door> doors, Area parent) {
    super(id, name, parent);
    this.doors = doors;
  }

  // returns itself as an arraylist
  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<>(Arrays.asList(this));
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitSpace(this);
  }

  public ArrayList<Door> getDoors() {
    return doors;
  }
}
