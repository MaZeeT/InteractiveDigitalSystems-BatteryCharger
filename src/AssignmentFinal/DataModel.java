package AssignmentFinal;

import java.util.ArrayList;

public class DataModel implements IDataModel {
    private ArrayList tempArray = new ArrayList(0);
    private ArrayList voltArray = new ArrayList(0);

    public void add(double temp, double volt) {
        tempArray.add(temp);
        voltArray.add(volt);
    }

    public int getSize() {
        return tempArray.size();
    }

    public double getTemp(int index) {
        return (double) tempArray.get(index);
    }

    public double getVolt(int index) {
        return (double) voltArray.get(index);
    }
}