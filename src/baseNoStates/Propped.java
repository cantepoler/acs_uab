package baseNoStates;

public class Propped extends DoorState {
  public Propped(Door door) {
    super(door);
    this.name = "propped";
    door.changePropped();
  }

  @Override
  public void open() {
    logger.error("Can't open door {} because it's already open", door.getId());
  }

  @Override
  public void close() {
    door.setClosed(true);
    logger.info("Door {} closed", door.getId());
    lock();
  }

  @Override
  public void unlock() {
    logger.error("Can't Unlock, door {} is propped",   door.getId());
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
      door.changePropped();
      logger.info("Door {} locked", door.getId());
      this.door.setState(new Locked(this.door));
    } else {
      logger.error("Door {} is not closed",  door.getId());
    }
  }

  @Override
  public void unlockShortly() {
    logger.error("Can't Unlock Shortly, door {} is propped",   door.getId());
  }

  @Override
  public void prop() {
  }
}
