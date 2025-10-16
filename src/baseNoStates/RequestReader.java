package baseNoStates;

import java.util.Date;

public class RequestReader implements Request {
  String credential;
  String action;
  Date now;
  String doorId;

  public RequestReader (String credential, String action, Date now, String doorId) {
    this.credential = credential;
    this.action = action;
    this.now = now;
    this.doorId = doorId;
  }

  @Override
  public void procces() {
    Door door = DirectoryDoors.findDoorById(doorId);
    User user = DirectoryUsers.findUserByCredential(credential);
    boolean authorised = authorize(door, user);
  }

  private boolean authorize(Door door, User user)
  {
    return user.canBeInSpace(door.fromSpace) && user.canBeInSpace(door.toSpace);
  }
}
