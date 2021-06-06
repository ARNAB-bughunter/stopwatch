import  javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

class STOPWATCH{
public static void main(String [ ] args){
clock object = new clock();
object.make();
    }
}

class clock implements ActionListener
{
    boolean st; 
    
JFrame frame=new JFrame("STOPWACH");
ImageIcon clock=new ImageIcon("clock.png");
ImageIcon stop=new ImageIcon("stop.jpeg");
ImageIcon reset=new ImageIcon("reset.png");
ImageIcon start=new ImageIcon("start.jpeg");
ImageIcon resume=new ImageIcon("resume.jpeg");
Container c=frame.getContentPane();
JButton bt1=new JButton("START");
JButton bt2=new JButton("STOP");
JButton bt3=new JButton("RESET");
JLabel label=new JLabel("00:00:00:000",JLabel.CENTER);
int ms=0,s=0,m=0,h=0;
Border line=BorderFactory.createLineBorder(Color.green);


public void make(){
c.setLayout(null);
frame.setVisible(true);
frame.setBounds(100,100,720,450);
c.setBackground(Color.black);
frame.setIconImage(clock.getImage());
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setResizable(false);
label.setBounds(250,160,220,40);
label.setForeground(Color.green);
label.setFont(new Font("Comic Sans MS",Font.BOLD,25));
label.setBorder(line);
c.add(label);
bt1.setBounds(280,110,160,50);
bt2.setBounds(280,200,60,50);
bt3.setBounds(390,200,50,50);
bt1.setIcon(start);
bt2.setIcon(stop);
bt3.setIcon(reset);
  bt1.addActionListener(this);
  bt2.addActionListener(this);
  bt3.addActionListener(this);
c.add(bt1);
c.add(bt3);
  c.add(bt2);
 bt3.setVisible(false);
 bt2.setVisible(false);
}


class  inner   extends Thread
{
public void run(){
bt2.setVisible(true);
while(st){
ms++;

label.setText(""+h+":"+m+":"+s+":"+ms);
if(ms==1000){
ms=0;
s++;
  }

if(s==60){
s=0;
m++;
}

if(m==60){
m=0;
h++;
}
 try{
   Thread.sleep(1);
  }
catch(Exception e){ }
       }
    } 
}
 public void actionPerformed(ActionEvent   e) 
      {
          inner obj=new inner();
      if(e.getSource()== bt1){
            st=true;
         bt1.setText("START");	
          label.setText("00:00:00:000");
          obj.start(); 
        }   
      if(e.getSource()== bt2){
       
        bt1.setIcon(resume);
        bt3.setVisible(true);	
       st=false;
        }
       if(e.getSource()== bt3){
      bt2.setVisible(false);
       bt1.setIcon(start);
        ms=0;s=0;m=0;h=0;
       label.setText("00:00:00:000");
       bt3.setVisible(false);
       st=false;
        }  
    }

}

/*
jar -cfm STOPWATCH.jar manifest.txt *

*/