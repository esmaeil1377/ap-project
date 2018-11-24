package FarmModel.OutMapObject.WorkShop;

public class WeavinFactory extends WorkShop {
    private int priceForSell;
    private int priceToBuy;

    @Override
    public int getPriceForSell() {
        return priceForSell;
    }

    @Override
    public int getPriceToBuy() {
        return priceToBuy;
    }
}
