package Main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Random;

import java.sql.SQLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComponent;

import javax.swing.KeyStroke;
import java.awt.Color;

import DBConnection.DBConnection;
import utils.imageSetter;

public class Main extends JFrame {
	private JPanel contentPane;
	private final JLabel lblBoard = new JLabel("New label");
	private JLabel lblDimage;
	private JLabel lblP1;
	private JButton btnDice;
	private JLabel lblPlayerName;
	public static JLabel lbl91;
	public static JLabel lbl92;
	public static JLabel lbl93;
	public static JLabel lbl94;
	public static JLabel lbl95;
	public static JLabel lbl96;
	public static JLabel lbl97;
	public static JLabel lbl98;
	public static JLabel lbl100;
	public static JLabel lbl99;
	public static JLabel lbl90;
	public static JLabel lbl89;
	public static JLabel lbl88;
	public static JLabel lbl87;
	public static JLabel lbl86;
	public static JLabel lbl85;
	public static JLabel lbl84;
	public static JLabel lbl83;
	public static JLabel lbl81;
	public static JLabel lbl82;
	public static JLabel lbl71;
	public static JLabel lbl72;
	public static JLabel lbl73;
	public static JLabel lbl74;
	public static JLabel lbl75;
	public static JLabel lbl76;
	public static JLabel lbl77;
	public static JLabel lbl78;
	public static JLabel lbl80;
	public static JLabel lbl79;
	public static JLabel lbl70;
	public static JLabel lbl69;
	public static JLabel lbl68;
	public static JLabel lbl67;
	public static JLabel lbl66;
	public static JLabel lbl65;
	public static JLabel lbl64;
	public static JLabel lbl63;
	public static JLabel lbl61;
	public static JLabel lbl62;
	public static JLabel lbl51;
	public static JLabel lbl52;
	public static JLabel lbl53;
	public static JLabel lbl54;
	public static JLabel lbl55;
	public static JLabel lbl56;
	public static JLabel lbl57;
	public static JLabel lbl58;
	public static JLabel lbl60;
	public static JLabel lbl59;
	public static JLabel lbl50;
	public static JLabel lbl49;
	public static JLabel lbl48;
	public static JLabel lbl47;
	public static JLabel lbl46;
	public static JLabel lbl45;
	public static JLabel lbl44;
	public static JLabel lbl43;
	public static JLabel lbl41;
	public static JLabel lbl42;
	public static JLabel lbl31;
	public static JLabel lbl32;
	public static JLabel lbl33;
	public static JLabel lbl34;
	public static JLabel lbl35;
	public static JLabel lbl36;
	public static JLabel lbl37;
	public static JLabel lbl38;
	public static JLabel lbl40;
	public static JLabel lbl39;
	public static JLabel lbl30;
	public static JLabel lbl29;
	public static JLabel lbl28;
	public static JLabel lbl27;
	public static JLabel lbl26;
	public static JLabel lbl25;
	public static JLabel lbl24;
	public static JLabel lbl23;
	public static JLabel lbl21;
	public static JLabel lbl22;
	public static JLabel lbl11;
	public static JLabel lbl12;
	public static JLabel lbl13;
	public static JLabel lbl14;
	public static JLabel lbl15;
	public static JLabel lbl16;
	public static JLabel lbl17;
	public static JLabel lbl18;
	public static JLabel lbl20;
	public static JLabel lbl19;
	public static JLabel lbl10;
	public static JLabel lbl9;
	public static JLabel lbl8;
	public static JLabel lbl7;
	public static JLabel lbl6;
	public static JLabel lbl5;
	public static JLabel lbl4;
	public static JLabel lbl3;
	public static JLabel lbl2;
	public static JLabel lbl1 = new JLabel("samik");
	private JLabel p1score;
	private JLabel lblP2;
	private JLabel p2score;
	private JButton btnRestart;
	private int flag1 = 0, winingPosition = 0;

	public String player1_username = "Player1";
	public String player2_username = "Player2";

	private int player = 1; // running player index.
	private int[] flag = new int[6];
	public int[] playerposition = new int[2];
	private int oldPosition = -1;
	private int point;
	private JLabel lblPlayer;
	private JLabel p1btn;
	private JLabel label;
	public static int chokkarAaagerPosition = 0, chokka = 0;

	public String started_at;
	public String ended_at;

	/**
	 * Launch the application.
	 */

	public void removeImage(int x) {
		if (x == 1) {
			lbl1.setVisible(false);
		} else if (x == 2) {
			lbl2.setVisible(false);
		} else if (x == 3) {
			lbl3.setVisible(false);
		} else if (x == 4) {
			lbl4.setVisible(false);
		} else if (x == 5) {
			lbl5.setVisible(false);
		} else if (x == 6) {
			lbl6.setVisible(false);
		} else if (x == 7) {
			lbl7.setVisible(false);
		} else if (x == 8) {
			lbl8.setVisible(false);
		} else if (x == 9) {
			lbl9.setVisible(false);
		} else if (x == 10) {
			lbl10.setVisible(false);
		} else if (x == 11) {
			lbl11.setVisible(false);
		} else if (x == 12) {
			lbl12.setVisible(false);
		} else if (x == 13) {
			lbl13.setVisible(false);
		} else if (x == 14) {
			lbl14.setVisible(false);
		} else if (x == 15) {
			lbl15.setVisible(false);
		} else if (x == 16) {
			lbl16.setVisible(false);
		} else if (x == 17) {
			lbl17.setVisible(false);
		} else if (x == 18) {
			lbl18.setVisible(false);
		} else if (x == 19) {
			lbl19.setVisible(false);
		} else if (x == 20) {
			lbl20.setVisible(false);
		} else if (x == 21) {
			lbl21.setVisible(false);
		} else if (x == 22) {
			lbl22.setVisible(false);
		} else if (x == 23) {
			lbl23.setVisible(false);
		} else if (x == 24) {
			lbl24.setVisible(false);
		} else if (x == 25) {
			lbl25.setVisible(false);
		} else if (x == 26) {
			lbl26.setVisible(false);
		} else if (x == 27) {
			lbl27.setVisible(false);
		} else if (x == 28) {
			lbl28.setVisible(false);
		} else if (x == 29) {
			lbl29.setVisible(false);
		} else if (x == 30) {
			lbl30.setVisible(false);
		} else if (x == 31) {
			lbl31.setVisible(false);
		} else if (x == 32) {
			lbl32.setVisible(false);
		} else if (x == 33) {
			lbl33.setVisible(false);
		} else if (x == 34) {
			lbl34.setVisible(false);
		} else if (x == 35) {
			lbl35.setVisible(false);
		} else if (x == 36) {
			lbl36.setVisible(false);
		} else if (x == 37) {
			lbl37.setVisible(false);
		} else if (x == 38) {
			lbl38.setVisible(false);
		} else if (x == 39) {
			lbl39.setVisible(false);
		} else if (x == 40) {
			lbl40.setVisible(false);
		} else if (x == 41) {
			lbl41.setVisible(false);
		} else if (x == 42) {
			lbl42.setVisible(false);
		} else if (x == 43) {
			lbl43.setVisible(false);
		} else if (x == 44) {
			lbl44.setVisible(false);
		} else if (x == 45) {
			lbl45.setVisible(false);
		} else if (x == 46) {
			lbl46.setVisible(false);
		} else if (x == 47) {
			lbl47.setVisible(false);
		} else if (x == 48) {
			lbl48.setVisible(false);
		} else if (x == 49) {
			lbl49.setVisible(false);
		} else if (x == 50) {
			lbl50.setVisible(false);
		}

		else if (x == 51) {
			lbl51.setVisible(false);
		} else if (x == 52) {
			lbl52.setVisible(false);
		} else if (x == 53) {
			lbl53.setVisible(false);
		} else if (x == 54) {
			lbl54.setVisible(false);
		} else if (x == 55) {
			lbl55.setVisible(false);
		} else if (x == 56) {
			lbl56.setVisible(false);
		} else if (x == 57) {
			lbl57.setVisible(false);
		} else if (x == 58) {
			lbl58.setVisible(false);
		} else if (x == 59) {
			lbl59.setVisible(false);
		} else if (x == 60) {
			lbl60.setVisible(false);
		}

		else if (x == 61) {
			lbl61.setVisible(false);
		} else if (x == 62) {
			lbl62.setVisible(false);
		} else if (x == 63) {
			lbl63.setVisible(false);
		} else if (x == 64) {
			lbl64.setVisible(false);
		} else if (x == 65) {
			lbl65.setVisible(false);
		} else if (x == 66) {
			lbl66.setVisible(false);
		} else if (x == 67) {
			lbl67.setVisible(false);
		} else if (x == 68) {
			lbl68.setVisible(false);
		} else if (x == 69) {
			lbl69.setVisible(false);
		} else if (x == 70) {
			lbl70.setVisible(false);
		}

		else if (x == 71) {
			lbl71.setVisible(false);
		} else if (x == 72) {
			lbl72.setVisible(false);
		} else if (x == 73) {
			lbl73.setVisible(false);
		} else if (x == 74) {
			lbl74.setVisible(false);
		} else if (x == 75) {
			lbl75.setVisible(false);
		} else if (x == 76) {
			lbl76.setVisible(false);
		} else if (x == 77) {
			lbl77.setVisible(false);
		} else if (x == 78) {
			lbl78.setVisible(false);
		} else if (x == 79) {
			lbl79.setVisible(false);
		} else if (x == 80) {
			lbl80.setVisible(false);
		}

		else if (x == 81) {
			lbl81.setVisible(false);
		} else if (x == 82) {
			lbl82.setVisible(false);
		} else if (x == 83) {
			lbl83.setVisible(false);
		} else if (x == 84) {
			lbl84.setVisible(false);
		} else if (x == 85) {
			lbl85.setVisible(false);
		} else if (x == 86) {
			lbl86.setVisible(false);
		} else if (x == 87) {
			lbl87.setVisible(false);
		} else if (x == 88) {
			lbl88.setVisible(false);
		} else if (x == 89) {
			lbl89.setVisible(false);
		} else if (x == 90) {
			lbl90.setVisible(false);
		}

		else if (x == 91) {
			lbl91.setVisible(false);
		} else if (x == 92) {
			lbl92.setVisible(false);
		} else if (x == 93) {
			lbl93.setVisible(false);
		} else if (x == 94) {
			lbl94.setVisible(false);
		} else if (x == 95) {
			lbl95.setVisible(false);
		} else if (x == 96) {
			lbl96.setVisible(false);
		} else if (x == 97) {
			lbl97.setVisible(false);
		} else if (x == 98) {
			lbl98.setVisible(false);
		} else if (x == 99) {
			lbl99.setVisible(false);
		} else if (x == 100) {
			lbl100.setVisible(false);
		}

		PositionCheck(x);
	}

	/**
	 * Create the frame.
	 */

	public void Dice() {
		Random rn = new Random();

		point = rn.nextInt(6) + 1;
		oldPosition = point;

		String dice = String.valueOf(point);
		String location = "/Image/dice " + dice + ".jpg";
		lblDimage.setIcon(new ImageIcon(Main.class.getResource(location)));

		if (point == 1)
			flag[player - 1] = 1;
		if (flag[player - 1] == 1)
			movedisc();

	}

	public void movedisc() {
		if (point == 6)
			chokka++;
		else
			chokka = 0;

		if (chokka > 0)
			chokkarAaagerPosition = playerposition[player - 1];

		if (playerposition[player - 1] + point > 100) {
			playerposition[player - 1] = playerposition[player - 1];
		}

		else if (chokka == 3) {
			playerposition[player - 1] = chokkarAaagerPosition;
		}

		else {
			removeImage(playerposition[player - 1]);
			playerposition[player - 1] += point;

			imageSetter.SetImage(playerposition[player - 1], player, labels);
			SkipTest(playerposition[player - 1]);

			if (playerposition[player - 1] != Skipper(playerposition[player - 1])) {
				removeImage(playerposition[player - 1]);
				playerposition[player - 1] = Skipper(playerposition[player - 1]);
				imageSetter.SetImage(playerposition[player - 1], player, labels);
			}

			// -------win check//
			if (playerposition[player - 1] == 100)
				winingPosition++;

			if (playerposition[player - 1] == 100 && flag1 == 0) {
				JOptionPane.showMessageDialog(null, "Player " + player + " won!!");
				flag1 = 1;
				ended_at = getCurrentTime();
				;
				storeGameHistory(player);
				restartGame(null, 1);

			}

			if (player == 1) {
				if (playerposition[player - 1] == 100 && winingPosition == 2)
					p1score.setText("Looser HaHA ");
				else if (playerposition[player - 1] == 100)
					p1score.setText("Winner " + winingPosition);
				else
					p1score.setText(String.valueOf(playerposition[player - 1]));
			}

			else {

				if (playerposition[player - 1] == 100 && winingPosition == 2)
					p2score.setText("Looser HaHA! ");
				else if (playerposition[player - 1] == 100)
					p2score.setText("Winner " + winingPosition);
				else
					p2score.setText(String.valueOf(playerposition[player - 1])); // score show

			}
		}

	}

	public void PositionCheck(int x) {

		for (int i = 0; i < 2; i++) {
			if (playerposition[i] == x && playerposition[i] != 0 && player != i + 1) {
				imageSetter.SetImage(x, i + 1, labels);
			}
		}
	}

	public Main(String player1_usernames, String player2_usernames) {

		setTitle("Snake and Ladder"); // constructor
		FrameinMiddle();
		initialize(player1_usernames, player2_usernames);

	}

	/*
	 * Checks if a certain block has ladder or snake
	 */
	public void SkipTest(int score) {
		if (score == 23 || score == 32 || score == 61 || score == 65 || score == 75) {
			System.out.println("Ladder at " + score);
		} else if (score == 21 || score == 27 || score == 47 || score == 56 || score == 74 || score == 90
				|| score == 99) {
			System.out.println("Snake at " + score);
		}
	}

	public int Skipper(int score) {
		if (score == 21)
			return 2;
		else if (score == 27)
			return 15;
		else if (score == 23)
			return 42;
		else if (score == 32)
			return 51;

		else if (score == 47)
			return 29;
		else if (score == 56)
			return 37;
		else if (score == 61)
			return 79;
		else if (score == 65)
			return 84;
		else if (score == 74)
			return 46;
		else if (score == 90)
			return 52;
		else if (score == 75)
			return 96;
		else if (score == 99)
			return 41;

		else
			return score;

	}

	// play dice roll sound
	public static void playStaticSound() {
		try {
			// Load the sound file
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
					Main.class.getResourceAsStream("/Image/dice-roll-sound.wav")); // Replace with your sound file path

			// Create a Clip to play the sound
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);

			// Add a listener to stop the clip when it finishes playing
			clip.addLineListener(new LineListener() {
				public void update(LineEvent event) {
					if (event.getType() == LineEvent.Type.STOP) {
						event.getLine().close();
					}
				}
			});

			// Start playing the sound
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JLabel[] labels;

	@SuppressWarnings("serial")

	public void initialize(String player1_usernames, String player2_usernames) {
		started_at = getCurrentTime();
		;
		this.player1_username = player1_usernames;
		this.player2_username = player2_usernames;

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GameMenu menu = new GameMenu();
				menu.GameMenu();
				dispose();
			}
		});

		setBounds(100, 100, 1200, 720);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lbl1 = new JLabel("");
		lbl1.setBounds(92, 576, 60, 60);
		contentPane.add(lbl1);

		lbl2 = new JLabel("");
		lbl2.setBounds(151, 576, 60, 60);
		contentPane.add(lbl2);

		lbl3 = new JLabel("");
		lbl3.setBounds(211, 576, 60, 60);
		contentPane.add(lbl3);

		lbl4 = new JLabel("");
		lbl4.setBounds(271, 576, 60, 60);
		contentPane.add(lbl4);

		lbl5 = new JLabel("");
		lbl5.setBounds(331, 576, 60, 60);
		contentPane.add(lbl5);

		lbl6 = new JLabel("");
		lbl6.setBounds(393, 576, 60, 60);
		contentPane.add(lbl6);

		lbl7 = new JLabel("");
		lbl7.setBounds(453, 576, 60, 60);
		contentPane.add(lbl7);

		lbl8 = new JLabel("");
		lbl8.setBounds(511, 576, 60, 60);
		contentPane.add(lbl8);

		lbl9 = new JLabel("");
		lbl9.setBounds(572, 576, 60, 60);
		contentPane.add(lbl9);

		lbl10 = new JLabel("");
		lbl10.setBounds(630, 576, 60, 60);
		contentPane.add(lbl10);

		lbl19 = new JLabel("");
		lbl19.setBounds(151, 517, 60, 60);
		contentPane.add(lbl19);

		lbl20 = new JLabel("");
		lbl20.setBounds(92, 517, 60, 60);
		contentPane.add(lbl20);

		lbl18 = new JLabel("");
		lbl18.setBounds(211, 517, 60, 60);
		contentPane.add(lbl18);

		lbl17 = new JLabel("");
		lbl17.setBounds(271, 517, 60, 60);
		contentPane.add(lbl17);

		lbl16 = new JLabel("");
		lbl16.setBounds(331, 517, 60, 60);
		contentPane.add(lbl16);

		lbl15 = new JLabel("");
		lbl15.setBounds(393, 517, 60, 60);
		contentPane.add(lbl15);

		lbl14 = new JLabel("");
		lbl14.setBounds(453, 517, 60, 60);
		contentPane.add(lbl14);

		lbl13 = new JLabel("");
		lbl13.setBounds(511, 517, 60, 60);
		contentPane.add(lbl13);

		lbl12 = new JLabel("");
		lbl12.setBounds(572, 517, 60, 60);
		contentPane.add(lbl12);

		lbl11 = new JLabel("");
		lbl11.setBounds(630, 517, 60, 60);
		contentPane.add(lbl11);

		lbl22 = new JLabel("");
		lbl22.setBounds(151, 457, 60, 60);
		contentPane.add(lbl22);

		lbl21 = new JLabel("");
		lbl21.setBounds(92, 457, 60, 60);
		contentPane.add(lbl21);

		lbl23 = new JLabel("");
		lbl23.setBounds(211, 457, 60, 60);
		contentPane.add(lbl23);

		lbl24 = new JLabel("");
		lbl24.setBounds(271, 457, 60, 60);
		contentPane.add(lbl24);

		lbl25 = new JLabel("");
		lbl25.setBounds(331, 457, 60, 60);
		contentPane.add(lbl25);

		lbl26 = new JLabel("");
		lbl26.setBounds(393, 457, 60, 60);
		contentPane.add(lbl26);

		lbl27 = new JLabel("");
		lbl27.setBounds(453, 457, 60, 60);
		contentPane.add(lbl27);

		lbl28 = new JLabel("");
		lbl28.setBounds(511, 457, 60, 60);
		contentPane.add(lbl28);

		lbl29 = new JLabel("");
		lbl29.setBounds(572, 457, 60, 60);
		contentPane.add(lbl29);

		lbl30 = new JLabel("");
		lbl30.setBounds(630, 457, 60, 60);
		contentPane.add(lbl30);

		lbl39 = new JLabel("");
		lbl39.setBounds(151, 396, 60, 60);
		contentPane.add(lbl39);

		lbl40 = new JLabel("");
		lbl40.setBounds(92, 396, 60, 60);
		contentPane.add(lbl40);

		lbl38 = new JLabel("");
		lbl38.setBounds(211, 396, 60, 60);
		contentPane.add(lbl38);

		lbl37 = new JLabel("");
		lbl37.setBounds(271, 396, 60, 60);
		contentPane.add(lbl37);

		lbl36 = new JLabel("");
		lbl36.setBounds(331, 396, 60, 60);
		contentPane.add(lbl36);

		lbl35 = new JLabel("");
		lbl35.setBounds(393, 396, 60, 60);
		contentPane.add(lbl35);

		lbl34 = new JLabel("");
		lbl34.setBounds(453, 396, 60, 60);
		contentPane.add(lbl34);

		lbl33 = new JLabel("");
		lbl33.setBounds(511, 396, 60, 60);
		contentPane.add(lbl33);

		lbl32 = new JLabel("");
		lbl32.setBounds(572, 396, 60, 60);
		contentPane.add(lbl32);

		lbl31 = new JLabel("");
		lbl31.setBounds(630, 396, 60, 60);
		contentPane.add(lbl31);

		lbl42 = new JLabel("");
		lbl42.setBounds(151, 335, 60, 60);
		contentPane.add(lbl42);

		lbl41 = new JLabel("");
		lbl41.setBounds(92, 335, 60, 60);
		contentPane.add(lbl41);

		lbl43 = new JLabel("");
		lbl43.setBounds(211, 335, 60, 60);
		contentPane.add(lbl43);

		lbl44 = new JLabel("");
		lbl44.setBounds(271, 335, 60, 60);
		contentPane.add(lbl44);

		lbl45 = new JLabel("");
		lbl45.setBounds(331, 335, 60, 60);
		contentPane.add(lbl45);

		lbl46 = new JLabel("");
		lbl46.setBounds(393, 335, 60, 60);
		contentPane.add(lbl46);

		lbl47 = new JLabel("");
		lbl47.setBounds(453, 335, 60, 60);
		contentPane.add(lbl47);

		lbl48 = new JLabel("");
		lbl48.setBounds(511, 335, 60, 60);
		contentPane.add(lbl48);

		lbl49 = new JLabel("");
		lbl49.setBounds(572, 335, 60, 60);
		contentPane.add(lbl49);

		lbl50 = new JLabel("");
		lbl50.setBounds(630, 335, 60, 60);
		contentPane.add(lbl50);

		lbl59 = new JLabel("");
		lbl59.setBounds(151, 277, 60, 60);
		contentPane.add(lbl59);

		lbl60 = new JLabel("");
		lbl60.setBounds(92, 277, 60, 60);
		contentPane.add(lbl60);

		lbl58 = new JLabel("");
		lbl58.setBounds(211, 277, 60, 60);
		contentPane.add(lbl58);

		lbl57 = new JLabel("");
		lbl57.setBounds(271, 277, 60, 60);
		contentPane.add(lbl57);

		lbl56 = new JLabel("");
		lbl56.setBounds(331, 277, 60, 60);
		contentPane.add(lbl56);

		lbl55 = new JLabel("");
		lbl55.setBounds(393, 277, 60, 60);
		contentPane.add(lbl55);

		lbl54 = new JLabel("");
		lbl54.setBounds(453, 277, 60, 60);
		contentPane.add(lbl54);

		lbl53 = new JLabel("");
		lbl53.setBounds(511, 277, 60, 60);
		contentPane.add(lbl53);

		lbl52 = new JLabel("");
		lbl52.setBounds(572, 277, 60, 60);
		contentPane.add(lbl52);

		lbl51 = new JLabel("");
		lbl51.setBounds(630, 277, 60, 60);
		contentPane.add(lbl51);

		lbl62 = new JLabel("");
		lbl62.setBounds(151, 217, 60, 60);
		contentPane.add(lbl62);

		lbl61 = new JLabel("");
		lbl61.setBounds(92, 217, 60, 60);
		contentPane.add(lbl61);

		lbl63 = new JLabel("");
		lbl63.setBounds(211, 217, 60, 60);
		contentPane.add(lbl63);

		lbl64 = new JLabel("");
		lbl64.setBounds(271, 217, 60, 60);
		contentPane.add(lbl64);

		lbl65 = new JLabel("");
		lbl65.setBounds(331, 217, 60, 60);
		contentPane.add(lbl65);

		lbl66 = new JLabel("");
		lbl66.setBounds(393, 217, 60, 60);
		contentPane.add(lbl66);

		lbl67 = new JLabel("");
		lbl67.setBounds(453, 217, 60, 60);
		contentPane.add(lbl67);

		lbl68 = new JLabel("");
		lbl68.setBounds(511, 217, 60, 60);
		contentPane.add(lbl68);

		lbl69 = new JLabel("");
		lbl69.setBounds(572, 217, 60, 60);
		contentPane.add(lbl69);

		lbl70 = new JLabel("");
		lbl70.setBounds(630, 217, 60, 60);
		contentPane.add(lbl70);

		lbl79 = new JLabel("");
		lbl79.setBounds(151, 157, 60, 60);
		contentPane.add(lbl79);

		lbl80 = new JLabel("");
		lbl80.setBounds(92, 157, 60, 60);
		contentPane.add(lbl80);

		lbl78 = new JLabel("");
		lbl78.setBounds(211, 157, 60, 60);
		contentPane.add(lbl78);

		lbl77 = new JLabel("");
		lbl77.setBounds(271, 157, 60, 60);
		contentPane.add(lbl77);

		lbl76 = new JLabel("");
		lbl76.setBounds(341, 157, 50, 60);
		contentPane.add(lbl76);

		lbl75 = new JLabel("");
		lbl75.setBounds(393, 157, 60, 60);
		contentPane.add(lbl75);

		lbl74 = new JLabel("");
		lbl74.setBounds(453, 157, 60, 60);
		contentPane.add(lbl74);

		lbl73 = new JLabel("");
		lbl73.setBounds(511, 157, 60, 60);
		contentPane.add(lbl73);

		lbl72 = new JLabel("");
		lbl72.setBounds(572, 157, 60, 60);
		contentPane.add(lbl72);

		lbl71 = new JLabel("");
		lbl71.setBounds(630, 157, 60, 60);
		contentPane.add(lbl71);

		lbl82 = new JLabel("");
		lbl82.setBounds(151, 97, 60, 60);
		contentPane.add(lbl82);

		lbl81 = new JLabel("");
		lbl81.setBounds(92, 97, 60, 60);
		contentPane.add(lbl81);

		lbl83 = new JLabel("");
		lbl83.setBounds(211, 97, 60, 60);
		contentPane.add(lbl83);

		lbl84 = new JLabel("");
		lbl84.setBounds(271, 97, 60, 60);
		contentPane.add(lbl84);

		lbl85 = new JLabel("");
		lbl85.setBounds(331, 97, 60, 60);
		contentPane.add(lbl85);

		lbl86 = new JLabel("");
		lbl86.setBounds(393, 97, 60, 60);
		contentPane.add(lbl86);

		lbl87 = new JLabel("");
		lbl87.setBounds(453, 97, 60, 60);
		contentPane.add(lbl87);

		lbl88 = new JLabel("");
		lbl88.setBounds(511, 97, 60, 60);
		contentPane.add(lbl88);

		lbl89 = new JLabel("");
		lbl89.setBounds(572, 97, 60, 60);
		contentPane.add(lbl89);

		lbl90 = new JLabel("");
		lbl90.setBounds(630, 97, 60, 60);
		contentPane.add(lbl90);

		lbl99 = new JLabel("");
		lbl99.setBounds(151, 38, 60, 60);
		contentPane.add(lbl99);

		lbl100 = new JLabel("");
		lbl100.setBounds(92, 38, 60, 60);
		contentPane.add(lbl100);

		lbl98 = new JLabel("");
		lbl98.setBounds(211, 38, 60, 60);
		contentPane.add(lbl98);

		lbl97 = new JLabel("");
		lbl97.setBounds(271, 38, 60, 60);
		contentPane.add(lbl97);

		lbl96 = new JLabel("");
		lbl96.setBounds(331, 38, 60, 60);
		contentPane.add(lbl96);

		lbl95 = new JLabel("");
		lbl95.setBounds(393, 38, 60, 60);
		contentPane.add(lbl95);

		lbl94 = new JLabel("");
		lbl94.setBounds(453, 38, 60, 60);
		contentPane.add(lbl94);

		lbl93 = new JLabel("");
		lbl93.setBounds(511, 38, 60, 60);
		contentPane.add(lbl93);

		lbl92 = new JLabel("");
		lbl92.setBounds(572, 38, 60, 60);
		contentPane.add(lbl92);

		lbl91 = new JLabel("");
		lbl91.setBounds(630, 38, 60, 60);
		contentPane.add(lbl91);

		labels = new JLabel[] {
				lbl1, lbl2, lbl3, lbl4, lbl5, lbl6, lbl7, lbl8, lbl9, lbl10,
				lbl11, lbl12, lbl13, lbl14, lbl15, lbl16, lbl17, lbl18, lbl19, lbl20,
				lbl21, lbl22, lbl23, lbl24, lbl25, lbl26, lbl27, lbl28, lbl29, lbl30,
				lbl31, lbl32, lbl33, lbl34, lbl35, lbl36, lbl37, lbl38, lbl39, lbl40,
				lbl41, lbl42, lbl43, lbl44, lbl45, lbl46, lbl47, lbl48, lbl49, lbl50,
				lbl51, lbl52, lbl53, lbl54, lbl55, lbl56, lbl57, lbl58, lbl59, lbl60,
				lbl61, lbl62, lbl63, lbl64, lbl65, lbl66, lbl67, lbl68, lbl69, lbl70,
				lbl71, lbl72, lbl73, lbl74, lbl75, lbl76, lbl77, lbl78, lbl79, lbl80,
				lbl81, lbl82, lbl83, lbl84, lbl85, lbl86, lbl87, lbl88, lbl89, lbl90,
				lbl91, lbl92, lbl93, lbl94, lbl95, lbl96, lbl97, lbl98, lbl99, lbl100
		};

		lblPlayerName = new JLabel("Playing Player -");
		lblPlayerName.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblPlayerName.setForeground(new Color(51, 204, 204));
		lblPlayerName.setBounds(724, 67, 200, 26);
		contentPane.add(lblPlayerName);

		btnDice = new JButton("Roll Dice");
		btnDice.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		btnDice.setForeground(new Color(255, 255, 255));
		btnDice.setBackground(new Color(0, 0, 51));
		btnDice.setFocusable(false);

		btnDice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDice.setBackground(new Color(0, 0, 0));
				playStaticSound();
				if (chokka == 0) {
					if (winingPosition == 2) {
						int confirm = JOptionPane.showConfirmDialog(null, "Replay?", "", JOptionPane.YES_NO_OPTION);
						if (confirm == JOptionPane.YES_OPTION) {
							dispose();
							Main frame = new Main(player1_username, player2_username);
							frame.setVisible(true);
						} else {
							setVisible(false);
							dispose(); // Destroy the JFrame object

						}
					}
					// --------current player number show-------//
					// give chance to player if dice point is 6
					if (player == 2 && oldPosition != 6)
						lblPlayer.setText(String.valueOf(2));
					else if (player == 1 && oldPosition != 6)
						lblPlayer.setText(String.valueOf(1));
				}
				Dice(); // dice method called
				if (chokka == 0 && oldPosition != 6) {
					player++;
					if (player == 3)
						player = 1;
				}
			}
		});
		btnDice.setBackground(new Color(0, 0, 51));
		btnDice.setBounds(724, 122, 200, 44);
		contentPane.add(btnDice);

		contentPane.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "EXIT");
		contentPane.getRootPane().getActionMap().put("EXIT", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				btnDice.doClick();
			}
		});

		lblP1 = new JLabel(player1_username);
		lblP1.setForeground(new Color(0, 204, 255));
		lblP1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblP1.setBounds(718, 323, 100, 26);
		contentPane.add(lblP1);

		lblDimage = new JLabel(".");
		lblDimage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDimage.setBounds(724, 176, 132, 129);
		contentPane.add(lblDimage);

		p1score = new JLabel("Score");
		p1score.setHorizontalAlignment(SwingConstants.LEFT);
		p1score.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		p1score.setForeground(new Color(255, 255, 255));
		p1score.setBounds(790, 329, 84, 14);
		contentPane.add(p1score);

		lblP2 = new JLabel(player2_username);
		lblP2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblP2.setForeground(new Color(255, 204, 0));
		lblP2.setBounds(718, 389, 100, 14);
		contentPane.add(lblP2);

		p2score = new JLabel("Score");
		p2score.setHorizontalAlignment(SwingConstants.LEFT);
		p2score.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		p2score.setForeground(new Color(255, 255, 255));
		p2score.setBounds(790, 389, 84, 14);
		contentPane.add(p2score);
		lblBoard.setBounds(92, 38, 600, 600);
		contentPane.add(lblBoard);

		lblBoard.setIcon(new ImageIcon(Main.class.getResource("/Image/Board Small 600 600.png")));

		lblPlayer = new JLabel("1");
		lblPlayer.setHorizontalAlignment(SwingConstants.LEFT);
		lblPlayer.setForeground(new Color(255, 0, 0));
		lblPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblPlayer.setBounds(858, 67, 62, 26);
		contentPane.add(lblPlayer);

		p1btn = new JLabel("");
		p1btn.setIcon(new ImageIcon(Main.class.getResource("/Image/player 1.png")));
		p1btn.setBounds(884, 312, 50, 50);
		contentPane.add(p1btn);

		label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/Image/player 2.png")));
		label.setBounds(884, 367, 50, 50);
		contentPane.add(label);

		btnRestart = new JButton("Restart??");
		btnRestart.setBackground(new Color(255, 255, 255));
		btnRestart.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnRestart.setFocusable(false);

		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartGame(e, 0);
			}
		});
		btnRestart.setBounds(734, 576, 150, 60);
		contentPane.add(btnRestart);

		for (int i = 0; i < 2; i++) {
			playerposition[i] = 0;
		}
	}

	public void restartGame(ActionEvent e, int restart) {
		if (restart == 1) {
			dispose();
			Main frame = new Main(player1_username, player2_username);
			frame.setVisible(true);
		} else {
			int confirm = JOptionPane.showConfirmDialog(null, "Do you want to Restart?", "Restart!!!",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				dispose();
				Main frame = new Main(player1_username, player2_username);
				frame.setVisible(true);
			}
		}
	}

	public String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public void storeGameHistory(int player) {
		Connection dbconn = DBConnection.connectDB();
		int generatedID = -1;

		System.out.println(dbconn);
		if (dbconn != null) {
			try {
				PreparedStatement st = dbconn.prepareStatement(
						"INSERT INTO gamehistory(player1_name, player2_name, player1_gamestatus, player2_gamestatus) VALUES (?, ?, ?, ?)",
						Statement.RETURN_GENERATED_KEYS);

				st.setString(1, player1_username);
				st.setString(2, player2_username);
				st.setString(3, player == 1 ? "win" : "lose");
				st.setString(4, player == 2 ? "win" : "lose");

				int res = st.executeUpdate();

				if (res > 0) {
					ResultSet generatedKeys = st.getGeneratedKeys();
					if (generatedKeys.next()) {
						generatedID = generatedKeys.getInt(1);
						st = dbconn.prepareStatement(
								"INSERT INTO gamedata(game_history_id, started_at, ended_at) VALUES (?, ?, ?)");

						st.setInt(1, generatedID);
						st.setString(2, started_at);
						st.setString(3, ended_at);
						int res1 = st.executeUpdate();
						if (res1 > 0) {
							System.out.println("Game data inserted successfully");
						} else {
							System.out.println("Game data insert failed");
						}
					} else {
						System.out.println("Key is not generated");
					}
					generatedKeys.close();
				} else {
					JOptionPane.showMessageDialog(this, "Game history save failed", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ex) {
				System.out.println(ex);
			} finally {
				try {
					dbconn.close(); // Close the database connection
				} catch (SQLException ex) {
					System.out.println("Error closing database connection: " + ex.getMessage());
				}
			}
		} else {
			System.out.println("Database connection is not established");
		}
	}

	public void FrameinMiddle() {

		Dimension screenSize, frameSize;
		int x, y;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frameSize = getSize();
		x = (screenSize.width - frameSize.width) / 2;
		y = (screenSize.height - frameSize.height) / 2;
		setLocation(x, y);
	}

}
