package GUIApp;

public class SelectState extends State {
  StateManager stateManager;
  int prevX, prevY;
  MyDrawing selected = null;

  public SelectState(StateManager stateManager){
    this.stateManager = stateManager;
  }

  @Override
  public void mouseDown(int x, int y){
    stateManager.mediator.setSelected(x, y);
    selected = stateManager.mediator.getSelectedDrawing();
    prevX = x;
    prevY = y;
  }

  @Override
  public void mouseDrag(int x, int y){
    if (selected != null) {
      int dx = x - prevX;
      int dy = y - prevY;
      selected.move(dx, dy);
      prevX = x;
      prevY = y;
      stateManager.mediator.repaint();
    }
  }

  @Override
  public void mouseUp(int x, int y){
    selected = null;
  }
}