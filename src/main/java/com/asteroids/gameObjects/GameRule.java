package com.asteroids.gameObjects;

import com.asteroids.gameController.AsteroidApplication;
import com.asteroids.gameController.AsteroidScenes;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class GameRule {
    static String rolesText = "Player: \n"
            + "You manipulate a space shuttle in space.\n\n"
            + "Enemy:\n"
            + "There are two kinds of enemies:\n"
            + "(1) The moving meteorite that crash you.\n"
            + "(2) The flying alien spacecraft ttat can shoot you and crash you.\n\n"
            + "Each time the alien spacecraft appears in a bigger shape and will be broken into three small ones when shot by your bullets \n"
            + "The smaller alien spacecraft will explode when shot by your bullets.";

    static String weaponText = "Weapon: \n"
                    + "The space shuttle can shoot bullets to meteorites and enemies.\n\n";



    public static void showGameRule(Stage stage) {

        Accordion accordion = new Accordion();
        TitledPane roles = new TitledPane("Roles", new Label(rolesText));
        TitledPane weapon = new TitledPane("Weapons", new Label(weaponText));
        accordion.getPanes().addAll(roles, weapon);


        // Create a button to return to the main menu
        Button backButton = new Button("Return to Main Menu");
        backButton.setOnAction(event -> AsteroidScenes.showMenu(stage));

        // Create a VBox to contain the button
        VBox vbox = new VBox(backButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);

        TitledPane backPane = new TitledPane("Back", vbox);
        accordion.getPanes().add(backPane);


        Scene scene = new Scene(accordion, AsteroidApplication.WIDTH, AsteroidApplication.HEIGHT); // set minimum width and height of the scene
        stage.setScene(scene); // set the scene of the stage to the created scene
        stage.setResizable(false); // prevent resizing of the window
        stage.show(); // display the stage with the created scene
    }
}
