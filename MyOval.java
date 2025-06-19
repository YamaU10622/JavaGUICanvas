package GUIApp;
import java.awt.*;

public class MyOval extends MyDrawing{
  public MyOval(int xpt, int ypt){
    Color fillColor = getFillColor();
    super.fillColor = fillColor;
    setLocation(xpt, ypt);
  }

  public void draw(Graphics g){
    super.draw(g);
    int x = getX();
    int y = getY();
    int w = getW();
    int h = getH();
  
    //高さや横幅が負のときのための処理
    if(w<0){
      x+=w;
      w*=-1;
    }
    if(h<0){
      y+=h;
      h*=-1;
    }
  
  Graphics2D g2 = (Graphics2D)g;
  g2.setStroke(new BasicStroke(getLineWidth()));
  g2.setColor(getFillColor());
  g2.fillOval(x, y, w, h);
  g2.setColor(getLineColor());
  g2.drawOval(x, y, w, h);
  // if(this.isRotate){
  //   g2.rotate(Math.PI/3);
  // }
  }
}
