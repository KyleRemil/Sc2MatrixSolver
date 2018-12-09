public class Value {
    int row;
    int column;
    double value;
    double probability;

    public Value(int thisRow, int thisColumn, double thisValue, double thisProbability){
        row = thisRow;
        column = thisColumn;
        value = thisValue;
        probability = thisProbability;
    }

    public Value(int thisRow, int thisColumn, double thisValue) {
        row = thisRow;
        column = thisColumn;
        value = thisValue;
    }

    public Value(double thisValue){
        value = thisValue;
        column = -2; // Mark this as an unset value.
        row = -2;

    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
