/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorations;

import Lists.PointDecoration;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

/**
 *
 * @author luxformel
 */
public class HighLightCircle{
    private static Point position;
    
    public HighLightCircle(Point position){
       this.position = position;
    }

    public static void setPosition(Point position) {
        HighLightCircle.position = position;
    }

    public static void draw(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.MAGENTA);
        // Antialiasing
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // opacity 
        
        // Set the opacity level (0.0f - fully transparent, 1.0f - fully opaque)
        float opacity = 0.5f;
        
        // Create an AlphaComposite object with the specified opacity
        AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        
        // Set the composite to Graphics2D
        g2D.setComposite(alphaComposite);
        
        // draws the dot
        g2D.drawOval(position.x - 30 , position.y - 30, 60, 60);
    }
}
