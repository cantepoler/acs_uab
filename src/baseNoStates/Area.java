package baseNoStates;

import java.util.ArrayList;

public abstract class Area {
  protected String id;
  protected String name;
  protected Area parent;

  public Area(String id, String name, Area parent) {
    this.id = id;
    this.name = name;
    this.parent = parent;
  }

  public abstract ArrayList<Space> getSpaces();

  public abstract ArrayList<Door> getDoorsGivingAccess();

  public abstract Area findAreaById(String id);
}
