package chap11.gui.apps;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SampleMenu1 {
  private JFrame f;
  private JMenuBar mb;

  public void go() {
    f = new JFrame("MenuBar");
    mb = new JMenuBar();
    f.setJMenuBar(mb);

    f.setSize(200,200);
    f.setVisible(true);
  }

  public static void main (String args[]) {
    SampleMenu1 sampleMenu = new SampleMenu1();
    sampleMenu.go();
  }
}
