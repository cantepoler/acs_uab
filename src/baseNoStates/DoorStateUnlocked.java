package baseNoStates;

public class DoorStateUnlocked extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals("open")) {
      return new DoorStatePropped();
    }
    return new DoorStateLocked();

  }
}
