package baseNoStates;

// Represents a state where the door has been physically held open
// and will not close automatically.
//
// As a Concrete State in the State Design Pattern, this class overrides standard behavior to
// block most operations (like locking or unlocking) because the physical reality of the door
// prevents them. This state is distinct from "Unlocked" because it implies
// a breach of normal protocol that usually requires a specific manual intervention (closing)
// to reset the cycle back to a Locked state.


public class Propped extends DoorState {
  public Propped(Door door) {
    super(door);
    this.name = "propped";
    door.changePropped();
  }

  @Override
  public void open() {
    logger.info("Can't open door {} because it's already open", door.getId());
  }

  @Override
  public void close() {
    door.setClosed(true);
    logger.info("Door {} closed", door.getId());
    lock();
  }

  @Override
  public void unlock() {
    logger.info("Can't Unlock, door {} is propped",   door.getId());
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
      door.changePropped();
      logger.info("Door {} locked", door.getId());
      this.door.setState(new Locked(this.door));
    } else {
      logger.info("Door {} is not closed",  door.getId());
    }
  }

  @Override
  public void unlockShortly() {
    logger.info("Can't Unlock Shortly, door {} is propped",   door.getId());
  }

  @Override
  public void prop() {
  }
}
