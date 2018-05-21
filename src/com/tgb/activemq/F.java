package com.tgb.activemq;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class F extends JFrame{

	public F() {
        pan p = new pan();
        this.add(p);
    }
    public static void main(String[] args) {
        F fl = new F();
        fl.setSize(400, 400);
        fl.setVisible(true);
        fl.run();
        fl.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    int x, y;
    public void run() {
        int r = 100;
        int angle = 0;
        while (true) {
            x = (int) ((Math.cos(angle * 2) * Math.PI) * r);
            y = (int) ((Math.sin(angle * 2) * Math.PI) * r);
            angle++;
            repaint();
        }
    }
 
    class pan extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
            g.drawLine(200, 200, 200, 250);
            g.drawLine(200, 225, x, y);
            g.drawLine(200, 225, x, y);
            g.drawLine(200, 250, 180, 300);
            g.drawLine(200, 250, 220, 300);
            g.drawOval(175, 150, 50, 50);
        }
    }
}
