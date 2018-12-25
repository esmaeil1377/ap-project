package FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WorkShop;


import FarmController.Exceptions.MissionNotLoaded;
import FarmModel.Cell;
import FarmModel.Game;
import FarmModel.ObjectInMap30_30.Product.Product;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Cake;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Cookie;
import FarmModel.ObjectInMap30_30.Product.WorkShopProduct.Flour;
import FarmModel.ObjectOutOfMap30_30ButInTheBorderOfPlayGround.WareHouse;

import java.util.HashMap;

public class CakeBakery extends WorkShop {
    public final String WorkShopName = "CakeBakery";

    public CakeBakery() {
        HashMap<Product, Integer> objectNeededToProduceOne=new HashMap<>();
        objectNeededToProduceOne.put(new Flour(),getMaxNumberOfGettingInput());
        objectNeededToProduceOne.put(new Cookie(),getMaxNumberOfGettingInput());
        setObjectNeededToProduceAProduct(objectNeededToProduceOne);
        setResultProduct(new Cake());
    }

    public String getWorkShopName() {
        return WorkShopName;
    }

    @Override
    public void MakeAProductAndPutItInMap() throws MissionNotLoaded {
        for (int i = 0; i < getCurrentNumberOfProducingProduct(); i++) {
            Cell cell = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission().getFarm().getMap()[i][0];
            cell.AddCellAMapObject(getResultProduct());
        }
    }
    public void getProductFromWareHouse() {
        int countOfFlour = 0;
        WareHouse wareHouse = new WareHouse();
        Flour flour = new Flour();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(flour.toString()))
                countOfFlour++;
        }
        int countOfCookie = 0;
        int min = 0;
        Cookie cookie = new Cookie();
        for (Object object : wareHouse.getWareHouseList()) {
            if (object.toString().equals(cookie.toString()))
                countOfCookie++;
        }
        if (getMaxNumberOfGettingInput() <= countOfFlour)
           min = getMaxNumberOfGettingInput() ;
        else
            min = countOfFlour;
        if (min <= countOfCookie)
             setCurrentNumberOfProducingProduct(min);
        else
           setCurrentNumberOfProducingProduct(countOfCookie);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(flour);
        for(int i = 0 ; i <getCurrentNumberOfProducingProduct();i++)
            wareHouse.RemovePieceOfObjectFromWareHouse(cookie);
    }


    @Override
    public String toString() {
        return "CakeBakery";
    }
}