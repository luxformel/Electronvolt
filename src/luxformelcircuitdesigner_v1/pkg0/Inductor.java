/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author luxformel 
 */
public class Inductor extends Component{
    private Point position;
    
    public Inductor(Point position){
        super(position, "Spule");
         this.position = position;
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
        // draws the body of the resistor
        //g.drawRect(position.x - 10, position.y - 30, 21, 61);
        g2D.drawArc(position.x - 10, position.y - 30, 20, 20, 90, 180);
        g2D.drawArc(position.x - 10, position.y - 10, 20, 20, 90, 180);
        g2D.drawArc(position.x - 10, position.y + 10, 20, 20, 90, 180);
        // draws the lines to connect the components
        g2D.drawLine(position.x, position.y - 30, position.x, position.y - 50);    
        g2D.drawLine(position.x, position.y + 31, position.x, position.y + 50);
    }

    @Override
    public String toString() {
        return "Inductor{" + "position=" + position + '}';
    }

    
}
