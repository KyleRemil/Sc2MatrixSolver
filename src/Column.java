import java.util.ArrayList;

public class Column {
    ArrayList columnList = new ArrayList();
    int columnNumber;
    double probability;
    double edge;
    boolean labelSwitch;
    int label;

    public Column(ArrayList arrayList){
        this.columnList.addAll(arrayList);
    }

    public Column(ArrayList arrayList, int colnum){
        this.columnList.addAll(arrayList);
        this.columnNumber = colnum;
    }

    public ArrayList getColumnValues(){
//        for (int i = 0; i < this.columnList.size(); i++){
//            System.out.println(this.columnList.get(i));
//        }
        return this.columnList;
    }

    public boolean isLabelSwitch() {
        return labelSwitch;
    }

    public void setLabelSwitch(boolean labelSwitch) {
        this.labelSwitch = labelSwitch;
    }

    public int getLabel() {
        return label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public void setColumnNumber(int thisColNum){
        columnNumber = thisColNum;
    }

    public int getColumnNumber(){
        return columnNumber;
    }

    public void setProbability(double thisProbability){
        probability = thisProbability;
    }

    public double getProbability(){
        return probability;
    }
}
