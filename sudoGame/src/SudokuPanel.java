mport java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class SudokuPanel implements ActionListener {
    public static JFrame f = new JFrame("Sudoku");
    public static JPanel p = new JPanel();
    public static JTextField[][]M = new JTextField[9][9];
    public static JTextField[][] CopieM = new JTextField[9][9];
    Font font = new Font("Lucida Console", Font.BOLD,28);

   
    SudokuPanel(){
        f.setSize(600,600);
        p.setVisible(false);
        p.setLayout(new GridLayout(9,9));
        for (int i = 0; i<9;i++){
            for (int j = 0; j<9;j++){
                M[i][j]= new JTextField();
                M[i][j].setFont(font);
                M[i][j].setForeground(Color.black);
                M[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                M[i][j].addActionListener(this);
                p.add(M[i][j]);
                
               
            }
        }
        f.setContentPane(p);
        p.setVisible(true);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        int x,y;
        for (x = 0;x<9;x++){
            for (y = 0;y<9;y++){
                switch(x){
                    case 0:case 1:case 2:case 6: case 7: case 8:{
                         switch(y){
                            case 0:case 1:case 2: case 6:case 7:case 8:{
                                M[x][y].setBackground(Color.BLUE);
                            }                            
                        }
                    } 
                }
            }
        }
            
        for (x = 0;x<9;x++){
            for (y = 0;y<9;y++){
                switch(x){
                    case 3:case 4:case 5:{
                          switch (y){             
                             case 3:case 4:case 5:{
                               M[x][y].setBackground(Color.BLUE);
                 
                            }                           
                        }  
                   }
                }  
            }
        }
    }
    public void affichage(int i , int j , String k  ){
        
    
        String text = M[i][j].setText(String.valueOf(k));
        
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
       
        
    }
}


   
    
   

