package baseNoStates;

import java.util.ArrayList;


// Represents a container area, like a Floor or a Building, that holds other areas inside it.
//
// This is the Composite part of the Composite Design Pattern. It keeps a list of children
// (which can be Spaces or other Partitions). When a Visitor visits this partition,
// this class passes the visitor down to all its children, allowing us to go through the
// whole building recursively.

public class Partition extends Area {
  private ArrayList<Area> areas;

  public Partition(String id, String name, Area parent) {
    super(id, name, parent);
  }

  // iterates for every area of its list and adds all the spaces of that area
  // to his personal list
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area area : areas) {
      spaces.addAll(area.getSpaces());
    }
    return spaces;
  }

  public void setAreas(ArrayList<Area> areas) {
    this.areas = areas;
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitPartition(this);
  }

  public ArrayList<Area> getAreas() {
    return areas;
  }
}
