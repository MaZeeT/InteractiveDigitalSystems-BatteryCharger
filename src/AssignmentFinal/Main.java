package AssignmentFinal;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        stage.setTitle("Arduino GUI");
        stage.setScene(new Scene(controller.view.border, 650, 540));
        stage.show();

        //this check for modifications of the external datafile
        new Thread() {  //
            public void run() {
                for (; ; ) { //infinite loop (nearly = to while(true))
                    try {
                        controller.update();
                        sleep(300);
                    } catch (Exception e) {
                    }
                }
            } //end of void run
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}