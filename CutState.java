package GUIApp;

public class CutState extends State {
  StateManager stateManager;

  public CutState(){}

  public CutState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  public void mouseDown(int x,int y){
    MyDrawing d = stateManager.mediator.getSelectedDrawing();
    if (d.contains(x, y)){
      stateManager.mediator.cut();
    }
  }

  public void mouseUp(int x,int y){

  };
  public void mouseDrag(int x,int y){

  };
}
