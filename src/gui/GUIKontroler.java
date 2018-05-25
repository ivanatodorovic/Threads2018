package gui;

import java.awt.EventQueue;

import test.Test;

public class GUIKontroler {

	public static ThreadsGUI glavniProzor;
	public static Test test;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test = new Test();
					glavniProzor = new ThreadsGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void testSing() {
		test.testSingInThreads(glavniProzor.getTextPane());
	}

	public static void testStopThreads() {
		test.stopThreads();
	}

}
