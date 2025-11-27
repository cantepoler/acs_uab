package baseNoStates;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserGroup {
  // This class defines a group of users and their access rights. The access rights
  // are what, when and where they can interact with the acs system.
  private final Logger logger = LoggerFactory.getLogger(UserGroup.class);
  private final String name;
  public ArrayList<User> users = new ArrayList<>();
  private final ArrayList<String> allowedActions;
  private final ArrayList<String> allowedAreas;
  private final Schedule schedule;

  // The constructor has no "users" parameter, because we will want to add
  // new users while executing.
  public UserGroup(String name, ArrayList<String> allowedActions,
                   ArrayList<String> allowedAreas, Schedule schedule) {
    this.name = name;
    this.allowedActions = allowedActions;
    this.allowedAreas = allowedAreas;
    this.schedule = schedule;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public boolean canSendRequests(LocalDateTime dateTime) {
    if (this.schedule != null) {
      return schedule.isAllowedAt(dateTime);
    }
    logger.error("User {} can't send requests", this.name);
    return false;
  }

  // Giving a space, it covers all the areas to which it has access
  // and returns if you have access to that site or not
  public boolean canBeInSpace(Space space) {
    if (this.allowedAreas != null) {
      // as we have the id, not the Area object, we have to findAreaById.
      for (String areaId : this.allowedAreas) {
        VisitorFindAreaById visitorFindAreaById = new VisitorFindAreaById(areaId);
        DirectoryAreas directoryAreas = DirectoryAreas.getDirectoryAreas();
        Area rootArea = directoryAreas.getRootArea();
        rootArea.acceptVisitor(visitorFindAreaById);
        Area area = visitorFindAreaById.getArea();
        if (area == space) {
          return true;
        }
        for (Space space1 : area.getSpaces()) {
          if (space1 == space) {
            return true;
          }
        }
      }
    }
    logger.error("Space {} not found", space.getName());
    return false;
  }

  public boolean canDoAction(String action) {
    if (this.allowedActions != null) {
      logger.info("Doing action {}", action);
      return allowedActions.contains(action);
    }
    logger.error("Action {} not allowed", action);
    return false;
  }

  public User findUserByCredential(String credential) {
    for (User user : users) {
      if (user.getCredential().equals(credential)) {
        logger.info("User {} found", this.name);
        return user;
      }
    }
    logger.error("Can't find user {}", this.name);
    return null;
  }
}
