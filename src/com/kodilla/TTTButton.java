package com.kodilla;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class TTTButton extends Button {
    private Game game;
    private int row;
    private int col;

    public TTTButton(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
        setPrefSize(200, 200);
        setFont(Font.font(80));
        setOnMouseClicked(e -> doClick());
    }

    public void doClick() {
        game.doClick(row, col);
        game.checkForEndingConditions();
        game.showBoard();

    }

    public void displayFigure(Figure figure) {
        if (figure instanceof FigureX)
            setText("X");
        if (figure instanceof FigureO)
            setText("O");
        if (figure.getColour())
            setStyle("-fx-background-color: yellow");
    }

}
