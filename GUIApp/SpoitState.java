package GUIApp;
import java.awt.*;

public class SpoitState extends State {
  StateManager stateManager;
  public SpoitState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y) throws Exception{
    PointerInfo pi = MouseInfo.getPointerInfo();
    Point point = pi.getLocation();
    int X = (int)point.getX();
    int Y = (int)point.getY();

    Robot robot = new Robot();
    Color spoitcolor = robot.getPixelColor(X, Y);
    
    MyDrawing selectedDrawing = stateManager.mediator.getSelectedDrawing();
    selectedDrawing.setFillColor(spoitcolor);
    stateManager.mediator.canvas.repaint();
  }
}
