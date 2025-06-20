package GUIApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;

public class OvalButton extends JButton{
  StateManager stateManager;

  public OvalButton(StateManager stateManager){
    super("円");

    addActionListener(new OvalListener());

    this.stateManager = stateManager;
  }

  class OvalListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new OvalState(stateManager));
    }
  }
}
