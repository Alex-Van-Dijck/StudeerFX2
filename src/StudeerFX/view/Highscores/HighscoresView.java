package StudeerFX.view.Highscores;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author LukasVandenBossche on 2-3-2020
 * @project StudeerFX2
 */
public class HighscoresView extends BorderPane {

    private BackgroundImage achtergrond;
    private Label MenuTekst;
    private TableView table = new TableView();
    private VBox doos;
    private Button back;

    public HighscoresView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.MenuTekst = new Label("Highscores");
        TableColumn naam = new TableColumn("Username");
        TableColumn score = new TableColumn("Scores");
        TableColumn tijd = new TableColumn("Tijd");
        table.getColumns().addAll(naam,score,tijd);
        final Label label = new Label("Highscores");
        this.back = new Button("Terug naar Menu");
        label.setFont(new Font("Arial", 20));
        doos = new VBox();
        doos.setSpacing(5);
        doos.setPadding(new Insets(10,0,0,10));
        doos.getChildren().setAll(label,table,back);
        naam.prefWidthProperty().bind(table.widthProperty().divide(2)); // w * 1/4
        score.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/2
        tijd.prefWidthProperty().bind(table.widthProperty().divide(4)); // w * 1/4
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        MenuTekst.setId("highscorestitel");
        doos.setId("doos");
        table.setPrefHeight(399);
        back.setId("back");
        table.setId("table");
        this.setTop(MenuTekst);
        this.setLeft(doos);
    }
}

