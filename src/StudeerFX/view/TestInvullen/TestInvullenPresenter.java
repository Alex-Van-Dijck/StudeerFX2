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
 * @author Alex Van Dijck and Miguel Reyntjens on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenPresenter {
    private Spel model;
    private TestInvullenView view;
    private Timeline stopwatchTimeline;

    public TestInvullenPresenter(Spel model, TestInvullenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();

    }

    //Eventhandler
    //Nakijken of de vraag klopt
    private void addEventHandlers() {
        view.getKijkNa().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.kijkNa(view.getAntwoord().getText());
                if(model.isTestKlaar()){
                    ResultaatView resultaatView = new ResultaatView();
                    ResultaatPresenter resultaatPresenter = new ResultaatPresenter(model, resultaatView);
                    view.getScene().setRoot(resultaatView);
                    model.Reset();
                }
                else {
                    model.geefVraag();
                    TestInvullenView testInvullenView = new TestInvullenView();
                    TestInvullenPresenter testInvullenPresenter = new TestInvullenPresenter(model, testInvullenView);
                    view.getScene().setRoot(testInvullenView);
                    testInvullenView.getScene().getWindow().sizeToScene();
                }

            }
        });
    }
    //updaten van de pagina wanneer je kijk na drukt zodat de vraag en pogingen etc refreshen en wijzigen
    private void updateView() {
        view.getVraagnr().setText("Vraag "  + model.getAantalVragenGesteld() + " Poging: " + model.getPoging());
        view.getVraag().setText(model.getVraagTest());
        view.getScore().setText(model.getPunten() + " / " + (int)(model.getMaxpunten()));
    }
}



