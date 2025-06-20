package GUIApp;

import java.lang.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.xml.crypto.Data;

public class MyApplication extends JFrame implements ActionListener{
  
  JComboBox fillColorComboBox,lineColorComboBox,AlphaValueComboBox,isShadowedComboBox,MouseDragComboBox;

  JTextField jt = new JTextField(5);

  MyCanvas canvas = new MyCanvas();
  Mediator mediator = canvas.mediator;
  StateManager stateManager = new StateManager(mediator);

  public MyApplication(){
    super("キャンバスアプリ");

    JPanel jp = new JPanel();
    jp.setLayout(new FlowLayout());

    RectButton rectButton = new RectButton(stateManager);
    jp.add(rectButton);
    OvalButton ovalButton = new OvalButton(stateManager);
    jp.add(ovalButton);
    SelectButton selectButton = new SelectButton(stateManager);
    jp.add(selectButton);
    DeleteButton deleteButton = new DeleteButton(stateManager);
    jp.add(deleteButton);
    CopyButton copyButton = new CopyButton(stateManager);
    jp.add(copyButton);
    CutButton cutButton = new CutButton(stateManager);
    jp.add(cutButton);
    PasteButton pasteButton = new PasteButton(stateManager);
    jp.add(pasteButton);
  
    String[] fillColorcombdata = {"赤","青","緑","黄","その他の色","スポイト"};
    this.fillColorComboBox = new JComboBox<>(fillColorcombdata);
    JLabel filllabel = new JLabel("塗りつぶしの色");
    jp.add(filllabel);
    jp.add(fillColorComboBox);
    fillColorComboBox.addActionListener(this);

    String[] lineColorcombdata = {"赤","青","緑","黄","その他の色"};
    this.lineColorComboBox = new JComboBox<>(lineColorcombdata);
    JLabel colorlabel = new JLabel("枠線の色");
    jp.add(colorlabel);
    jp.add(lineColorComboBox);
    lineColorComboBox.addActionListener(this);

    Integer[] AlphaValuecombdata = {250,200,150,100,50,0};
    this.AlphaValueComboBox = new JComboBox<>(AlphaValuecombdata);
    JLabel Alphalabel = new JLabel("透過度");
    jp.add(Alphalabel);
    jp.add(AlphaValueComboBox);
    AlphaValueComboBox.addActionListener(this);

    JLabel lwLabel = new JLabel("枠線の太さ(デフォルト1)"); 
    jp.add(lwLabel);
    jp.add(jt);
    JButton setButton = new JButton("セット");
    jp.add(setButton);
    setButton.addActionListener(this); 

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(jp,BorderLayout.NORTH);
    getContentPane().add(canvas,BorderLayout.CENTER);
    

    canvas.addMouseListener (new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        try {
          stateManager.mouseDown(e.getX(), e.getY());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

      public void mouseReleased(MouseEvent e) {
        try {
          stateManager.mouseUp(e.getX(), e.getY());
        } catch (Exception ex) {
          ex.printStackTrace();
        }
        }
      }
      );

    canvas.addMouseMotionListener(new MouseMotionAdapter(){
      private MouseEvent preEvent;
      
        public void mouseDragged(MouseEvent e) {
          try {
            stateManager.mouseDrag(e.getX(), e.getY());
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      
      public void mouseMoved(MouseEvent e){
      try{
        stateManager.mouseMoved(e.getX(), e.getY());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
      }
    });

    
    canvas.addKeyListener(new KeyAdapter() {
      @Override
      public void keyTyped(KeyEvent e){
        MyDrawing d = mediator.getSelectedDrawing();
        switch (e.getKeyCode()) {
          case KeyEvent.VK_C:
            mediator.copy();
          break;
          case KeyEvent.VK_P:
            mediator.paste(d.getX()+5, d.getY()+5);
            canvas.repaint();
          break;
        }
      }
      @Override
      public void keyReleased(KeyEvent e){}
      @Override
      public void keyPressed(KeyEvent e){}
    });

    this.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e){
        System.exit(0);
      }
    });
  }

  public void actionPerformed(ActionEvent e){
    Object fillcolor = this.fillColorComboBox.getSelectedItem();
    if (fillcolor == "赤"){
      mediator.setFillColor(Color.red); 
    }
    else if(fillcolor == "青"){
      mediator.setFillColor(Color.blue);
    }
    else if(fillcolor == "緑"){
      mediator.setFillColor(Color.green);
    }
    else if(fillcolor == "黄"){
      mediator.setFillColor(Color.yellow);
    }
    else if(fillcolor == "その他の色"){
      JColorChooser jColorChooser = new JColorChooser();
      JPanel jPanel = new JPanel();
      getContentPane().add(jColorChooser,BorderLayout.CENTER);
      Color color = jColorChooser.showDialog(null,"JColorChooser",Color.white);
      mediator.setFillColor(color);
    }
    else if(fillcolor == "スポイト"){
      stateManager.setState(new SpoitState(stateManager));
    }

    Object linecolor = this.lineColorComboBox.getSelectedItem();
    if (linecolor == "赤"){
      mediator.setLineColor(Color.red); 
    }
    else if(linecolor == "青"){
      mediator.setLineColor(Color.blue);
    }
    else if(linecolor == "緑"){
      mediator.setLineColor(Color.green);
    }
    else if(linecolor == "黄"){
      mediator.setLineColor(Color.yellow);
    }
    else if(linecolor == "その他の色"){
      JColorChooser jColorChooser = new JColorChooser();
      JPanel jPanel = new JPanel();
      getContentPane().add(jColorChooser,BorderLayout.CENTER);
      Color color = jColorChooser.showDialog(null,"JColorChooser",Color.white);
      mediator.setLineColor(color);
    }

    Object alphaValue = this.AlphaValueComboBox.getSelectedItem();
    MyDrawing selectedDrawing = mediator.getSelectedDrawing();

    switch ((int)alphaValue){
      case 0: selectedDrawing.setAlpha(0);
      break;
      case 50: selectedDrawing.setAlpha(50);
      break;
      case 100: selectedDrawing.setAlpha(100);
      break;
      case 150: selectedDrawing.setAlpha(150);
      break;
      case 200: selectedDrawing.setAlpha(200);
      break;
      case 250: selectedDrawing.setAlpha(250);
      break;
    }
  
    String setLineWidth = jt.getText();
    if(setLineWidth == null || setLineWidth.trim().isEmpty()){
      setLineWidth = "1";
    }
    float LineWidth = Float.parseFloat(setLineWidth);
    if (LineWidth!=0){
      MyDrawing d = mediator.getSelectedDrawing();
      d.setLineWidth(LineWidth);
    }
    canvas.repaint();
  }

  public Dimension getPreferredSize(){
    return new Dimension(1700,100);
  }

  public static void main(String[] args){
    MyApplication app = new MyApplication();

    app.pack();
    app.setExtendedState(JFrame.MAXIMIZED_BOTH);
    app.setVisible(true);
    app.setFocusable(true);
    app.requestFocusInWindow();
  }
}
