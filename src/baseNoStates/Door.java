package baseNoStates;

import baseNoStates.requests.RequestReader;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Represents a physical door and acts as the Context in the
// State Pattern.
//
// Instead of using complex if-else/switch to determine how the
// door should react to requests based on its current status,
// this class delegates behavior to a 'currentState' object. This allows the door's
// behavior to change dynamically at runtime without modifying the Door class itself.
// This class also serves as the structural link between two Spaces (fromSpace/toSpace).

public class Door {
  private final Logger logger =  LoggerFactory.getLogger("FITA1");
  private final String id;
  private boolean closed; // physically
  private DoorState currentState;
  private Space fromSpace;
  private Space toSpace;
  private boolean propped = false;

  public Door(String id) {
    this.id = id;
    closed = true;
    this.currentState = new Locked(this);
  }

  public void processRequest(RequestReader request) {
    // it is the Door that process the request because the door has and knows
    // its state, and if closed or open
    if (request.isAuthorized()) {
      String action = request.getAction();
      doAction(action);
    } else {
      logger.info("not authorized");
    }
    request.setDoorStateName(getStateName());
  }

  public boolean isClosed() {
    return closed;
  }

  public void setClosed(boolean closed) {
    this.closed = closed;
  }

  public void setState(DoorState doorState) {
    this.currentState = doorState;
  }

  public String getId() {
    return id;
  }

  public String getStateName() {
    return currentState.name;
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
      case Actions.UNLOCK_SHORTLY:
        currentState.unlockShortly();
        break;
      default:
        logger.info("Unrecognized or unimplemented action: {}", action);
    }
  }

  @Override
  public String toString() {
    return "Door{" +
            "id='" + id + '\'' +
            ", closed=" + closed +
            ", currentState=" + currentState +
            ", fromSpace=" + fromSpace +
            ", toSpace=" + toSpace +
            ", propped=" + propped +
            '}';
  }

  public void changePropped() {
    this.propped = !this.propped;
  }

  public boolean isPropped() {
    return propped;
  }

  public Space getFromSpace() {
    return fromSpace;
  }

  public void setFromSpace(Space fromSpace) {
    this.fromSpace = fromSpace;
  }

  public Space getToSpace() {
    return toSpace;
  }

  public void setToSpace(Space toSpace) {
    this.toSpace = toSpace;
  }
}
