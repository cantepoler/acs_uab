package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// This is just a placeholder implementation for a future function that the visitor will implement.


public class VisitorAnotherComputation implements Visitor {
  private final Logger logger = LoggerFactory.getLogger(VisitorAnotherComputation.class);
  public void visitSpace(Space space) {
    logger.info("VisitorAnotherComputation visit space: {}", space.getName());
  }
  public void visitPartition(Partition partition) {
    logger.info("VisitorAnotherComputation visit partition: {}", partition.getName());
  }

}
