/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorations;

import Lists.TwoPointDecoration;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

/**
 *
 * @author luxformel
 */
public class CurrentArrow extends TwoPointDecoration{

    private Point position1, position2;

    public CurrentArrow(Point position1, Point position2) {
        super(position1, position2);
        // finds the most optimal line and draws horizontal or vertical lines depending on the input
        int xDifference = Math.abs(position1.x - position2.x);
        int yDifference = Math.abs(position1.y - position2.y);
        if (xDifference < yDifference) {
            this.position1 = new Point(position1.x, position1.y);
            this.position2 = new Point(position1.x, position2.y);
        }else if (xDifference > yDifference) {
            this.position1 = new Point(position1.x, position1.y);
            this.position2 = new Point(position2.x, position1.y);
        }
    }
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.RED); 
        // Antialiasing
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // draws the pointy bit
        
        if (position1.x > position2.x) {
            // arrow should be drawn from right to left
            // triangle
            Path2D.Double currentArrow = new Path2D.Double();
           
            currentArrow.moveTo(position2.x, position1.y - 10);
            currentArrow.lineTo(position2.x - 10, position1.y);
            currentArrow.lineTo(position2.x, position1.y + 10);
            g2D.draw(currentArrow);
            
        }else if (position1.x < position2.x) {
            // arrow should be drawn from letf to right
            // triangle
            Path2D.Double currentArrow = new Path2D.Double();
           
            currentArrow.moveTo(position2.x, position1.y + 10);
            currentArrow.lineTo(position2.x + 10, position1.y);
            currentArrow.lineTo(position2.x, position1.y - 10);
            g2D.draw(currentArrow);
        }else if (position1.y > position2.y) {
            // arrow should be drawn from bottom to top
            // triangle
            Path2D.Double currentArrow = new Path2D.Double();
           
            currentArrow.moveTo(position2.x - 10, position2.y);
            currentArrow.lineTo(position2.x, position2.y - 10);
            currentArrow.lineTo(position2.x + 10, position2.y);
            g2D.draw(currentArrow);
        }else if (position1.y < position2.y) {
            // line was drawn from top to bottom
            // triangle
            Path2D.Double currentArrow = new Path2D.Double();
           
            currentArrow.moveTo(position2.x - 10, position2.y);
            currentArrow.lineTo(position2.x, position2.y + 10);
            currentArrow.lineTo(position2.x + 10, position2.y);
            g2D.draw(currentArrow);
        }
    }
    
}
