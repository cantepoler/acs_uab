package baseNoStates;

import java.util.ArrayList;

public class User {
  private final String name;
  private final String credential;
  private ArrayList<Area> areas;

  public User(String name, String credential) {
    this.name = name;
    this.credential = credential;
  }

  public String getCredential() {
    return credential;
  }

  @Override
  public String toString() {
    return "User{name=" + name + ", credential=" + credential + "}";
  }

  //Giving a space, it covers all the areas to which it has access
  //and returns if you have access to that site or not
  public boolean canBeInSpace(Space space) {
    for(Area area : areas) {
      for (Space space1 : area.getSpaces()) {
        if (space1 == space) {
          return true;
        }
      }
    }
    return false;
  }

  private ArrayList<Space> getSpaces() {
    //falta implementació
    return null;
  }
}
