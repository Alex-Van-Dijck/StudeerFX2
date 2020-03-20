package StudeerFX.view.TestInvullen;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenView extends BorderPane {
    private BackgroundImage achtergrond;
    private Label lbltitel, lblvraagnr, lblvraag, lblscore, lblscoretitel;
    private VBox middenCon, overlap, scorebox;
    private TextField antwoord;
    private Button btnkijkNa;

    public TestInvullenView() {
        initialiseerNodes();
        layoutNodes();
        this.animate();
    }

    private void initialiseerNodes() {
        this.middenCon = new VBox();
        this.overlap = new VBox();
        this.scorebox = new VBox();
        this.lblscore = new Label("3" + "/" + "5");
        this.lblscoretitel = new Label("Score: ");
        this.lbltitel = new Label("Test invullen");
        this.antwoord = new TextField ("Vul hier je antwoord in");
        this.lblvraagnr = new Label();
        this.lblvraag = new Label();

        this.btnkijkNa = new Button("Kijk na");
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg", 1280, 720, false, false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        overlap.getChildren().setAll(middenCon);
        middenCon.getChildren().setAll(lblvraagnr, lblvraag, antwoord, btnkijkNa);
        scorebox.getChildren().setAll(lblscoretitel, lblscore);

    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setCenter(overlap);
        this.setTop(lbltitel);
        this.setBottom(scorebox);
        lbltitel.setId("highscorestitel");
        lblvraagnr.setId("testVraagnr");
        lblvraag.setId("testVraag");
        overlap.setId("overlap");
        btnkijkNa.setId("nakijken");
        antwoord.setId("TestAntwoord");
        lblscore.setId("score");
        lblscoretitel.setId("scoretitel");
        scorebox.setId("scorebox");
        middenCon.setSpacing(20);

        this.setMargin(overlap, new Insets(0,300,50,350));
        btnkijkNa.setDefaultButton(true);
    }

    private void animate(){
        
    }
    //package-private getters

    public Label getLblvraagnr() {
        return lblvraagnr;
    }

    public Label getLblvraag() {
        return lblvraag;
    }

    public Label getLblscore() {
        return lblscore;
    }

    public Button getBtnkijkNa() {
        return btnkijkNa;
    }

    public TextField getAntwoord() {
        return antwoord;
    }

}



