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
import java.io.FileWriter;  

import java.awt.event.*;  
import javax.swing.*;    

class WaterApp extends JFrame { 
  
    // frame 
    static JFrame f; 
  
    // text areas 
    static JTextArea t1, t2; 

    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void readFile(String filePath){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                t2.setText(data); 
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    //---------------------------------------------------------
    // read the output.txt file, which holds compiler&program output
    //---------------------------------------------------------
    public static void readOutputFile(){
        try {
            File myObj = new File("output.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                t1.setText(data); 
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
    public static void saveFile(String filePath){

            try {
                FileWriter myWriter = new FileWriter(filePath);
                myWriter.write(t2.getText());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

    }   


    //---------------------------------------------------------
    // saves the code that user writes in the textbox
    //---------------------------------------------------------
    public static void saveCode(){

            try {
                FileWriter myWriter = new FileWriter("input.txt");
                myWriter.write(t2.getText());
                myWriter.close();
                System.out.println("   saveCode()");

            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

    }   


    //---------------------------------------------------------
    //
    //---------------------------------------------------------
    public static void runScript(){
            System.out.println("   runScript( )");


                 Runtime run = Runtime.getRuntime();  
        //The best possible I found is to construct a command which you want to execute  
        //as a string and use that in exec. If the batch file takes command line arguments  
        //the command can be constructed a array of strings and pass the array as input to  
        //the exec method. The command can also be passed externally as input to the method.  

        Process p = null;  
        String cmd = "C:\\Users\\marc\\Desktop\\ide\\hello.cmd";  
        try {  
            p = run.exec(cmd);  
            p.getErrorStream();  
            System.out.println("RUN.COMPLETED.SUCCESSFULLY");  
        }  
        catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("ERROR.RUNNING.CMD");  
            p.destroy();  
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
        t2 = new JTextArea(40, 50); 

  JScrollPane sp1 = new JScrollPane(t1); 
  JScrollPane sp2 = new JScrollPane(t2); 
  
        // set texts 
        t1.setText("this is first text area"); 
        t2.setText("this is second text area"); 

        //add button
       
          JButton b=new JButton("RUN");  
    b.setBounds(50,100,95,30);  
    b.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                            System.out.println("save code and run script:");
                                    saveCode();
                                    runScript();
                                    readOutputFile();
                                    
                                }    
        });  


           JButton buttonRefresh=new JButton("revert");  
    buttonRefresh.setBounds(50,100,95,30);  
    buttonRefresh.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                                    System.out.println("refresh CODE");
                                }    
        }); 


               JButton buttonReadOutput=new JButton("otuput.txt");  
    buttonReadOutput.setBounds(50,100,95,30);  
    buttonReadOutput.addActionListener(new ActionListener(){  
                        public void actionPerformed(ActionEvent e){  
                                   // tf.setText("Welcome to Javatpoint.");  
                                    System.out.println("output.txt");
                                    readOutputFile();
                                }    
        }); 
  
        // add text area to panel -----------------
        p1.add(sp1); 
        p1.add(b);
        p1.add(buttonRefresh);
        p1.add(buttonReadOutput);
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



        String target="C:\\Users\\marc\\Desktop\\ide\\study_material\\Executors1.java";
        String target2="study_material\\Executors1.java";
        //readFile("output.txt");
        readFile(target2);
        saveFile("input.txt");
    } 
} 