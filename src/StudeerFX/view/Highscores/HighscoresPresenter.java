package StudeerFX.view.Highscores;

import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck and Miguel Reyntjens on 27/02/2020
 * @project StudeerFX
 */
public class HighscoresPresenter {
    private Spel model;
    private HighscoresView view;

    public HighscoresPresenter(Spel model, HighscoresView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    //Handler om terug naar menu te gaan.
    private void addEventHandlers() {
        view.getBack().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               MenuView menuView = new MenuView();
                MenuPresenter menuPresenter = new MenuPresenter(model, menuView);
                view.getScene().setRoot(menuView);
                menuView.getScene().getWindow().sizeToScene();
            }
        });
    }
    //Highscores updaten bij het refreshen van de highscore page.
    private void updateView() {
        model.geefScores();
        view.getL1().setText("1. " + model.getScoreLijst().get(0));
        view.getL2().setText("2. " + model.getScoreLijst().get(1));
        view.getL3().setText("3. " + model.getScoreLijst().get(2));
        view.getL4().setText("4. " + model.getScoreLijst().get(3));
        view.getL5().setText("5. " + model.getScoreLijst().get(4));
        view.getL6().setText("6. " + model.getScoreLijst().get(5));
        view.getL7().setText("7. " + model.getScoreLijst().get(6));
        view.getL8().setText("8. " + model.getScoreLijst().get(7));
        view.getL9().setText("9. " + model.getScoreLijst().get(8));
        view.getL10().setText("10. " + model.getScoreLijst().get(9));

    }
}


