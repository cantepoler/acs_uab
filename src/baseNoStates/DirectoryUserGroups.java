package baseNoStates;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public final class DirectoryUserGroups {
  private static final ArrayList<UserGroup> userGroups = new ArrayList<>();

  public static void makeUsers() {

    // users without any privilege, just to keep temporally users instead of deleting them,
    // this is to withdraw all permissions but still to keep user data to give back
    // permissions later
    UserGroup g1 = new UserGroup("blank", null, null, null);
    g1.addUser(new User("Bernat", "12345", g1));
    g1.addUser(new User("Blai", "77532", g1));
    userGroups.add(g1);

    // employees :
    // Sep. 1 this year to Mar. 1 next year
    // week days 9-17h
    // just shortly unlock
    // ground floor, floor1, exterior, stairs (this, for all), that is, everywhere but the parking
    ArrayList<DayOfWeek> weekDays = new ArrayList<>(
            Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
                    DayOfWeek.WEDNESDAY,  DayOfWeek.THURSDAY,
                    DayOfWeek.FRIDAY));

    Schedule scheduleG2 = new Schedule(weekDays, LocalTime.of(9, 0),
        LocalTime.of(17, 0), LocalDate.of(LocalDate.now().getYear(), 9, 1),
        LocalDate.of(LocalDate.now().getYear() + 1, 3, 1));

    UserGroup g2 = new UserGroup("employees",
                                 new ArrayList<>(Arrays.asList(Actions.UNLOCK_SHORTLY,
                                                 Actions.CLOSE, Actions.OPEN)),
                                 new ArrayList<>(Arrays.asList("ground_floor",
                                                               "floor1", "exterior", "stairs")),
                                 scheduleG2);

    g2.addUser(new User("Ernest", "74984", g2));
    g2.addUser(new User("Eulalia", "43295", g2));
    userGroups.add(g2);

    // managers :
    // Sep. 1 this year to Mar. 1 next year
    // week days + saturday, 8-20h
    // all actions
    // all spaces

    ArrayList<DayOfWeek> daysG3 = new ArrayList<>(weekDays);
    daysG3.add(DayOfWeek.SATURDAY);

    ArrayList<String> allActions = new ArrayList<>(Arrays.asList(Actions.UNLOCK_SHORTLY,
                                                                 Actions.UNLOCK, Actions.LOCK,
                                                                 Actions.UNLOCK, Actions.CLOSE,
                                                                 Actions.OPEN));

    ArrayList<String> allSpaces = new ArrayList<>(Arrays.asList("ground_floor",
                                                                "floor1", "exterior",
                                                                "stairs", "parking"));


    Schedule scheduleG3 = new Schedule(daysG3, LocalTime.of(8, 0),
        LocalTime.of(20, 0),  LocalDate.of(LocalDate.now().getYear(), 9, 1),
        LocalDate.of(LocalDate.now().getYear() + 1, 3, 1));


    UserGroup g3 = new UserGroup("managers", allActions, allSpaces, scheduleG3);
    g3.addUser(new User("Manel", "95783", g3));
    g3.addUser(new User("Marta", "05827", g3));
    userGroups.add(g3);

    // admin :
    // always=Jan. 1 this year to 2100
    // all days of the week
    // all actions
    // all spaces

    ArrayList<DayOfWeek> daysG4 = new ArrayList<>(daysG3);
    daysG4.add(DayOfWeek.SUNDAY);

    Schedule scheduleG4 = new Schedule(daysG4, LocalTime.of(0, 0),
        LocalTime.of(23, 59),  LocalDate.of(LocalDate.now().getYear(), 1, 1),
        LocalDate.of(2100, 1, 1));

    UserGroup g4 = new UserGroup("admin", allActions, allSpaces, scheduleG4);

    g4.addUser(new User("Ana", "11343", g4));
    userGroups.add(g4);
  }

  public static User findUserByCredential(String credential) {
    for (UserGroup userGroup : userGroups) {
      User user = userGroup.findUserByCredential(credential);
      if (user != null) {
        return user;
      }
    }
    System.out.println("user with credential " + credential + " not found");
    return null; // otherwise we get a Java error
  }

}
