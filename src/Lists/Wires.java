/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lists;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author luxformel
 */
public class Wires {
    private ArrayList<Wire> alWires = new ArrayList<>();
    
    public void add(Wire wire){
        alWires.add(wire);
    }
    public void remove(Wire wire){
        alWires.remove(wire);
    }
    public void clear(){
        alWires.clear();
    }
    public Wire get(int index){
        return alWires.get(index);
    }
    public Object[] toArray() {
        return alWires.toArray();
    }
    public void draw(Graphics g){
        for (int i = 0; i < alWires.size(); i++) {
            alWires.get(i).draw(g);   
        }
    }
}
