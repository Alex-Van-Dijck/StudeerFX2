package StudeerFX.view.Start;

import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;


public class StartPresenter {
    private Spel model;
    private StartView view;

    public StartPresenter(Spel model, StartView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    //Start button naar het menu en de naam doorgeven
    private void addEventHandlers() {
        view.getBtnstart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.setNaam(view.getNaam().getText());
                MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();


            }
        });
    }

    private void updateView() {

    }
    //Handler voor het kruisje bij afsluiten.
    public void addWindowEventHandlers() {
        view.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setHeaderText("Weet je zeker dat je het spel wilt sluiten?");
                ButtonType nee = new ButtonType("Nee");
                ButtonType ja = new ButtonType("Ja");
                alert.getButtonTypes().addAll(nee, ja);
                alert.showAndWait();
                if (alert.getResult() == null || alert.getResult().equals(nee)) {
                    event.consume();
                }else{
                    Platform.exit();
                }
            }
        });
    }
}


