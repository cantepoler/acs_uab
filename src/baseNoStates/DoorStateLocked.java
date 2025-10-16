package baseNoStates;

public class DoorStateLocked extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals(Actions.UNLOCK)) {
        // return new DoorStateUnlocked();    crec que aquesta classe pot sobrar pq si fem unlock sempre es canvia a closed
        return new DoorStateClosed();
    } else if (state.equals(Actions.UNLOCK_SHORTLY)) {
        return new DoorStateUnlockedShortly();
    }
    return this;
  }
}
