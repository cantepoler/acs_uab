package baseNoStates;

public class DoorStateOpened extends DoorState {
  @Override
  public DoorState changeState(String state) {
    if (state.equals("Close")) {
      try {
        wait(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return new DoorStateClosed();
    }
    return new DoorStateLocked();
  }
}
