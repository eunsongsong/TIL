package chap11.gui.apps;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleMenu
    implements ActionListener, ItemListener {
  private JFrame f;
  private JMenuBar mb;
  private JMenu m1;
  private JMenu m2;
  private JMenu m3;
  private JMenuItem mi1;
  private JMenuItem mi2;
  private JMenuItem mi3;
  private JMenuItem mi4;
  private JCheckBoxMenuItem mi5;

  public void go() {
    f = new JFrame("Menu");
    mb = new JMenuBar();
    m1 = new JMenu("File");
    m2 = new JMenu("Edit");
    m3 = new JMenu("Help");
    mb.add(m1);
    mb.add(m2);
    mb.add(m3);
    f.setJMenuBar(mb);

    mi1 = new JMenuItem("New");
    mi2 = new JMenuItem("Save");
    mi3 = new JMenuItem("Load");
    mi4 = new JMenuItem("Quit");
    mi1.addActionListener(this);
    mi2.addActionListener(this);
    mi3.addActionListener(this);
    mi4.addActionListener(this);
    m1.add(mi1);
    m1.add(mi2);
    m1.add(mi3);
    m1.addSeparator();
    m1.add(mi4);

    mi5 = new JCheckBoxMenuItem("Persistent");
    mi5.addItemListener(this);
    m1.add(mi5);

    f.setSize(200,200);
    f.setVisible(true);
  }

  public void actionPerformed( ActionEvent ae) {
    System.out.println("Button \"" + 
        ae.getActionCommand() + "\" pressed.");

    if (ae.getActionCommand().equals("Quit")) {
      System.exit(0);
    }
  }

  public void itemStateChanged(ItemEvent ie) {
    String state = "deselected";

    if (ie.getStateChange() == ItemEvent.SELECTED) {
      state = "selected";
    }
    System.out.println(ie.getItem() + " " + state);
  }

  public static void main (String args[]) {
    SampleMenu sampleMenu = new SampleMenu();
    sampleMenu.go();
  }
}
