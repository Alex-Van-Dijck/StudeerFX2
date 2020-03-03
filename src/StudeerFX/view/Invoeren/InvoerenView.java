package StudeerFX.view.Invoeren;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenView extends GridPane{

    private BackgroundImage achtergrond;
    private Label titel;
    private HBox titelcon;




    public InvoerenView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.titel = new Label("Gegevens invoeren");
        this.titelcon = new HBox();
        titelcon.getChildren().setAll(titel);
    }

    private void layoutNodes() {
        titel.setId("titel");
        titelcon.setId("labelcon");
        this.add(titelcon, 0,0);
        this.setGridLinesVisible(true);
        this.titel.setPrefSize(720,200);
    }
} 


