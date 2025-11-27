package baseNoStates;

// The purpose of this class is to eliminate "magic strings", ensuring consistency
// between the different class structure.

public final class Actions {
  // possible actions in reader and area requests
  public static final String LOCK = "lock";
  public static final String UNLOCK = "unlock";
  public static final String UNLOCK_SHORTLY = "unlock_shortly";
  // possible actions in door requests
  public static final String OPEN = "open";
  public static final String CLOSE = "close";
}
