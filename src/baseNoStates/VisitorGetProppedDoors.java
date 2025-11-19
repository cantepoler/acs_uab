package baseNoStates;

import java.util.ArrayList;

public class VisitorGetProppedDoors implements Visitor {
  ArrayList<Door> proppedDoors = new ArrayList<>();
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
