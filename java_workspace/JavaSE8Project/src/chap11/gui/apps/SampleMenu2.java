package chap11.gui.apps;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleMenu2 {
  private JFrame f;
  private JMenuBar mb;
  private JMenu m1;
  private JMenu m2;
  private JMenu m3;

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

    f.setSize(200,200);
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleMenu2 sampleMenu = new SampleMenu2();
    sampleMenu.go();
  }
}
