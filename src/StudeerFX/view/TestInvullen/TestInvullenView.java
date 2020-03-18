package StudeerFX.view.TestInvullen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenView extends BorderPane {
    private BackgroundImage achtergrond;
    private Label titel, vraagnr, vraag, score, scoretitel, tijd, tijdTitel;
    private VBox middenCon, overlap, scorebox;
    private TextField antwoord;
    private Button kijkNa;

    public TestInvullenView() {
        initialiseerNodes();
        layoutNodes();
        this.animate();
    }

    private void initialiseerNodes() {
        this.middenCon = new VBox();
        this.overlap = new VBox();
        this.scorebox = new VBox();
        this.score = new Label("3" + "/" + "5");
        this.scoretitel = new Label("Score: ");
        this.titel = new Label("Test invullen");
        this.antwoord = new TextField ("Vul hier je antwoord in");
        this.vraagnr = new Label();
        this.vraag = new Label();

        this.kijkNa = new Button("Kijk na");
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg", 1280, 720, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        overlap.getChildren().setAll(middenCon);
        middenCon.getChildren().setAll(vraagnr, vraag, antwoord, kijkNa);
        scorebox.getChildren().setAll(scoretitel, score);

    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setCenter(overlap);
        this.setTop(titel);
        this.setBottom(scorebox);
        titel.setId("highscorestitel");
        vraagnr.setId("testVraagnr");
        vraag.setId("testVraag");
        overlap.setId("overlap");
        kijkNa.setId("nakijken");
        antwoord.setId("TestAntwoord");
        score.setId("score");
        scoretitel.setId("scoretitel");
        scorebox.setId("scorebox");
        middenCon.setSpacing(20);

        this.setMargin(overlap, new Insets(0,300,50,350));
        kijkNa.setDefaultButton(true);
    }

    private void animate(){
        
    }
    //package-private getters

    public Label getVraagnr() {
        return vraagnr;
    }

    public Label getVraag() {
        return vraag;
    }

    public Label getScore() {
        return score;
    }

    public Button getKijkNa() {
        return kijkNa;
    }

    public TextField getAntwoord() {
        return antwoord;
    }

}



