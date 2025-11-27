package baseNoStates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Observable {
  private static final Logger LOGGER = LoggerFactory.getLogger(Clock.class);
  private LocalDateTime date;
  private final Timer timer;
  private static  Clock clockInstance = null;

  private Clock() {
    LOGGER.info("Rellotge creat");
    timer = new Timer();
  }

  public static Clock getClockInstance() {
    if (clockInstance == null) {
      clockInstance = new Clock();
    }
    LOGGER.info("Rellotge cridat");
    return clockInstance;
  }

  public void start() {
    // Once the function calls a new clock, it creates a new task to a list which is updated each
    // second. As it notifies the observer of it's update, the observer verifies if it has to keep
    // running or the task has finished.
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        date = LocalDateTime.now();
        setChanged();
        notifyObservers(date);
      }
    };
    // this class defines the class clock, which is used in the unlockedShortly functions
    // and its purpose is to follow the Observer pattern applied to unlockedShortly.
    // In this case, Clock is the observable and has the date and a Timer.
    int period = 1000;
    timer.scheduleAtFixedRate(task, 0, period);
  }

}
