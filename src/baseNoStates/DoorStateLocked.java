package baseNoStates;

public class DoorStateLocked extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals(Actions.UNLOCK_SHORTLY)) {
        return new DoorStateUnlockedShortly();
    }
    return this;
  }
}
