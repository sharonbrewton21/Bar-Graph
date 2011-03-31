/*
 * Sharon Brewton
 * Umar CSc 2310
 * 3/16/11
 * Project 1: Bar Graph
 */

package project1bargraph;

import jpb.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Width, Height, Data1, Data2, DataN..
         int [] data = new int [args.length - 2];
         int width = Integer.parseInt(args[0]);
         int height = Integer.parseInt(args[1]);

         for(int i = 0; i < data.length; i++){
           data[i] = Integer.parseInt(args[i + 2]);
         }

         int maxHeight = -1;
         for(int i = 0; i < data.length; i++){
             if (data[i] > maxHeight)
                 maxHeight = data[i];
         }

           //Creating the chart
         DrawableFrame df = new DrawableFrame("ChartsProject");
         df.show();
         df.setSize(width, height);

         //Getting graphics context
         Graphics g = df.getGraphicsContext();

         int barWidth = (width  - (data.length + 1) * 5) / data.length;
       
         //looping through the bars
         for(int i = 0; i < data.length; i++){
             double ratio = (double) data[i] / maxHeight;
             int barHeight = (int)(ratio * (height - 20));
             int currentColor = i % 8;
                if(currentColor == 0)
                    g.setColor(Color.orange);
                if(currentColor == 1)
                    g.setColor(Color.pink);
              if(currentColor == 2)
                    g.setColor(Color.red);
                if(currentColor == 3)
                    g.setColor(Color.yellow);
              if(currentColor == 4)
                    g.setColor(Color.blue);
                if(currentColor == 5)
                    g.setColor(Color.green);
              if(currentColor == 6)
                    g.setColor(Color.cyan);
                if(currentColor == 7)
                    g.setColor(Color.magenta);

             int x = i * (5 + barWidth) + 5;
             int y = height - barHeight;
             g.fillRect(x, y, barWidth, barHeight);
           }
        df.repaint();

         
    }

}
