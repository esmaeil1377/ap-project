package FarmModel.ObjectOutOfMap15_15ButInTheBorderOfPlayGround.WorkShop;

public class CakeBakery extends WorkShop{
    private int priceForSell;
    private int priceToBuy;

    @Override
    public int getPriceToBuy() {
        return priceToBuy;
    }

    @Override
    public int getPriceForSell() {
        return priceForSell;
    }
}
