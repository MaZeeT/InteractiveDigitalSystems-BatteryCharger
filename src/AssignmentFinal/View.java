package AssignmentFinal;

import javafx.scene.canvas.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import static javafx.scene.paint.Color.*;

public class View implements IView {
    private Canvas canvas = new Canvas(500.0, 500.0);
    private TextArea textArea = new TextArea();
    private VBox vBox = new VBox();
    private VBox buttonVBox = new VBox();
    private GraphicsContext canvasGC = canvas.getGraphicsContext2D();
    private int offSet = 0, scale = 5;
    private double tempOldY = 500, voltOldY = 500;

    public View() { //setup gui
        border.setCenter(canvas);
        border.setRight(vBox);
        vBox.getChildren().addAll(refreshButton, buttonVBox);
        buttonVBox.getChildren().addAll(graphButton, textButton);
        vBox.setSpacing(40.0);
        buttonVBox.setSpacing(5.0);
        textArea.setPrefSize(200.0, 200.0);
        refreshButton.setPrefWidth(100.0);
        graphButton.setPrefWidth(100.0);
        textButton.setPrefWidth(100.0);
        drawFrame();
    }

    public void selectScene(String scene){
        if (scene.equals("text")){
            border.setCenter(textArea);
        }else if (scene.equals("graph")){
            border.setCenter(canvas);
        }else{
            System.out.println("Wrong selected Scene");
        }
    }

    public void addDataPoint(int index, double tempValue, double voltValue){
        drawTemp(index,tempValue);
        drawVolt(index,voltValue);
        addText(tempValue,voltValue);
    }

    public void clear(int i) {
        textArea.clear();
        canvasGC.clearRect(0, 0, 500, 500);
        offSet = i;
        drawFrame();
    }

    public BorderPane getScene(){
        return border;
    }

    private void drawTemp(int index, double temp) {
        int i = index - offSet;
        canvasGC.setStroke(RED);
        drawLine(i * scale, tempOldY * 1,
                i * scale + scale, 500 - temp * scale);
        tempOldY = 500 - temp * scale;
    }

    private void drawVolt(int index, double volt) {
        int i = index - offSet;
        canvasGC.setStroke(BLUE);
        drawLine(i * scale, voltOldY * 1,
                i * scale + scale, 500 - volt * scale);
        voltOldY = 500 - volt * scale;
    }

    private void addText(double temp, double volt) {
        textArea.appendText(
                "Temp: " + String.valueOf(temp) +
             " - Volt: " + String.valueOf(volt) + "\n");
    }

    private void drawLine(int x, double y, int w, double h) {
        canvasGC.strokeLine(x, y, w, h);
    }

    private void drawFrame() {
        drawLine(0, 0, 500, 0); //top frame
        drawLine(0, 0, 0, 500); //left frame
        drawLine(0, 500, 500, 500); //bottom frame
        drawLine(500, 0, 500, 500); // right frame
    }
}