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

public class Waffle_Wallet extends JFrame{

  JTabbedPane tabbedpane;
  JTextField indexText;

  private String[][] tabledata = {
    {"","","",""}
  };
  
  private String[] columnNames = {"Time","SEND","RECEIVE","BALANCE"};

  public static void main(String[] args){
    Waffle_Wallet frame = new Waffle_Wallet();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100, 100, 300, 230);
    frame.setTitle("Waffle Wallet");
    frame.setVisible(true);
  }

  Waffle_Wallet(){
    tabbedpane = new JTabbedPane();

    int width = 300;
    JPanel tabPanel1 = new JPanel();
    FlowLayout firstTabFlowLayout = new FlowLayout(FlowLayout.LEFT);
    firstTabFlowLayout.setVgap(8);
    firstTabFlowLayout.setHgap(5);
    tabPanel1.setLayout(firstTabFlowLayout);
    tabPanel1.add(new JLabel("ID:   "));
    tabPanel1.add(new JTextField(20));
    tabPanel1.add(this.createSeparator(width, 0));
    tabPanel1.add(new JLabel("BTC:"));
    tabPanel1.add(new JTextField(10));
    tabPanel1.add(new JLabel("BTC"));
    tabPanel1.add(this.createSeparator(width, 0));


    JPanel firstTabEndPanel = new JPanel();
    firstTabEndPanel.setLayout(new FlowLayout());
    firstTabEndPanel.setPreferredSize(new Dimension(width - 30, 500));
    firstTabEndPanel.add(new JButton("SEND"));
    tabPanel1.add(firstTabEndPanel);


    JPanel tabPanel2 = new JPanel();

    JTable table = new JTable(tabledata,columnNames);
    JScrollPane sp = new JScrollPane(table);
    sp.setPreferredSize(new Dimension(275,150));
    tabPanel2.add(sp);

    tabbedpane.addTab("SEND", tabPanel1);
    tabbedpane.addTab("HISTORY", tabPanel2);

    getContentPane().add(tabbedpane, BorderLayout.CENTER);

  }

    private JSeparator createSeparator(int width, int hight) {
    JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
    separator.setPreferredSize(new Dimension(width, hight));
    return separator;
  }
}