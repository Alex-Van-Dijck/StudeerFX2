package StudeerFX.view.Start;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;


public class StartView extends BorderPane {
        private BackgroundImage achtergrond;
        private Label welkom2, welkom;
        private HBox labelcon, buttoncon;
        private VBox generalcon;
        private TextField naam;
        private Button start;
    public StartView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.welkom2 = new Label("E-Study");
        this.welkom = new Label("Welkom bij ");
        labelcon = new HBox();
        buttoncon = new HBox();
        generalcon = new VBox();
        this.start = new Button("Start");
        this.naam = new TextField("Geef hier je naam in.");
        labelcon.getChildren().setAll(welkom,welkom2,start);
        generalcon.getChildren().setAll(labelcon,buttoncon);
        buttoncon.getChildren().setAll(naam, start);
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setCenter(generalcon);
        welkom2.setId("welkomtekst");
        labelcon.setId("labelcon");
        generalcon.setId("generalcon");
        buttoncon.setId("buttoncon");
        naam.setPrefWidth(400);
        naam.setPrefHeight(30);
        this.start.setPrefSize(55,35);
        start.setId("startbutton");
    }
    //package-private getters
}


