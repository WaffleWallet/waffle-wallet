import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.Color;

public class WaffleWallet extends JFrame implements ActionListener{
    JTabbedPane tabbedpane;
    JTextField indexText;
    
    JPanel tabPanel1 = new JPanel();
    JPanel tabPanel4 = new JPanel();

    private String[][] tabledata = {
        {"","","",""}
    };

    private String[] columnNames = {"Time", "SEND", "RECEIVE", "BALANCE"};

    public static void main(String[] args){
        Waffle_Wallet frame = new Waffle_Wallet();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 230);
        frame.setTitle("Waffle Wallet");
        frame.setVisible(true);
    }

    public WaffleWallet() {
        tabbedpane = new JTabbedPane();

        int width = 300;
        JPanel tabPanel1 = new JPanel();
        FlowLayout firstTabFlowLayout = new FlowLayout(FlowLayout.LEFT);
        firstTabFlowLayout.setVgap(50);
        firstTabFlowLayout.setHgap(15);
        tabPanel1.setLayout(firstTabFlowLayout);
        tabPanel1.setBackground(new Color(220,220,255));
        tabPanel1.add(new JLabel("ID:   "));
        tabPanel1.add(new JTextField(23));
        tabPanel1.add(this.createSeparator(width, 0));
        tabPanel1.add(new JLabel("BTC:"));
        tabPanel1.add(new JTextField(23));
        tabPanel1.add(new JLabel("BTC"));
        tabPanel1.add(this.createSeparator(width, 0));

        JPanel tabPanel2 = new JPanel();
        JButton button = new JButton("SEND");
        button.setBackground(new Color(130,230,130));
        tabPanel2.setLayout(new FlowLayout());
        tabPanel2.setBackground(new Color(220,220,255));
        tabPanel2.setPreferredSize(new Dimension(width - 150, 50));
        button.addActionListener(this);
        tabPanel2.add(button);
        tabPanel1.add(tabPanel2);


        JPanel tabPanel3 = new JPanel();

        JTable table = new JTable(tabledata,columnNames);
        JScrollPane sp = new JScrollPane(table);
        sp.setPreferredSize(new Dimension(500,300));
        tabPanel3.add(sp);
        tabPanel3.setBackground(new Color(220,220,255));

        tabbedpane.addTab("SEND", tabPanel1);
        tabbedpane.addTab("HISTORY", tabPanel3);
        tabbedpane.setBackgroundAt(0, new Color(150,150,225));
        tabbedpane.setBackgroundAt(1, new Color(150,150,225));


        getContentPane().add(tabbedpane, BorderLayout.CENTER);
    }

    private JSeparator createSeparator(int width, int hight) {
        JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
        separator.setPreferredSize(new Dimension(width, hight));
        return separator;
    }
    
    public void actionPerformed(ActionEvent e){
        tabPanel4.add(new JLabel("Complete!!")); 
        tabPanel4.setLayout(new FlowLayout());
        tabPanel4.setBackground(new Color(220,220,255));
        tabPanel4.setPreferredSize(new Dimension(300 - 30, 500));
        tabPanel1.add(tabPanel4);
    }
}
