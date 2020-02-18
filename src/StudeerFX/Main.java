package StudeerFX;

import StudeerFX.model.StudeerModel;
import StudeerFX.view.Start.StartPresenter;
import StudeerFX.view.Start.StartView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage start){
        start.setResizable(false);
        StudeerModel model = new StudeerModel();
        StartView view = new StartView();
        StartPresenter presenter = new StartPresenter(model, view);
        Scene scene = new Scene(view,1280,720);
        start.setScene(scene);
        start.setTitle("E-Study");
        start.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


