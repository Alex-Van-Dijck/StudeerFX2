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

        private Label titel,vraag;
        private TextField vraagField;
        private HBox titelcon,buttonCon;
        private VBox vraagCon;
        private ComboBox<String> vakkeuze;
        private Button afnemen,terug,toevoegen;

        public TestVoorbereidenView() {
            initialiseerNodes();
            layoutNodes();
        }

        private void initialiseerNodes() {
            this.setBackground(new Background(new BackgroundImage(new Image("/Images/Books.jpg",1280,720,false,false), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
            this.titel = new Label("Test voorbereiden");
            this.titelcon = new HBox();
            ObservableList<String> vakken = FXCollections.observableArrayList("Frans","Programmeren","Statistiek");
            this.vakkeuze = new ComboBox<>(vakken);
            this.vraag = new Label("Aantal vragen");
            this.vraagCon = new VBox();
            this.vraagField = new TextField("Geef hier je aantal vragen in.");
            this.terug = new Button("Terug naar menu");
            this.afnemen = new Button("Test afnemen");
            this.toevoegen = new Button("Toevoegen aan test");
            this.buttonCon = new HBox();
            vraagCon.getChildren().addAll(vraag,vraagField);
            titelcon.getChildren().setAll(titel);
            buttonCon.getChildren().setAll(afnemen,terug);

        }

        private void layoutNodes() {
            getStylesheets().add("/Style/Style.css");
            titel.setId("titel");
            titelcon.setId("labelcon");
            vakkeuze.setId("comboBox");
            vakkeuze.setPromptText("Selecteer een vak");
            vraagField.setId("InputBox");
            vraag.setId("label");
            terug.setId("InvoerButton");
            afnemen.setId("InvoerButton");
            toevoegen.setId("Toevoegen");
            vraagField.setFont(Font.font(15));
            this.setAlignment(Pos.TOP_LEFT);
            this.add(titelcon, 0,0);
            this.add(vakkeuze, 0,1);
            this.add(vraagCon,0,2);
            this.add(toevoegen,0,3);
            this.add(buttonCon,0,4);
            this.titel.setPrefSize(720,150);
            this.setVgap(20);
            this.setPadding(new Insets(100));
            buttonCon.setSpacing(20);
            vraagField.setMaxWidth(220);
            vraagCon.setSpacing(10);
//        setGridLinesVisible(true);
        }
        Button getTerug(){
            return terug;
        }

    public Button getAfnemen() {
        return afnemen;
    }

    public Button getToevoegen() {
        return toevoegen;
    }

    public TextField getVraagField() {
        return vraagField;
    }

    public ComboBox<String> getVakkeuze() {
        return vakkeuze;
    }
}
