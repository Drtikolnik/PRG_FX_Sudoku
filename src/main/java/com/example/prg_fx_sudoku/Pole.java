package com.example.prg_fx_sudoku;

import javafx.scene.control.Button;
import javafx.animation.PauseTransition;
import javafx.scene.control.TextField;
import javafx.util.Duration;


public class Pole {
    private int id;
    private TextField textPole;
    //private boolean matched = false;






    public Pole(int id) {
        this.id = id;
        this.textPole = new TextField(null);
        this.textPole.setMinSize(63,63);
    }















}

//  1 2 3        123
//  4 5 6   ->   456
//  7 8 9        789





