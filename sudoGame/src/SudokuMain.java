public class SodokuMain {
    public static void main (String[] args){
        SudokuPanel panel = new   SudokuPanel();
        panel.setText(0, 1, "9");
        Sudoku s = new Sudoku();
        panel.setS(s);
       
       
    }
}
