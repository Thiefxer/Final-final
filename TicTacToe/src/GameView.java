import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameView extends JPanel {

	public int turntracker;
	TileFactory Factory = new TileFactory();

	private static final long serialVersionUID = 1L;

	// Differnt game tile views
	public static JButton tiles[] = new JButton[9];

	// creates game board
	public GameView() {
		setLayout(new GridLayout(3, 3));
		maketiles();
	}

	public void maketiles() {
		for (int i = 0; i <= 8; i++) {

			tiles[i] = new JButton();
			tiles[i].setText("");
			tiles[i].addActionListener(new buttonListener());

			add(tiles[i]);

		}
	}

	public class buttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (turntracker == 8) {
				checkForWin();
				if (checkForWin() == true) {
					JOptionPane.showMessageDialog(null, "Player Wins");
					System.exit(0);
				} else {GameTile user = Factory.setTurn(turntracker);
				JButton buttonClicked = (JButton) e.getSource();
				buttonClicked.setText(user.gettiledesign());
				buttonClicked.setEnabled(false);
				checkForWin();
				if (checkForWin() == true) {
					JOptionPane.showMessageDialog(null, "Player Wins");
					System.exit(0);
				} else {
					JOptionPane.showMessageDialog(null, "Tie");
					System.exit(0);
				}
				}
			}

			else {
				GameTile user = Factory.setTurn(turntracker);
				JButton buttonClicked = (JButton) e.getSource();

				buttonClicked.setText(user.gettiledesign());
				buttonClicked.setEnabled(false);
				turntrackerCheck();

				computerturntracker();
				checkWhoWon(checkForWin());

			}

		}

	}

	public boolean checkForWin() {

		// horizontal win detection
		if (WinCheck(0, 1) && WinCheck(1, 2))
			return true;

		else if (WinCheck(3, 4) && WinCheck(4, 5))
			return true;

		else if (WinCheck(6, 7) && WinCheck(7, 8))
			return true;

		// vertical win detection

		else if (WinCheck(0, 3) && WinCheck(3, 6))
			return true;

		else if (WinCheck(1, 4) && WinCheck(4, 7))
			return true;

		else if (WinCheck(2, 5) && WinCheck(5, 8))
			return true;

		// diagonal win detection

		else if (WinCheck(0, 4) && WinCheck(4, 8))
			return true;

		else if (WinCheck(2, 4) && WinCheck(4, 6))
			return true;

		else
			return false;

	}

	public boolean WinCheck(int a, int b) {

		if (tiles[a].getText().equals(tiles[b].getText()) && !tiles[a].getText().equals(""))
			return true;

		else
			return false;

	}

	public void turntrackerCheck() {
		turntracker++;
	}

	public void computerturntracker() {

		GameTile user1 = Factory.setTurn(turntracker);

		int i = (int) Math.floor(Math.random() * 9);

		checkWhoWon(checkForWin());
		if (tiles[i].isEnabled() == true) {
			tiles[i].setText(user1.gettiledesign());
			tiles[i].setEnabled(false);
			turntracker++;
		}

		else {
			while (tiles[i].isEnabled() == false) {
				i = (int) Math.floor(Math.random() * 9);
			}
			tiles[i].setText(user1.gettiledesign());
			tiles[i].setEnabled(false);
			turntracker++;
		}

	}

	public void checkWhoWon(Boolean b) {
		if (b == true) {
			if (turntracker % 2 == 0) {
				JOptionPane.showMessageDialog(null, "Computer Wins.");
				System.exit(0);
			}

			else {
				JOptionPane.showMessageDialog(null, "Player Wins.");
				System.exit(0);
			}
		}
	}

}
