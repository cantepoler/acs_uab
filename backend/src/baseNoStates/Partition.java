package baseNoStates;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


// Represents a container area, like a Floor or a Building, that holds other areas inside it.
//
// This is the Composite part of the Composite Design Pattern. It keeps a list of children
// (which can be Spaces or other Partitions). When a Visitor visits this partition,
// this class passes the visitor down to all its children, allowing us to go through the
// whole building recursively.

public class Partition extends Area {
  private ArrayList<Area> areas;

  public Partition(String id, String name, Area parent) {
    super(id, name, parent);
  }

  // iterates for every area of its list and adds all the spaces of that area
  // to his personal list
  @Override
  public ArrayList<Space> getSpaces() {
    ArrayList<Space> spaces = new ArrayList<>();
    for (Area area : areas) {
      spaces.addAll(area.getSpaces());
    }
    return spaces;
  }

  public void setAreas(ArrayList<Area> areas) {
    this.areas = areas;
  }

  public void acceptVisitor(Visitor visitor) {
    visitor.visitPartition(this);
  }

  public ArrayList<Area> getAreas() {
    return areas;
  }

  public JSONObject toJson(int depth) {
    // for depth=1 only the root and children,
    // for recusive = all levels use Integer.MAX_VALUE
    JSONObject json = new JSONObject();
    json.put("class", "partition");
    json.put("id", id);
    JSONArray jsonAreas = new JSONArray();
    if (depth > 0) {
      for (Area a : areas) {
        jsonAreas.put(a.toJson(depth - 1));
      }
      json.put("areas", jsonAreas);
    }
    return json;
  }
}
