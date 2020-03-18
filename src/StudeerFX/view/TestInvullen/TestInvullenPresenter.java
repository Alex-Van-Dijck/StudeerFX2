package StudeerFX.view.TestInvullen;
import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import StudeerFX.view.Resultaat.ResultaatPresenter;
import StudeerFX.view.Resultaat.ResultaatView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.security.Key;
import java.sql.Time;

/**
 * @author Alex Van Dijck on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenPresenter {
    private Spel model;
    private TestInvullenView view;
    private Timeline stopwatchTimeline;

    public TestInvullenPresenter(Spel model, TestInvullenView view) {
        this.model = model;
        this.view = view;
        setupTimeline();
        addEventHandlers();
        updateView();

    }

    //Timer

    private void setupTimeline(){
        stopwatchTimeline = new Timeline();
        stopwatchTimeline.setCycleCount(Animation.INDEFINITE);
        updateClockSpeed();
    }

    private void updateClockSpeed(){
        stopwatchTimeline.getKeyFrames().clear();
        stopwatchTimeline.getKeyFrames().add(new KeyFrame(
                Duration.millis(this.model.getTickDurationMillis()), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.tick();
                updateView();
            }
        }));
    }

    //Eventhandler
    private void addEventHandlers() {
        view.getKijkNa().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.kijkNa(view.getAntwoord().getText());
                if(model.isTestKlaar()){
                    ResultaatView resultaatView = new ResultaatView();
                    ResultaatPresenter resultaatPresenter = new ResultaatPresenter(model, resultaatView);
                    view.getScene().setRoot(resultaatView);
                }
                else {
                    updateView();
                    stopwatchTimeline.play();
                }
            }
        });
    }

    private void updateView() {
        view.getVraagnr().setText("Vraag "  + model.getAantalVragenGesteld() + " Poging: " + model.getPoging());
        view.getVraag().setText(model.getVraagTest());
        view.getScore().setText(model.getPunten() + " / " + (int)(model.getMaxpunten()));
        this.view.getTijd().setText(String.format("%02d", this.model.getSeconds()));
    }
}



