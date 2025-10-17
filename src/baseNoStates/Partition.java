package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  private Area[] areas;

  public Partition(String name, Area[] areas, Area parent) {
    super(name, parent);
    this.areas = areas;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<Space>();
    for(Area area : areas) {
      spaces.add(area.getSpaces());
    }
    return spaces;
  }
}
