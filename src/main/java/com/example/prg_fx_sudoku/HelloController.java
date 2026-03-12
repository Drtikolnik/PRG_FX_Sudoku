package com.example.prg_fx_sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    private ArrayList<Pole> pole = new ArrayList<>();


    //public void generateNumbers() {
    //    for(int i = 1; i <= 9; i++) {
    //        pole.add(new Pole(i));
    //    }
    //}

    @FXML
    public void displayCards() {
        int index = 0;

        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                Card card = cards.get(index++);
                Button btn = card.getButton();
                btn.setOnAction( e -> handleCardClick(card));
                gridPane.add(btn, col, row);
            }
        }

    }



}
