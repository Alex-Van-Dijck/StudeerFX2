package StudeerFX.view.Resultaat;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck on 13/03/2020
 * @project StudeerFX
 */
public class ResultaatView extends BorderPane{
    private BackgroundImage achtergrond;
    private Label welkom2, welkom, tekst, score;
    private HBox labelcon;
    private VBox scorealles;
    private Label Resultaat;
    private Button terug;

    public ResultaatView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.welkom2 = new Label("Miguel");
        this.welkom = new Label();
        this.tekst = new Label("U behaalde");
        this.score = new Label();
        this.Resultaat = new Label("Resultaat");
        this.terug = new Button("Terug naar menu");
        labelcon = new HBox();
        scorealles = new VBox();
        labelcon.getChildren().setAll(welkom,welkom2);
        scorealles.getChildren().setAll(labelcon,tekst, score,terug);
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        Resultaat.setId("labelconresultaat");
        scorealles.setId("resultaat");
        welkom2.setId("naamresultaat");
        score.setId("bold");
        terug.setId("InvoerButton2");
        tekst.setId("tekstbehaal");
        labelcon.setAlignment(Pos.CENTER);
        scorealles.setAlignment(Pos.CENTER);
        this.setTop(Resultaat);
        this.setCenter(scorealles);
    }
    Button getTerug(){
        return terug;
    }

    public Label getWelkom2() {
        return welkom2;
    }

    public Label getWelkom() {
        return welkom;
    }

    public void setWelkom2(Label welkom2) {
        this.welkom2 = welkom2;
    }

    public Label getScore() {
        return score;
    }

    public void setScore(Label score) {
        this.score = score;
    }

}