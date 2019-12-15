import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Controller extends GameView {

	public static void main(String[] args) {
		buildGameViews();

	}

	public static void buildGameViews() {
		// Task 1: Create a frame, set the title and dimensions. Make it VISIBLE.
		JFrame frame = new JFrame();
		frame.setTitle("Tic-Tac-Toe"); // frame title
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // what frame does on x button click
		frame.setVisible(true); // frame visibility
		frame.setSize(500, 550); // frame dimensions

		// Task 2: Instantiate a GameView Object and add it to the frame
		GameView gameView = new GameView();
		frame.add(gameView);

	}

}
