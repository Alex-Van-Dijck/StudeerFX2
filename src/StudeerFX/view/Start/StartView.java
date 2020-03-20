package StudeerFX.view.Start;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;


public class StartView extends BorderPane {
    private BackgroundImage achtergrond;
        private Label lblwelkom2, lblwelkom;
        private HBox labelcon, buttoncon;
        private VBox generalcon;
        private TextField tfnaam;
        private Button btnstart;
        private String username;
    public StartView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.lblwelkom2 = new Label("E-Study");
        this.lblwelkom = new Label("Welkom bij ");
        labelcon = new HBox();
        buttoncon = new HBox();
        generalcon = new VBox();
        this.btnstart = new Button("Start");
        this.tfnaam = new TextField("Geef hier je naam in");
        labelcon.getChildren().setAll(lblwelkom, lblwelkom2, btnstart);
        generalcon.getChildren().setAll(labelcon,buttoncon);
        buttoncon.getChildren().setAll(tfnaam, btnstart);
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setCenter(generalcon);
        lblwelkom2.setId("welkomtekst");
        labelcon.setId("labelcon");
        generalcon.setId("generalcon");
        buttoncon.setId("buttoncon");
        tfnaam.setPrefWidth(400);
        tfnaam.setPrefHeight(30);
        this.btnstart.setPrefSize(55,35);
        btnstart.setId("startbutton");
        btnstart.setDefaultButton(true);
    }
    //package-private getters
    public Button getBtnstart(){
        return btnstart;
    }

    public TextField getTfnaam() {
        return tfnaam;
    }
}


