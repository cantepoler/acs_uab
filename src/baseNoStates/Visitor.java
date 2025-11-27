package baseNoStates;

// This interface is the core of the Visitor Design Pattern in our system.
//
// It forces any visitor class
// to know how to handle both a 'Space' (a single room) and a 'Partition' (a floor/building).
// We need this interface so we can traverse the Composite structure of the building
// without the Area classes needing to know what we are actually calculating.



public interface Visitor {
  void visitSpace(Space space);
  void visitPartition(Partition partition);
}
