package baseNoStates;

import java.util.ArrayList;

public class VisitorDoorGivingAccess implements Visitor {
  private final ArrayList<Door> doorsGivingAccess;
  public VisitorDoorGivingAccess() {
    doorsGivingAccess = new ArrayList<>();
  }
  public void visitSpace(Space space) {
    if (space.getDoors() != null) {
      for (Door door : space.getDoors()) {
        if (door.getToSpace() == space || door.getFromSpace() == space) {
          doorsGivingAccess.add(door);
        }
      }
    }
  }
  public void visitPartition(Partition partition) {
    for (Area area : partition.getAreas()) {
      area.acceptVisitor(this);
    }
  }

  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }
}
