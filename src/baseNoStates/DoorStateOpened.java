package baseNoStates;

public class DoorStateOpened extends DoorState {
  @Override
  public DoorState changeState(String state) {
      if (state.equals(Actions.CLOSE)) {
          return new DoorStateClosed();
      }
      return this;
  }
}
