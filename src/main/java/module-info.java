module com.example.prg_fx_sudoku {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.prg_fx_sudoku to javafx.fxml;
    exports com.example.prg_fx_sudoku;
}