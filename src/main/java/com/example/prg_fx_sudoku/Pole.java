package com.example.prg_fx_sudoku;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class Pole extends TextField {
    private int id;
    private TextField textPole;
    //private boolean matched = false;






    public Pole(int id) {
        this.id = id;
        this.textPole = new TextField(null);
        this.textPole.setMinWidth(63);
        this.textPole.setPrefWidth(63);
        this.textPole.setMaxWidth(63);

        this.textPole.setMinHeight(63);
        this.textPole.setPrefHeight(63);
        this.textPole.setMaxHeight(63);
        this.textPole.setAlignment(Pos.CENTER);
    }















}

//  1 2 3        123
//  4 5 6   ->   456
//  7 8 9        789





