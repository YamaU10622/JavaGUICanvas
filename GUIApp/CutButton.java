package GUIApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;


public class CutButton extends JButton{
  StateManager stateManager;

  public CutButton(StateManager stateManager){
    super("切り取り");

    addActionListener(new CutListener());

    this.stateManager = stateManager;
  }

  class CutListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new CutState(stateManager));
    }
  }
}
