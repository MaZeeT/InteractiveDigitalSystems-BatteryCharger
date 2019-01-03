package AssignmentFinal;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public interface IView {
    BorderPane border = new BorderPane();
    Button refreshButton = new Button("Refresh");
    Button graphButton = new Button("Graph");
    Button textButton = new Button("Text");

    void selectScene(String scene);

    void addDataPoint(int index, double tempValue, double voltValue);

    void clear(int i);
}