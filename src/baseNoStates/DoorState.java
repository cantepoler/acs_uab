package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class executes all the actions that involve the door state. It doesn't control the states,
// it only implements them.

public abstract class DoorState {
  protected final Logger logger =  LoggerFactory.getLogger("FITA1");
  protected Door door;
  protected String name;

  public DoorState(Door door) {
    this.door = door;
  }

  public abstract void open();

  public abstract void close();

  public abstract void unlock();

  public abstract void lock();

  public abstract void unlockShortly();

  public abstract void prop();
}
