package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TransferQueue;

public class UnlockedShortly extends DoorState implements Observer {
  private static final Clock CLOCK = new Clock();
  private final long MAX_PERIOD = 10;
  private int seconds = 0;
  private LocalDateTime startingTime;

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
    LocalDateTime time = (LocalDateTime) arg;
    if (startingTime == null)
    {
        startingTime = time;
    }
    if (timeComplete(time)) {
      if (door.isClosed()) {
        lock();
      }
      else {
        prop();
      }
      CLOCK.deleteObserver(this);
    }

  }

    private boolean timeComplete(LocalDateTime time) {
      boolean complete = false;
      Duration elapsed = Duration.between(startingTime, time);
      if (startingTime.plus(elapsed).equals(startingTime.plus(Duration.of(MAX_PERIOD, ChronoUnit.SECONDS))))
      {
          complete = true;
      }

      return complete;
    }
}
