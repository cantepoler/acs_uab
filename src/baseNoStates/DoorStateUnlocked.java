package baseNoStates;

public class DoorStateUnlocked extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals("open")) {
      return new DoorStateOpened();
    } else if (state.equals("closed")) {
      return new DoorStateClosed();
    }
    return new DoorStateClosed();

  }
}
