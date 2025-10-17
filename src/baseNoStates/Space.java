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

  //if the doors in this area give acces to it they are added to the list
  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsGivingAccess = new ArrayList<>();
      for(Door door : doors)
      {
          if (door.toSpace == this){
              doorsGivingAccess.add(door);
          }
      }

      return doorsGivingAccess;
  }
}
