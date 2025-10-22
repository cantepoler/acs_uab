package baseNoStates;

import java.time.LocalDateTime;
import java.util.*;

public class Clock extends Observable {
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
    timer.scheduleAtFixedRate(task, 0, 1000 );
  }

  public void stop() {
    timer.cancel();
  }

}
