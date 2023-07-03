/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Electronvolt;

import Components.Amperemeter;
import Lists.StackItem;
import Lists.ConnectionPoints;
import Lists.Component;
import Lists.Components;
import Lists.Wire;
import Lists.Wires;
import Components.Transistor;
import Components.Resistor;
import Components.Inductor;
import Components.LightBulb;
import Components.Diode;
import Components.Battery;
import Components.Capacitor;
import Components.OLDInductor;
import Components.ACGenerator;
import Components.ACPowerSource;
import Components.Switch;
import Components.ToggleSwitch;
import Components.Transformer;
import Components.Connector;
import Components.DCMotor;
import Components.DCGenerator;
import Components.Highpass;
import Components.Lowpass;
import Components.LED;
import Components.Potentiometer;
import Components.Voltmeter;
import Components.Wattmeter;
import Decorations.Dot;
import Decorations.HighLightCircle;
import Decorations.Text;
import Lists.PointDecoration;
import Lists.PointDecorations;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


/**
 *
 * @author luxformel
 */

public class MainFrame extends javax.swing.JFrame {
    
    private Components components = new Components();
    private Wires wires = new Wires();
    private PointDecorations pointDecorationsList = new PointDecorations();
    private ImageGenerator imagegenerator;
    private Point position;
    private Point connection1 = new Point();
    private Point connection2 = new Point();
    private int mousePressedCounter = 0;
    private Stack redoStack = new Stack();
    private Stack undoStack = new Stack();
    /**
     * Creates new form MainFrame
     */
    // Declares the tree view
    DefaultTreeModel model;
       
    public MainFrame() {
        initComponents();
        loadJTree();
        loadComboBox();
        textTextField.setText("");
        jtextSizeSpinner.setValue(20);
        setTitle("Electronvolt");
        jComponentRadioButton.setSelected(true);
        drawPanel.setComponents(components);
        drawPanel.setWires(wires);
        drawPanel.setPointDecorationsList(pointDecorationsList);
        componentsList.setListData(components.toArray());
        
        //Logo
        final ImageIcon icon = new ImageIcon("Icon.png");
        setIconImage(icon.getImage()); //change icon of frame
        //this.getContentPane().setBackground(new Color(0x123456)); //change color of background }
    }
    
    public void updateView(){
        drawPanel.setComponents(components);
        drawPanel.setWires(wires);
        drawPanel.setPointDecorationsList(pointDecorationsList);
        componentsList.setListData(components.toArray());
        repaint();
    }
    
    public void loadComboBox(){
        UIManager.LookAndFeelInfo[] lafInfo = UIManager.getInstalledLookAndFeels();
        
        String name;
        String[] names = new String[lafInfo.length];
        for (int i = 0; i < lafInfo.length; i++) {
            name = lafInfo[i].getName();
            names[i] = name;
            System.out.println(name);
        }
        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(names));
    }
    
    DefaultMutableTreeNode componentNode2 = new DefaultMutableTreeNode("Bauteile");
    
    public void loadJTree(){
        DefaultMutableTreeNode componentNode = new DefaultMutableTreeNode("Bauteile");
        componentNode.add(new DefaultMutableTreeNode("Widerstand"));
        componentNode.add(new DefaultMutableTreeNode("Diode"));
        componentNode.add(new DefaultMutableTreeNode("Spule"));
        componentNode.add(new DefaultMutableTreeNode("Kondensator"));
        componentNode.add(new DefaultMutableTreeNode("Transistor"));
        componentNode.add(new DefaultMutableTreeNode("Transformator"));
        componentNode.add(new DefaultMutableTreeNode("Potentiometer"));
        
        DefaultMutableTreeNode lightNodes = new DefaultMutableTreeNode("Lichtquellen");
        lightNodes.add(new DefaultMutableTreeNode("Glühlampe"));
        lightNodes.add(new DefaultMutableTreeNode("LED"));
             
        DefaultMutableTreeNode switchesNode = new DefaultMutableTreeNode("Schalter");
        switchesNode.add(new DefaultMutableTreeNode("Schalter"));
        switchesNode.add(new DefaultMutableTreeNode("Umschalter"));
        
        DefaultMutableTreeNode powerSourceNode = new DefaultMutableTreeNode("Spannungsquellen");
        powerSourceNode.add(new DefaultMutableTreeNode("Batterie"));
        powerSourceNode.add(new DefaultMutableTreeNode("Wechselspannungsquelle"));
        powerSourceNode.add(new DefaultMutableTreeNode("Wechselspannungsgenerator"));
        powerSourceNode.add(new DefaultMutableTreeNode("Gleichspannungsgenerator"));
        
        DefaultMutableTreeNode oldComponentNode = new DefaultMutableTreeNode("Veraltet Schreibweisen");
        oldComponentNode.add(new DefaultMutableTreeNode("Inductor"));
        
        DefaultMutableTreeNode connectorNode = new DefaultMutableTreeNode("Anschlüsse");
        connectorNode.add(new DefaultMutableTreeNode("Anschluss"));
        
        DefaultMutableTreeNode mechanicalComponentsNode = new DefaultMutableTreeNode("Mechanische Bauteile");
        mechanicalComponentsNode.add(new DefaultMutableTreeNode("Gleichstrom-Motor"));
        
        DefaultMutableTreeNode filterNodes = new DefaultMutableTreeNode("Filterschaltungen");
        filterNodes.add(new DefaultMutableTreeNode("Hochpass"));
        filterNodes.add(new DefaultMutableTreeNode("Tiefpass"));
        
        DefaultMutableTreeNode measuringDeviceNode = new DefaultMutableTreeNode("Messgeräte");
        measuringDeviceNode.add(new DefaultMutableTreeNode("Amperemeter"));
        measuringDeviceNode.add(new DefaultMutableTreeNode("Voltmeter"));
        measuringDeviceNode.add(new DefaultMutableTreeNode("Wattmeter"));
        
        componentNode2.add(componentNode);
        componentNode2.add(switchesNode);
        componentNode2.add(powerSourceNode);
        componentNode2.add(oldComponentNode);
        componentNode2.add(connectorNode);
        componentNode2.add(lightNodes);
        componentNode2.add(mechanicalComponentsNode);
        componentNode2.add(measuringDeviceNode);
        componentNode2.add(filterNodes);
        
        model = (DefaultTreeModel)jTree.getModel();
        model.setRoot(componentNode2);
        jTree.setModel(model);
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jDialog1 = new javax.swing.JDialog();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        drawButtonGroup = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree = new javax.swing.JTree();
        drawPanel = new Electronvolt.DrawPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        componentsList = new javax.swing.JList();
        jThemeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        deleteSelectedComponentButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCurrentRadioButton = new javax.swing.JRadioButton();
        jVoltageRadioButton = new javax.swing.JRadioButton();
        jDotConnectionRadioButton = new javax.swing.JRadioButton();
        jComponentRadioButton = new javax.swing.JRadioButton();
        highLightSelectedComponentButton = new javax.swing.JButton();
        jTextRadioButton = new javax.swing.JRadioButton();
        textTextField = new javax.swing.JTextField();
        jtextSizeSpinner = new javax.swing.JSpinner();
        jMenuBar = new javax.swing.JMenuBar();
        jFileMenu = new javax.swing.JMenu();
        jExportMenuItem = new javax.swing.JMenuItem();
        jDeleteAllMenuItem = new javax.swing.JMenuItem();
        jEditMenu = new javax.swing.JMenu();
        jRedoMenuItem = new javax.swing.JMenuItem();
        jUndoMenuItem = new javax.swing.JMenuItem();
        jHelpMenu = new javax.swing.JMenu();
        jHowToUseMenuItem = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane2.setViewportView(jTree);

        drawPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                drawPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout drawPanelLayout = new javax.swing.GroupLayout(drawPanel);
        drawPanel.setLayout(drawPanelLayout);
        drawPanelLayout.setHorizontalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1171, Short.MAX_VALUE)
        );
        drawPanelLayout.setVerticalGroup(
            drawPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Electronvolt");

        componentsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        componentsList.setNextFocusableComponent(componentsList);
        jScrollPane3.setViewportView(componentsList);

        jThemeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Windows", " " }));
        jThemeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jThemeComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Change Look and Feel:");

        deleteSelectedComponentButton.setText("Delete Selected Component");
        deleteSelectedComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSelectedComponentButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Zeichnungsauswahl:");

        drawButtonGroup.add(jCurrentRadioButton);
        jCurrentRadioButton.setText("Strompfeil");

        drawButtonGroup.add(jVoltageRadioButton);
        jVoltageRadioButton.setText("Spannungspfeil");

        drawButtonGroup.add(jDotConnectionRadioButton);
        jDotConnectionRadioButton.setText("Verbindung");

        drawButtonGroup.add(jComponentRadioButton);
        jComponentRadioButton.setText("Bauteile");

        highLightSelectedComponentButton.setText("Hightlight selected component");
        highLightSelectedComponentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highLightSelectedComponentButtonActionPerformed(evt);
            }
        });

        drawButtonGroup.add(jTextRadioButton);
        jTextRadioButton.setText("Text");

        textTextField.setText("jTextField1");

        jFileMenu.setText("File");

        jExportMenuItem.setText("Export");
        jExportMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExportMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jExportMenuItem);

        jDeleteAllMenuItem.setText("Delete All");
        jDeleteAllMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDeleteAllMenuItemActionPerformed(evt);
            }
        });
        jFileMenu.add(jDeleteAllMenuItem);

        jMenuBar.add(jFileMenu);

        jEditMenu.setText("Edit");

        jRedoMenuItem.setText("Redo");
        jRedoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRedoMenuItemActionPerformed(evt);
            }
        });
        jEditMenu.add(jRedoMenuItem);

        jUndoMenuItem.setText("Undo");
        jUndoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUndoMenuItemActionPerformed(evt);
            }
        });
        jEditMenu.add(jUndoMenuItem);

        jMenuBar.add(jEditMenu);

        jHelpMenu.setText("Help");

        jHowToUseMenuItem.setText("How To Use");
        jHowToUseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jHowToUseMenuItemActionPerformed(evt);
            }
        });
        jHelpMenu.add(jHowToUseMenuItem);

        jMenuBar.add(jHelpMenu);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteSelectedComponentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(highLightSelectedComponentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDotConnectionRadioButton)
                            .addComponent(jComponentRadioButton)
                            .addComponent(jCurrentRadioButton)
                            .addComponent(jVoltageRadioButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextRadioButton)
                                .addGap(67, 67, 67)
                                .addComponent(textTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtextSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jComponentRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDotConnectionRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCurrentRadioButton)
                        .addGap(3, 3, 3)
                        .addComponent(jVoltageRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextRadioButton)
                            .addComponent(textTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtextSizeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(drawPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jThemeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(highLightSelectedComponentButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteSelectedComponentButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jExportMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExportMenuItemActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Save Your Circuit as .png");
        
        int response = fileChooser.showSaveDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile != null) {
                // Save button clicked without selecting a file
                String fileName = fileChooser.getSelectedFile().getName();
                File newFile = new File(fileChooser.getCurrentDirectory(), fileName);
                System.out.println("New file: " + newFile.getAbsolutePath());
                
                String path = selectedFile.getAbsolutePath() + ".png";
            
                imagegenerator = new ImageGenerator();
                imagegenerator.exportAsPNG(drawPanel, path);
            }   
        }
    }//GEN-LAST:event_jExportMenuItemActionPerformed

    private void jDeleteAllMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDeleteAllMenuItemActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
                this, 
                "If You continue your sketch will be deleted!",
                "Confirm", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE
        );
        
        if (response == JOptionPane.YES_OPTION) {
            components.clear();
            wires.clear();
            redoStack.clear();
            undoStack.clear();
            pointDecorationsList.clear();
            ConnectionPoints.clear();
        }
        mousePressedCounter = 0;
        updateView();
    }//GEN-LAST:event_jDeleteAllMenuItemActionPerformed

    private void drawPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drawPanelMousePressed
        // TODO add your handling code here:
        int X = evt.getX();
        int Y = evt.getY();
        
        if (jDotConnectionRadioButton.isSelected() && evt.getButton() == MouseEvent.BUTTON1) {
            Dot dot = new Dot(new Point(X, Y));
            pointDecorationsList.add(dot);
            undoStack.push(new StackItem(dot));
        }
        if (jVoltageRadioButton.isSelected() && evt.getButton() == MouseEvent.BUTTON1) {
            
        }
        if (jCurrentRadioButton.isSelected() && evt.getButton() == MouseEvent.BUTTON1) {
            
        }
        if (jTextRadioButton.isSelected() && evt.getButton() == MouseEvent.BUTTON1 && !textTextField.equals("")) {
            Point position = evt.getPoint();
            Text text = new Text(position, textTextField.getText(), (int) jtextSizeSpinner.getValue());
            pointDecorationsList.add(text);
            textTextField.setText("");
            textTextField.requestFocus();
        }
        
        if (jComponentRadioButton.isSelected() && !jTree.isSelectionEmpty() && evt.getButton() == MouseEvent.BUTTON1) {
            
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree.getSelectionPath().getLastPathComponent();
            String selectedComponent = selectedNode.getUserObject().toString();
           

            position = new Point(X, Y);
            Component component;

            // switch statement to check what was selected
            switch (selectedComponent) {
                case "Widerstand":
                    component = new Resistor(position);
                    break;
                case "Spule":
                    component = new Inductor(position);
                    break;
                case "Kondensator":
                    component = new Capacitor(position);
                    break;
                case "Diode":
                    component = new Diode(position);
                    break;
                case "Transistor":
                    component = new Transistor(position);
                    break;  
                case "Glühlampe":
                    component = new LightBulb(position);
                    break;    
                case "Batterie":
                    component = new Battery(position);
                    break;
                case "Inductor":
                    component = new OLDInductor(position);
                    break;
                case "Schalter":
                    component = new Switch(position);
                    break;
                case "Umschalter":
                    component = new ToggleSwitch(position);
                    break;  
                case "Transformator":
                    component = new Transformer(position);
                    break;
                case "Wechselspannungsquelle":
                    component = new ACPowerSource(position);
                    break;    
                case "Wechselspannungsgenerator":
                    component = new ACGenerator(position);
                    break; 
                case "Gleichspannungsgenerator":
                    component = new DCGenerator(position);
                    break;    
                case "Anschluss":
                    component = new Connector(position);
                    break;    
                case "LED":
                    component = new LED(position);
                    break;  
                case "Gleichstrom-Motor":
                    component = new DCMotor(position);
                    break;   
                case "Voltmeter":
                    component = new Voltmeter(position);
                    break;
                case "Amperemeter":
                    component = new Amperemeter(position);
                    break; 
                case "Wattmeter":
                    component = new Wattmeter(position);
                    break;   
                case "Potentiometer":
                    component = new Potentiometer(position);
                    break;
                case "Hochpass":
                    component = new Highpass(position);
                    break; 
                case "Tiefpass":
                    component = new Lowpass(position);
                    break;    
                default:
                    throw new AssertionError(); 
            }
            components.add(component);
            undoStack.push(new StackItem(component)); 
                
        }else if(mousePressedCounter == 1 && evt.getButton() == MouseEvent.BUTTON3){  
            connection2 = new Point(X, Y);
            Wire wire = new Wire(connection1, connection2);
            wires.add(wire);  
            undoStack.push(new StackItem(wire));
            mousePressedCounter = 0;
         
        }else if (mousePressedCounter == 0 && evt.getButton() == MouseEvent.BUTTON3) {
            mousePressedCounter++;
            connection1 = new Point(X, Y);
        }
        updateView();
    }//GEN-LAST:event_drawPanelMousePressed

    private void jThemeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jThemeComboBoxActionPerformed
        // TODO add your handling code here:
        String lookAndFeelName =  String.valueOf(jThemeComboBox.getSelectedItem());
            if (lookAndFeelName != null) {
                for (UIManager.LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
                    if (lookAndFeelName.equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                            SwingUtilities.updateComponentTreeUI(this);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (UnsupportedLookAndFeelException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }       
                }
            }
    }//GEN-LAST:event_jThemeComboBoxActionPerformed

    private void deleteSelectedComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSelectedComponentButtonActionPerformed
        // TODO add your handling code here:
        int index = componentsList.getSelectedIndex();
        if (index != -1 && index < components.size()) {
            Component component = components.get(index);
            redoStack.push(new StackItem(component));
            components.remove(index);
            //Point position = components.get(index).getPosition();
        }
        // HLC = high light circle
        drawPanel.setDrawHLC(false);
        updateView();
    }//GEN-LAST:event_deleteSelectedComponentButtonActionPerformed

    private void jHowToUseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jHowToUseMenuItemActionPerformed
        // TODO add your handling code here:
       HelpFrame helpFrame = new HelpFrame();
       helpFrame.show();
    }//GEN-LAST:event_jHowToUseMenuItemActionPerformed

    private void jRedoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRedoMenuItemActionPerformed
        // TODO add your handling code here:
        if (!redoStack.empty()) {
            StackItem item = (StackItem) redoStack.pop();
            if (item.getIsComponent()) {
                Component component = (Component) item.getComponent();
                components.add(component);
                undoStack.push(new StackItem(component));
            }else if (item.getIsWire()) {
                Wire wire = item.getWire();
                wires.add(wire);
                undoStack.push(new StackItem(wire));
            }else if (item.getIsPointDecoration()) {
                PointDecoration pointDecoration = item.getPointDecoration();
                pointDecorationsList.add(pointDecoration);
                undoStack.push(new StackItem(pointDecoration));
            }
        }
        updateView();
    }//GEN-LAST:event_jRedoMenuItemActionPerformed

    private void jUndoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUndoMenuItemActionPerformed
        // TODO add your handling code here:
        if (!undoStack.empty()) {
            StackItem item = (StackItem) undoStack.pop();
            if (item.getIsComponent()) {
                Component component = item.getComponent();
                components.remove(component);
                redoStack.push(new StackItem(component));
            }else if (item.getIsWire()) {
                Wire wire = item.getWire();
                wires.remove(wire);
                redoStack.push(new StackItem(wire));
            } else if (item.getIsPointDecoration()) {
                PointDecoration pointDecoration = item.getPointDecoration();
                pointDecorationsList.remove(pointDecoration);
                redoStack.push(new StackItem(pointDecoration));
            }
        }
        updateView();
    }//GEN-LAST:event_jUndoMenuItemActionPerformed

    private void highLightSelectedComponentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highLightSelectedComponentButtonActionPerformed
        // TODO add your handling code here:
        int index = componentsList.getSelectedIndex();
        if (index != -1) {
            System.out.println("Index: " + index);
            Point point = components.get(index).getPosition();
            HighLightCircle.setPosition(point);
            drawPanel.setDrawHLC(true);     
        }
        updateView();
        componentsList.setSelectedIndex(index);
    }//GEN-LAST:event_highLightSelectedComponentButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList componentsList;
    private javax.swing.JButton deleteSelectedComponentButton;
    private javax.swing.ButtonGroup drawButtonGroup;
    private Electronvolt.DrawPanel drawPanel;
    private javax.swing.JButton highLightSelectedComponentButton;
    private javax.swing.JRadioButton jComponentRadioButton;
    private javax.swing.JRadioButton jCurrentRadioButton;
    private javax.swing.JMenuItem jDeleteAllMenuItem;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JRadioButton jDotConnectionRadioButton;
    private javax.swing.JMenu jEditMenu;
    private javax.swing.JMenuItem jExportMenuItem;
    private javax.swing.JMenu jFileMenu;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JMenu jHelpMenu;
    private javax.swing.JMenuItem jHowToUseMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jRedoMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton jTextRadioButton;
    private javax.swing.JComboBox<String> jThemeComboBox;
    private javax.swing.JTree jTree;
    private javax.swing.JMenuItem jUndoMenuItem;
    private javax.swing.JRadioButton jVoltageRadioButton;
    private javax.swing.JSpinner jtextSizeSpinner;
    private javax.swing.JTextField textTextField;
    // End of variables declaration//GEN-END:variables
}
