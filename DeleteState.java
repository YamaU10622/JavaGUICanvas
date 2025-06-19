package GUIApp;
import java.lang.Object;

public class DeleteState extends State {
  StateManager stateManager;

  public DeleteState(){}

  public DeleteState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    Mediator mediator = stateManager.mediator;
    MyDrawing d = mediator.getSelectedDrawing();
    mediator.removeDrawing(d);
  }

  public void mouseUp(int x,int y){

  };
  public void mouseDrag(int x,int y){

  };
}
