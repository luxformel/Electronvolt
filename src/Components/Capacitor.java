/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import Lists.Component;
import Lists.ConnectionPoints;

/**
 *
 * @author luxformel
 */
public class Capacitor extends Component{
    private Point position;
    
    public Capacitor(Point position){
        super(position, "Spule");
         this.position = position;
         
         // creates the connector points
        Point connection1 = new Point(position.x, position.y + 20);
        Point connection2 = new Point(position.x, position.y - 20);
        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.BLACK);
        // draws the plates of the capacitor
        g2D.drawLine(position.x - 20, position.y - 5, position.x + 20, position.y - 5);
        g2D.drawLine(position.x - 20, position.y + 5, position.x + 20, position.y + 5);
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 5, position.x, position.y - 20);
        g2D.drawLine(position.x, position.y + 5, position.x, position.y + 20);
    }

    @Override
    public String toString() {
        return "Kondensator{" + "position=" + position + '}';
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }
    
}
