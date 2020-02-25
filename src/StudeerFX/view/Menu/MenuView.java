package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck on 25/02/2020
 * @project StudeerFX
 */
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.Inet4Address;


public class MenuView extends BorderPane {

    private Label MenuTekst;
    private Label MenuNaam;
    private Label Menuvraag;
    private HBox labelconmenu;
    private HBox labelconvraag;
    private HBox knoppen1;
    private HBox knoppen2;
    private Button knop1;
    private Button knop2;
    private Button knop3;
    private Button knop4;
    private VBox alleknoppen;
    private VBox alletekst;
    public MenuView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.MenuNaam = new Label("Miguel");
        this.MenuTekst = new Label("Welkom, ");
        this.Menuvraag = new Label("Wat wilt u gaan doen?");
        labelconmenu = new HBox();
        labelconvraag = new HBox();
        this.knop1 = new Button("Gegevens Invoeren");
        this.knop2 = new Button("Test Afnemen");
        this.knop3 = new Button("Highscores");
        this.knop4 = new Button("Afsluiten");
        knoppen1 = new HBox();
        knoppen2 = new HBox();
        alleknoppen = new VBox();
        alletekst = new VBox();
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setTop(alletekst);
        this.setCenter(alleknoppen);
        MenuNaam.setId("MenuNaam");
        labelconmenu.setId("labelconmenu");
        labelconvraag.setId("labelconvraag");
        knop1.setId("knopmenu");
        knop2.setId("knopmenu");
        knop3.setId("knopmenu");
        knop4.setId("knopmenu");
        alleknoppen.setId("alleknoppen");
        labelconmenu.getChildren().setAll(MenuTekst,MenuNaam);
        labelconvraag.getChildren().setAll(Menuvraag);
        knoppen1.getChildren().addAll(knop1,knop2);
        knoppen2.getChildren().addAll(knop3,knop4);
        alleknoppen.getChildren().addAll(knoppen1,knoppen2);
        alleknoppen.setSpacing(30);
        knoppen1.setSpacing(30);
        knoppen2.setSpacing(30);
        alletekst.getChildren().addAll(labelconmenu,labelconvraag);
    }
    //package-private getters
}


