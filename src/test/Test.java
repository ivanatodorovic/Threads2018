/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import javax.swing.JTextPane;

import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

	public static final Scanner IN = new Scanner(System.in);

	private Singer pattiSmith;
	private Singer bruceSpringsteen;
	private Singer robbieWilliams;
	private Singer avicii;

	private void initializeSingingInThreads(JTextPane textPane) {
		String lyrics1 = "Because the night";
		String lyrics2 = "Belongs to lovers";
		String lyrics3 ="The rain was never cold when I was young\n" + 
				"I'm still young we're still young";	
		String lyrics4 = "Through the darkness you'd hide with me\n" + "Like the wind we'd be wild and free";

		boolean stopIt = false;
		Synchronizer synch = new Synchronizer(0, textPane);

		Performance firstVoicePerformance = new Performance(lyrics1, 1500);
		Performance secondVoicePerformance = new Performance(lyrics2, 1500);
		Performance thirdVoicePerformance = new Performance(lyrics3, 2000);
		Performance fourthVoicePerformance = new Performance(lyrics4, 2000);
		
		pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
		bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
		robbieWilliams = new Singer("Robbie Williams", Voice.THIRD, thirdVoicePerformance, stopIt, synch);
		avicii = new Singer("Avicii", Voice.FOURTH,fourthVoicePerformance, stopIt, synch);
	}

	public void testSingInThreads(JTextPane textPane) {

		initializeSingingInThreads(textPane);

		pattiSmith.start();
		bruceSpringsteen.start();
		robbieWilliams.start();
		avicii.start();

//		IN.nextLine();
//		pattiSmith.setStopIt(true);
//		bruceSpringsteen.setStopIt(true);
//		avicii.setStopIt(true);
	}

	public void simpleDelay() {
		long l1 = System.currentTimeMillis();
		System.out.println("Wait 2sec...");
		while (System.currentTimeMillis() < (l1 + 2000)) {
		}
		System.out.println("Done.");
	}

	public synchronized void waitDelay() {
		System.out.println("Wait 2sec...");
		try {
			wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done.");
	}

	public synchronized void loopDelay() {
		System.out.println("Wait 5 times 2sec...");
		for (int i = 0; i < 4; i++) {
			try {
				wait(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i + 1);
		}
		System.out.println("Done.");
	}

	public synchronized void threadWaitDelay() {
		WaitThread w1 = new WaitThread("t1");
		WaitThread w2 = new WaitThread("t2");
		System.out.println("Two threads...");
		w1.start();
		try {
			wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w2.start();
	}

	public void stopThreads() {
		pattiSmith.setStopIt(true);
		bruceSpringsteen.setStopIt(true);
		robbieWilliams.setStopIt(true);
		avicii.setStopIt(true);
	}

}
