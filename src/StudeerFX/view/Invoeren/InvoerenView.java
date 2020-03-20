package StudeerFX.view.Invoeren;

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
 * @author Alex Van Dijck and Miguel Reyntjens on 27/02/2020
 * @project StudeerFX
 */
public class InvoerenView extends GridPane{
    //Declareren
    private BackgroundImage achtergrond;
    private Label lbltitel, lblvraag, lblantwoord;
    private TextField tfvraagField, tfantwoordField, tfantwoordField2;
    private HBox titelcon,buttonCon;
    private VBox vraagCon, antwoordCon;
    private ComboBox<String> cbvakkeuze;
    private Button btntoevoegen, btnterug, btngenereren;
    private Label lblantwoord2;



    public InvoerenView() {
        initialiseerNodes();
        layoutNodes();
    }
    //Nodes initialiseren
    private void initialiseerNodes() {
        //Achtergrond aanpassen
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        //Titel zetten van de pagina
        this.lbltitel = new Label("Gegevens invoeren");
        //Nieuwe HBox aanmaken
        this.titelcon = new HBox();
        //Dropdownlist met de verschillende vakken.
        ObservableList<String> vakken = FXCollections.observableArrayList("Frans","Programmeren","Statistiek");
        this.cbvakkeuze = new ComboBox<>(vakken);
        //Label vraag
        this.lblvraag = new Label("Vraag");
        //Label antwoord
        this.lblantwoord = new Label("Antwoord");
        this.lblantwoord2 = new Label("Antwoord 2 (optioneel)");
        //Vbox aanmaken
        this.vraagCon = new VBox();
        this.antwoordCon = new VBox();
        //Tekst dat in het Textfield staat en tekstfield aanmaken
        this.tfvraagField = new TextField("Geef hier je vraag in.");
        this.tfantwoordField = new TextField("Geef hier je antwoord in.");
        this.tfantwoordField2 = new TextField("Geef hier je antwoord in");
        // Buttons aanmaken
        this.btnterug = new Button("Terug naar menu");
        this.btntoevoegen = new Button("Toevoegen");
        this.btngenereren = new Button("Genereren");
        //Nieuwe Hbox
        this.buttonCon = new HBox();
        //Toevoegen aan de Hboxen en Vboxen
        vraagCon.getChildren().addAll(lblvraag, tfvraagField);
        antwoordCon.getChildren().addAll(lblantwoord, tfantwoordField, lblantwoord2, tfantwoordField2);
        titelcon.getChildren().setAll(lbltitel);
        buttonCon.getChildren().setAll(btntoevoegen, btnterug, btngenereren);

    }

    private void layoutNodes() {
        //Stylesheet linken
        getStylesheets().add("/Style/Style.css");
        //IDs geven
        lbltitel.setId("titel");
        titelcon.setId("labelcon");
        cbvakkeuze.setId("comboBox");
        //Tekst in dropdown
        cbvakkeuze.setPromptText("Selecteer een vak");
        //IDs geven
        tfvraagField.setId("InputBox");
        tfantwoordField.setId("InputBox");
        tfantwoordField2.setId("InputBox");
        lblvraag.setId("label");
        lblantwoord.setId("label");
        lblantwoord2.setId("label");
        btnterug.setId("InvoerButton");
        btntoevoegen.setId("InvoerButton");
        btngenereren.setId("InvoerButton");
        //Font geven aan tekst in antwoordfield en vraagfield
        tfantwoordField.setFont(Font.font(15));
        tfantwoordField2.setFont(Font.font(15));
        tfvraagField.setFont(Font.font(15));
        //Grid begint hierdoor vanboven links
        this.setAlignment(Pos.TOP_LEFT);
        //Plaatsen in grid
        //eerste vakje
        this.add(titelcon, 0,0);
        //1 omlaag 0 opzij
        this.add(cbvakkeuze, 0,1);
        //2 omlaag 0 opzij
        this.add(vraagCon,0,2);
        //3 omlaag 0 opzij
        this.add(antwoordCon,0,3);
        //4 omlaag 0 opzij
        this.add(buttonCon,0,4);
        //grootte van titel aanpassen
        this.lbltitel.setPrefSize(720,150);
        //gap van grid
        this.setVgap(20);
        //padding van grid
        this.setPadding(new Insets(100));
        //spacing van Hbox buttons
        buttonCon.setSpacing(20);
        //grootte van de vraagfield en antwoordfield
        tfvraagField.setMaxWidth(495);
        tfantwoordField.setMaxWidth(495);
        tfantwoordField2.setMaxWidth(495);
        //Spacing plaatsen
        vraagCon.setSpacing(10);
        antwoordCon.setSpacing(10);
        // Dit kan je uit commentaar zetten om de grid lijnen te tonen
        // setGridLinesVisible(true);
    }
    //Button om terug naar menu te gaan
    Button getBtnterug(){
        return btnterug;
    }
    //Button om vragen toe te voegen
    Button getBtntoevoegen(){
        return btntoevoegen;
    }
    //Button om naar Scene "Genereren te gaan"
    Button getBtngenereren(){
        return btngenereren;
    }
    //Vragen doorgeven
    public TextField getTfvraagField(){
        return tfvraagField;
    }
    //Antwoorden doorgeven
    public TextField getTfantwoordField(){
        return tfantwoordField;
    }

    public TextField getTfantwoordField2() {
        return tfantwoordField2;
    }

    public ComboBox<String> getCbvakkeuze() {
        return cbvakkeuze;

    }
}


