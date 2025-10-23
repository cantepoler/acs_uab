package baseNoStates;

import java.time.LocalDateTime;
import java.util.*;

public class Clock extends Observable {
  private int period = 1000;
  private LocalDateTime date;
  private Timer timer;
  public Clock() {
    timer = new Timer();
  }

  public void start() {
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

  public void stop() {
    timer.cancel();
  }

}
