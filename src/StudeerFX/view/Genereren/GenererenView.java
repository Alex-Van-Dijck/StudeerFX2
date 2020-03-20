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
 * @author Alex Van Dijck and Miguel Reyntjens on 10/03/2020
 * @project StudeerFX
 */
public class GenererenView extends GridPane {
    //declareren
    private BackgroundImage achtergrond;
    private Label lbltitel, lblaantalVraag, lblantwoord;
    private TextField tfaantalVraagField, tfantwoordField;
    private HBox titelcon,buttonCon;
    private VBox vraagCon;
    private ComboBox<String> cbvakkeuze;
    private Button btntoevoegen, btnterug;




    public GenererenView() {
        initialiseerNodes();
        layoutNodes();
    }
    // nodes initialiseren
    private void initialiseerNodes() {
        this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        this.lbltitel = new Label("Vragen genereren");
        this.titelcon = new HBox();
        ObservableList<String> vakken = FXCollections.observableArrayList("Statistiek");
        this.cbvakkeuze = new ComboBox<>(vakken);
        this.lblaantalVraag = new Label("Aantal vragen");
        this.vraagCon = new VBox();
        this.tfaantalVraagField = new TextField("Geef aantal in");
        this.btnterug = new Button("Terug naar menu");
        this.btntoevoegen = new Button("Toevoegen");
        this.buttonCon = new HBox();
        vraagCon.getChildren().addAll(lblaantalVraag, tfaantalVraagField);
        titelcon.getChildren().setAll(lbltitel);
        buttonCon.getChildren().setAll(btntoevoegen, btnterug);
        cbvakkeuze.getSelectionModel().selectFirst();

    }

    // hoe het op scherm wordt getoont
    private void layoutNodes() {
        getStylesheets().add("/Style/Style.css");
        lbltitel.setId("titel");
        titelcon.setId("labelcon");
        cbvakkeuze.setId("comboBox");
        cbvakkeuze.setPromptText("Selecteer een vak");
        tfaantalVraagField.setId("InputBox");
        lblaantalVraag.setId("label");
        btnterug.setId("InvoerButton");
        btntoevoegen.setId("InvoerButton");
        tfaantalVraagField.setFont(Font.font(15));
        this.setAlignment(Pos.TOP_LEFT);
        this.add(titelcon, 0,0);
        this.add(cbvakkeuze, 0,1);
        this.add(vraagCon,0,2);
        this.add(buttonCon,0,4);
        this.lbltitel.setPrefSize(720,150);
        this.setVgap(20);
        this.setPadding(new Insets(100));
        buttonCon.setSpacing(20);
        tfaantalVraagField.setMaxWidth(220);
        vraagCon.setSpacing(10);
        btntoevoegen.setDefaultButton(true);
    }
    Button getBtnterug(){
        return btnterug;
    }

    public Button getBtntoevoegen() {
        return btntoevoegen;
    }

    public TextField getTfaantalVraagField() {
        return tfaantalVraagField;
    }

    public ComboBox<String> getCbvakkeuze() {
        return cbvakkeuze;
    }
}


