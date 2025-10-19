package baseNoStates;

import java.util.Observable;
import java.util.Observer;

public class UnlockedShortly extends DoorState implements Observer {
  private static final Clock CLOCK = new Clock();
  private final int MAX_PERIOD = 10;
  private int seconds = 0;

  public UnlockedShortly(Door door) {
    super(door);
    CLOCK.addObserver(this);
    CLOCK.start();
    this.name = "unlocked_shortly";
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
    this.door.setState(new Propped(this.door));
  }

  @Override
  public void update(Observable o, Object arg) {
    seconds++;
    if (seconds >= MAX_PERIOD) {
      if (door.isClosed()) {
        lock();
      }
      else {
        prop();
      }
      CLOCK.deleteObserver(this);
    }

  }
}
