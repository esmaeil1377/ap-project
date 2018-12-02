package FarmModel.ObjectInMap15_15.LiveAnimals;

import FarmModel.Game;
import FarmModel.ObjectInMap15_15.Product.AnimalsProduct.Egg;

public class Chicken extends AnimalProducer {

    @Override
    public String toString() {
        return "Chicken";
    }

    public Chicken(){
        setAnimalAmountOfHunger();
        setMinOfHungerToGoToFindTheGrass();
        setTurnToProduce();
    }
    @Override
    public void Produce() {
        int x=getX();
        int y=getY();
        Game.getGameInstance().getCurrentUserAcount().getCurrentPlayingMission().getFarm().getMap()[x][y].AddCellAMapObject(new Egg());
    }

    public boolean IsHungry() {
        if (getAnimalAmountOfHunger() <= 3) {
            return true;
        }
        return false;
    }

}
