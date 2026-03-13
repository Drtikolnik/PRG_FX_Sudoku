package com.example.prg_fx_sudoku;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private GridPane grid1;



    //public void generateNumbers() {
    //    for(int i = 1; i <= 9; i++) {
    //        pole.add(new Pole(i));
    //    }
    //}

    //private ArrayList<Pole> pole = new ArrayList<>();
    private Pole[][] policka = new Pole[9][9];
    private int[][] cisla = new int[9][9];

    @FXML
    public void displayFields() {
        int id = 0;

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                Pole policko = new Pole(id);
                id++;
                policka[row][col] = policko;
                grid1.add(policko, col, row);
            }
        }

    }

    public void nacteniCisel(){
        for(int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = policka[row][col].getText();

                if(text == null || text.trim().isEmpty()){
                    text = "0";
                }
                cisla[row][col] = Integer.parseInt(text.trim());

            }
        }
    }


    public void onKontrolaZadani(){
        nacteniCisel();

        for(int row = 0; row < 9; row++) {
            int[] radek = new int[9];
            for (int col = 0; col < 9; col++) {
                radek[col] = cisla[row][col];
            }

            //tady dosaď to co by tam mělo být - ta kontrola radek
        }



    }










    public void initialize(){
        displayFields();
    }



}
