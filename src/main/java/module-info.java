module com.gordon.kanbanboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.gordon.kanbanboard to javafx.fxml;
    exports com.gordon.kanbanboard;    
    exports com.gordon.model.board;

}
