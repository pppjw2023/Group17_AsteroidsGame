package com.asteroids.gameController;
import com.asteroids.gameObjects.GameObject;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;


import java.io.File;
import java.io.IOException;
import java.util.*;

public class AsteroidApplication extends Application {


    public static final int WIDTH = 900;
    public static final int HEIGHT = 400;

    public static String userName = "Unnamed";

    public static List<Integer> highScores = new ArrayList<Integer>();
    public static Map<String, Integer> scoreMap = new HashMap<String, Integer>();


    public static int CurrentScore = 0;

    // add BGM
    private static final String BGM_PATH = System.getProperty("user.dir") + File.separator + "BGM.mp3";
    private static final String BACKGROUND_MUSIC = BGM_PATH;

    private MediaPlayer mediaPlayer;


    @Override
    public void start(Stage stage) throws IOException {
        // play BGM
        Media backgroundMusic = new Media(new File(BACKGROUND_MUSIC).toURI().toString());
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        startAsteroidsApp(stage);
    }


    public static void startAsteroidsApp(Stage stage) {
        AsteroidScenes.showMenu(stage);
    }

    @Override
    public void stop() throws Exception {
        // stop BGM when exit app
        mediaPlayer.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}