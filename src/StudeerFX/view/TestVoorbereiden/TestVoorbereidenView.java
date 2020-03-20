package StudeerFX.view.TestVoorbereiden;

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
public class TestVoorbereidenView extends GridPane{

        private Label lbltitel, lblvraag;
        private TextField tfvraagField;
        private HBox titelcon,buttonCon;
        private VBox vraagCon;
        private ComboBox<String> cbvakkeuze;
        private Button btnafnemen, btnterug, btntoevoegen;

        public TestVoorbereidenView() {
            initialiseerNodes();
            layoutNodes();
        }

        private void initialiseerNodes() {
            this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            this.lbltitel = new Label("Test voorbereiden");
            this.titelcon = new HBox();
            ObservableList<String> vakken = FXCollections.observableArrayList("Frans","Programmeren","Statistiek");
            this.cbvakkeuze = new ComboBox<>(vakken);
            this.lblvraag = new Label("Aantal vragen");
            this.vraagCon = new VBox();
            this.tfvraagField = new TextField("Geef hier je aantal vragen in.");
            this.btnterug = new Button("Terug naar menu");
            this.btnafnemen = new Button("Test afnemen");
            this.btntoevoegen = new Button("Toevoegen aan test");
            this.buttonCon = new HBox();
            vraagCon.getChildren().addAll(lblvraag, tfvraagField);
            titelcon.getChildren().setAll(lbltitel);
            buttonCon.getChildren().setAll(btnafnemen, btnterug);

        }

        private void layoutNodes() {
            getStylesheets().add("/Style/Style.css");
            lbltitel.setId("titel");
            titelcon.setId("labelcon");
            cbvakkeuze.setId("comboBox");
            cbvakkeuze.setPromptText("Selecteer een vak");
            tfvraagField.setId("InputBox");
            lblvraag.setId("label");
            btnterug.setId("InvoerButton");
            btnafnemen.setId("InvoerButton");
            btntoevoegen.setId("Toevoegen");
            tfvraagField.setFont(Font.font(15));
            this.setAlignment(Pos.TOP_LEFT);
            this.add(titelcon, 0,0);
            this.add(cbvakkeuze, 0,1);
            this.add(vraagCon,0,2);
            this.add(btntoevoegen,0,3);
            this.add(buttonCon,0,4);
            this.lbltitel.setPrefSize(720,150);
            this.setVgap(20);
            this.setPadding(new Insets(100));
            buttonCon.setSpacing(20);
            tfvraagField.setMaxWidth(220);
            vraagCon.setSpacing(10);
//        setGridLinesVisible(true);
        }
        Button getBtnterug(){
            return btnterug;
        }

    public Button getBtnafnemen() {
        return btnafnemen;
    }

    public Button getBtntoevoegen() {
        return btntoevoegen;
    }

    public TextField getTfvraagField() {
        return tfvraagField;
    }

    public ComboBox<String> getCbvakkeuze() {
        return cbvakkeuze;
    }
}
