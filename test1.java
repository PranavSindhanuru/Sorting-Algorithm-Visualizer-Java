import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;

class test1 extends JPanel {

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // draw the rectangle here
    //   g.drawRect(10, 10, 50, 100);
        int x = 10, y = 10;
        g.fillRect(x, y, 50, 200);
        x += 20;
        repaint();
        x += 40;
        repaint();
   }

   @Override
   public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(500, 500);
   }

   // create the GUI explicitly on the Swing event thread
   private static void createAndShowGui() {
      test1 mainPanel = new test1();

      JFrame frame = new JFrame("Visualizer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}