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
import luxformelcircuitdesigner_v1.pkg0.Component;
import luxformelcircuitdesigner_v1.pkg0.ConnectionPoints;

/**
 *
 * @author luxformel
 */
public class Battery extends Component{
    private Point position;
    
    public Battery(Point position){
        super(position, "Batterie");
        this.position = position;
        
        Point connection1 = new Point(position.x, position.y - 20);
        Point connection2 = new Point(position.x, position.y + 20);
        
        ConnectionPoints.add(connection1);
        ConnectionPoints.add(connection2);
    }
    
    @Override
    public void draw(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(5));
        // draws the plates of the capacitor
        g2D.drawLine(position.x - 20, position.y - 5, position.x + 20, position.y - 5);
        g2D.drawLine(position.x - 10, position.y + 5, position.x + 10, position.y + 5);
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 5, position.x, position.y - 20);
        g2D.drawLine(position.x, position.y + 5, position.x, position.y + 20);
    }

    @Override
    public String toString() {
        return "Batterie{" + "position=" + position + '}';
    }
}
