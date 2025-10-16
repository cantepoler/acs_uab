package baseNoStates;

public class DoorStateClosed extends DoorState {
  @Override
  public DoorState changeState(String state) {
      if (state.equals(Actions.OPEN)) {
          return new DoorStateOpened();
      } else if (state.equals(Actions.LOCK)) {
          return new DoorStateLocked();
      }
      //if (state.equals(Actions.CLOSE)) {
      //  Es pot posar algo com "No es pot tancar pq ja està tancada"
      //}
      return this;
  }
}
