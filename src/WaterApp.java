package src;


import javax.swing.event.*; 
import java.awt.*; 
import javax.swing.*; 
  

import java.awt.FlowLayout;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.io.IOException;

class WaterApp extends JFrame { 
  
    // frame 
    static JFrame f; 
  
    // text areas 
    static JTextArea t1, t2; 

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void readfile(){
        try {
            File myObj = new File("output.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    // main class 
    public static void main(String[] args) 
    { 
        // create a new frame 
        f = new JFrame("frame"); 

  
        // create a object 
        WaterApp s = new WaterApp(); 
  
        // create a panel 
        JPanel p1 = new JPanel(); 
        JPanel p = new JPanel(); 
  
        // create text areas 
        t1 = new JTextArea(40, 20); 
        t2 = new JTextArea(40, 100); 

  JScrollPane sp1 = new JScrollPane(t1); 
  JScrollPane sp2 = new JScrollPane(t2); 
  
        // set texts 
        t1.setText("this is first text area"); 
        t2.setText("this is second text area"); 
  
        // add text area to panel 
        p1.add(sp1); 
        p.add(sp2); 
  
        // create a splitpane 
        JSplitPane sl = new JSplitPane(SwingConstants.VERTICAL, p1, p); 
  
        // set Orientation for slider 
        sl.setOrientation(SwingConstants.VERTICAL); 
  
        // add panel 
        f.add(sl); 
  
        // set the size of frame 
        f.setSize(300, 300); 
    
        f.show(); 

        
         f.setVisible(true);
    f.setExtendedState(f.getExtendedState() | JFrame.MAXIMIZED_BOTH);


        readfile();
    } 
} 