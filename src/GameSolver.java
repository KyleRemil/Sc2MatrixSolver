//Created by Kyle Remillard 03/24/2018

// !!!!!!!!! IMPORTANT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//  If you have NOT read the README, DO SO NOW!

import java.util.ArrayList;

public class GameSolver {

    private static Value[][] matrix;
    private static Value[][] originalMatrix;
    private static ArrayList colList = new ArrayList();
    private static ArrayList rowList = new ArrayList();
    private static ArrayList pivotCanidateList = new ArrayList();
    private static ArrayList rowOddsList = new ArrayList();
    private static ArrayList colOddsList = new ArrayList();
    private static double adjustment;
    private static double pivotGameValue;
    private static Value pivot;
    private static double d;
    private static double previuousPivotValue;
    private static String rawInput;

    public static void main(String args[]){
        generateMatrix();
        buildColumns();
        buildRows();
        printMatrix(matrix);

        copyOriginalMatrix();
        makeAllPositive();
        createEdges();
        printMatrix(matrix);

        loop();

        interpretResults();

//        System.out.println("Break");
    }

    private static void generateMatrix(){

        //  This method creates the matrix. It uses the build value method to create a new instance of the Value object
        //with the appropriate attributes.

//        matrix = new Value[4][4];
//
//        matrix[0][0] = buildValue(16.0);
//        matrix[0][1] = buildValue(-8.0);
//        matrix[0][2] = buildValue(9.0);
//        matrix[0][3] = buildValue(-3.0);
//
//        matrix[1][0] = buildValue(-20.0);
//        matrix[1][1] = buildValue(4.0);
//        matrix[1][2] = buildValue(9.0);
//        matrix[1][3] = buildValue(-3.0);
////
//        matrix[2][0] = buildValue(25.0);
//        matrix[2][1] = buildValue(1.0);
//        matrix[2][2] = buildValue(18.0);
//        matrix[2][3] = buildValue(-6.0);
//
//        matrix[3][0] = buildValue(-11.0);
//        matrix[3][1] = buildValue(13.0);
//        matrix[3][2] = buildValue(-18.0);
//        matrix[3][3] = buildValue(6.0);

        matrix = new Value[2][6];

        matrix[0][0] = buildValue(-6.0);
        matrix[0][1] = buildValue(-2.0);
        matrix[0][2] = buildValue(0.0);
        matrix[0][3] = buildValue(0.0);
        matrix[0][4] = buildValue(0.0);
        matrix[0][5] = buildValue(0.0);

        matrix[1][0] = buildValue(0.0);
        matrix[1][1] = buildValue(0.0);
        matrix[1][2] = buildValue(0.0);
        matrix[1][3] = buildValue(-6.0);
        matrix[1][4] = buildValue(-2.0);
        matrix[1][5] = buildValue(0.0);


//        matrix[3][0] = buildValue(-11.0);
//        matrix[3][1] = buildValue(13.0);
//        matrix[3][2] = buildValue(-18.0);
//        matrix[3][3] = buildValue(6.0);

        // Really big matrix.
//        matrix = new Value[6][11];
//
//        matrix[0][0] = buildValue(1.0);
//        matrix[0][1] = buildValue(2.0);
//        matrix[0][2] = buildValue(3.0);
//        matrix[0][3] = buildValue(4.0);
//        matrix[0][4] = buildValue(2311114.0);
//        matrix[0][5] = buildValue(4.0);
//        matrix[0][6] = buildValue(423123.0);
//        matrix[0][7] = buildValue(423.0);
//        matrix[0][8] = buildValue(423222.0);
//        matrix[0][9] = buildValue(4.0);
//        matrix[0][10] = buildValue(12312324.0);
//
//
//        matrix[1][0] = buildValue(1.0);
//        matrix[1][1] = buildValue(2.0);
//        matrix[1][2] = buildValue(3.0);
//        matrix[1][3] = buildValue(4.0);
//        matrix[1][4] = buildValue(1231234.0);
//        matrix[1][5] = buildValue(42224.0);
//        matrix[1][6] = buildValue(4.0);
//        matrix[1][7] = buildValue(232324.0);
//        matrix[1][8] = buildValue(2324.0);
//        matrix[1][9] = buildValue(2323234.0);
//        matrix[1][10] = buildValue(456666666224.0);
//
//        matrix[2][0] = buildValue(1231232221.0);
//        matrix[2][1] = buildValue(7878782.0);
//        matrix[2][2] = buildValue(23233.0);
//        matrix[2][3] = buildValue(4977.0);
//        matrix[2][4] = buildValue(3422.0);
//        matrix[2][5] = buildValue(4224.0);
//        matrix[2][6] = buildValue(23234.0);
//        matrix[2][7] = buildValue(787878787784.0);
//        matrix[2][8] = buildValue(4.0);
//        matrix[2][9] = buildValue(78875555676774.0);
//        matrix[2][10] = buildValue(4.0);
//
//        matrix[3][0] = buildValue(45751.0);
//        matrix[3][1] = buildValue(2.0);
//        matrix[3][2] = buildValue(343.0);
//        matrix[3][3] = buildValue(4.0);
//        matrix[3][4] = buildValue(4.0);
//        matrix[3][5] = buildValue(3236724.0);
//        matrix[3][6] = buildValue(34634.0);
//        matrix[3][7] = buildValue(4.0);
//        matrix[3][8] = buildValue(2347854.0);
//        matrix[3][9] = buildValue(420433334.0);
//        matrix[3][10] = buildValue(4.0);
//
//        matrix[4][0] = buildValue(457841.0);
//        matrix[4][1] = buildValue(2.0);
//        matrix[4][2] = buildValue(353.0);
//        matrix[4][3] = buildValue(5534.0);
//        matrix[4][4] = buildValue(24584.0);
//        matrix[4][5] = buildValue(974.0);
//        matrix[4][6] = buildValue(434634.0);
//        matrix[4][7] = buildValue(9564.0);
//        matrix[4][8] = buildValue(45454544.0);
//        matrix[4][9] = buildValue(4577444.0);
//        matrix[4][10] = buildValue(587679674.0);
//
//        matrix[5][0] = buildValue(4578731.0);
//        matrix[5][1] = buildValue(2.0);
//        matrix[5][2] = buildValue(32453.0);
//        matrix[5][3] = buildValue(23454.0);
//        matrix[5][4] = buildValue(7865564.0);
//        matrix[5][5] = buildValue(7976674.0);
//        matrix[5][6] = buildValue(887654.0);
//        matrix[5][7] = buildValue(464.0);
//        matrix[5][8] = buildValue(4.0);
//        matrix[5][9] = buildValue(4456.0);
//        matrix[5][10] = buildValue(1141116432.0);

//        matrix = new Value[4][4];
//
//        matrix[0][0] = buildValue(-3.0);
//        matrix[0][1] = buildValue(5.0);
//        matrix[0][2] = buildValue(7.0);
//        matrix[0][3] = buildValue(2.0);
//
//        matrix[1][0] = buildValue(0.0);
//        matrix[1][1] = buildValue(9.0);
//        matrix[1][2] = buildValue(-4.0);
//        matrix[1][3] = buildValue(3.0);
//
//        matrix[2][0] = buildValue(-2.0);
//        matrix[2][1] = buildValue(5.0);
//        matrix[2][2] = buildValue(0.0);
//        matrix[2][3] = buildValue(-5.0);
//
//        matrix[3][0] = buildValue(6.0);
//        matrix[3][1] = buildValue(1.0);
//        matrix[3][2] = buildValue(3.0);
//        matrix[3][3] = buildValue(-2.0);


//        matrix = new Value[3][3];
//
//        matrix[0][0] = buildValue(2.0);
//        matrix[0][1] = buildValue(-1.0);
//        matrix[0][2] = buildValue(6.0);
//
//        matrix[1][0] = buildValue(0.0);
//        matrix[1][1] = buildValue(1.0);
//        matrix[1][2] = buildValue(-1.0);
//
//        matrix[2][0] = buildValue(-2.0);
//        matrix[2][1] = buildValue(2.0);
//        matrix[2][2] = buildValue(1.0);


//        matrix = new Value[3][3];
//
//        matrix[0][0] = buildValue(6.0);
//        matrix[0][1] = buildValue(0.0);
//        matrix[0][2] = buildValue(3.0);
//
//        matrix[1][0] = buildValue(8.0);
//        matrix[1][1] = buildValue(-2.0);
//        matrix[1][2] = buildValue(3.0);
//
//        matrix[2][0] = buildValue(4.0);
//        matrix[2][1] = buildValue(6.0);
//        matrix[2][2] = buildValue(5.0);

        //EXAMPLE 1.
//        matrix = new Value[3][4];
//
//        matrix[0][0] = buildValue(1.0);
//        matrix[0][1] = buildValue(3.0);
//        matrix[0][2] = buildValue(2.0);
//        matrix[0][3] = buildValue(6.0);
//
//        matrix[1][0] = buildValue(6.0);
//        matrix[1][1] = buildValue(7.0);
//        matrix[1][2] = buildValue(4.0);
//        matrix[1][3] = buildValue(5.0);
//
//        matrix[2][0] = buildValue(0.0);
//        matrix[2][1] = buildValue(2.0);
//        matrix[2][2] = buildValue(2.0);
//        matrix[2][3] = buildValue(-3.0);

        //Zero sum practice V2 #8
//        matrix = new Value[3][3];
//
//        matrix[0][0] = buildValue(-2.0);
//        matrix[0][1] = buildValue(4.0);
//        matrix[0][2] = buildValue(0.0);
//
//        matrix[1][0] = buildValue(0.0);
//        matrix[1][1] = buildValue(-2.0);
//        matrix[1][2] = buildValue(4.0);
//
//        matrix[2][0] = buildValue(4.0);
//        matrix[2][1] = buildValue(0.0);
//        matrix[2][2] = buildValue(1.0);

//        matrix = new Value[3][4];
//
//        matrix[0][0] = buildValue(1.0);
//        matrix[0][1] = buildValue(2.0);
//        matrix[0][2] = buildValue(3.0);
//        matrix[0][3] = buildValue(5.0);
//
//        matrix[1][0] = buildValue(10.0);
//        matrix[1][1] = buildValue(11.0);
//        matrix[1][2] = buildValue(12.0);
//        matrix[1][3] = buildValue(4.0);
//
//        matrix[2][0] = buildValue(9.0);
//        matrix[2][1] = buildValue(8.0);
//        matrix[2][2] = buildValue(7.0);
//        matrix[2][3] = buildValue(6.0);

    }

    private static Value buildValue(double thisValue){

        //  Creates a new instance of the Value object to hold information.

        return new Value(thisValue);
    }

    private static int getNumberOfSpaces(double number){

        // Finds how many characters of space a double contains

        String numbString = String.valueOf(number);
        int spaces = numbString.length();
        return spaces;
    }

    private static String prettyPrintString(int numbSpaces, double numbInput) {

        //  Makes all data into a uniformed sized string.

        String uglyString = String.valueOf(numbInput);
        String prettyString = uglyString;
        String spaces;
        int payload = uglyString.length();
        int filler = numbSpaces - payload;

        for (int i = 0; i < filler; i++) {

            prettyString = prettyString + " ";
        }

        return prettyString;
    }

    private static void printMatrix(Value[][] thisMatrix){

        //  Loops through the matrix and prints the value for each of the Values.

        int mostSpaces = 0;

        for (int i = 0; i < thisMatrix.length; i++) {
            for (int j = 0; j < thisMatrix[0].length; j++) {

                int currentSpaces = getNumberOfSpaces(thisMatrix[i][j].getValue());

                if (currentSpaces > mostSpaces) {
                    mostSpaces = currentSpaces;

                }
            }
        }

        System.out.println("----------------------------------- MATRIX ----------------------------------------------");
        for (int i = 0; i < thisMatrix.length ; i++) {

            for (int j = 0; j < thisMatrix[0].length; j++) {

                System.out.print(prettyPrintString(mostSpaces, thisMatrix[i][j].getValue()) + "  ");
            }
            int rowNum = matrix[i][0].getRow();
            Row row = (Row) rowList.get(rowNum);
            System.out.print(" | " + prettyPrintString(mostSpaces, row.getEdge()));
            System.out.println();
        }
        for (int i = 0; i < colList.size(); i++) {

            System.out.print("------");
        }
        System.out.println();
        for (int i = 0; i < colList.size(); i++) {

            int colNum = matrix[0][i].getColumn();
            Column column = (Column) colList.get(colNum);
            System.out.print(prettyPrintString(mostSpaces, column.getEdge()) + "  ");
        }
        System.out.print(prettyPrintString(mostSpaces, pivotGameValue));
        System.out.println("\n \n");
    }

    private static void buildColumns(){

        //  Populates the colList with unique Columns

        colList.clear();
        ArrayList templList = new ArrayList();
        Value thisValue;
        int colNum = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            thisValue = matrix[0][j];
            for(int i = 0; i < matrix.length ; i++) {
                Value tempVal = matrix[i][j];
                tempVal.setColumn(j);
                templList.add(tempVal);
                colNum = j;
            }
            Column columnListObject = new Column(templList, colNum);
            colList.add(columnListObject);
            templList.clear();
        }
    }

    private static void buildRows(){

        //  Populates the colList with unique Rows.

        rowList.clear();
        ArrayList templList = new ArrayList();
        Value thisValue;
        int rowNum = 0;
        for (int i = 0; i < matrix.length ; i++) {
            thisValue = matrix[i][0];
            for(int j = 0; j < matrix[0].length; j++) {
                Value tempVal = matrix[i][j];
                tempVal.setRow(i);
                templList.add(tempVal);
                rowNum = i;
            }
            Row rowListObject = new Row(templList, rowNum);
            rowList.add(rowListObject);
            templList.clear();
        }
    }

    private static void copyOriginalMatrix(){

        //  Makes a new matrix with the same data. It is used as a reference for many operations from one schema to the next.
        //If I used the original as I was changing it I would get the wrong results for obvious reasons.

        originalMatrix = new Value[matrix.length][matrix[0].length];

        for(int j = 0; j < matrix[0].length ; j++) {
            for (int i = 0; i < matrix.length; i++) {
                Value oldValue = matrix[i][j];
                int rowNum = oldValue.getRow();
                int colNum = oldValue.getColumn();
                double value = oldValue.getValue();

                Value newValue = new Value(rowNum, colNum, value);

                originalMatrix[i][j] = newValue;
            }
        }
    }

    private static void makeAllPositive(){

        //   Finds the lowest negative value and adds a positive value of that amount to make the smallest number in the
        // the matrix 0.

        double min = 0;

        for(int j = 0; j < matrix[0].length ; j++) {
            for (int i = 0; i < matrix.length; i++) {
                double thisValue = matrix[i][j].getValue();
                if (thisValue < min){
                    min = thisValue;
                }
            }
        }

        if (min !=0){
            adjustment = min*(-1);
            for(int j = 0; j < matrix[0].length ; j++) {
                for (int i = 0; i < matrix.length; i++) {
                    Value thisVal = matrix[i][j];
                    double oldValue = thisVal.getValue();
                    thisVal.setValue(oldValue + adjustment);
                }
            }
        }
    }

    private static void createEdges(){

        // Creates the initial edge values that the probabilities will come from.

        for (int i = 0; i < colList.size(); i++){

            Column thisCol = (Column) colList.get(i);
            thisCol.setEdge(-1);
            thisCol.setLabel(i);
            thisCol.setLabelSwitch(false);
        }
        for (int i = 0; i < rowList.size(); i++){

            Row thisRow = (Row) rowList.get(i);
            thisRow.setEdge(1);
            thisRow.setLabel(i);
            thisRow.setLabelSwitch(false);
        }
        pivotGameValue = 0;
        d = 1;

//        System.out.println("////// Start of print Row edges ///////////////////////////////////////////////////////// \n");
//        for (int i = 0; i < rowList.size(); i++){
//            Row row = (Row) rowList.get(i);
//            System.out.println("Row: " + i + " Edge: " + row.getEdge());
//        }
//        System.out.println("////// Start of print Column edges //////////////////////////////////////////////// \n");
//        for (int i = 0; i < colList.size(); i++){
//            Column column = (Column) colList.get(i);
//            System.out.println("Column: " + i + " Edge: " + column.getEdge());
//        }
    }

    private static void getPivotCanidates(Value[][] thisMatrix) {
        //      Gets the smallest number from each Column and adds them to the candidate list

        pivotCanidateList.clear();
        Value lowestRatioVal = thisMatrix[0][0];

        for (int j = 0; j < thisMatrix[0].length; j++) {

            int k = 0;
            lowestRatioVal = thisMatrix[0][j];

            while (!isPostive(lowestRatioVal) && k < thisMatrix.length - 1){
                k++;
                lowestRatioVal = thisMatrix[k][j];
            }

            for (int i = 0; i < thisMatrix.length; i++) {

                double lowestRatio = getRatio(lowestRatioVal);

                Value currentVal = thisMatrix[i][j];
                double currentRatio = getRatio(currentVal);

                if (currentRatio < lowestRatio && isPostive(currentVal)){

                    lowestRatioVal = currentVal;
                }
            }

            if (isPostive(lowestRatioVal)){
                pivotCanidateList.add(lowestRatioVal);

            }
        }
    }

    private static boolean isPostive(Value value){

        //      Checks if the value is positive in the reference matrix

        int row = value.getRow();
        int col = value.getColumn();

        if (originalMatrix[row][col].getValue() >= 0) {
            return true;
        }
        else return false;
    }

    private static double getRatio(Value thisVal){

        //      Performs the operations needed to evaluate the evaluation criterion.

        double p = thisVal.getValue();
        int rowNum = thisVal.getRow();
        Row lowestValRow = (Row) rowList.get(rowNum);
        double r = lowestValRow.getEdge();
        int colNum = thisVal.getColumn();
        Column lowestValCol = (Column) colList.get(colNum);
        double c = lowestValCol.getEdge();

        double ratio = (-1.0) * ((r * c) / p);

        return ratio;
    }

    private static void getPivot(){

        //      Performs the operations for the evaluation criterion again, but on a refined list of candidates to
        //  obtain the best Pivot.

        Value maxMinVal = (Value) pivotCanidateList.get(0);
        double lP = maxMinVal.getValue();
        int lRowNum = maxMinVal.getRow();
        Row maxMinRow = (Row) rowList.get(lRowNum);
        double lR = maxMinRow.getEdge();
        int lColNum = maxMinVal.getColumn();
        Column maxMinCol = (Column) colList.get(lColNum);
        double lC = maxMinCol.getEdge();
        double maxMinRatio = (-1.0) * ((lR * lC) / lP);

//        System.out.println(" starting pivot canidate: " + lP + "Ratio: " + maxMinRatio);

        for (int i = 1; i < pivotCanidateList.size(); i++) {

            Value currentVal = (Value) pivotCanidateList.get(i);
            double p = currentVal.getValue();
            int rowNum = currentVal.getRow();
            Row currentValRow = (Row) rowList.get(rowNum);
            double r = currentValRow.getEdge();
            int colNum = currentVal.getColumn();
            Column currentValCol = (Column) colList.get(colNum);
            double c = currentValCol.getEdge();
            double currentRatio = (-1.0) * ((r * c) / p);

//            System.out.println(" current pivot Canidate " + p + "Ratop: " + currentRatio);

            if (currentRatio > maxMinRatio){
                maxMinVal = currentVal;
                maxMinRatio = currentRatio;
            }
        }
        pivot = maxMinVal;
        previuousPivotValue = maxMinVal.getValue();
//        System.out.println(" THe current pivot value :  " + pivot.getValue());
    }

    private static void updatePivotColumn(){

        //      Changes the sign of all the values in the pivot Column

        int colNum = pivot.getColumn();
        Column pivotCol = (Column) colList.get(colNum);
        ArrayList colItems = pivotCol.getColumnValues();

        for (int i = 0; i < colItems.size(); i++) {
            Value currentVal = (Value) colItems.get(i);
            if (currentVal != pivot) {
                currentVal.setValue(currentVal.getValue() * (-1));
            }
        }

        pivotCol.setEdge(pivotCol.getEdge() * (-1));
    }

    private static void updatePivot(){

        //      Sets the value of the pivot to the auxiliary value d.

        pivot.setValue(d);
    }

    private static void updateOtherMatrixValues(){

        //      Performs the operations to transform all values not in the Pivot Row or Column.

        // updates values that are not the pivot, or in its row or column.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                Value currentVal = matrix[i][j];
                int currentRowNum = currentVal.getRow();
                int currentColNum = currentVal.getColumn();

                int pivotRowNum = pivot.getRow();
                int pivotColNum = pivot.getColumn();

                if (currentColNum != pivotColNum && currentRowNum != pivotRowNum) {

                    double n = currentVal.getValue();
                    double p = previuousPivotValue;
                    Row pivotROw = (Row) rowList.get(pivotRowNum);
                    ArrayList pivotRowList = pivotROw.getRowValues();
                    Value rVal = (Value) pivotRowList.get(currentColNum);
                    double r = rVal.getValue();
                    Column pivotCol = (Column) colList.get(pivotColNum);
                    ArrayList pivotColList = pivotCol.getColumnValues();
                    Value cVal = (Value) pivotColList.get(currentRowNum);
                    double c = cVal.getValue();

                    currentVal.setValue(((n * p) - (r * c)) / d);
                }
            }
        }
    }

    private static void updateEdges(){

        //      Transforms the edge values the same as in the method above, but since edge positions will not change
        //  this can be done with a lower computational complexity.

        for (int i = 0; i < rowList.size(); i++) {

            if (i != pivot.getRow()){

                Row row = (Row) rowList.get(i);
                double n = row.getEdge();
                double p = previuousPivotValue;
                int pivotRowNum = pivot.getRow();
                Row pivotRow = (Row) rowList.get(pivotRowNum);
                double r = pivotRow.getEdge();
                int pivotColNum = pivot.getColumn();
                Column pivotCol = (Column) colList.get(pivotColNum);
                ArrayList pivotColList = pivotCol.getColumnValues();
                Value cVal = (Value) pivotColList.get(i);
                double c = cVal.getValue();

                row.setEdge(((n * p) - (r * c)) / d);
//                System.out.println("Row Edge updated to: " + row.getEdge());
            }
        }

        for (int i = 0; i < colList.size(); i++) {

            if (i != pivot.getColumn()){

                Column col = (Column) colList.get(i);
                double n = col.getEdge();
                double p = previuousPivotValue;
                int pivotRowNum = pivot.getRow();
                Row pivotRow = (Row) rowList.get(pivotRowNum);
                ArrayList pivotRowList = pivotRow.getRowValues();
                Value rVal = (Value) pivotRowList.get(i);
                double r = rVal.getValue();
                Column pivotCol = (Column) colList.get(pivot.getColumn());
                double c = pivotCol.getEdge();

                col.setEdge(((n * p) - (r * c)) / d);
//                System.out.println("Col Edge updated to: " + col.getEdge());
            }
        }

        Column pivotCol = (Column) colList.get(pivot.getColumn());
        double c = pivotCol.getEdge();
        Row pivotRow = (Row) rowList.get(pivot.getRow());
        double r = pivotRow.getEdge();
        double n = pivotGameValue;
        double p = previuousPivotValue;

        pivotGameValue = ((n * p) - (r * c)) / d;
    }

    private static void switchLabels() {

        //      Switches the labels for the Row and Column associated with the Pivot. This is done to keep track of what
        //  probabilities will go where.

        Row pivotRow = (Row) rowList.get(pivot.getRow());
        int rowLabel = pivotRow.getLabel();
        Column pivotCol = (Column) colList.get(pivot.getColumn());
        int colLabel = pivotCol.getLabel();

        pivotRow.setLabel(colLabel);
        pivotRow.setLabelSwitch(true);

        pivotCol.setLabel(rowLabel);
        pivotCol.setLabelSwitch(true);

    }

    private static void loop() {

        //      This method just holds all the methods needed to complete recursive operations until the final schema
        //  is achieved.

        getPivotCanidates(matrix);
        getPivot();
        updatePivot();
        updateOtherMatrixValues();
        updateEdges();
        updatePivotColumn();
        d = previuousPivotValue;
        switchLabels();
        printMatrix(matrix);
        check4Negatives();
        copyOriginalMatrix();

    }

    private static void check4Negatives() {

        //      Evaluates all the Column edge values to determine whether or now the schema is in its final stage.

        int counter = 0;

        for (int i = 0; i < colList.size(); i++) {

            Column column = (Column) colList.get(i);

            if (column.getEdge() < 0) {
                counter = counter + 1;
            }
        }

        if (counter > 0) {
            loop();
        }
    }

    private static void interpretResults() {

        //      Collects information relevant to the solution from the final schema.

        getColProbabilities();
        getRowProbabilities();

        double finalGameValue = (d / pivotGameValue) - adjustment;

        System.out.print("!!!!!!!!!!!!!!!!!!!!!!!!!! THE GAME RESULTS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");

        System.out.print("Row Probabilities: ( ");

        for (int i = 0; i < rowList.size(); i++) {

            Row row = (Row) rowList.get(i);
            System.out.print(row.getProbability() + ", ");
        }
        System.out.print(")\n");

        System.out.print("Column Probabilities: ( ");

        for (int i = 0; i < colList.size(); i++) {

            Column column = (Column) colList.get(i);
            System.out.print(column.getProbability() + ", ");
        }
        System.out.print(")\n");
        System.out.println("The Value of the game is: " + finalGameValue);
    }

    private static void getRowProbabilities() {

        //      Gets and computes the probabilities for each Row.

        rowOddsList.clear();
        double denominator = 0.0;

        for (int i = 0; i < rowList.size(); i++) {

            Row currentRow = (Row) rowList.get(i);

            if (currentRow.isLabelSwitch()) {

                int colLabel = currentRow.getLabel();
                Column referenceColumn = (Column) colList.get(colLabel);
                denominator = denominator + referenceColumn.getEdge();
                rowOddsList.add(currentRow);

            } else {

                currentRow.setProbability(0.0);
            }
        }
        for (int i = 0; i < rowOddsList.size(); i++) {

            Row currentRow = (Row) rowOddsList.get(i);

            if (currentRow.isLabelSwitch()) {

                Column referenceColumn = (Column) colList.get(currentRow.getLabel());
                double numerator = referenceColumn.getEdge();

                currentRow.setProbability(numerator / denominator);
            }
        }
    }

    private static void getColProbabilities() {

        //      Gets and computes the probabilities for each Column.

        colOddsList.clear();
        double denominator = 0.0;

        for (int i = 0; i < colList.size(); i++) {

            Column currentCol = (Column) colList.get(i);

            if (currentCol.isLabelSwitch()) {

                int rowLabel = currentCol.getLabel();
                Row referenceRow = (Row) rowList.get(rowLabel);
                denominator = denominator + referenceRow.getEdge();
                colOddsList.add(currentCol);
            } else {
                currentCol.setProbability(0);
            }
        }
        for (int i = 0; i < colOddsList.size(); i++) {

            Column currentCol = (Column) colOddsList.get(i);

            if (currentCol.isLabelSwitch()) {

                Row referenceRow = (Row) rowList.get(currentCol.getLabel());
                double numerator = referenceRow.getEdge();

                currentCol.setProbability(numerator / denominator);
            }
        }
    }
// END
}
