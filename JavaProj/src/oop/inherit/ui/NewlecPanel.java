package oop.inherit.ui;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;


public class NewlecPanel extends Panel {
   
   Font myFont;
   
   public NewlecPanel() {
      this.setLayout(new GridLayout());
   }
   
   @Override
   public void paint(Graphics g) {
      super.paint(g);
      myFont = new Font ("바탕", 1, 23);
      g.setFont(myFont);

      g.drawString("인 원(명)",40, 40); // 2
      g.drawString("2",60, 500); // 2
      g.drawString("4",60, 400); // 4
      g.drawString("6",60, 300); // 6
      g.drawString("8",60, 200); // 8
      g.drawString("10",60, 100); // 8

      g.drawString("누적 상대도수(%)",800, 40); // 2
      g.drawString("20",910, 500); // 20
      g.drawString("40",910, 400); // 40
      g.drawString("60",910, 300); // 60
      g.drawString("80",910, 200); // 80
      g.drawString("100",910, 100); // 100

      g.drawLine(50, 600, 950, 600);
      g.setColor(Color.BLUE);
      g.drawLine(100, 650, 100, 50);
      g.setColor(Color.red);
      g.drawLine(900, 650, 900, 50);
      
      
      g.setColor(Color.green);
      drawDottedLine(g, 100, 500);
      drawDottedLine(g, 100, 400);
      drawDottedLine(g, 100, 300);
      drawDottedLine(g, 100, 200);
      drawDottedLine(g, 100, 100);
   }


   public void drawDottedLine(Graphics g, int x, int y){
      for(int i=0;i<800;i+=20)
         g.drawString("-", x+i,y);   
   // 200, 600 �� ����, ������ 200,50 550
      
      /*g.drawLine(150,500,850,500); // 700
      g.drawLine(150,400,850,400);
      g.drawLine(150,300,850,300);
      g.drawLine(150,200,850,200);
      */
      
   }
}
