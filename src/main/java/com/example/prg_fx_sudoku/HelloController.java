package com.example.prg_fx_sudoku;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
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
                policko.setMinSize(50,50);
                policko.setMaxSize(50,50);
                policko.setPrefSize(50,50);
                policko.setAlignment(Pos.CENTER);

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

    public boolean jeSpravne(int[] poleCisel, boolean zadani) {
        boolean[] videno = new boolean[10];

        for (int cislo : poleCisel) {
            if (cislo == 0) {
                if(zadani){
                    continue;
                }else{
                    return false;
                }

            }

            if (videno[cislo]) {
                return false;
            }

            videno[cislo] = true;
        }
        return true;
    }
    
    public boolean jeZkontrolovaneASpravne(boolean zadani) {
        nacteniCisel();
        boolean spravne = true;

        //radky
        for(int row = 0; row < 9; row++) {
            int[] radek = new int[9];
            for(int col = 0; col < 9; col++) {
                radek[col] = cisla[row][col];
            }

            if (!jeSpravne(radek, zadani)) {
                System.out.println("Chyba v řádku číslo: " +(row + 1));
                return false;
            }
        }

        //sloupce
        for(int col = 0; col < 9; col++) {
            int[] sloupec = new int[9];
            for(int row = 0; row < 9; row++) {
                sloupec[col] = cisla[row][col];
            }

            if (!jeSpravne(sloupec, zadani)) {
                System.out.println("Chyba ve sloupci číslo: " + (col + 1));
                return false;
            }
        }

        //bloky
        for(int startRow = 0; startRow < 9; startRow += 3) {
            int[] blok = new int[9];
            for(int startCol = 0; startCol < 9; startCol += 3) {

                int pozice = 0;
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        blok[pozice] = cisla[startRow + row][startCol + col];
                        pozice++;

                    }
                }

                if (!jeSpravne(blok, zadani)) {
                    System.out.println("Chyba v bloku na řádku číslo: " +(startRow + 1)+ ", a ve sloupci číslo: " +(startRow + 1));
                    return false;
                }
            }
        }
        
        return true;
    }


    public void onKontrolaZadani(){
        boolean zadani = true;
        nacteniCisel();
        if(!jeZkontrolovaneASpravne(zadani)){
            handleShowKontrola("Kontrola zadání", "ŠPATNÉ ZADÁNÍ!", "zadej jinak!");
        }else{
            handleShowKontrola("Kontrola zadání", "SPRÁVNÉ ZADÁNÍ!", "výborně!");
        }
        
    }
    
    public void onKontrolaReseni(){
        boolean zadani = false;
        nacteniCisel();
        if(!jeZkontrolovaneASpravne(zadani)){
            handleShowKontrola("Kontrola řešení", "ŠPATNÉ ŘEŠNÍ!", "zadej jinak!");
        }else{
            handleShowKontrola("Kontrola řešení", "SPRÁVNÉ ŘEŠENÍ!", "výborně!");
        }
    }

    @FXML
    public void OnUzamknoutZadani() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String text = policka[row][col].getText();

                if (text == null || text.trim().isEmpty() || text.trim().equals("0")) {

                } else {
                    policka[row][col].setDisable(true);
                }
            }
        }

    }


    @FXML
    public void handleShowKontrola(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public void initialize(){
        displayFields();
    }



}
