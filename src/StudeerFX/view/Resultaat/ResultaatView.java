package StudeerFX.view.Resultaat;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 13/03/2020
 * @project StudeerFX
 */
public class ResultaatView extends BorderPane{
    private BackgroundImage achtergrond;
    private Label lblwelkom2, lblwelkom, lbltekst, lblscore;
    private HBox labelcon;
    private VBox scorealles;
    private Label lblResultaat;
    private Button btnterug;

    public ResultaatView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.lblwelkom2 = new Label("Miguel");
        this.lblwelkom = new Label();
        this.lbltekst = new Label("U behaalde");
        this.lblscore = new Label();
        this.lblResultaat = new Label("Resultaat");
        this.btnterug = new Button("Terug naar menu");
        labelcon = new HBox();
        scorealles = new VBox();
        labelcon.getChildren().setAll(lblwelkom, lblwelkom2);
        scorealles.getChildren().setAll(labelcon, lbltekst, lblscore, btnterug);
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        lblResultaat.setId("labelconresultaat");
        scorealles.setId("resultaat");
        lblwelkom2.setId("naamresultaat");
        lblscore.setId("bold");
        btnterug.setId("InvoerButton2");
        lbltekst.setId("tekstbehaal");
        labelcon.setAlignment(Pos.CENTER);
        scorealles.setAlignment(Pos.CENTER);
        this.setTop(lblResultaat);
        this.setCenter(scorealles);
    }
    Button getBtnterug(){
        return btnterug;
    }

    public Label getLblwelkom2() {
        return lblwelkom2;
    }

    public void setLblwelkom2(Label lblwelkom2) {
        this.lblwelkom2 = lblwelkom2;
    }

    public Label getLblwelkom() {
        return lblwelkom;
    }

    public Label getLblscore() {
        return lblscore;
    }

    public void setLblscore(Label lblscore) {
        this.lblscore = lblscore;
    }

}