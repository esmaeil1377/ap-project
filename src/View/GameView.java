package View;
import View.ScenesAndMainGroupView.*;


public class GameView {
    private static GameView gameView=new GameView();
    private StartMenuView startMenuView=new StartMenuView(Main.getPrimaryStage());
    private MissionSelectionView missionSelectionView=new MissionSelectionView(Main.getPrimaryStage());
    private GameShopView gameShopView;
    private FarmView farmView;
    private ProductInTruckView productInTruckView;
    private ProductInHelicopterView productInHelicopterView;

    public void setProductInTruckView(ProductInTruckView productInTruckView) {
        this.productInTruckView = productInTruckView;
    }
    public void setProductInHelicopterView(ProductInHelicopterView productInHelicopterView) {
        this.productInHelicopterView = productInHelicopterView;
    }
    public ProductInHelicopterView getProductInHelicopterView() {
        return productInHelicopterView;
    }
    public static void setGameView(GameView gameView) {
        GameView.gameView = gameView;
    }
    public ProductInTruckView getProductInTruckView() {
        return productInTruckView;
    }
    public void setFarmView(FarmView farmView) {
        this.farmView = farmView;
    }
    public FarmView getFarmView() {
        return farmView;
    }
    public GameShopView getGameShopView() {
        return gameShopView;
    }
    public void setGameShopView(GameShopView gameShopView) {
        this.gameShopView = gameShopView;
    }
    public StartMenuView getStartMenuView() {
        return startMenuView;
    }
    public void setStartMenuView(StartMenuView startMenuView) {
        this.startMenuView = startMenuView;
    }
    public MissionSelectionView getMissionSelectionView() {
        return missionSelectionView;
    }
    public void setMissionSelectionView(MissionSelectionView missionSelectionView) {
        this.missionSelectionView = missionSelectionView;
    }

    private GameView(){}
    public static GameView getGameView() {
        return gameView;
    }

}