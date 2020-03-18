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
 * @author Alex Van Dijck on 2-3-2020
 * @project StudeerFX2
 */
public class HighscoresView extends BorderPane {

    //Declareren
    private BackgroundImage achtergrond;
    private Label MenuTekst;
    private TableView table;
    private VBox doos;
    private Button back;

    public HighscoresView() {
        initialiseerNodes();
        layoutNodes();
    }
//Nodes Initialiseren
    private void initialiseerNodes() {
        //Achtergrond kiezen
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        //aanmaken Label titel Highscores
        this.MenuTekst = new Label("Highscores");
        //Table aanmaken
        this.table = new TableView();
        //Kollomen aanmaken
        TableColumn naam = new TableColumn("Username");
        TableColumn score = new TableColumn("Scores");
        //Kollomen toevoegen in de tabel
        table.getColumns().addAll(naam,score);
        //Button aanmaken voor terug naar het menu te gaan
        this.back = new Button("Terug naar Menu");
        //Vbox aanmaken
        doos = new VBox();
        //Vbox spacing geven
        doos.setSpacing(5);
        //Vbox padding geven
        doos.setPadding(new Insets(10,0,0,10));
        //Elementen toevoegen aan de Vbox
        doos.getChildren().setAll(table,back);
        //Kiezen hoe breed de kollomen zijn. uitleg staat achter de lijnen coden.
        naam.prefWidthProperty().bind(table.widthProperty().divide(2)); // 1/2
        score.prefWidthProperty().bind(table.widthProperty().divide(2)); // 1/2
    }

    private void layoutNodes() {
        //Stylesheet linken
        getStylesheets().add("/Style/Style.css");
        //IDs geven
        MenuTekst.setId("highscorestitel");
        doos.setId("doos");
        //Hoogte kiezen van tabel
        table.setPrefHeight(399);
        //IDs geven
        back.setId("back");
        table.setId("table");
        //MenuTekst top zetten
        this.setTop(MenuTekst);
        //MenuTekst links zetten
        this.setLeft(doos);
    }
    //Terug naar menu gaan button.
    Button getBack(){
        return  back;
    }
}

