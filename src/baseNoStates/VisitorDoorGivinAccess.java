package baseNoStates;

import java.util.ArrayList;

public class VisitorDoorGivinAccess implements Visitor {
  ArrayList<Door> doorsGivingAccess =  null;
  public VisitorDoorGivinAccess() {
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

  public ArrayList<Door> getDoorsGivingAcces() {
    return doorsGivingAccess;
  }
}
