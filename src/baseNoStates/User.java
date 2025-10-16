package baseNoStates;

public class User {
  private final String name;
  private final String credential;
  private Area[] areas;

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

  //Donat un espai, recorre totes les àrees a les que té accés
  //i retorna si te accés a aquell espai o no
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

  private Space[] getSpaces() {
    //falta implementació
    return null;
  }
}
