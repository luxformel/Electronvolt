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
import java.awt.RenderingHints;
import luxformelcircuitdesigner_v1.pkg0.Component;
import luxformelcircuitdesigner_v1.pkg0.ConnectionPoints;

/**
 *
 * @author luxformel
 */
public class Switch extends Component{
    private Point position;
    
    public Switch(Point position){
        super(position, "Switch");
        this.position = position;
        
        // creates the connector points
        Point connection1 = new Point(position.x + 45, position.y);
        Point connection2 = new Point(position.x - 30, position.y);
        
        // add the connector Points to the list
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(5));
        g2D.setColor(Color.BLACK);
        // Antialiasing
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2D.drawLine(position.x - 30, position.y, position.x, position.y);
        g2D.drawOval(position.x - 3, position.y - 3, 6, 6);
        g2D.drawLine(position.x, position.y, position.x + 20, position.y - 10);
        g2D.drawLine(position.x + 22, position.y, position.x + 45, position.y);
    }

    @Override
    public String toString() {
        return "Schalter{" + "position=" + position + '}';
    }
}
