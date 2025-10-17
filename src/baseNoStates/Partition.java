package baseNoStates;

import java.util.ArrayList;

public class Partition extends Area {
  private ArrayList<Area> areas;

  public Partition(String name, ArrayList<Area> areas, Area parent) {
    super(name, parent);
    this.areas = areas;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area area : areas)
    {
        spaces.addAll(area.getSpaces());
    }
    return spaces;
  }

    @Override
    public Area findAreaById(String id) {

      Area find = null;
      for (Area area : areas){

          find = area.findAreaById(id);

          if (find != null) {
              return find;
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
}
