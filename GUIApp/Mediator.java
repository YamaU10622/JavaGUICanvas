package GUIApp;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Mediator
{
  Vector<MyDrawing> drawings;
  MyCanvas canvas;
  MyDrawing selectedDrawing;
  MyDrawing buffer = null;

  public Mediator (MyCanvas canvas) {
    this.canvas = canvas;
    drawings = new Vector<MyDrawing>();
  }

  public Enumeration<MyDrawing> drawingsElements() {
    return drawings.elements();
  }

  public void addDrawing (MyDrawing d) {
    drawings.add(d);
    canvas.repaint();
  }

  public void removeDrawing (MyDrawing d) {
    drawings.remove(d);
    canvas.repaint();
  }

  public MyDrawing getSelectedDrawing() {
    return selectedDrawing;
  }

  public void setSelectedDrawing(MyDrawing d) {
    this.selectedDrawing = d;
    d.setSelected(true);
    canvas.repaint();
  }

  public void setFillColor(Color color){
    MyDrawing d = getSelectedDrawing();
    if (d != null){
      d.setFillColor(color);
      canvas.repaint();
    }
  }

  public void setLineColor(Color color){
    MyDrawing d = getSelectedDrawing();
    if (d != null){
      System.out.println("Mediator/setColor/selectedDrawing is "+d);
      d.setLineColor(color);
      canvas.repaint();
    }
  }

  public void move(int dx, int dy) {
    if (selectedDrawing != null)
    selectedDrawing.move(dx, dy);
  }

  public void repaint(){
    canvas.repaint();
  }

  public void setSelected(int x,int y){
    Enumeration<MyDrawing> drawingElements = this.drawingsElements();
    while (drawingElements.hasMoreElements()) {
      MyDrawing d = drawingElements.nextElement();
      if (d != null){
        if (d.contains(x,y)){
            setSelectedDrawing(d);
          }
        else{
          d.setSelected(false);
          }
        }
      }
    } 

  public void clearBuffer(){
    buffer = null;
  }

  public void copy(){
    clearBuffer();
    buffer = selectedDrawing.clone();
  }

  public void cut(){
    clearBuffer();
    buffer = selectedDrawing.clone();
    removeDrawing(selectedDrawing);
  }

  public void paste(int x, int y){
    MyDrawing clone = (MyDrawing)buffer.clone();
    clone.setSelected(false);
    clone.setLocation(x, y);
    addDrawing(clone);
    this.repaint();
  }
}  