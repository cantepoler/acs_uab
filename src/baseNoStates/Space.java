package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;

public class Space extends Area {
  private Door[] doors;

  public Space(String name, Door[] doors, Area parent) {
    super(name, parent);
    this.doors = doors;
  }

  @Override
  public ArrayList<Space> getSpaces() {
    return new ArrayList<Space>(Arrays.asList(this));
  }
}
