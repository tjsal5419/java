package oop.inherit.ui;

import java.awt.Graphics;
import java.awt.Panel;

public class ChartPanel extends Panel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawLine(200,100,200,900);
		g.drawLine(100,800,900,800);		
		g.drawLine(800,100,800,900);
		g.drawString("0", 190, 100);
	}
}
