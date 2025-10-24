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

  //first gets the time in which it has been added to the observer list
  //and then if the time has passed and its closed returns a locked state
  //and if its opened returns a propped state and deletes the observer
  @Override
  public void update(Observable o, Object arg) {
    LocalDateTime time = (LocalDateTime) arg;
    if (startingTime == null)
    {
        startingTime = time;
    }
    if (timeComplete(time)) {
      CLOCK.deleteObserver(this);
      if (door.isClosed()) {
        lock();
      }
      else {
        prop();
      }
    }
  }

  //compares the actual time and checks if it has passed the MAX_PERIOD that
  //the door should be opened, if the time is bigger than it should return
  //true which means the period has been completed and if not return false
  private boolean timeComplete(LocalDateTime time) {
    boolean complete = false;
    Duration elapsed = Duration.between(startingTime, time);
    if (startingTime.plus(elapsed).isAfter(startingTime.plus(Duration.of(MAX_PERIOD, ChronoUnit.SECONDS))))
    {
        complete = true;
    }
     return complete;
  }
}
