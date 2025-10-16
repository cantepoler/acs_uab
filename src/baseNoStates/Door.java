package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  DoorState doorState;
  Space fromSpace;
  Space toSpace;

  // public Door(String id, Space fromSpace, Space toSpace) {
  public Door(String id) {
    this.id = id;
    closed = true;
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;
    this.doorState = new DoorStateLocked();
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      // En comptes de doAction, deleguem la tasca a DoorState
      doorState = doorState.changeState(action);    // Això potser hauria de canviar-se directament amb doorState.changeState(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  public boolean isClosed() {
    return closed;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return "unlocked";
  }

  @Override
  public String toString() {
    return "Door{"
        + ", id='" + id + '\''
        + ", closed=" + closed
        + ", state=" + getStateName()
        + "}";
  }

  public JSONObject toJson() {
    JSONObject json = new JSONObject();
    json.put("id", id);
    json.put("state", getStateName());
    json.put("closed", closed);
    return json;
  }
}
