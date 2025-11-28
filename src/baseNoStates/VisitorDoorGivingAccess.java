package baseNoStates;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// A concrete Visitor that finds which doors belong to a specific space.
//
// Its job is to walk through the building structure
// and collect all the doors that connect to the space we are interested in.
// We use the Visitor pattern here to separate this search logic from the Space class.

public class VisitorDoorGivingAccess implements Visitor {
  private final Logger logger =  LoggerFactory.getLogger("FITA2");
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
