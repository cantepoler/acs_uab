package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

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
