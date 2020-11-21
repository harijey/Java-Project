import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.PlatformLoggingMXBean;
import java.util.Random;

public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel bottom = new JPanel();
    JLabel turns = new JLabel();
    JPanel buttonPanel = new JPanel();
    ImageIcon logo;
    ImageIcon tile;
    ImageIcon X;
    ImageIcon O;
    JLabel textfield = new JLabel();
    JButton[] button = new JButton[9];
    boolean player1Turn;
    int moves;
    TicTacToe(){
        int moves=0;
         logo=new ImageIcon("logo.png");
        X = new ImageIcon("X.png");
        X = new ImageIcon(X.getImage().getScaledInstance(60, 60, 4));
        O = new ImageIcon("O.png");
        O = new ImageIcon(O.getImage().getScaledInstance(60, 60, 4));

         frame.setTitle("Let the Fight Begin");
         frame.setIconImage ( logo.getImage());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setSize(520,550);
         frame.getContentPane().setBackground(Color.WHITE);
         frame.setLayout(new BorderLayout());
         frame.setVisible(true);

         textfield.setBackground(Color.BLACK);
         textfield.setForeground(Color.green);
         textfield.setFont(new Font("Ink Free",Font.BOLD,75));
         textfield.setHorizontalAlignment(JLabel.CENTER);
         textfield.setText("Tic-Tac-Toe");
         textfield.setOpaque(true);

         titlePanel.setLayout(new BorderLayout());
         titlePanel.setBounds(0,0,520,100);

        turns.setBackground(Color.BLACK);
        turns.setForeground(Color.green);
        turns.setFont(new Font("Ink Free",Font.BOLD,75));
        turns.setHorizontalAlignment(JLabel.CENTER);
        turns.setText("Let's Begin");
        turns.setOpaque(true);

        bottom.setLayout(new BorderLayout());
        bottom.setBounds(0,0,520,100);

         buttonPanel.setLayout(new GridLayout(3,3));
         buttonPanel.setBackground(Color.cyan);

         for(int i=0;i<9;++i){
             button[i]= new JButton();
             buttonPanel.add(button[i]);
             button[i].setFont(new Font("MV Boli",Font.BOLD,0));
             button[i].setFocusable(false);
             button[i].addActionListener(this);

             tile = new ImageIcon(( i+1) + ".png");
             tile = new ImageIcon(tile.getImage().getScaledInstance(60, 60, 4));
             button[i].setIcon(tile);
         }
        bottom.add(turns);
         titlePanel.add(textfield);
         frame.add(bottom,BorderLayout.SOUTH);
         frame.add(titlePanel,BorderLayout.NORTH);
         frame.add(buttonPanel,BorderLayout.CENTER);
         firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++) {
            if(e.getSource()==button[i]) {
                if(player1Turn) {
                    if(button[i].getText()=="") {
                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        button[i].setIcon(X);
                        turns.setText("O turn");
                        moves++;
                        check();
                        player1Turn =false;
                    }
                }
                else {
                    if(button[i].getText()=="") {
                        button[i].setForeground(new Color(0,0,255));
                        button[i].setIcon(O);
                        button[i].setText("O");
                        player1Turn=true;
                        turns.setText("X turn");
                        moves++;
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn()  {
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        if(random.nextInt(2)==0){
            player1Turn=true;
            turns.setText("X Turn");
        }
        else{
            player1Turn=false;
            turns.setText("O Turn");
        }
    }
    public void check(){
        if((button[0].getText()=="X")&& (button[1].getText()=="X")&&(button[2].getText()=="X")) {
            xWins(0,1,2); return;
        }
        else if((button[3].getText()=="X")&& (button[4].getText()=="X")&&(button[5].getText()=="X")) {
            xWins(3,4,5);return;
        }
        else if((button[6].getText()=="X")&& (button[7].getText()=="X")&&(button[8].getText()=="X")) {
            xWins(6,7,8);return;
        }
        else if((button[0].getText()=="X")&& (button[3].getText()=="X")&&(button[6].getText()=="X")) {
            xWins(0,3,6);return;
        }
        else if((button[1].getText()=="X")&& (button[4].getText()=="X")&&(button[7].getText()=="X")) {
            xWins(1,4,7);return;
        }
        else if((button[2].getText()=="X")&& (button[5].getText()=="X")&&(button[8].getText()=="X")) {
            xWins(2,5,8);return;
        }
        else if((button[0].getText()=="X")&& (button[4].getText()=="X")&&(button[8].getText()=="X")) {
            xWins(0,4,8);return;
        }
        else if((button[2].getText()=="X")&& (button[4].getText()=="X")&&(button[6].getText()=="X")) {
            xWins(2,4,6);return;
        }
        else{}
        //O
        if((button[0].getText()=="O")&& (button[1].getText()=="O")&&(button[2].getText()=="O")) {
            oWins(0,1,2);return;
        }
        else if((button[3].getText()=="O")&& (button[4].getText()=="O")&&(button[5].getText()=="O")) {
            oWins(3,4,5);return;
        }
        else if((button[6].getText()=="O")&& (button[7].getText()=="O")&&(button[8].getText()=="O")) {
            oWins(6,7,8);return;
        }
        else if((button[0].getText()=="O")&& (button[3].getText()=="O")&&(button[6].getText()=="O")) {
            oWins(0,3,6);return;
        }
        else if((button[1].getText()=="O")&& (button[4].getText()=="O")&&(button[7].getText()=="O")) {
            oWins(1,4,7);return;
        }
        else if((button[2].getText()=="O")&& (button[5].getText()=="O")&&(button[8].getText()=="O")) {
            oWins(2,5,8);return;
        }
        else if((button[0].getText()=="O")&& (button[4].getText()=="O")&&(button[8].getText()=="O")) {
            oWins(0,4,8);return;
        }
        else if((button[2].getText()=="O")&& (button[4].getText()=="O")&&(button[6].getText()=="O")) {
            oWins(2,4,6);return;
        }
        else{}
        if (moves==9) {
            turns.setText(" Tied");
            return;
        }
    }
    public void xWins(int a,int b,int c){
        button[a].setBackground(new Color(255, 223, 0));
        button[b].setBackground(new Color(255, 223, 0));
        button[c].setBackground(new Color(255, 223, 0));
        for(int i=0;i<9;++i){
            button[i].setText("z");
        }
        turns.setText("X Wins");

    }
    public void oWins(int a,int b,int c){
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        for(int i=0;i<9;++i){
            button[i].setText("z");
        }
        turns.setText("O Wins");
    }
}
