package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;

import FarmController.Exceptions.MissionNotLoaded;
import FarmController.Exceptions.NotEnoughMoney;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Fabric;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Sewing;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class WeavinFactory extends WorkShop {
    public final String workShopName = "WeavingFactory";

    public WeavinFactory(int currentLevel) throws UnknownObjectException, NotEnoughMoney, MissionNotLoaded {
        for(int i=0;i<currentLevel;i++){
            Upgrade();
        }
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Sewing(),1);
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Fabric());
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[15 - i][15];
            cell.AddCellAMapObject(getNewProductByType(getResultProduct()));
        }
    }
    public String getWorkShopName() {
        return workShopName;
    }

    @Override
    public void getProductFromWareHouse() {
        int countOfFibre = 0;
        WareHouse wareHouse = new WareHouse();
        Fabric fabric = new Fabric();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(fabric.toString()))
                countOfFibre++;
        }
        if (getMaxNumberOfGettingInput() <= countOfFibre)
            setCurrentNumberOfProducingProduct(getMaxNumberOfGettingInput());
        else
            setCurrentNumberOfProducingProduct(countOfFibre);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(fabric);
        }

    @Override
    public String toString() {
        return "WeavinFactory";
    }
}
