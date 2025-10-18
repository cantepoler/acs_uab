package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;


public class Door {
  private final String id;
  private boolean closed; // physically
  private DoorState currentState;
  public Space fromSpace;
  public Space toSpace;

  // public Door(String id, Space fromSpace, Space toSpace) {
  public Door(String id) {
    this.id = id;
    closed = true;
    this.fromSpace = fromSpace;
    this.toSpace = toSpace;
    this.currentState = new Locked(this);
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      System.out.println("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {this.closed = closed;}

  public void setState(DoorState doorState) {this.currentState = doorState;}

  public String getId() {
    return id;
  }

  public String getStateName() {
    return currentState.name;
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

  private void doAction(String action) {
    // This switch controls the action that will be executed in DoorState class
    switch (action) {
      case Actions.OPEN:
        currentState.open();
        break;
      case Actions.CLOSE:
        currentState.close();
        break;
      case Actions.UNLOCK:
        currentState.unlock();
        break;
      case Actions.LOCK:
        currentState.lock();
        break;
      default:
        System.out.println("Unrecognized or unimplemented action: " + action);
    }
  }
}
