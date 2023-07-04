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

/**
 *
 * @author luxformel
 */
public class VoltageArrow extends TwoPointDecoration{
    private Point position1, position2;

    public VoltageArrow(Point position1, Point position2) {
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
        g2D.setColor(Color.BLUE);
        
        g2D.drawLine(position1.x, position1.y, position2.x, position2.y);
        
        // Antialiasing
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // draws the pointy bit
        
        if (position1.x > position2.x) {
            // line was drawn from right to left
            // triangle
            int[] xPoints = {position2.x - 2, position2.x + 5, position2.x + 5};
            int[] yPoints = {position2.y, position2.y - 5, position2.y + 5};
            g2D.drawPolygon(xPoints, yPoints, 3);
        }else if (position1.x < position2.x) {
            // line was drawn from left to right 
            // triangle
            int[] xPoints = {position2.x + 2, position2.x - 5, position2.x - 5};
            int[] yPoints = {position2.y, position2.y - 5, position2.y + 5};
            g2D.drawPolygon(xPoints, yPoints, 3);
        }else if (position1.y > position2.y) {
            // line was drawn from bottom to top
            // triangle
            int[] xPoints = {position2.x, position2.x - 5, position2.x + 5};
            int[] yPoints = {position2.y - 2, position2.y + 5, position2.y + 5};
            g2D.drawPolygon(xPoints, yPoints, 3);
        }else if (position1.y < position2.y) {
            // line was drawn from top to bottom
            // triangle
            int[] xPoints = {position2.x, position2.x - 5, position2.x + 5};
            int[] yPoints = {position2.y + 2, position2.y - 5, position2.y - 5};
            g2D.drawPolygon(xPoints, yPoints, 3);
        }
    }
    
}
