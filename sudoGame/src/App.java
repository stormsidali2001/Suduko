public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nprogram:\n");
        Sudoku s = new Sudoku();
      char[][] arr={
                    {'.','.','.', '.','5','.', '.','1','.'},
                    {'4','.','3', '.','.','.', '.','.','.'},
                    {'.','.','.', '.','.','3', '.','.','1'},

                    {'8','.','.', '.','.','.', '.','2','.'},
                    {'.','.','2', '.','7','.', '.','.','.'},
                    {'.','1','5', '.','.','.', '.','.','.'},
                   

                    {'.','.','.', '.','.','.', '2','.','.'},
                    {'.','2','.', '9','.','.', '.','.','.'},
                    {'.','.','4', '.','.','.', '.','.','.'}
                 };
        s.setSudoku(arr);
        System.out.println("Sudoku :\n"+s.toString());
        System.out.println("valide Matrix :\n"+s.validMatrix());
        System.out.println((int)1.2);
       
      
        
    }
}
