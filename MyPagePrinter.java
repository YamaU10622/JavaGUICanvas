package GUIApp;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.awt.print.PageFormat;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Vector;

public class MyPagePrinter implements Printable{
  StateManager stateManager;
  Enumeration<MyDrawing> drawingsElements;

  public MyPagePrinter(StateManager stateManager){
    this.stateManager = stateManager;
  }
  
  public int print(Graphics g, PageFormat fmt, int pageIndex) {
  if (pageIndex >= 1) {  
    return NO_SUCH_PAGE;
  }
  else{
  Enumeration<MyDrawing> drawingsElements = stateManager.mediator.drawingsElements();
  while (drawingsElements.hasMoreElements()) {
    MyDrawing d = drawingsElements.nextElement();
    d.draw(g);
  }
    return PAGE_EXISTS;
  }
  }
}