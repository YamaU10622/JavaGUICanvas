package GUIApp;
import java.lang.Object;

public class PasteState extends State {
  StateManager stateManager;

  public PasteState(){}

  public PasteState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    stateManager.mediator.paste(x, y);
  }
  
  public void mouseUp(int x,int y){

  }
  public void mouseDrag(int x,int y){

  }
}
