package baseNoStates;

public class DoorStateUnlockedShortly extends DoorState{
  @Override
  public DoorState changeState(String state) {
    if (state.equals("Open")) {
      return new DoorStateOpened();
    } else if (state.equals("Closed")) {
      return new DoorStateClosed();
    }
    return new DoorStateLocked();
  }
}
