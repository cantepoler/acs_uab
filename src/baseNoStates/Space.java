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

  //returns itself as an arraylist
  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<>(Arrays.asList(this));
  }

  //if this is the area we are searching for returns true
  //if not returns null
  @Override
  public Area findAreaById(String id) {
      if (id.equals(this.id))
      {
          return this;
      }

      return null;
  }

  //if there is any door on these space and it gives
  //access to it, the door is added to the list we return.
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsGivingAccess = new ArrayList<>();
    if (this.doors != null) {
      for (Door door : doors) {
        if (door.toSpace == this || door.fromSpace == this) {
          doorsGivingAccess.add(door);
        }
      }

      return doorsGivingAccess;
    }
    return doorsGivingAccess;
  }
}
