package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

public class UnlockedShortly extends DoorState implements Observer {
  // the unlockedShortly class is an observer, that when it is created it
  // starts checking the different time of tasks of the Clock class when it updates
  private static final Clock CLOCK = Clock.getClockInstance();
  private static final long MAX_PERIOD = 10;
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
    System.out.println("Can't unlock shortly door " + door.getId()
            + " because it's already unlocked");
  }

  @Override
  public void prop() {
    this.door.setState(new Propped(this.door));
  }

  // First gets the time in which it has been added to the observer list,
  // and verifies if the time has passed. Once this happens, if it is closed
  // it returns the door in a locked state. If the door it's opened, it returns the
  // door as in a propped state and deletes the observer
  @Override
  public void update(Observable o, Object arg) {
    LocalDateTime time = (LocalDateTime) arg;
    if (startingTime == null) {
      startingTime = time;
    }
    if (timeComplete(time)) {
      CLOCK.deleteObserver(this);
      if (door.isClosed()) {
        lock();
      } else {
        prop();
      }
    }
  }

  // It compares the actual time and checks if it has passed the MAX_PERIOD
  // in which the door should be opened.
  // if the time is bigger, it has to return true, since the period has been completed
  // and the update() needs to check which action do. If not, it must return false.

  private boolean timeComplete(LocalDateTime time) {
    boolean complete = false;
    Duration elapsed = Duration.between(startingTime, time);
    // TODO: move if statement to a new method
    if (checkIsTimeCompleted(time, elapsed)) {
      complete = true;
    }
    return complete;
  }

  private boolean checkIsTimeCompleted (LocalDateTime time, Duration elapsed) {
    return startingTime.plus(elapsed).isAfter(startingTime.plus(Duration.of(MAX_PERIOD, ChronoUnit.SECONDS)));
  }
}
