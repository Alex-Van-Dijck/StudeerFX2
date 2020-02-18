package StudeerFX.view.Start;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.HBox;


public class StartView extends BorderPane {
        private BackgroundImage achtergrond;
        private Label welkom2;
        private Label welkom;
        private HBox labelcon;
    public StartView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.welkom2 = new Label("E-Study");
        this.welkom = new Label("Welkom bij ");
        labelcon = new HBox();
        labelcon.getChildren().setAll(welkom,welkom2);
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setCenter(labelcon);
        welkom2.setId("welkomtekst");
        labelcon.setId("labelcon");
    }
    //package-private getters
}


