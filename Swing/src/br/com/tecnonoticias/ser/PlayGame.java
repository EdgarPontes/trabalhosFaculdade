package br.com.tecnonoticias.ser;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PlayGame extends JFrame {

	boolean vai;
	boolean volta;
	int x= mover(getX());
	int y= moverY(getY());

	Icon mundo = new ImageIcon("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/Espaco003.jpg");
	Icon kuririn = new ImageIcon("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/kuririn.png");
	Icon goku = new ImageIcon("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/GokuBd.png");
	Icon freeza = new ImageIcon(
			"/media/edgar/VICTOR/WorkspaceNew/Swing/src/br/com/tecnonoticias/ser/imagem/freeza2.gif");

	JLabel mundo1 = new JLabel(mundo);
	JLabel personagen1 = new JLabel(kuririn);
	JLabel personagen2 = new JLabel(goku);
	JLabel personagen3 = new JLabel(freeza);

	public PlayGame() {
		editarJanela();
		new Movimento().start();
	}

	public int mover(int personagenX) {
		int x = 0;
		if (personagenX > 500) {
			vai = false;
			volta = true;
		}
		if (personagenX <= 1) {
			vai = true;
			volta = false;
		}
		if (vai) {
			x += 5;
		}
		if (volta) {
			x -= 5;
		}
		return this.x += x;
	}
	public int moverY(int personagenY) {
		int x = 0;
		if (personagenY > 500) {
			vai = false;
			volta = true;
		}
		if (personagenY <= 1) {
			vai = true;
			volta = false;
		}
		if (vai) {
			x += 5;
		}
		if (volta) {
			x -= 5;
		}
		return this.y += x;
	}

	public Integer random() {
		Random random = new Random();
		Integer numero = random.nextInt(750);
		return numero;
	}

	public class Movimento extends Thread {
		public void run() {
			while (true) {
				try {
					sleep(120);
				} catch (Exception erro) {
				}
				if(random() % 100 == 0){
				personagen1.setBounds(mover(personagen1.getX()),mover(personagen1.getY()), 60, 85);
				personagen2.setBounds(mover(personagen2.getX()), 80, 60, 85);
				personagen3.setBounds(mover(personagen3.getX()), 150, 60, 85);
				}else{
					personagen1.setBounds(personagen1.getX(), mover(personagen1.getY()), 60, 85);
					personagen2.setBounds(personagen2.getX(), mover(personagen2.getY()), 60, 85);
					personagen3.setBounds(personagen3.getX(), mover(personagen3.getY()), 60, 85);
				}
			}
		}
	}

	public void editarJanela() {
		setTitle("Seres");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		personagen1.setBounds(1, 0, 60, 85);
		add(personagen1);
		personagen2.setBounds(1, 80, 60, 85);
		add(personagen2);
		personagen3.setBounds(1, 150, 65, 85);
		add(personagen3);
		mundo1.setLocation(0, 0);
		add(mundo1);

	}

	public static void main(String[] args) {
		new PlayGame();
	}
}