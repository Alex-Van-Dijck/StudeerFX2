package StudeerFX.view.Highscores;

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Highscores.HighscoresView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 27/02/2020
 * @project StudeerFX
 */
public class HighscoresPresenter {
    private StudeerModel model;
    private HighscoresView view;

    public HighscoresPresenter(StudeerModel model, HighscoresView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {

    }

    private void updateView() {

    }
}


