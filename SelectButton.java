package GUIApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;


public class SelectButton extends JButton{
  StateManager stateManager;

  public SelectButton(StateManager stateManager){
    super("選択");

    addActionListener(new SelectListener());

    this.stateManager = stateManager;
  }

  class SelectListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new SelectState(stateManager));
    }
  }
}
