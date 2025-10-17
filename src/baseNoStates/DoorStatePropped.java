package baseNoStates;

public class DoorStatePropped extends DoorState {
  @Override
  public DoorState changeState(String state) {
    return new DoorStateLocked();
  }
}
