package baseNoStates;

public class Unlocked extends DoorState {

  public Unlocked(Door door){
    super(door);
    this.name = "unlocked";
  }

  @Override
  public void open() {
    this.door.setClosed(false);
  }

  @Override
  public void close() {
    this.door.setClosed(true);
  }

  @Override
  public void unlock() {
    System.out.println("Can't unlock door " + door.getId() + " because it's already unlocked");
  }

  @Override
  public void lock() {
    this.door.setState(new Locked(this.door));
  }

  @Override
  public void unlockShortly() {
    System.out.println("Can't unlock shortly door " + door.getId() + " because it's already unlocked");
  }

  @Override
  public void prop() {

  }
}
