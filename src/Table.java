import java.util.LinkedList;

public class Table {
    //region Attributes
    //2D array to visualise the tables in restaurant
    private int[][] tables = new int[4][4];

    //First number of tables
    private int startNumber;

    //Use List to be able to add or remove from elements
    private LinkedList<Integer> selectedTables = new LinkedList<>();
    //endregion

    //region Methods
    //Constructor
    public Table(int startNumber) {
        this.startNumber = startNumber;
    }

    //Return selectedTables
    public LinkedList<Integer> getSelectedTables() {
        return selectedTables;
    }

    //Fill the tables, if someone sat on table, show it as 0
    public void fillTable(int startNumber) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tables[i][j] = startNumber;
                if (selectedTables.contains(tables[i][j])) {
                    tables[i][j] = 0;
                }
                startNumber++;
            }
        }
    }

    //Print all tables
    public void printTables() {
        fillTable(startNumber);
        for (int[] row : tables) {
            for (int i : row) {
                System.out.print(i);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
    //endregion
}
