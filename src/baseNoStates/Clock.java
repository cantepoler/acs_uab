package baseNoStates;

import java.time.LocalDateTime;
import java.util.*;

public class Clock extends Observable {
    //this class defines the class clock, which is used in the unlockedShortly functions
    // and its purpose is to follow the Observer pattern applied to unlockedShortly.
    //In this case, Clock is the observable and has the date and a Timer.
    private int period = 1000;
    private LocalDateTime date;
    private Timer timer;
    public Clock() {
    timer = new Timer();
  }

  public void start() {
      // Once the function calls a new clock, it creates a new task to a list which is updated each
      //second. As it notifies the observer of it's update, the observer verifies if it has to keep
      //running or the task has finished.
    TimerTask task = new TimerTask() {
      @Override
      public void run() {
        date = LocalDateTime.now();
        setChanged();
        notifyObservers(date);
      }
    };
    timer.scheduleAtFixedRate(task, 0, period );
  }
}
