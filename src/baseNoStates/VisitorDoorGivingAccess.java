package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class VisitorDoorGivingAccess implements Visitor {
  private final Logger logger =  LoggerFactory.getLogger(VisitorDoorGivingAccess.class);
  private final ArrayList<Door> doorsGivingAccess;
  public VisitorDoorGivingAccess() {
    doorsGivingAccess = new ArrayList<>();
  }
  public void visitSpace(Space space) {
    logger.info("VisitorDoorGivingAccess visiting space {}", space.getName());
    if (space.getDoors() != null) {
      for (Door door : space.getDoors()) {
        if (door.getToSpace() == space || door.getFromSpace() == space) {
          doorsGivingAccess.add(door);
        }
      }
    }
  }
  public void visitPartition(Partition partition) {
    logger.info("VisitorDoorGivingAccess visiting partition {}", partition.getName());
    for (Area area : partition.getAreas()) {
      area.acceptVisitor(this);
    }
  }

  public ArrayList<Door> getDoorsGivingAccess() {
    return doorsGivingAccess;
  }
}
