package baseNoStates;

import java.util.ArrayList;

// A specific Visitor designed to find all the doors that are currently propped.
//
// This class uses the Visitor pattern to walk through the entire
// Area hierarchy. It checks every room, looks at the doors,
// and if a door is propped, it adds it to the list.

public class VisitorGetProppedDoors implements Visitor {
  private final ArrayList<Door> proppedDoors = new ArrayList<>();
  public VisitorGetProppedDoors() {}
  public void visitSpace(Space space) {
    if (space.getDoors() != null) {
      for (Door door : space.getDoors()) {
        if (door.isPropped()) {
          proppedDoors.add(door);
        }
      }
    }
  }
  public void visitPartition(Partition partition) {
    for (Area area : partition.getAreas()) {
      area.acceptVisitor(this);
    }
  }

  public ArrayList<Door> getProppedDoors() {
    return proppedDoors;
  }
}
