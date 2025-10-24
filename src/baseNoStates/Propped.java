package baseNoStates;

public class Propped extends DoorState {
  public Propped(Door door) {
    super(door);
    this.name = "propped";
  }

  @Override
  public void open() {
    System.out.println("Door is already open");
  }

  @Override
  public void close() {
    door.setClosed(true);
    lock();
  }

  @Override
  public void unlock() {
    System.out.println("Door is propped");
  }

  @Override
  public void lock() {
    if (door.isClosed()) {
        this.door.setState(new Locked(this.door));
    }
    else {
        System.out.println("Door is not closed");
    }
  }

  @Override
  public void unlockShortly() {
    System.out.println("Door is propped");
  }

  @Override
  public void prop() {

  }
}
