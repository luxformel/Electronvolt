/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class Components {
    
    private ArrayList<Component> alComponents = new ArrayList<>();
    private Color color;
    
    public void add(Component component){
        alComponents.add(component);
    }
    public void remove(Component component){
        alComponents.remove(component);
    }
    public void clear(){
        alComponents.clear();
    }
    
    public Component get(int index){
        return alComponents.get(index);
    }

    public Object[] toArray() {
        return alComponents.toArray();
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < alComponents.size(); i++) {
            alComponents.get(i).draw(g);            
        }
    }
    
}
