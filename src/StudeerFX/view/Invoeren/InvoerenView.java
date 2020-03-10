package StudeerFX.view.Invoeren;

import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.w3c.dom.Text;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenView extends GridPane{

    private BackgroundImage achtergrond;
    private Label titel,vraag,antwoord;
    private TextField vraagField, antwoordField;
    private HBox titelcon,buttonCon;
    private VBox vraagCon, antwoordCon;
    private ComboBox<String> vakkeuze;
    private Button toevoegen,terug,genereren;




    public InvoerenView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.titel = new Label("Gegevens invoeren");
        this.titelcon = new HBox();
        ObservableList<String> vakken = FXCollections.observableArrayList("Frans","Programmeren","Statistiek");
        this.vakkeuze = new ComboBox<>(vakken);
        this.vraag = new Label("Vraag");
        this.antwoord = new Label("Antwoord");
        this.vraagCon = new VBox();
        this.antwoordCon = new VBox();
        this.vraagField = new TextField("Geef hier je vraag in.");
        this.antwoordField = new TextField("Geef hier je antwoord in.");
        this.terug = new Button("Terug naar menu");
        this.toevoegen = new Button("Toevoegen");
        this.genereren = new Button("Genereren");
        this.buttonCon = new HBox();
        vraagCon.getChildren().addAll(vraag,vraagField);
        antwoordCon.getChildren().addAll(antwoord,antwoordField);
        titelcon.getChildren().setAll(titel);
        buttonCon.getChildren().setAll(toevoegen,terug,genereren);

    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        titel.setId("titel");
        titelcon.setId("labelcon");
        vakkeuze.setId("comboBox");
        vakkeuze.setPromptText("Selecteer een vak");
        vraagField.setId("InputBox");
        antwoordField.setId("InputBox");
        vraag.setId("label");
        antwoord.setId("label");
        terug.setId("InvoerButton");
        toevoegen.setId("InvoerButton");
        genereren.setId("InvoerButton");
        antwoordField.setFont(Font.font(15));
        vraagField.setFont(Font.font(15));
        this.setAlignment(Pos.TOP_LEFT);
        this.add(titelcon, 0,0);
        this.add(vakkeuze, 0,1);
        this.add(vraagCon,0,2);
        this.add(antwoordCon,0,3);
        this.add(buttonCon,0,4);
        this.titel.setPrefSize(720,150);
        this.setVgap(20);
        this.setPadding(new Insets(100));
        buttonCon.setSpacing(20);
        vraagField.setMaxWidth(495);
        antwoordField.setMaxWidth(495);
        vraagCon.setSpacing(10);
        antwoordCon.setSpacing(10);
//        setGridLinesVisible(true);
    }
    Button getTerug(){
        return terug;
    }
    Button getToevoegen(){
        return toevoegen;
    }
    Button getGenereren(){
        return  genereren;
    }
    public TextField getVraagField(){
        return vraagField;
    }
    public TextField getAntwoordField(){
        return antwoordField;
    }
} 


