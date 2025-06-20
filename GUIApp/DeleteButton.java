package GUIApp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;


public class DeleteButton extends JButton{
  StateManager stateManager;

  public DeleteButton(StateManager stateManager){
    super("削除");

    addActionListener(new DeleteListener());

    this.stateManager = stateManager;
  }

  class DeleteListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      stateManager.setState(new DeleteState(stateManager));
    }
  }
}
