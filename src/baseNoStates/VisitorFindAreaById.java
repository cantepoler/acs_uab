package baseNoStates;

public class VisitorFindAreaById implements Visitor {
  private Area area = null;
  private final String searchedId;

  public VisitorFindAreaById(String searchedId) {
    this.searchedId = searchedId;
  }
  public void visitSpace(Space space) {
    if (space != null && space.getId().equals(searchedId)) {
      this.area = space;
    }
  }
  public void visitPartition(Partition partition) {
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
