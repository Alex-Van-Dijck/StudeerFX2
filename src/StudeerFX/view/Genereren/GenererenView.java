package StudeerFX.view.Genereren;

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
/**
 * @author Alex Van Dijck on 10/03/2020
 * @project StudeerFX
 */
public class GenererenView extends GridPane {

    private BackgroundImage achtergrond;
    private Label titel,aantalVraag,antwoord;
    private TextField aantalVraagField, antwoordField;
    private HBox titelcon,buttonCon;
    private VBox vraagCon;
    private ComboBox<String> vakkeuze;
    private Button toevoegen,terug;




    public GenererenView() {
        initialiseerNodes();
        layoutNodes();
    }

    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.titel = new Label("Vragen genereren");
        this.titelcon = new HBox();
        ObservableList<String> vakken = FXCollections.observableArrayList("Statistiek");
        this.vakkeuze = new ComboBox<>(vakken);
        this.aantalVraag = new Label("Aantal vragen");
        this.vraagCon = new VBox();
        this.aantalVraagField = new TextField("Geef aantal in");
        this.terug = new Button("Terug naar menu");
        this.toevoegen = new Button("Toevoegen");
        this.buttonCon = new HBox();
        vraagCon.getChildren().addAll(aantalVraag,aantalVraagField);
        titelcon.getChildren().setAll(titel);
        buttonCon.getChildren().setAll(toevoegen,terug);
        vakkeuze.getSelectionModel().selectFirst();

    }

    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        titel.setId("titel");
        titelcon.setId("labelcon");
        vakkeuze.setId("comboBox");
        vakkeuze.setPromptText("Selecteer een vak");
        aantalVraagField.setId("InputBox");
        aantalVraag.setId("label");
        terug.setId("InvoerButton");
        toevoegen.setId("InvoerButton");
        aantalVraagField.setFont(Font.font(15));
        this.setAlignment(Pos.TOP_LEFT);
        this.add(titelcon, 0,0);
        this.add(vakkeuze, 0,1);
        this.add(vraagCon,0,2);
        this.add(buttonCon,0,4);
        this.titel.setPrefSize(720,150);
        this.setVgap(20);
        this.setPadding(new Insets(100));
        buttonCon.setSpacing(20);
        aantalVraagField.setMaxWidth(220);
        vraagCon.setSpacing(10);
//        setGridLinesVisible(true);
    }
    Button getTerug(){
        return terug;
    }

}


