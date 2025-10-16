package baseNoStates;

public class DoorStateUnlockedShortly extends DoorState{
  @Override
  public DoorState changeState(String state) {
    if (state.equals(Actions.OPEN)) {
      return new DoorStateOpened();
    } else if (state.equals(Actions.CLOSE)) {
      return new DoorStateClosed();
    }
    return new DoorStateLocked();
  }
  // Potser no hauriem de fer return, sino canviar d'alguna forma el state directament, pq si no no es pot esperar
    // els 10 segons i mirar l'estat
}
