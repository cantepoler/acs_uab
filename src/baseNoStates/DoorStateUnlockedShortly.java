package baseNoStates;

public class DoorStateUnlockedShortly extends DoorState{
  @Override
  public DoorState changeState(String state) {
    return new DoorStateLocked();
  }
  // Potser no hauriem de fer return, sino canviar d'alguna forma el state directament, pq si no no es pot esperar
    // els 10 segons i mirar l'estat
}
