/*
 * Created on May 10, 2018
 *
 */
package music;

import javax.swing.JTextPane;

public class Synchronizer {

	private JTextPane textPane;
	private int counter;

	public Synchronizer(int counter, JTextPane textPane) {
		super();
		this.textPane = textPane;
		this.counter = counter;
	}

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (counter != 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (counter != 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singThirdVoice(String lyrics, int delay) {
		while (counter != 2) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private void sing(String lyrics, int delay) {
		System.out.println(textPane.getText() + lyrics + "\n");
		try {
			wait(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter = (counter + 1) % 3;
		notifyAll();
	}

}
