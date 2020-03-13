package StudeerFX.view.TestInvullen;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenView extends BorderPane {
    private BackgroundImage achtergrond;
    private Label titel,vraag;


    public TestInvullenView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {

        this.titel = new Label("Test invullen");
        this.vraag = new Label("Vraag" + "6");
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/StartDonker.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
    titel.setId("testTitel");
    this.setTop(titel);
    this.setCenter(vraag);

    }
    //package-private getters
} 


