package baseNoStates;

public final class DirectoryAreas {
  private static Area rootArea;
  private static Door[] doors;

  public static void makeAreas(){

  }

  public static Area findAreaById(String id){
    return rootArea.findAreaById(id);
  }

  public static Door findDoorById(String id){
    return null;
  }

  public static Door[] getAllDoors() {
    return doors;
  }
}
