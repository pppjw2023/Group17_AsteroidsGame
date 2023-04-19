package com.asteroids.gameController;

import com.asteroids.gameObjects.GameRule;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AsteroidScenes {


    public static void createScene(Parent node, Stage stage) {
        Scene scene = new Scene(node);
        stage.setTitle("Asteroid Application!");
        stage.setScene(scene);
        stage.show();
    }


    public static void showMenu(Stage gameStage) {

        FlowPane fileMenu = new FlowPane();
        fileMenu.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        fileMenu.setOrientation(Orientation.VERTICAL);
        fileMenu.setCenterShape(true);
        fileMenu.setVgap(10);
        fileMenu.setAlignment(Pos.CENTER);
        fileMenu.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        //Creating menu Items
        Button gamePlayBtn = new Button("Play the Game");
        gamePlayBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        gamePlayBtn.setStyle("-fx-text-fill: white;");
        Button leaderBoardBtn = new Button("Leader Board");
        leaderBoardBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        leaderBoardBtn.setStyle("-fx-text-fill: white;");
        Button gameRulesBtn = new Button("Game Rules");
        gameRulesBtn.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        gameRulesBtn.setStyle("-fx-text-fill: white;");

        //Adding functions to call on click of buttons:
        gamePlayBtn.setOnAction(clicked -> {
            //return game window
            showGameScene(gameStage);
        });


        leaderBoardBtn.setOnAction(clicked -> {
            //return game window
            showLeaderBoardScene();
        });


        gameRulesBtn.setOnAction(clicked -> {
            //show Rule window
            showGameRuleScene(gameStage);
        });

        //Adding all the menu items to the menu
        fileMenu.getChildren().addAll(gamePlayBtn, leaderBoardBtn, gameRulesBtn);
        createScene(fileMenu, gameStage);
    }


    public static void getUserName(Stage stage){
        VBox vbox = new VBox();
        vbox.setSpacing(10); // Set spacing between elements

        // Create a text field
        vbox.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        vbox.setSpacing(10);
        vbox.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));

        TextField nameField = new TextField();
        vbox.getChildren().add(nameField); // Add text field to VBox

        nameField.setPrefWidth(10);

        // Create a scene with the VBox as the root element

        // Create a button
        Button playButton = new Button("Play the game!");
        Button addUserName = new Button("Add the username!");
        playButton.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        playButton.setStyle("-fx-text-fill: white;");
        addUserName.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        addUserName.setStyle("-fx-text-fill: white;");

        playButton.setDisable(true);
        vbox.getChildren().add(addUserName);
        vbox.getChildren().add(playButton); // Add button to VBox
        vbox.setAlignment(Pos.CENTER);

        addUserName.setOnAction(clicked -> {
            String nameInput = nameField.getText();
            if(!nameInput.isEmpty()){
                playButton.setDisable(false);
                AsteroidApplication.userName = nameInput;
            }
        });
        playButton.setOnAction(clicked -> {
            GameLevels.levelOneGame(stage);
        });


        

        // Create a scene with the VBox as the root element
        Scene scene = new Scene(vbox, AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT);

        // Set the scene on the primary stage
        stage.setScene(scene);
        stage.setTitle("Create User!");
        stage.show();

    }

    public static void showGameScene(Stage stage) {
        getUserName(stage);
    }




    public static void showLeaderBoardScene() {

    }

    public static void showGameRuleScene(Stage stage) {
        GameRule.showGameRule(stage);
    }



    public static void gameOverScene(boolean sceneStop, Stage stage){

        if(sceneStop){
            AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);

            //logic to add this scoremap to a file


            createGameOverScene(stage);
        }
    }

    public static void createGameOverScene(Stage stage){
        AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);
        Text gameOverText = new Text(AsteroidApplication.WIDTH/2,AsteroidApplication.HEIGHT/2, "Game Over!");
//        addToHighScore(AsteroidApplication.CurrentScore);
        String playerScoreStr = AsteroidApplication.userName +"'s Score: " + AsteroidApplication.CurrentScore;
        Text playerScore = new Text(AsteroidApplication.WIDTH/2,AsteroidApplication.HEIGHT/2+10,playerScoreStr);
        Pane gameOverPane = new Pane();
        gameOverPane.setPrefSize(AsteroidApplication.WIDTH,AsteroidApplication.HEIGHT);
        gameOverPane.getChildren().add(gameOverText);
        gameOverPane.getChildren().add(playerScore);
        AsteroidApplication.CurrentScore = 0;
        Scene scene = new Scene(gameOverPane);
        stage.setScene(scene);
        stage.show();
    }

//    public static void addToHighScore(int currentScore){
//        if(AsteroidApplication.highScores)
//
//    }


    public static void nextLevelScene(boolean nextLevel, int level, Stage stage){
        if(nextLevel){
            switch(level){
                case 1:
                    GameLevels.levelTwoGame(stage);
                    break;
                case 2:
                    GameLevels.levelThreeGame(stage);
                    break;
                case 3:
                    GameLevels.levelFourgame(stage);
                    break;
                case 4:
                    AsteroidApplication.scoreMap.put(AsteroidApplication.userName, AsteroidApplication.CurrentScore);
                    AsteroidScenes.showMenu(stage);
            }
        }
    }




}
