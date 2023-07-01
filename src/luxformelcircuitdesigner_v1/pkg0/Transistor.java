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
public class Transistor extends Component{
     private Point position;
    
    public Transistor(Point position){
        super(position, "Transistor");
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
        g2D.drawRect(0, 0, position.x, position.y);
        
    }

    @Override
    public String toString() {
        return "Transistor{" + "position=" + position + '}';
    }
    
    
}
