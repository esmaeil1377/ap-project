package FarmModel;

import java.util.ArrayList;
import java.util.HashMap;

public class Mission {
    private int startMoneyInMission;
    private int constantRewardAfterFinishingtheMission;
    private int TimeTakeForPlayerToFinishTheMap;
    private Farm farm;
    private boolean isMissionCompletedBefore = false;
    private HashMap<Object, Integer> requiermentToFinishTheMission = new HashMap<>();


    public Mission(int startMoneyInMission, int timeTakeForPlayerToPlayTheMap, Farm farm) {
        TimeTakeForPlayerToFinishTheMap = timeTakeForPlayerToPlayTheMap;
        this.farm = farm;
        this.startMoneyInMission=startMoneyInMission;
    }

    public int getStartMoneyInMission() {
        return startMoneyInMission;
    }

    public void setStartMoneyInMission(int startMoneyInMission) {
        this.startMoneyInMission = startMoneyInMission;
    }

    public int getTimeTakeForPlayerToFinishTheMap() {
        return TimeTakeForPlayerToFinishTheMap;
    }

    public void setTimeTakeForPlayerToFinishTheMap(int timeTakeForPlayerToFinishTheMap) {
        TimeTakeForPlayerToFinishTheMap = timeTakeForPlayerToFinishTheMap;
    }

    public boolean isMissionCompletedBefore() {
        return isMissionCompletedBefore;
    }

    public void setMissionCompletion(boolean missionCompletedBefore) {
        isMissionCompletedBefore = missionCompletedBefore;
    }

    public void PutStartingObjectRandomlyInTheirPlace(ArrayList<Object> ObjectForStartingTheMission) {
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Farm getFarm() {
        return farm;
    }

    public void GiveRewardToUser() {
    }

    public int CalcualteMoneyToGiveUserAfterCompletingTheMission(){
        //it is a function of timeplayerfinished the mission and other thing that i don't know
    }

    public boolean CheckIfMissionIsFinished() {
        boolean result = true;
        Farm farm=Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm();
        for (Object object : requiermentToFinishTheMission.keySet()) {
            if (object.toString().equals("Chicken")) {
                int numberofchicken = farm.getCurrentChickenInMap().size();
                if (!(numberofchicken < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cow")) {
                int numberOfCow = farm.getCurrnetCowInMap().size();
                if (!(numberOfCow < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Ship")) {
                int numberOfShip = farm.getCurrnetShipInMap().size();
                if (!(numberOfShip < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Cat")) {
                int numberOfCat = farm.getCurrentCatInMap().size();
                if (!(numberOfCat < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else if (object.toString().equals("Dog")) {
                int numberOfDog =farm.getCurrentCatInMap().size();
                if (!(numberOfDog < requiermentToFinishTheMission.get(object))) {
                    result = false;
                }
            } else {
                int numberOfObjectInMapNeededForMissionToBeFinished=farm.getWareHouse().getRecordNoteBookThatRecordEveryThingAndNumbers().get(object.getClass());
                if(numberOfObjectInMapNeededForMissionToBeFinished<requiermentToFinishTheMission.get(object)){
                    result=false;
                }
            }
        }
        return result;
    }
}
