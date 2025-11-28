package baseNoStates;

// Represents a specific state of the Door where it is physically secured and cannot be opened.
// This class is a Concrete State implementation in the State Design Pattern. It encapsulates
// the specific business logic for a locked door: it rejects "open" requests and only allows
// transitions to an "Unlocked" or "UnlockedShortly" state upon valid authorization.

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
    this.name = "locked";
  }

  @Override
  public void open() {
    logger.info("Can't open door {} because it's locked", door.getId());
  }

  @Override
  public void close() {
    logger.info("Can't close door {} because it's already closed", door.getId());
  }

  @Override
  public void unlock() {
    logger.info("Door {} is Unlocked", door.getId());
    this.door.setState(new Unlocked(this.door));
  }

  @Override
  public void lock() {
    logger.info("Can't lock door {} because it's already locked", door.getId());
  }

  @Override
  public void unlockShortly() {
    logger.info("Door {} is Unlocked Shortly", door.getId());
    this.door.setState(new UnlockedShortly(this.door));
  }

  @Override
  public void prop() {

  }
}
