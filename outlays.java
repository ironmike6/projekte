import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class outlays extends JPanel {

    int value[] = {38,20,18,15,7,2};
    String[] label = {"social security and medicare: 38%", "national defense: 20%", "social programs: 18%", "interest on national debt: 15%", "human and community development: 7%", "general government: 2%"};
    int start = 90;
    int xpos = 100;
    int sum = 0;  
    Color[] colors = {Color.green, Color.blue, Color.black, Color.gray, Color.orange, Color.cyan};
    
    public outlays() {   
        for(int k = 0; k < value.length; k++)
        {        
        	sum += value[k];
        }    
    }

    public void paintComponent(Graphics g)  {
    	
        for(int i = 0; i < value.length; i++) {
            g.setColor(colors[i%colors.length]);
            g.fillArc(10, 10, 360, 360, start, -(value[i]*360)/sum-3);
            g.drawString(label[i], 380, xpos += 15);
            start = start -(value[i]*360)/sum;
        }
    }

    public static void main(String args[]) {
        JFrame f = new JFrame("Outlays");
        
        outlays p = new outlays();

        f.add(p);
        p.setPreferredSize(new Dimension(600, 500));
        f.pack();
        f.setVisible(true);
    }
}
