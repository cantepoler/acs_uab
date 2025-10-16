package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  protected String name;
  // crec que no cal de moment protected Area parent;

  public Area(String name, Area parent) {
    this.name = name;
    //this.parent = parent;
  }
  public abstract ArrayList<Space> getSpaces();

  public Door[] getDoorsGivingAccess() {
    return null;
  }
}
