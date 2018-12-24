package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Grass;
import FarmModel.ObjectInMap15_15.ObjectInMap15_15;

public abstract class AnimalProducer extends Animals {
    private int animalAmountOfHunger=8;
    private int healthyAnimalAmountOfHunger;
    private int remainTurnToProduce=18;
    private boolean wantToEatGrass = false;
    private int minOfHungerToGoToFindTheGrass;
    private final int turnToProduce=18;

    public int getHealthyAnimalAmountOfHunger() {
        return healthyAnimalAmountOfHunger;
    }

    public void setHealthyAnimalAmountOfHunger(int healthyAnimalAmountOfHunger) {
        this.healthyAnimalAmountOfHunger = healthyAnimalAmountOfHunger;
    }


    public int getTurnToProduce() {
        return turnToProduce;
    }

    public int getMinOfHungerToGoToFindTheGrass() {
        return minOfHungerToGoToFindTheGrass;
    }

    public void setMinOfHungerToGoToFindTheGrass(int minOfHungerToGoToFindTheGrass) {
        this.minOfHungerToGoToFindTheGrass = minOfHungerToGoToFindTheGrass;
    }

    public void setWantToEatGrass(boolean wantToEatGrass) {
        this.wantToEatGrass = wantToEatGrass;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    public boolean WantToEat() {
        return wantToEatGrass;
    }


    public abstract void Produce() throws MissionNotLoaded;

    public void EatGrass() throws MissionNotLoaded {
        int x = getX();
        int y = getY();
        Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[x][y];
        for (ObjectInMap15_15 objectInMap15_15 : cell.getCellObjectInMap1515()) {
            if (objectInMap15_15 instanceof Grass) {
                cell.RemoveCellAMapObject(objectInMap15_15);
                setAnimalAmountOfHunger(getAnimalAmountOfHunger() + 1);
                if (getAnimalAmountOfHunger() == healthyAnimalAmountOfHunger) {
                    setWantToEatGrass(false);
                }
                return;
            }
        }
    }


    public int getAnimalAmountOfHunger() {
        return animalAmountOfHunger;
    }

    public int getRemainTurnToProduce() {
        return remainTurnToProduce;
    }

    public void setAnimalAmountOfHunger(int animalAmountOfHunger) {
        this.animalAmountOfHunger = animalAmountOfHunger;
    }

    public void setRemainTurnToProduce(int remainTurnToProduce) {
        this.remainTurnToProduce = remainTurnToProduce;
    }

}
