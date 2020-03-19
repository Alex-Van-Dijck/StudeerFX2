package StudeerFX.view.TestVoorbereiden;

import StudeerFX.model.Spel;
import StudeerFX.model.VraagSelector;
import StudeerFX.model.Vragen;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.TestInvullen.TestInvullenPresenter;
import StudeerFX.view.TestInvullen.TestInvullenView;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 27/02/2020
 * @project StudeerFX
 */
public class TestVoorbereidenPresenter {
    private Spel model;
    private Vragen vragen;
    private VraagSelector vraagSelector;
    private TestVoorbereidenView view;
    private Timeline stopwatchTimeline;

    public TestVoorbereidenPresenter(Spel model, TestVoorbereidenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    //terug naar menu
    private void addEventHandlers() {
        view.getTerug().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });
        //Alerts en eerste vraag doorgeven
        view.getAfnemen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                model.geefVragen();
                if (model.getVragenTest().size() == 0 ) {
                    Alert grensAlert = new Alert(Alert.AlertType.ERROR);
                    grensAlert.setHeaderText("Je moet eerst vragen toevoegen aan de test!");
                    grensAlert.showAndWait();
                } else {
                    model.geefVragen();
                    model.geefVraag();
                    TestInvullenView testInvullenView = new TestInvullenView();
                    TestInvullenPresenter testInvullenPresenter = new TestInvullenPresenter(model, testInvullenView);
                    view.getScene().setRoot(testInvullenView);
                    testInvullenView.getScene().getWindow().sizeToScene();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Alle getallen moeten afgerond worden op 2 getallen na de komma!");
                    alert.setContentText("Bij een foutieve afronding wordt het antwoord fout gerekend");
                    alert.showAndWait();
                }
            }
        });
        //vragen toevoegen aan de test
        view.getToevoegen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if( !model.isInteger(view.getVraagField().getText())){
                    Alert intAlert = new Alert(Alert.AlertType.ERROR);
                    intAlert.setHeaderText("Geef een geheel getal!");
                    intAlert.showAndWait();

                }
                else if(Integer.parseInt(view.getVraagField().getText()) > 9999 ||Integer.parseInt(view.getVraagField().getText()) < 1 ){
                    Alert grensAlert = new Alert(Alert.AlertType.ERROR);
                    grensAlert.setHeaderText("Geef een geheel getal tussen 1 en 9999! ");
                    grensAlert.showAndWait();
                }
                if(view.getVakkeuze().getValue() == null){
                    Alert vakAlert = new Alert(Alert.AlertType.ERROR);
                    vakAlert.setHeaderText("Kies een vak!");
                    vakAlert.showAndWait();
                }
                else {
                    model.setAantalVragenAfnemen(Integer.parseInt(view.getVraagField().getText()));
                    model.setVakkeuzeAfnemen(view.getVakkeuze().getValue());
                    model.addVragenVraagselector();
                    TestVoorbereidenView testVoorbereidenView = new TestVoorbereidenView();
                    TestVoorbereidenPresenter testVoorbereidenPresenter = new TestVoorbereidenPresenter(model, testVoorbereidenView);
                    view.getScene().setRoot(testVoorbereidenView);
                }
            }
        });
    }
    //refreshen van punten en Maxpunten zodat de test opniew gemaakt kan worden
    private void updateView() {
        model.setPunten(0);
        model.setMaxpunten(0);
    }
}



