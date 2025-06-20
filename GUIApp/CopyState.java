package GUIApp;

public class CopyState extends State {
  StateManager stateManager;

  public CopyState(){}

  public CopyState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    MyDrawing d = stateManager.mediator.getSelectedDrawing();
    if (d.contains(x, y)){
      stateManager.mediator.copy();
    }
  }

  public void mouseUp(int x,int y){

  };
  public void mouseDrag(int x,int y){

  };
}
