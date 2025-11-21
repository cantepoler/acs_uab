package baseNoStates;

import java.util.ArrayList;

public class VisitorDoorGivingAccess implements Visitor {
  ArrayList<Door> doorsGivingAccess =  null;
  public VisitorDoorGivingAccess() {
    doorsGivingAccess = new ArrayList<>();
  }
  public void visitSpace(Space space) {
    if (space.getDoors() != null) {
      for (Door door : space.getDoors()) {
        if (door.toSpace == space || door.fromSpace == space) {
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
