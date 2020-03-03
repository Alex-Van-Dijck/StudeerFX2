package StudeerFX.view.Invoeren;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenView extends BorderPane{

    private BackgroundImage achtergrond;




    public InvoerenView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

    }

    private void layoutNodes() {

    }
} 


