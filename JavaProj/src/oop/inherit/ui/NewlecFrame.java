package oop.inherit.ui;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;


public class NewlecFrame extends Frame {
   
   Panel graphPanel;
   
   public NewlecFrame() {
      graphPanel = new NewlecPanel();
      this.add(graphPanel);
   }
   
}