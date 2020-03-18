package StudeerFX.view.Genereren;

import StudeerFX.model.Spel;
import StudeerFX.view.Invoeren.InvoerenPresenter;
import StudeerFX.view.Invoeren.InvoerenView;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenPresenter;
import StudeerFX.view.TestVoorbereiden.TestVoorbereidenView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

import java.util.Optional;

/**
 * @author Alex Van Dijck on 10/03/2020
 * @project StudeerFX
 */
public class GenererenPresenter {

    private Spel model;
    private GenererenView view;

    public GenererenPresenter(Spel model, GenererenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();

    }
// Eventlistner om terug naar menu te gaan
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
        view.getToevoegen().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!model.isInteger(view.getAantalVraagField().getText())) {
                    Alert intAlert = new Alert(Alert.AlertType.ERROR);
                    intAlert.setHeaderText("Geef een geheel getal!");
                    intAlert.showAndWait();

                } else if (Integer.parseInt(view.getAantalVraagField().getText()) > 9999 || Integer.parseInt(view.getAantalVraagField().getText()) < 1) {
                    Alert grensAlert = new Alert(Alert.AlertType.ERROR);
                    grensAlert.setHeaderText("Geef een geheel getal tussen 1 en 9999! ");
                    grensAlert.showAndWait();
                } else {
                    model.setAantalVragenInvoeren(Integer.parseInt(view.getAantalVraagField().getText()));
                    model.genereerVraag();
                    GenererenView genererenView = new GenererenView();
                    GenererenPresenter genererenPresenter = new GenererenPresenter(model, genererenView);
                    view.getScene().setRoot(genererenView);
                    genererenView.getScene().getWindow().sizeToScene();
                }
            }
        });

    }

    private void updateView() {

    }
}


