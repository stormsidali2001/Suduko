import java.util.HashSet;

public class Sudoku{
    private char[][] board;
    public String tmp="";
    public char[][] getSudoku() {
        return this.board;
    }

    public void setSudoku(char[][] board) {
        this.board = board;
    }
    public void setVal(int i,int j,char val)
    {
        this.board[i][j] = val;
    }
    public Sudoku()
    {
       init();
    }
    public void init()
    {
        board=new char[9][9];
        for(int i=0;i<9;i++)
        {
           
            for(int j=0;j<9;j++)
            {
                board[i][j]='.';
            }
        }
    }
    public boolean validInColumn(int r,int c)
    {
        
        for(int i=0;i<9;i++ )
        {
            if(i==r) continue;
           
            if(board[i][c]==board[r][c]) return false;
            
        }
        return true;
    }
    public boolean validInRow(int r,int c)
    {
        
        for(int j=0;j<9;j++ )
        {
            
            if( j==c) continue;
          
            if(board[r][j]==board[r][c]) return false;
            
        }
        return true;
    }
   
    public boolean validInBox(int r,int c)
    {

        int ibox=((int)(r/3))*3;
        int jbox=((int)(c/3))*3;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                
               
                 if(((ibox+i==r) && (j+jbox==c))|| board[i+ibox][j+jbox]=='.') continue;
               
                if((board[ibox+i][jbox+j]==board[r][c])) 
                {
                   
                    return false;
                }

               
            }
        }
        return true;
    }
    //
    public boolean isValidSudokuS2(char[][] board) {
        HashSet<Integer> [] rows = new HashSet[9];
        HashSet<Integer> [] columns = new HashSet[9];
        HashSet<Integer> [] boxes = new HashSet[9];
        //init sets
        for (int i = 0; i < 9; i++) {
          rows[i] = new HashSet<Integer>();
          columns[i] = new HashSet<Integer>();
          boxes[i] = new HashSet<Integer>();
        }
    
        // validate a board
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            if (board[i][j] != '.') continue;

              int n = (int)board[i][j];
              int r=(int)(i / 3 ) * 3;
              int c=(int)(j / 3);
              int box_index =r + c;//0..9  
             /*
            rows[i].add(n):return true if  n exist in the set

             */
             if((!rows[i].add(n))
                ||
                (!columns[j].add(n))
                ||
                (!boxes[box_index].add(n))){
                    return false;
              }
                
            
          }
        }
    
        return true;
      }
    public String validMatrix()
    {
        String tmpS="{\n";
        for(int i=0;i<9;i++)
        {
           
            for(int j=0;j<9;j++)
            {
                String row;
                String col;
                String box;
                if(this.board[i][j]=='.')
                {
                    tmpS+="..."+",";
                    continue;
                }
                if(validInRow(i, j)) row="R";
                else row="r";
                if(validInColumn(i, j)) col="C";
                else col="c";
                if(validInBox(i, j)) box="B";
                else {
                    box="b";
                    tmp+="("+i+","+j+")"+"  |";
                } 
                tmpS+=row+col+box+",";
            }
            tmpS+="\n";
        }
        tmpS+="}";
        return tmpS;
    }
    public boolean solve(int row, int col){
        // If completed all rows, we have solved board, return true
        if(row==9) return true;
        
        // Reached to the last cell in a row, move to next row and first col
        if(col==9) {
            return solve(row+1,0);
        }
        
        // If current cell is empty
        if(board[row][col]=='.'){
            for(char num='1';num<='9';num++){
                // try placing each number at empty cell
                // if board is still valid, move to next cell
                boolean valid = isPossible(row,col,num);
                
                if(valid){
                    // place the number
                    board[row][col] = num;
                    
                    // solve for next cell
                    boolean solved = solve(row,col+1);
                    
                    
                    if(solved){
                        return true;        
                    }else {
                        // if board can't be solved with current number
                        // reset and try next number
                        board[row][col] = '.';
                    };
                }
            }
            
        }
        else {
            // if not empty, solve for next cell in same row
            return solve(row,col+1);
        }
        
        
        return false;
        
    }
    public boolean isPossible(int r,int c,char num)
    {
        char digit = num;
        
        // check if row has n
        for(int i=0;i<9;i++){
            if(board[r][i]==digit) return false;
        }

        // check if col has n
        for(int i=0;i<9;i++){
            if(board[i][c]==digit) return false;
        }
        
     
        
        int startRowIndex = (r/3)*3;
        int startColIndex = (c/3)*3;
        
        for(int i = startRowIndex; i < startRowIndex+3; i++){
            for(int j = startColIndex; j < startColIndex+3; j++){
                if(board[i][j]==digit) return false;
            }
        }
		
        return true;
    }
    @Override
    public String toString()
    {
        String tmpS="{\n";
        for(int i=0;i<9;i++)
        {
           
            for(int j=0;j<9;j++)
            {
                tmpS+=board[i][j]+",";
            }
            tmpS+="\n";
        }
        tmpS+="}";
        return tmpS;
    }
    
}
