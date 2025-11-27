package baseNoStates;

// Represents the standard "Unlocked" state of a door.
//
// This is a Concrete State in the State Pattern. When the door is here, it allows
// "open" and "close" actions freely. It enforces logic like preventing the door from
// being locked if it is currently open (you have to close it first).

public class Unlocked extends DoorState {

  public Unlocked(Door door) {
    super(door);
    this.name = "unlocked";
  }

  @Override
  public void open() {
    if (door.isClosed()) {
      this.door.setClosed(false);
      logger.info("Door {} opened", door.getId());
    } else {
      logger.error("Can't Open, door {} is already opened", door.getId());
    }
  }

  @Override
  public void close() {
    if (this.door.isClosed()) {
      logger.error("Door {} already closed", door.getId());
    } else {
      this.door.setClosed(true);
      logger.info("Closed door {}", door.getId());
    }
  }

  @Override
  public void unlock() {
    logger.error("Can't unlock door {} because it's already unlocked",   door.getId());
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
      logger.info("Locked door {}", door.getId());
      this.door.setState(new Locked(this.door));
    } else {
      logger.error("Can't lock door {} because it's not closed", door.getId());
    }
  }

  @Override
  public void unlockShortly() {
    logger.error("Can't unlock shortly door {} because it's already unlocked", door.getId());
  }

  @Override
  public void prop() {

  }
}
