package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class Space extends Area {
  private ArrayList<Door> doors;

  public Space(String name, ArrayList<Door> doors, Area parent) {
    super(name, parent);
    this.doors = doors;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<Space>(Arrays.asList(this));
  }

    @Override
    public Area findAreaById(String id) {
        if (id.equals(this.id))
        {
            return this;
        }

        return null;
    }

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
