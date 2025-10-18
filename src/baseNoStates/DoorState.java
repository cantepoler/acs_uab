package baseNoStates;

public abstract class DoorState {
  // This class executes all the actions that involve the door state. It doesn't control the states,
  // it only implements them.
  protected Door door;
  protected String name;

  public DoorState(Door door){
    this.door = door;
  }

  public abstract void open();
  public abstract void close();
  public abstract void unlock();
  public abstract void lock();
  public abstract void unlockShortly();
  public abstract void prop();
}
