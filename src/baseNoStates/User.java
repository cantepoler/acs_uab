package baseNoStates;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private UserGroup userGroup;
  private ArrayList<String> areas;

  public User(String name, String credential, UserGroup userGroup) {
    this.name = name;
    this.credential = credential;
    this.userGroup = userGroup;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  public boolean canBeInSpace(Space space) {
    return userGroup.canBeInSpace(space);
  }

  public boolean canSendRequests(LocalDateTime dateTime) {
    return userGroup.canSendRequests(dateTime);
  }

  public boolean canDoAction(String action) {
    return userGroup.canDoAction(action);
  }
}
