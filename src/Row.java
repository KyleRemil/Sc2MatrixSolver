import java.util.ArrayList;

public class Row {
    ArrayList rowList = new ArrayList();
    int rowNumber;
    double probability;
    double edge;
    boolean labelSwitch;
    int label;

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    public Row(ArrayList arrayList){
        this.rowList.addAll(arrayList);
    }

    public Row(ArrayList arrayList, int rowNum){
        this.rowList.addAll(arrayList);
        this.rowNumber = rowNum;
    }

    public ArrayList getRowValues() {
//        for (int i = 0; i < rowList.size(); i++){
//            System.out.println(rowList.get(i));
//        }
        return rowList;
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

    public void setRowNumber(int thisRowNum){
        rowNumber = thisRowNum;
    }

    public int getRowNumber(){
        return rowNumber;
    }

    public void setProbability(double thisProbability){
        probability = thisProbability;
    }

    public double getProbability(){
        return probability;
    }
}
