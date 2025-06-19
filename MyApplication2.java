package GUIApp;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import GUIApp.MyCanvas;

public class MyApplication2 extends JFrame {

  MyCanvas canvas = new MyCanvas();
  
  public MyApplication2(){
    super("Canvas");
    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(canvas,BorderLayout.CENTER);

    this.setLocation(0,100);

    this.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
  }

  public Dimension getPreferredSize(){
    return new Dimension(1700,800);
  } 
}
