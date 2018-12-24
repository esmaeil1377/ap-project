package FarmModel.ObjectInMap15_15;

public class Grass extends ObjectInMap30_30 {
    private int turnToDisapear;
    private int remainTurnToDisApear;

    public Grass() {
        setTurnToDisapear(30);
    }

    public int getRemainTurnToDisApear() {
        return remainTurnToDisApear;
    }

    public void setRemainTurnToDisApear(int remainTurnToDisApear) {
        this.remainTurnToDisApear = remainTurnToDisApear;
    }

    public int getTurnToDisapear() {
        return turnToDisapear;
    }

    public void setTurnToDisapear(int turnTODisApear) {
        this.turnToDisapear = turnTODisApear;
    }

    @Override
    public String toString() {
        return "Grass";
    }
}
