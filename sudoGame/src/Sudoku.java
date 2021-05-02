public class Sudoku{
    private char[][] board;
    public String tmp="";
    public char[][] getSudoku() {
        return this.board;
    }

    public void setSudoku(char[][] board) {
        this.board = board;
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