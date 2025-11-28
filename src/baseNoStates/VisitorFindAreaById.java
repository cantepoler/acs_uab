package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// A concrete Visitor acting as a search engine for the building.
//
// This visitor traverses the whole tree, checking
// every Partition and Space until it finds the one with the matching ID.


public class VisitorFindAreaById implements Visitor {
  private final Logger logger =  LoggerFactory.getLogger(VisitorFindAreaById.class);
  private Area area = null;
  private final String searchedId;

  public VisitorFindAreaById(String searchedId) {
    this.searchedId = searchedId;
  }

  public void visitSpace(Space space) {
    logger.info("VisitorFindAreaById visit space: {}", space.getName());
    if (space != null && space.getId().equals(searchedId)) {
      this.area = space;
    }
  }

  public void visitPartition(Partition partition) {
    logger.info("VisitorFindAreaById visit partition: {}", partition.getName());
    if (partition != null && partition.getId().equals(searchedId)) {
      this.area = partition;
    } else  {
      for (Area area : partition.getAreas()) {
        area.acceptVisitor(this);
      }
    }
  }

  public Area getArea() {
    return area;
  }
}
