package GUIApp;

public class StateManager{
  State state = new State();
  Mediator mediator;

  public StateManager(Mediator mediator){
    this.mediator = mediator;
  }

  public void addDrawing(MyDrawing d){
    mediator.addDrawing(d);
  }

  public void setState(State state){
    this.state = state;
  }

  public void mouseUp (int x,int y) throws Exception{
    this.state.mouseUp(x, y);
  }

  public void mouseDown (int x,int y) throws Exception{
    this.state.mouseDown(x, y);
  }

  public void mouseDrag(int x,int y) throws Exception{
    this.state.mouseDrag(x, y);
  }

  public void mouseMoved(int x,int y) throws Exception{
    this.state.mouseMoved(x, y);
  }

  public void repaint(){
    this.mediator.repaint();
  }
}
