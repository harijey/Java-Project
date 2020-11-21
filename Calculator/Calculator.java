import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Calculator {  
    private JFrame frame = new JFrame("Calculator");
    private JTextArea txtScreen = new JTextArea();
    private JLabel lblCredit = new JLabel("calculator");

    String strNum1 = "";
    String strNum2 = "";
    String[] statement;
    double num1 = 0;
    double num2 = 0;
    String strTotal = "";
    double totalVal = 0;

    private JButton btnEqual = new JButton("=");  
    private JButton btn0 = new JButton("0");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
    private JButton btnDiv = new JButton("/");
    private JButton btnMul = new JButton("*");
    private JButton btnSub = new JButton("-");
    private JButton btnAdd = new JButton("+");
    private JButton btnDec = new JButton(".");
    private JButton btnCancel = new JButton("C");

    public Calculator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400, 560);
        frame.setResizable(false);
        frame.setLayout(null);
        txtScreen.setSize(380, 150);
        txtScreen.setLocation(7, 15);
        txtScreen.setEditable(false);            
        lblCredit.setSize(200, 100);
        lblCredit.setLocation(12, 150);     
        btn0.setSize(80, 50);
        btn0.setLocation(105, 470);
        ImageIcon icon = new ImageIcon("gamer.JPEG");    
		frame.setIconImage(icon.getImage());

        btn0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("0");
            }
        });

        btn1.setSize(80, 50);
        btn1.setLocation(10, 395);

        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("1");
            }
        });

        btn2.setSize(80, 50);
        btn2.setLocation(105, 395);

        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("2");
            }

        });

        btn3.setSize(80, 50);
        btn3.setLocation(200, 395);

        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("3");
            }

        });   

        btn4.setSize(80, 50);
        btn4.setLocation(10, 310);

        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("4");
           }
        });

        btn5.setSize(80, 50);
        btn5.setLocation(105, 310);

        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("5");
            }
        });

        btn6.setSize(80, 50);
        btn6.setLocation(200, 310);
        btn6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("6");
            }
        });

        btn7.setSize(80, 50);
        btn7.setLocation(10, 230);

        btn7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("7");
            }

        });

        btn8.setSize(80, 50);
        btn8.setLocation(105, 230);

        btn8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("8");
            }
        });

        btn9.setSize(80, 50);
        btn9.setLocation(200, 230);
        btn9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("9");
            }

        });

        btnDiv.setSize(70, 60);
        btnDiv.setLocation(310, 180);
        btnDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("/");
            }
        });

        btnMul.setSize(70, 60);
        btnMul.setLocation(310, 250);
        btnMul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("*");
            }
        });

        btnSub.setSize(70, 60);
        btnSub.setLocation(310, 320);
        btnSub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("-");
            }
        });

        btnAdd.setSize(70, 60);
        btnAdd.setLocation(310, 390);

        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append("+");
            }
        });

        btnDec.setSize(80, 50);
        btnDec.setLocation(200, 470);
        btnDec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                txtScreen.append(".");
            }
        });

        btnCancel.setSize(80, 50);
        btnCancel.setLocation(10, 470);

        btnCancel.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	      String command = e.getActionCommand();
        	      if (command.charAt(0) == 'C') {                  
        	         txtScreen.setText("");
            }
        }});

        btnEqual.setSize(70, 60);
        btnEqual.setLocation(310, 460);
        
        btnEqual.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                if(txtScreen.getText().contains("+")){
                    statement = txtScreen.getText().split("\\+");             
                    strNum1 = statement[0];
                    strNum2 = statement[1];
                    num1 = Double.parseDouble(strNum1);
                    num2 = Double.parseDouble(strNum2);                 
                    totalVal = num1 + num2;
                    strTotal = Double.toString(totalVal);
                    txtScreen.setText(strTotal);
                }
                else if(txtScreen.getText().contains("-")){
                    statement = txtScreen.getText().split("\\-");                
                    strNum1 = statement[0];
                    strNum2 = statement[1]; 
                    num1 = Integer.parseInt(strNum1);
                    num2 = Integer.parseInt(strNum2);                
                    totalVal = num1 - num2;                  
                    strTotal = Double.toString(totalVal);
                    txtScreen.setText(strTotal);
                }

                else if(txtScreen.getText().contains("/")){

                    statement = txtScreen.getText().split("\\/");
                    strNum1 = statement[0];
                    strNum2 = statement[1];
                    num1 = Double.parseDouble(strNum1);
                    num2 = Double.parseDouble(strNum2);
                    totalVal = num1 / num2;
                    strTotal = Double.toString(totalVal);
                    txtScreen.setText(strTotal);
                }

                else if(txtScreen.getText().contains("*")){
                    statement = txtScreen.getText().split("\\*");               
                    strNum1 = statement[0];
                    strNum2 = statement[1];
                    num1 = Double.parseDouble(strNum1);
                    num2 = Double.parseDouble(strNum2);
                    totalVal = num1 * num2;
                    strTotal = Double.toString(totalVal);
                    txtScreen.setText(strTotal);
                }

                else if(txtScreen.getText().contains("C"))

                {     

                	statement = txtScreen.getText().split("\\C");
                	txtScreen.setText(" ");
                }
            }
        });

        frame.add(txtScreen);
        frame.add(btn0);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);    
        frame.add(lblCredit);       
        frame.add(btnDiv);
        frame.add(btnMul);
        frame.add(btnSub);
        frame.add(btnAdd);
        frame.add(btnDec);
        frame.add(btnCancel);
        frame.add(btnEqual); 
        
        SwingUtilities.updateComponentTreeUI(frame);
}
    public static void main(String[] args) {
        new Calculator();
    }
}