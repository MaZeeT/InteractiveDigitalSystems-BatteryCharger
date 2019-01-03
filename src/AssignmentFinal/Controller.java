package AssignmentFinal;

import javafx.event.*;

public class Controller {
    private IDataModel data = new DataModel();
    private IInputModel input = new InputModel();
    public IView view = new View();

    public Controller() {
        view.refreshButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view.clear(data.getSize());
            }
        });

        view.graphButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { view.selectScene("graph"); }
        });

        view.textButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { view.selectScene("text"); }
        });
    }

    private void addInputToData() {
        input.read();
        data.add(input.getTemp(), input.getVolt());
    }

    public void update() {
        if (input.modified()) {
            addInputToData();
            int index = data.getSize() - 1;
            view.addDataPoint(index, data.getTemp(index),data.getVolt(index));
        }
    }
}