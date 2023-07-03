/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author luxformel
 */
public class Wire {
    private Point connectionPoint1;
    private Point connectionPoint2;
    
    public Wire(Point connectionPoint1, Point connectionPoint2) {
        this.connectionPoint1 = ConnectionPoints.findColsestPoint(connectionPoint1);
        this.connectionPoint2 = ConnectionPoints.findColsestPoint(connectionPoint2);
    }
    
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.BLACK);
        // Determine horizontal line coordinates
        
        if (connectionPoint1.x < connectionPoint2.x && connectionPoint1.y < connectionPoint2.y) {
            // Horizontal Line
            g2D.drawLine(
                    connectionPoint1.x, 
                    connectionPoint1.y, 
                    connectionPoint2.x, 
                    connectionPoint1.y
            );
            // Vertical Line 
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint1.y, 
                    connectionPoint2.x, 
                    connectionPoint2.y 
            );
        }else if (connectionPoint1.x < connectionPoint2.x && connectionPoint1.y > connectionPoint2.y) {
            // Horizontal Line
            g2D.drawLine(
                    connectionPoint1.x, 
                    connectionPoint1.y, 
                    connectionPoint2.x, 
                    connectionPoint1.y
            );
            // Vertical Line 
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint1.y, 
                    connectionPoint2.x, 
                    connectionPoint2.y
            );
        }else if (connectionPoint1.x > connectionPoint2.x && connectionPoint1.y < connectionPoint2.y) {
            // Horizontal Line
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint1.y, 
                    connectionPoint1.x, 
                    connectionPoint1.y
            );
            // Vertical Line 
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint1.y, 
                    connectionPoint2.x, 
                    connectionPoint2.y
            );
        }else {
            // Horizontal Line
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint1.y, 
                    connectionPoint1.x, 
                    connectionPoint1.y
            );
            // Vertical Line 
            g2D.drawLine(
                    connectionPoint2.x, 
                    connectionPoint2.y, 
                    connectionPoint2.x, 
                    connectionPoint1.y
            );
        }
    }
}
