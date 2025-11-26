package baseNoStates;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
    this.name = "locked";
  }

  @Override
  public void open() {
    logger.error("Can't open door {} because it's locked", door.getId());
  }

  @Override
  public void close() {
    logger.error("Can't close door {} because it's already closed", door.getId());
  }

  @Override
  public void unlock() {
    logger.info("Door {} is Unlocked", door.getId());
    this.door.setState(new Unlocked(this.door));
  }

  @Override
  public void lock() {
    logger.error("Can't lock door {} because it's already locked", door.getId());
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
