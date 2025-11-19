package baseNoStates;

import java.util.ArrayList;

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
