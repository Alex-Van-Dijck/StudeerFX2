package StudeerFX.view.TestInvullen;
import StudeerFX.model.Spel;
import StudeerFX.view.Menu.MenuPresenter;
import StudeerFX.view.Menu.MenuView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * @author Alex Van Dijck on 12/03/2020
 * @project StudeerFX
 */
public class TestInvullenPresenter {
    private Spel model;
    private TestInvullenView view;

    public TestInvullenPresenter(Spel model, TestInvullenView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        view.getKijkNa().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.kijkNa(view.getAntwoord().getText());
                model.geefVraag();
                TestInvullenView testInvullenView = new TestInvullenView();
                TestInvullenPresenter testInvullenPresenter = new TestInvullenPresenter(model, testInvullenView);
                view.getScene().setRoot(testInvullenView);
                testInvullenView.getScene().getWindow().sizeToScene();

            }
        });
    }

    private void updateView() {
        view.getVraagnr().setText("Vraag "  + model.getAantalVragenGesteld() + " Poging: " + model.getPoging());
        view.getVraag().setText(model.getVraagTest());
        view.getScore().setText(model.getPunten() + " / " + model.getMaxpunten());
    }
}



