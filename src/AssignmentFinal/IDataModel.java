package AssignmentFinal;

public interface IDataModel {

    void add(double temp, double volt);

    int getSize();

    double getTemp(int index);

    double getVolt(int index);
}