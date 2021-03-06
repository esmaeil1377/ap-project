package View.ScenesAndMainGroupView;//package View.ScenesAndMainGroupView;

import FarmController.Exceptions.MissionNotLoaded;
import javafx.scene.control.Label;
import FarmController.Exceptions.UnknownObjectException;
import FarmModel.Game;
import FarmModel.Mission;
import FarmModel.User;
import View.GameView;
import View.View;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MissionSelectionView extends View {
    private Group root = new Group();
    private Scene scene = new Scene(root, 1600, 900);
    private String bestTimeForMissino1="99:99";
    private String bestTimeForMission2="99:99";
    private String bestTimeForMission3="99:99";
    private String bestTimeForMission4="99:99";
    private int SHIFT = 0;
    private User user=Game.getGameInstance().getCurrentUserAccount();
    private Mission[] missions = new Mission[4];
    ArrayList<Label>[] arrayListLabelOfObject = new ArrayList[4];
    ArrayList<Label>[] arrayListLabelOfInteger = new ArrayList[4];

    private File informationMissionFile = new File("Data\\Callout\\Callout.png");
    private Image informationMissionImage = new Image(informationMissionFile.toURI().toString());
    private ImageView[] informationMissionImageView = new ImageView[10];


    public String getBestTimeForCurrnetMissionToEnd() throws MissionNotLoaded {
        Mission mission=Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();
        if (mission.getMissionName().equals("mission1")){
            return bestTimeForMissino1;
        }else if (mission.getMissionName().equals("mission2")){
            return bestTimeForMission2;
        }else if (mission.getMissionName().equals("mission3")){
            return bestTimeForMission3;
        }else if (mission.getMissionName().equals("mission4")){
            return bestTimeForMission4;
        }
        return "00:00";
    }

    public void setBestTimeForCurrnetMissionIfItIsBest(String newTime) throws MissionNotLoaded {
        int value=0;
        int value2=0;
        Mission mission = Game.getGameInstance().getCurrentUserAccount().getCurrentPlayingMission();;
        String lastTime = GameView.getGameView().getMissionSelectionView().getBestTimeForCurrnetMissionToEnd();
        if (newTime.length()>4) {
            value = Integer.valueOf(newTime.substring(0, 2)) * 60 + Integer.valueOf(newTime.substring(3, 5));
        }else{
            value = Integer.valueOf(newTime.substring(0, 1)) * 60 + Integer.valueOf(newTime.substring(2, 4));
        }
        if(lastTime.length()>4){
            value2 = Integer.valueOf(lastTime.substring(0, 2)) * 60 + Integer.valueOf(lastTime.substring(3, 5));
        }else{
            value2 = Integer.valueOf(lastTime.substring(0, 1)) * 60 + Integer.valueOf(lastTime.substring(2, 4));
        }
        if (value<value2) {
            if (mission.getMissionName().equals("mission1")) {
                bestTimeForMissino1 = newTime;
            } else if (mission.getMissionName().equals("mission2")) {
                bestTimeForMission2 = newTime;
            } else if (mission.getMissionName().equals("mission3")) {
                bestTimeForMission3 = newTime;
            } else if (mission.getMissionName().equals("mission4")) {
                bestTimeForMission4 = newTime;
            }
        }
    }

    public Scene getScene() {
        return scene;
    }

    public MissionSelectionView(Stage primaryStage) {
        Start(primaryStage);
    }

    @Override
    public void Start(Stage primaryStage) {
        AddBackGround(primaryStage);
//        BeachOfMission(primaryStage);
        NumberOfMission(primaryStage);
        FarmerOfFarm(primaryStage);
        AddMainMenu(primaryStage);
        AddShopButton(primaryStage);


    }

    private void AddBackGround(Stage primaryStage) {
        File backGroundFile = new File("Data\\Mission\\MissionBackGround.jpg");
        Image backGroundImage = new Image(backGroundFile.toURI().toString());
        ImageView BackGroundView = new ImageView(backGroundImage);
        BackGroundView.setFitHeight(900);
        BackGroundView.setFitWidth(1600);
        root.getChildren().addAll(BackGroundView);
        AddGando();
    }


//    private void BeachOfMission(Stage primaryStage) {
//        File restartFile = new File("Data\\Mission\\Map.jpeg");
//        Image restartImage = new Image(restartFile.toURI().toString());
//        ImageView restartImageView = new ImageView(restartImage);
//        restartImageView.relocate(1230, 550);
//        primaryStage.setFullScreen(true);
//        restartImageView.setFitHeight(120);
//        restartImageView.setFitWidth(120);
//        //Circle circle = new Circle(1200, 500, 150); // cast to Circle
//        //circle.setFill(restartImageView);
//        root.getChildren().addAll(restartImageView);
//    }

    private void FarmerOfFarm(Stage primaryStage) {
        File farmerFile = new File("Data\\Gif\\SeaAnimal.gif");
        Image farmerImage = new Image(farmerFile.toURI().toString());
        ImageView farmerImageView = new ImageView(farmerImage);
        farmerImageView.relocate(1200, 410);
        primaryStage.setFullScreen(true);
        farmerImageView.setFitHeight(200);
        farmerImageView.setFitWidth(200);
        root.getChildren().addAll(farmerImageView);
        primaryStage.show();
    }

    private void NumberOfMission(Stage primaryStage) {
        missions[0] = user.getMission1();
        missions[1] = user.getMission2();
        missions[2] = user.getMission3();
        missions[3] = user.getMission4();
        File numberFile = new File("Data\\Mission\\Bubble.png");
        Image numberImage = new Image(numberFile.toURI().toString());
        //ImageView numberImageView = new ImageView(numberImage);
        ImageView[] numberImageView = new ImageView[10];
        for (int i = 20; i < 30; i++) {
            ImageView bubbleImageView = new ImageView(numberImage);
            numberImageView[i - 20] = bubbleImageView;
            bubbleImageView.relocate(1300 - 300 * Math.cos(i * 3.14 / 11), 550 - 300 * Math.sin(i * 3.14 / 11));
            bubbleImageView.setFitWidth(50);
            bubbleImageView.setFitHeight(50);
            root.getChildren().addAll(bubbleImageView);
        }
        for (int i = 20; i < 24; i++) {
            ImageView imageView = new ImageView(informationMissionImage);
            arrayListLabelOfInteger[i - 20] = new ArrayList<>();
            arrayListLabelOfObject[i - 20] = new ArrayList<>();
            informationMissionImageView[i - 20] = imageView;
            informationMissionImageView[i - 20].relocate(1300 - 300 * Math.cos(i * 3.14 / 11) - 200, 550 - 300 * Math.sin(i * 3.14 / 11) - 140);
            informationMissionImageView[i - 20].setFitHeight(150);
            informationMissionImageView[i - 20].setFitWidth(300);
            HashMap<Object, Integer> hashMap = missions[i - 20].getRequirementToFinishTheMission();
            SHIFT = 25;
            for (Map.Entry map: hashMap.entrySet()) {
                Label label1 = new Label(map.getKey().toString());
                label1.relocate(1300 - 300 * Math.cos(i * 3.14 / 11) + 60 - 200, 550 - 300 * Math.sin(i * 3.14 / 11) + SHIFT - 130 );
                label1.setTextFill(Color.BLACK);
                label1.setStyle("-fx-font: 25 Georgia; -fx-base: #030202;");
                arrayListLabelOfObject[i - 20].add(label1);
                Label label2 = new Label(map.getValue().toString());
                label2.relocate(1300 - 300 * Math.cos(i * 3.14 / 11) + 230 - 200, 550 - 300 * Math.sin(i * 3.14 / 11) + SHIFT - 130);
                label2.setTextFill(Color.BLACK);
                label2.setStyle("-fx-font: 25 Georgia; -fx-base: #030202;");
                arrayListLabelOfInteger[i - 20].add(label2);
                SHIFT += 25;
            }
            SHIFT = 0;
        }
        try {
            for (int i = 20; i < 30; i++) {
                final int finali = i;
                numberImageView[finali - 20].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Mission mission = Game.getGameInstance().getCurrentUserAccount().getMissions().get(finali - 20);
                        Game.getGameInstance().getCurrentUserAccount().setCurrentPlayingMission(mission);
                        try {
                            GameView.getGameView().setFarmView(new FarmView(primaryStage));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        primaryStage.setScene(GameView.getGameView().getFarmView().getScene());
                        primaryStage.setFullScreen(true);
                    }
                });

                numberImageView[finali - 20].setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[finali - 20].relocate(1300 - 300 * Math.cos(finali * 3.14 / 11) + 5, 550 - 300 * Math.sin(finali * 3.14 / 11) + 5);
                        numberImageView[finali - 20].setFitWidth(40);
                        numberImageView[finali - 20].setFitHeight(40);
                        if (finali - 20 < 4) {
                            root.getChildren().addAll(informationMissionImageView[finali - 20]);
                            for (Label label1: arrayListLabelOfObject[finali - 20]) {
                                root.getChildren().addAll(label1);
                            }
                            for (Label label1 : arrayListLabelOfInteger[finali - 20]) {
                                root.getChildren().addAll(label1);
                            }
                        }
                    }
                });
                numberImageView[finali - 20].setOnMouseExited(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        numberImageView[finali - 20].relocate(1300 - 300 * Math.cos(finali * 3.14 / 11), 550 - 300 * Math.sin(finali * 3.14 / 11));
                        numberImageView[finali - 20].setFitWidth(50);
                        numberImageView[finali - 20].setFitHeight(50);
                        if (finali - 20 < 4) {
                            root.getChildren().remove(informationMissionImageView[finali - 20]);
                            for (Label label1: arrayListLabelOfObject[finali - 20]) {
                                root.getChildren().remove(label1);
                            }
                            for (Label label1 : arrayListLabelOfInteger[finali - 20]) {
                                root.getChildren().remove(label1);
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void AddGando() {
        File restartFile = new File("Data\\Gif\\Gando.gif");
        Image restartImage = new Image(restartFile.toURI().toString());
        ImageView restartImageView = new ImageView(restartImage);
        restartImageView.relocate(450, 250);
        restartImageView.setFitHeight(200);
        restartImageView.setFitWidth(200);
        root.getChildren().addAll(restartImageView);
    }

    private void AddMainMenu(Stage primaryStage) {
        File menuButton = new File("Data\\Mission\\OkButton.png");
        Image menuButtonImage = new Image(menuButton.toURI().toString());
        ImageView menuButtonView = new ImageView(menuButtonImage);
        menuButtonView.setFitHeight(75);
        menuButtonView.setFitWidth(150);
        menuButtonView.relocate(1350, 760);
        menuButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1345, 755);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1350, 760);
            }
        });
        menuButtonView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getScene());
                primaryStage.setFullScreen(true);
            }
        });
        File menuText = new File("Data\\Mission\\MenuText.png");
        Image menuTextImage = new Image(menuText.toURI().toString());
        ImageView menuTextView = new ImageView(menuTextImage);
        menuTextView.setFitHeight(50);
        menuTextView.setFitWidth(100);
        menuTextView.relocate(1378, 770);
        menuTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.relocate(1345, 755);
                menuButtonView.setFitHeight(85);
                menuButtonView.setFitWidth(160);
            }
        });
        menuTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menuButtonView.setFitHeight(75);
                menuButtonView.setFitWidth(150);
                menuButtonView.relocate(1350, 760);
            }
        });
        menuTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setScene(GameView.getGameView().getStartMenuView().getScene());
                primaryStage.setFullScreen(true);
            }
        });
        root.getChildren().addAll(menuButtonView, menuTextView);
    }

    private void AddShopButton(Stage primaryStage) {
        File menuButton = new File("Data\\Mission\\OkButton.png");
        Image menuButtonImage = new Image(menuButton.toURI().toString());
        ImageView shopButtonView = new ImageView(menuButtonImage);
        shopButtonView.setFitHeight(75);
        shopButtonView.setFitWidth(150);
        shopButtonView.relocate(15, 760);
        shopButtonView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 755);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopButtonView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 760);
            }
        });
        ShowShopScene(primaryStage, shopButtonView);

        File shopText = new File("Data\\Mission\\ShopText.png");
        Image shopTextImage = new Image(shopText.toURI().toString());
        ImageView shopTextView = new ImageView(shopTextImage);
        shopTextView.setFitHeight(50);
        shopTextView.setFitWidth(100);
        shopTextView.relocate(40, 772);
        shopTextView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.relocate(10, 755);
                shopButtonView.setFitHeight(85);
                shopButtonView.setFitWidth(160);
            }
        });
        shopTextView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                shopButtonView.setFitHeight(75);
                shopButtonView.setFitWidth(150);
                shopButtonView.relocate(15, 760);
            }
        });
        ShowShopScene(primaryStage, shopTextView);
        root.getChildren().addAll(shopButtonView, shopTextView);
    }

    private void ShowShopScene(Stage primaryStage, ImageView shopTextView) {
        shopTextView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                GameShopView gameShopView = new GameShopView(primaryStage);
                GameView.getGameView().setGameShopView(gameShopView);
                primaryStage.setScene(gameShopView.getScene());
                primaryStage.setFullScreen(true);
            }
        });
    }



}