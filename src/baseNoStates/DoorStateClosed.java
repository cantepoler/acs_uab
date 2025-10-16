package baseNoStates;

public class DoorStateClosed extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals("Open")) {
      return new DoorStateOpened();
    }
    return new DoorStateLocked();
  }
}
