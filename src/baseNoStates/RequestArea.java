package baseNoStates;

public class RequestArea implements Request {
  @Override
  public void procces() {
    Area area = DirectoryAreas.findAreaById(areaId);
    if (area != null) {
      for(Door door : area.getDoorsGivingAccess()){
        RequestReader requestReader = new RequestReader(credential, action, noew, door.getId());
        requestReader.procces();
      }
    }
  }
}
