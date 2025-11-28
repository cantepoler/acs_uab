package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

// A specific Visitor designed to find all the doors that are currently propped.
//
// This class uses the Visitor pattern to walk through the entire
// Area hierarchy. It checks every room, looks at the doors,
// and if a door is propped, it adds it to the list.

public class VisitorGetProppedDoors implements Visitor {
    private final Logger logger =  LoggerFactory.getLogger("FITA2");
    private final ArrayList<Door> proppedDoors = new ArrayList<>();

  public VisitorGetProppedDoors() {}

  public void visitSpace(Space space) {
    logger.info("Visiting sapce {}", space.getName());
    if (space.getDoors() != null) {
      for (Door door : space.getDoors()) {
        if (door.isPropped()) {
          proppedDoors.add(door);
        }
      }
    }
  }

  public void visitPartition(Partition partition) {
    logger.info("Visiting partition {}", partition.getName());
    for (Area area : partition.getAreas()) {
      area.acceptVisitor(this);
    }
  }

  public ArrayList<Door> getProppedDoors() {
    return proppedDoors;
  }
}
