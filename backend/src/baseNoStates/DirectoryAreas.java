package baseNoStates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class is responsible for building the map of the building.
//
// It is a Singleton. Its main job is to create the object tree for the Composite Pattern
// and linking the Doors between them. It also provides methods to find specific
// areas or doors by ID so we don't have to traverse the tree
// manually every time we need something.


public final class DirectoryAreas {
  private static final Logger LOGGER = LoggerFactory.getLogger("FITA1");
  private static Area rootArea;
  private static ArrayList<Door> doors;
  private static DirectoryAreas directoryAreas = null;

  private DirectoryAreas() {
    LOGGER.info("DirectoryAreas creat");
  }

  public static DirectoryAreas getDirectoryAreas() {
    if (directoryAreas == null) {
      directoryAreas = new DirectoryAreas();
    }
    LOGGER.info("DirectoryAreas cridat");
    return directoryAreas;
  }

  public void makeAreas() {
    // create partitions
    Partition building = new Partition("building", "Building", null);
    Partition basement = new Partition("basement", "Basement", building);
    Partition groundFloor = new Partition("ground_floor", "Ground floor", building);
    Partition floor1 = new Partition("floor1", "Floor 1", building);

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
    Space hall = new Space("hall", "Floor", hallDoors, groundFloor);
    Space room1 = new Space("room1", "Room", room1Doors, groundFloor);
    Space room2 = new Space("room2", "Room", room2Doors, groundFloor);

    ArrayList<Area> groundFloorSpaces = new ArrayList<>(Arrays.asList(hall, room1, room2));

    groundFloor.setAreas(groundFloorSpaces);

    // floor_1 parent
    Space room3 = new Space("room3", "Room", room3Doors, floor1);
    Space corridor = new Space("corridor", "Corridor", corridorDoors, floor1);
    Space it = new Space("it", "It", itDoors, floor1);

    ArrayList<Area> floor1Spaces = new ArrayList<>(Arrays.asList(room3, corridor, it));

    floor1.setAreas(floor1Spaces);


    // building parent
    Space stairs = new Space("stairs", "Stairs", building);
    Space exterior = new Space("exterior", "Exterior", building);

    ArrayList<Area> buildingSpaces = new ArrayList<>(Arrays.asList(
        basement, groundFloor, floor1, stairs, exterior
    ));
    building.setAreas(buildingSpaces);

    // set spaces from and to
    doors.get(0).setFromSpace(exterior);
    doors.get(0).setToSpace(parking);
    doors.get(1).setFromSpace(stairs);
    doors.get(1).setToSpace(parking);
    doors.get(2).setFromSpace(exterior);
    doors.get(2).setToSpace(hall);
    doors.get(3).setFromSpace(stairs);
    doors.get(3).setToSpace(hall);
    doors.get(4).setFromSpace(hall);
    doors.get(4).setToSpace(room1);
    doors.get(5).setFromSpace(hall);
    doors.get(5).setToSpace(room2);
    doors.get(6).setFromSpace(stairs);
    doors.get(6).setToSpace(corridor);
    doors.get(7).setFromSpace(corridor);
    doors.get(7).setToSpace(room3);
    doors.get(8).setFromSpace(corridor);
    doors.get(8).setToSpace(it);
  }

  private void makeDoors() {
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

  public static Area findAreaById(String areaId) {
    if (areaId.equals("ROOT")) {
      // Special id that means that the wanted area is the root.
      // This is because the Flutter app client doesn't know the
      // id of the root, differently from the simulator
      return rootArea;
    } else {
      VisitorFindAreaById visitorFindAreaById = new VisitorFindAreaById(areaId);
      rootArea.acceptVisitor(visitorFindAreaById);

      return visitorFindAreaById.getArea();
    }
  }

  private ArrayList<Door> findDoorsByIds(List<String> ids) {
    ArrayList<Door> doors = new ArrayList<>();
    for (String id : ids) {
      Door door = findDoorById(id);
      if (door != null) {
        doors.add(door);
      }
    }
    return doors;
  }

  public Door findDoorById(String id) {
    for (Door door : doors) {
      if (door.getId().equals(id)) {
        return door;
      }
    }
    return null;
  }

  public ArrayList<Door> getAllDoors() {
    return doors;
  }

  public Area getRootArea() {
    return rootArea;
  }
}
