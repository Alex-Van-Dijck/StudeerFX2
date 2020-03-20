package StudeerFX.view.Highscores;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 2-3-2020
 * @project StudeerFX2
 */
public class HighscoresView extends BorderPane {

    //Declareren
    private BackgroundImage achtergrond;
    private Label lblMenuTekst, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    private VBox labels, box;
    private Button btnback;

    public HighscoresView() {
        initialiseerNodes();
        layoutNodes();
    }
//Nodes Initialiseren
    private void initialiseerNodes() {
        //Achtergrond kiezen
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        //aanmaken Label titel Highscores
        this.lblMenuTekst = new Label("Highscores");
        //Button aanmaken voor terug naar het menu te gaan
        this.btnback = new Button("Terug naar Menu");
        //Labels adden voor highscores
        this.l1 = new Label();
        this.l2 = new Label();
        this.l3 = new Label();
        this.l4 = new Label();
        this.l5 = new Label();
        this.l6 = new Label();
        this.l7 = new Label();
        this.l8 = new Label();
        this.l9 = new Label();
        this.l10 = new Label();
        this.box = new VBox();
        this.labels = new VBox();
        // Alle labels in een vbox
        labels.getChildren().setAll(l1,l2,l3,l4,l5,l6,l7,l8,l9,l10);
        //Label en button samensteken
        box.getChildren().setAll(labels, btnback);
    }

    private void layoutNodes() {
        //Stylesheet linken
        getStylesheets().add("/Style/Style.css");
        //IDs geven
        lblMenuTekst.setId("highscorestitel");
        //IDs geven
        btnback.setId("back");
        //MenuTekst top zetten
        this.setTop(lblMenuTekst);
        //MenuTekst links zetten
        this.setLeft(box);
        labels.setId("highScore");
        labels.setSpacing(10);
        box.setSpacing(20);
        box.setPadding(new Insets(0,0,0,100));
    }
    //Terug naar menu gaan button.
    Button getBtnback(){
        return btnback;
    }

    //Getters vor label

    public Label getL1() {
        return l1;
    }

    public Label getL2() {
        return l2;
    }

    public Label getL3() {
        return l3;
    }

    public Label getL4() {
        return l4;
    }

    public Label getL5() {
        return l5;
    }

    public Label getL6() {
        return l6;
    }

    public Label getL7() {
        return l7;
    }

    public Label getL8() {
        return l8;
    }

    public Label getL9() {
        return l9;
    }

    public Label getL10() {
        return l10;
    }
}

