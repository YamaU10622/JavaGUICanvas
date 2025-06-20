package GUIApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

public class RectButton extends JButton{
  StateManager stateManager;

  public RectButton(StateManager stateManager){
    super("正方形");

    addActionListener(new RectListener());

    this.stateManager = stateManager;
  }

  class RectListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new RectState(stateManager));
    }
  }
}
