package GUIApp;
import java.lang.Object;

public class OvalState extends State {
  StateManager stateManager;

  public OvalState(){}

  public OvalState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    stateManager.addDrawing(new MyOval(x, y));
  }

  public void mouseUp(int x,int y){

  };
  public void mouseDrag(int x,int y){

  };
}
