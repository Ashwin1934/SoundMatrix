import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.applet.*;
import java.net.*;

public class SoundMatrix extends JPanel implements MouseListener,Runnable{


	JFrame frame;
	JPanel panel;
	JToggleButton [][] togglers;
	int [][] soundMatrix;
	AudioClip soundClip [] = new AudioClip[1];
	boolean notStopped=true;

	public SoundMatrix(){
		frame = new JFrame("SoundMatrix");
		frame.add(this);
		frame.setSize(600,600);

		try{
			URL test = new URL("file:MB1-B3-1.wav");
			soundClip[0] = JApplet.newAudioClip(test);
		}catch(MalformedURLException mue){
			System.out.println("File not found");
		}

		panel = new JPanel();
		panel.setLayout(new GridLayout(8,8,10,10));

		togglers = new JToggleButton[8][8];

		for(int i = 0;i<8;i++){
			for(int j = 0;j<8;j++){
				togglers[i][j] = new JToggleButton();
				togglers[i][j].addMouseListener(this);
				panel.add(togglers[i][j]);
			}
		}

		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Thread timing  = new Thread(this);
		timing.start();
	}

	public void run(){
		do
		{
			try
			{
				if(togglers[0][0].isSelected())
				{
					soundClip[0].play();
				}
				new Thread().sleep(1000);
			}
			catch(InterruptedException e)
			{
			}
		}while(notStopped);

	}
	public void mouseClicked(MouseEvent e)
	{
	}
	public void mousePressed(MouseEvent e){

	}
	public void mouseExited(MouseEvent e){

	}
	public void mouseEntered(MouseEvent e){

	}
	public void mouseReleased(MouseEvent e){

	}

	public static void main(String [] args){
		SoundMatrix app = new SoundMatrix();
	}
}