package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DirectoryAreas {
  private static Area rootArea;
  private static ArrayList<Door> doors;

  public static void makeAreas() {
    //create partitions
    Partition building = new Partition("A1", "Building", null);
    Partition basement = new Partition("A2", "Basement", building);
    Partition ground_floor = new Partition("A3", "Ground floor", building);
    Partition floor_1 = new Partition("A4", "Floor 1", building);

    //set rootArea
    rootArea = building;

    //create door arrays
    doors = DirectoryDoors.getAllDoors();
    ArrayList<Door> parkingDoors = findDoorsByIds(Arrays.asList("D1", "D2"));
    ArrayList<Door> hallDoors = findDoorsByIds(Arrays.asList("D3", "D4"));
    ArrayList<Door> room_1Doors = findDoorsByIds(Arrays.asList("D5"));
    ArrayList<Door> room_2Doors = findDoorsByIds(Arrays.asList("D6"));
    ArrayList<Door> room_3Doors = findDoorsByIds(Arrays.asList("D8"));
    ArrayList<Door> corridorDoors = findDoorsByIds(Arrays.asList("D7"));
    ArrayList<Door> itDoors = findDoorsByIds(Arrays.asList("D9"));

    //create spaces
    //buiding parent
    Space stairs = new Space("A5", "Stairs", building);
    Space exterior = new Space("A6", "Exterior", building);

    //basement parent
    Space parking = new Space("A7", "Parking", parkingDoors, basement);

    ArrayList<Area> basementSpaces = new ArrayList<>(Arrays.asList(parking));

    basement.setAreas(basementSpaces);

    //ground_floor parent
    // hall = A8
    Space hall = new Space("hall", "Floor", hallDoors, ground_floor);
    Space room1 = new Space("A9", "Room", room_1Doors, ground_floor);
    Space room2 = new Space("A10", "Room", room_2Doors, ground_floor);

    ArrayList<Area> groundFloorSpaces = new ArrayList<>(Arrays.asList(hall, room1, room2));

    ground_floor.setAreas(groundFloorSpaces);

    //floor_1 parent
    Space room3 = new Space("A11", "Room", room_3Doors, floor_1);
    Space corridor = new Space("A12", "Corridor", corridorDoors, floor_1);
    Space it = new Space("A13", "It", itDoors, floor_1);

    ArrayList<Area> floor_1Spaces = new ArrayList<>(Arrays.asList(room3, corridor, it));

    floor_1.setAreas(floor_1Spaces);

    ArrayList<Area> buildingSpaces = new ArrayList<>(Arrays.asList(
        basement, ground_floor, floor_1, stairs, exterior
    ));
    building.setAreas(buildingSpaces);

    //set spaces from and to
    doors.get(0).fromSpace = exterior;
    doors.get(0).toSpace = parking;
    doors.get(1).fromSpace = stairs;
    doors.get(1).toSpace = parking;
    doors.get(2).fromSpace = exterior;
    doors.get(2).toSpace = hall;
    doors.get(3).fromSpace = stairs;
    doors.get(3).toSpace = hall;
    doors.get(4).fromSpace = hall;
    doors.get(4).toSpace = room1;
    doors.get(5).fromSpace = hall;
    doors.get(5).toSpace = room2;
    doors.get(6).fromSpace = stairs;
    doors.get(6).toSpace = corridor;
    doors.get(7).fromSpace = corridor;
    doors.get(7).toSpace = room3;
    doors.get(8).fromSpace = corridor;
    doors.get(8).toSpace = it;
  }

  private static ArrayList<Door> findDoorsByIds(List<String> ids) {
    ArrayList<Door> doors = new ArrayList<>();
    for(String id : ids){
      Door door = findDoorById(id);
      if (door != null){
        doors.add(door);
      }
    }
    return doors;
  }

  public static Area findAreaById(String id){
    return rootArea.findAreaById(id);
  }

  public static Door findDoorById(String id){
    for (Door door : doors){
      if(door.getId().equals(id)){
        return door;
      }
    }
    return null;
  }

  public static ArrayList<Door> getAllDoors() {
    return doors;
  }
}
