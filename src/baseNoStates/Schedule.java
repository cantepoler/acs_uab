package baseNoStates;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

public class Schedule {
  // This class is meant to define the schedule when a userGroup is allowed to do actions,
  // also, it is used to make sure if a certain LocalDateTime is inside it.
  private Set<DayOfWeek> weekDays;
  private LocalTime startTime;
  private LocalTime endTime;
  private LocalDate startDate;
  private LocalDate endDate;

  public Schedule(Set<DayOfWeek> weekDays, LocalTime startTime, LocalTime endTime,
                  LocalDate startDate, LocalDate endDate) {
    this.weekDays = weekDays;
    this.startTime = startTime;
    this.endTime = endTime;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public Boolean isAllowedAt(LocalDateTime dateTime){
    DayOfWeek day = dateTime.getDayOfWeek();
    LocalTime hour = dateTime.toLocalTime();
    LocalDate date = dateTime.toLocalDate();

    if (!weekDays.contains(day)) {
      return false;
    }
    if (hour.isBefore(startTime) || hour.isAfter(endTime)) {
      return false;
    }
    if (date.isBefore(startDate) || date.isAfter(endDate)) {
      return false;
    }
    return true;
  }
}
