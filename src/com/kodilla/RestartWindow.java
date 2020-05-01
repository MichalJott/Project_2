package com.kodilla;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RestartWindow {
    Game game;
    public RestartWindow(Game game) {
        this.game = game;
    }
    public void displayWindow() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        Label label = new Label();
        Button button = new Button();
        if(game.winningConditions == true){
            window.setTitle("Results");
            label.setText(game.whichPlayerWon());
            button.setText("Challenge Yourself one more time");
        }

        if(game.endingConditions == true) {
            window.setTitle("Tie");
            label.setText("Tie between Players");
            button.setText("Challenge Yourself one more time");
        }

        button.setOnAction(e -> {
            window.close();
            game.restartGame();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 100);
        window.setScene(scene);
        window.showAndWait();
    }
}
