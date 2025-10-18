package baseNoStates;

public class Locked extends DoorState {

  public Locked(Door door) {
    super(door);
    this.name = "locked";
  }

  @Override
  public void open() {
    System.out.println("Can't open door " + door.getId() + " because it's locked");
  }

  @Override
  public void close() {
    System.out.println("Can't close door " + door.getId() + " because it's already closed");
  }

  @Override
  public void unlock() {
    this.door.setState(new Unlocked(this.door));
  }

  @Override
  public void lock() {
    System.out.println("Can't lock door " + door.getId() + " because it's already locked");
  }

  @Override
  public void unlockShortly() {
    this.door.setState(new UnlockedShortly(this.door));
  }

  @Override
  public void prop() {

  }
}
