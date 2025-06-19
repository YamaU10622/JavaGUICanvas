package GUIApp;

import javax.print.FlavorException;
import java.awt.*;
import java.awt.Rectangle;
import java.io.Serializable;

public class MyDrawing implements Cloneable,Serializable
{
  int x, y, w, h; // X, Y,
  Color lineColor, fillColor; 
  float lineWidth;// 線の太さ
  boolean isSelected = false; // 図形の選択状態
  boolean isDashed;
  boolean isShadowed = false;
  boolean isMove = true;
  boolean isRotate = false;
  Shape region;
  final int SIZE=7;// 選択表示矩形に付くの四角形の大きさ

  // 包含判定用
  public MyDrawing() {
    x = y = 0;
    w = h = 40;
    lineColor = Color.black;
    fillColor = Color.white;
    lineWidth = 1;
    setRegion();
  }

  public MyDrawing(int x,int y,int w,int h,Color lineColor,Color fillColor,int lineWidth,boolean isDashed){
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.lineColor = lineColor;
    this.fillColor = fillColor;
    this.lineWidth = lineWidth;
    this.isDashed = isDashed;
  }

  public void draw(Graphics g) {
    if (isShadowed) {
      MyDrawing d = this.clone();
      d.lineColor = new Color(0,0,0,0);
      d.fillColor = Color.black;
      d.isShadowed = false;
      d.isSelected = false;
      d.move(5, 5);
      d.draw(g);
    }

    if (isSelected) {
      g.setColor(Color.black);
      g.fillRect(x+w/2-SIZE/2, y-SIZE/2, SIZE, SIZE);
      g.fillRect(x-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
      g.fillRect(x+w/2-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
      g.fillRect(x+w-SIZE/2, y+h/2-SIZE/2, SIZE, SIZE);
      g.fillRect(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
      g.fillRect(x+w-SIZE/2, y-SIZE/2, SIZE, SIZE);
      g.fillRect(x-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
      g.fillRect(x+w-SIZE/2, y+h-SIZE/2, SIZE, SIZE);
    }
  }

  public boolean getSelected(){
    return isSelected;
  }

  public void setSelected(boolean isSelected){
    this.isSelected = isSelected;
  }

  @Override
  public MyDrawing clone(){
    MyDrawing b = null;
    try {
      b=(MyDrawing)super.clone();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
    return b;
  }

  public boolean contains(int x,int y){
    return region.contains(x, y);
  }

  public void setRegion(){
    int x = getX();
    int y = getY();
    int w = getW();
    int h = getH();
    this.region = new Rectangle(x,y,w,h);
  };

  public void move(int dx,int dy){
    x += dx;
    y += dy;
    setRegion();
  }

  public void setLocation(int x,int y){
    this.x = x;
    this.y = y;
    setRegion();
  }

  public void setSize(int w,int h){
    this.w = w;
    this.h = h;
    setRegion();
  }

  public void setLineColor(Color c){
    this.lineColor = c;
  }

  public void setLineWidth(float f){
    this.lineWidth = f;
  }

  public void setFillColor(Color c){
    this.fillColor = c;
  }

  public void setAlpha(int alpha){
    lineColor  = getLineColor();
    int r = lineColor.getRed();
    int g = lineColor.getGreen();
    int b = lineColor.getBlue();
    lineColor = new Color(r,g,b,alpha);
    setLineColor(lineColor);

    fillColor  = getFillColor();
    int R = fillColor.getRed();
    int G = fillColor.getGreen();
    int B = fillColor.getBlue();
    fillColor = new Color(R,G,B,alpha);
    setFillColor(fillColor);
  }

  public void setDashed(boolean isDashed){
    this.isDashed = isDashed;
  }

  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  public int getW(){
    return w;
  }

  public int getH(){
    return h;
  }

  public float getLineWidth(){
    return lineWidth;
  }

  public Color getLineColor(){
    return lineColor;
  }

  public Color getFillColor(){
    return fillColor;
  }

  public boolean getDashed(){
    return isDashed;
  }
}
