/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luxformelcircuitdesigner_v1.pkg0;

import java.util.Stack;

/**
 *
 * @author luxformel
 */
public class RedoStack {
    private Stack <StackItem> redoStack = new Stack<StackItem>();
    
    public void push(StackItem deletedItem){
        redoStack.push(deletedItem);
    }
    public void pop(){
        redoStack.pop();
    }

    public Stack<StackItem> getRedoStack() {
        return redoStack;
    }

    

    public void clear(){
        redoStack.clear();
    }
}
