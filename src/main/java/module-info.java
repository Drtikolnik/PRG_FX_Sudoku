module com.example.prg_fx_sudoku {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.prg_fx_sudoku to javafx.fxml;
    exports com.example.prg_fx_sudoku;
}