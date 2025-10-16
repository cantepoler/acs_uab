package baseNoStates;

public class DoorStateLocked extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals("Unlock")) {
      return new DoorStateUnlocked();
    } else if (state.equals("UnlockShortly")) {
      return new DoorStateUnlockedShortly();
    }
    return this;
  }
}
