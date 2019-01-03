package AssignmentFinal;

import java.io.*;
import java.util.ArrayList;

public class InputModel implements IInputModel {
    double temp, volt;
    long lastMod = 0;
    ArrayList<String> dataList;
    String filePath = "C:\\Users\\MaZeeT\\Dropbox\\RUC\\SourceCode\\Processing\\random2Numbers\\data.txt";
    File file = new File(filePath);

    public void read() { //read the data.txt and export it in the variables temp/volt
        int i = 0;
        dataList = new ArrayList<String>(0);
        String line;
        try {
            BufferedReader buffInput = new BufferedReader(new FileReader(file));
            while ((line = buffInput.readLine()) != null) {
                dataList.add(i, line);
                i++;
            }
            temp = Double.parseDouble(dataList.get(0));
            volt = Double.parseDouble(dataList.get(1));
            lastMod = file.lastModified();
        } catch (Exception e) {
        }
    }

    public boolean modified() { return (lastMod != file.lastModified()); }

    public double getTemp() { return temp; }

    public double getVolt() { return volt; }
}