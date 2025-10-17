package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  private ArrayList<Area> areas;

  public Partition(String id, String name, Area parent) {
    super(id, name, parent);
    this.areas = areas;
  }
  public Partition(String id, String name, ArrayList<Area> areas, Area parent) {
    super(id, name, parent);
    this.areas = areas;
  }

  //iterates for every area of its list and adds all the spaces of that area
  //to his personal list
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area area : areas)
    {
        spaces.addAll(area.getSpaces());
    }
    return spaces;
  }

  //First checks if it is the area we are looking for, if it is returns itself, if not
  //goes for all its areas and checks if one of them is the one, if not returns null
  @Override
  public Area findAreaById(String id) {

    Area find = null;
    if (this.id.equals(id)){
      find = this;
    } else {
      for (Area area : areas) {

        find = area.findAreaById(id);

        if (find != null) {
          return find;
        }
      }
    }
    return find;
  }

  @Override
  public ArrayList<Door> getDoorsGivingAccess() {
    ArrayList<Door> doorsGivingAcces = new ArrayList<>();
    for (Area area : areas)
    {
        doorsGivingAcces.addAll(area.getDoorsGivingAccess());
    }
    return doorsGivingAcces;
  }

  public void setAreas(ArrayList<Area> areas) {
    this.areas = areas;
  }
}
