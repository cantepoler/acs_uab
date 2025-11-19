package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DirectoryAreas {
  private static Area rootArea;
  private static ArrayList<Door> doors;
  private static DirectoryAreas directoryAreas = null;

  private DirectoryAreas() {
      makeAreas();
  }

  public static DirectoryAreas getDirectoryAreas() {
    if (directoryAreas == null) {
      directoryAreas = new DirectoryAreas();
    }
    return directoryAreas;
  }

  private static void makeAreas() {
    // create partitions
    Partition building = new Partition("building", "Building", null);
    Partition basement = new Partition("basement", "Basement", building);
    Partition ground_floor = new Partition("ground_floor", "Ground floor", building);
    Partition floor_1 = new Partition("floor1", "Floor 1", building);

    // set rootArea
    rootArea = building;

    // create door arrays
    makeDoors();

    ArrayList<Door> parkingDoors = findDoorsByIds(Arrays.asList("D1", "D2"));
    ArrayList<Door> hallDoors = findDoorsByIds(Arrays.asList("D3", "D4"));
    ArrayList<Door> room1Doors = findDoorsByIds(Arrays.asList("D5"));
    ArrayList<Door> room2Doors = findDoorsByIds(Arrays.asList("D6"));
    ArrayList<Door> room3Doors = findDoorsByIds(Arrays.asList("D8"));
    ArrayList<Door> corridorDoors = findDoorsByIds(Arrays.asList("D7"));
    ArrayList<Door> itDoors = findDoorsByIds(Arrays.asList("D9"));

    // create spaces

    // basement parent
    Space parking = new Space("parking", "Parking", parkingDoors, basement);

    ArrayList<Area> basementSpaces = new ArrayList<>(Arrays.asList(parking));

    basement.setAreas(basementSpaces);

    // ground_floor parent
    // hall = A8
    Space hall = new Space("hall", "Floor", hallDoors, ground_floor);
    Space room1 = new Space("room1", "Room", room1Doors, ground_floor);
    Space room2 = new Space("room2", "Room", room2Doors, ground_floor);

    ArrayList<Area> groundFloorSpaces = new ArrayList<>(Arrays.asList(hall, room1, room2));

    ground_floor.setAreas(groundFloorSpaces);

    // floor_1 parent
    Space room3 = new Space("room3", "Room", room3Doors, floor_1);
    Space corridor = new Space("corridor", "Corridor", corridorDoors, floor_1);
    Space it = new Space("it", "It", itDoors, floor_1);

    ArrayList<Area> floor1Spaces = new ArrayList<>(Arrays.asList(room3, corridor, it));

    floor_1.setAreas(floor1Spaces);


    // buiding parent
    Space stairs = new Space("stairs", "Stairs", building);
    Space exterior = new Space("exterior", "Exterior", building);

    ArrayList<Area> buildingSpaces = new ArrayList<>(Arrays.asList(
        basement, ground_floor, floor_1, stairs, exterior
    ));
    building.setAreas(buildingSpaces);

    // set spaces from and to
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

  private static void makeDoors() {
    // basement
    Door d1 = new Door("D1"); // exterior, parking
    Door d2 = new Door("D2"); // stairs, parking

    // ground floor
    Door d3 = new Door("D3"); // exterior, hall
    Door d4 = new Door("D4"); // stairs, hall
    Door d5 = new Door("D5"); // hall, room1
    Door d6 = new Door("D6"); // hall, room2

    // first floor
    Door d7 = new Door("D7"); // stairs, corridor
    Door d8 = new Door("D8"); // corridor, room3
    Door d9 = new Door("D9"); // corridor, IT

    doors = new ArrayList<>(Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8, d9));
  }

  private static ArrayList<Door> findDoorsByIds(List<String> ids) {
    ArrayList<Door> doors = new ArrayList<>();
    for (String id : ids) {
      Door door = findDoorById(id);
      if (door != null) {
        doors.add(door);
      }
    }
    return doors;
  }

  public static Door findDoorById(String id) {
    for (Door door : doors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    return null;
  }

  public static ArrayList<Door> getAllDoors() {
    return doors;
  }

  public static Area getRootArea() {
    return rootArea;
  }
}
