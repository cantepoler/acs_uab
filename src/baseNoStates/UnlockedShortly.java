package baseNoStates;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

// the unlockedShortly class is an observer, that when it is created it
// starts checking the different time of tasks of the Clock class when it updates

public class UnlockedShortly extends DoorState implements Observer {
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
      if (door.isClosed()) {
          this.door.setClosed(false);
          logger.info("Door {} opened in Unlocked Shortly", door.getId());
      } else {
          logger.error("Can't Open, door {} is already opened", door.getId());
      }
  }

  @Override
  public void close() {
      if (this.door.isClosed()) {
          logger.error("Door {} already closed", door.getId());
      } else {
          this.door.setClosed(true);
          logger.info("Closed door {} in Unlocked Shortly", door.getId());
      }
  }

  @Override
  public void unlock() {
    logger.error("Can't unlock door {} while in Unlocked Shortly", door.getId());
  }

  @Override
  public void lock() {
    this.door.setState(new Locked(this.door));
    logger.info("Door {} is Locked", door.getId());
  }

  @Override
  public void unlockShortly() {
    logger.error("Can't Unlock Shortly while door {} already Unlocked Shortly", door.getId());
  }

  @Override
  public void prop() {
    this.door.setState(new Propped(this.door));
    logger.info("Door {} is Propped", door.getId());
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
    if (checkIsTimeCompleted(elapsed)) {
      complete = true;
      logger.info("Timer is completed");
    }
    return complete;
  }

  private boolean checkIsTimeCompleted (Duration elapsed) {
    return startingTime.plus(elapsed).isAfter(startingTime.plus(Duration.of(MAX_PERIOD, ChronoUnit.SECONDS)));
  }
}
