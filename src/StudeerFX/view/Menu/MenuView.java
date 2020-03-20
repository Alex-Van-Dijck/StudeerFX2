package StudeerFX.view.Menu;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 25/02/2020
 * @project StudeerFX
 */
import StudeerFX.view.Start.StartView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class MenuView extends BorderPane {
    StartView startView = new StartView();
    private Label lblMenuTekst;
    private Label lblMenuNaam;
    private Label lblMenuvraag;
    private HBox labelconmenu;
    private HBox labelconvraag;
    private HBox knoppen1;
    private HBox knoppen2;
    private Button btnknop1;
    private Button btnknop2;
    private Button btnknop3;
    private Button btnknop4;
    private VBox alleknoppen;
    private VBox alletekst;
    public MenuView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.lblMenuNaam = new Label();
        this.lblMenuTekst = new Label("Welkom, ");
        this.lblMenuvraag = new Label("Wat wilt u gaan doen?");
        labelconmenu = new HBox();
        labelconvraag = new HBox();
        this.btnknop1 = new Button("Gegevens Invoeren");
        this.btnknop2 = new Button("Test Afnemen");
        this.btnknop3 = new Button("Highscores");
        this.btnknop4 = new Button("Afsluiten");
        knoppen1 = new HBox();
        knoppen2 = new HBox();
        alleknoppen = new VBox();
        alletekst = new VBox();
    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        this.setTop(alletekst);
        this.setCenter(alleknoppen);
        lblMenuNaam.setId("MenuNaam");
        labelconmenu.setId("labelconmenu");
        labelconvraag.setId("labelconvraag");
        btnknop1.setId("knopmenu");
        btnknop2.setId("knopmenu");
        btnknop3.setId("knopmenu");
        btnknop4.setId("knopmenu");
        alleknoppen.setId("alleknoppen");
        labelconmenu.getChildren().add(lblMenuTekst);
        labelconmenu.getChildren().add(lblMenuNaam);
        labelconvraag.getChildren().setAll(lblMenuvraag);
        knoppen1.getChildren().addAll(btnknop1, btnknop2);
        knoppen2.getChildren().addAll(btnknop3, btnknop4);
        alleknoppen.getChildren().addAll(knoppen1,knoppen2);
        alleknoppen.setSpacing(30);
        knoppen1.setSpacing(30);
        knoppen2.setSpacing(30);
        alletekst.getChildren().addAll(labelconmenu,labelconvraag);
    }
    //package-private getters
    Button getBtnknop1(){
        return btnknop1;
    }
    Button getBtnknop2(){
        return btnknop2;
    }
    Button getBtnknop3(){
        return btnknop3;
    }
    Button getBtnknop4(){
        return btnknop4;
    }

    public Label getLblMenuNaam() {
        return lblMenuNaam;
    }

    public void setLblMenuNaam(Label lblMenuNaam) {
        this.lblMenuNaam = this.lblMenuNaam;
    }

    //package-private setters
}


