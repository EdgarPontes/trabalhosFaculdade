package br.com.tecnonoticias.ser;

import java.awt.Container;
import java.io.File;
import java.util.jar.JarException;
import javazoom.jl.decoder.JavaLayerException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Cenario extends JFrame {

	static JProgressBar bar = new JProgressBar();
	static JProgressBar bar1 = new JProgressBar();
	static JProgressBar bar2 = new JProgressBar();

	Container parede = getContentPane();
	static Ser serA = new Ser("");
	static JLabel labelSerA;
	static JLabel BarraSerA;

	static Ser serB = new Ser("");
	static JLabel labelSerB;
	static JLabel BarraSerB;

	static Ser serC = new Ser("");
	static JLabel labelSerC;
	static JLabel BarraSerC;

	static Ser serD = new Ser("");
	static JLabel labelSerD;

	static Ser planeta = new Ser("");
	static JLabel Mundo;

	static Ser arvore = new Ser("");
	static JLabel labelArvore;

	static Ser arvore1 = new Ser("");
	static JLabel labelArvore1;
	
	static Ser freeza = new Ser("");
	static JLabel laberlFreeza;

	Icon goku = new ImageIcon(("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/GokuBd.png"));
	Icon bart = new ImageIcon(("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/kuririn.png"));
	Icon vejeta = new ImageIcon(("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/Vegeta_Saiyan.gif"));
	Icon monstro = new ImageIcon(("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/morcego.gif"));
	Icon mundo = new ImageIcon(("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/Espaco003.jpg"));
	Icon icomArvore = new ImageIcon("/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/arvore.png");
	Icon freezaIcon = new ImageIcon(
			"/media/edgar/VICTOR/WorkspaceNew/Swing/src/br/com/tecnonoticias/ser/imagem/freeza2.gif");

	static Sequencer player; 
	static String musica1 = "/media/edgar/VICTOR/WorkspaceNew/Swing/imagens/batalha.mid"; 
	

	public static void tocarMusica(String nome, int repetir) {
		try {
			player = MidiSystem.getSequencer();
			Sequence musica = MidiSystem.getSequence(new File(nome));
			player.open(); 
			player.setSequence(musica); 
			player.setLoopCount(repetir); 
			player.start(); 
		} catch (Exception e) {
			System.out.println("Erro ao tocar: " + nome);
		}
	}

	public Cenario() throws InterruptedException {
		super("Mundo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		parede = getContentPane();
		parede.setLayout(null);
		setSize(800, 600);
		setLocationRelativeTo(null);

		labelSerA = new JLabel(goku);
		parede.add(labelSerA);
		labelSerA.setSize(90, 100);
		parede.add(bar);
		bar.setSize(100, 10);
		bar.setLocation(10, 10);
		BarraSerA = new JLabel("Vida Ser A");
		BarraSerA.setLocation(20, 20);
		BarraSerA.setSize(100, 10);
		parede.add(BarraSerA);

		labelSerB = new JLabel(bart);
		parede.add(labelSerB);
		labelSerB.setSize(65, 65);
		parede.add(bar1);
		bar1.setSize(100, 10);
		bar1.setLocation(110, 10);
		BarraSerB = new JLabel("Vida Ser B");
		BarraSerB.setLocation(120, 20);
		BarraSerB.setSize(100, 10);
		parede.add(BarraSerB);

		labelSerC = new JLabel(vejeta);
		parede.add(labelSerC);
		labelSerC.setSize(65, 65);
		parede.add(bar2);
		bar2.setSize(100, 10);
		bar2.setLocation(210, 10);
		BarraSerC = new JLabel("Vida Ser C");
		BarraSerC.setLocation(220, 20);
		BarraSerC.setSize(100, 10);
		parede.add(BarraSerC);

		labelSerD = new JLabel(freezaIcon);
		parede.add(labelSerD);
		labelSerD.setSize(60, 60);

		labelArvore = new JLabel(icomArvore);
		parede.add(labelArvore);
		labelArvore.setSize(80, 70);

		labelArvore1 = new JLabel(icomArvore);
		parede.add(labelArvore1);
		labelArvore1.setSize(80, 70);
		
		Mundo = new JLabel(mundo);
		parede.add(Mundo);
		Mundo.setSize(800, 600);

	}

	public static boolean gameOver(int a, int b, int c) {
		boolean pare = true;
		if (a <= 0 && b <= 0 && c <= 0) {
			pare = false;
		}
		return pare;
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException, JarException, JavaLayerException {
		Cenario teste = new Cenario();
		teste.show(true);

		tocarMusica(musica1, 999);
		
		labelSerA.setLocation(serA.randomAparecer(serA.linha), serA.randomAparecer(serA.coluna));
		serA.x = serA.randomAparecer(300);
		labelSerB.setLocation(serB.randomAparecer(serB.linha), serB.randomAparecer(serB.coluna));
		serB.x = serB.randomAparecer(600);
		labelSerC.setLocation(serC.linha, serC.coluna);
		serC.x = serC.randomAparecer(400);
		labelArvore.setBounds(300, 350, 80, 70);
		labelArvore1.setBounds(450, 150, 80, 70);

		while (gameOver(serA.vida, serB.vida, serC.vida)) {

			if (serA.random(600) % 100 == 0) {
				labelSerA.setBounds(serA.moverX(serA.x, 10, 700), serA.y, 60, 85);
			} else if (serA.random(600) % 50 == 0) {
				labelSerA.setBounds(serA.x, serA.moverY(serA.y, 10, 500), 60, 85);
			}

			if (serA.bateu(labelSerA, labelSerD)) {
				serA.morrer(1, serA.vida);
				bar.setValue(serA.vida);
				String vida = Integer.toString(serA.vida);
				labelSerA.setText(vida);
				if (serA.vida <= 0) {
					labelSerA.setVisible(false);
					bar.setVisible(false);
				}
			}
			if (serA.bateu(labelSerA, labelArvore1)) {
				serA.vida = serA.viver(1, serA.vida);
				bar.setValue(serA.vida);
				System.out.println("Aumenta a viada ser A "+serA.vida);
			}

			if (serB.random(600) % 100 == 0) {
				labelSerB.setBounds(serB.moverX(serB.x, 10, 700), serB.y, 60, 85);
			} else if (serB.random(600) % 100 == 0) {
				labelSerB.setBounds(serB.x, (serB.moverY(serB.y, 10, 500)), 60, 85);
			}
			if (serB.bateu(labelSerB, labelSerD)) {
				serB.morrer(1, serB.vida);
				bar1.setValue(serB.vida);
				String vida = Integer.toString(serB.vida);
				labelSerB.setText(vida);
				if (serB.vida <= 0) {
					labelSerB.setVisible(false);
					bar1.setVisible(false);
				}
			}
			if (serB.bateu(labelSerB, labelArvore1)) {
				serB.vida = serB.viver(1, serB.vida);
				bar.setValue(serB.vida);
				System.out.println("Aumenta a viada ser A "+serB.vida);
			}

			if (serC.random(600) % 100 == 0) {
				labelSerC.setBounds(serC.moverX(serC.x, 10, 700), serC.y, 60, 85);
			} else if (serC.random(600) % 50 == 0) {
				labelSerC.setBounds(serC.x, (serC.moverY(serC.y, 10, 500)), 60, 85);
			}
			if (serC.bateu(labelSerC, labelSerD)) {
				serC.morrer(2, serC.vida);
				bar2.setValue(serC.vida);
				String vida = Integer.toString(serC.vida);
				labelSerC.setText(vida);
				if (serC.vida <= 0) {
					labelSerC.setVisible(false);
					bar2.setVisible(false);
				}
			}
			if (serC.bateu(labelSerC, labelArvore1)) {
				serC.vida = serC.viver(1, serC.vida);
				bar.setValue(serC.vida);
				String vida = Integer.toString(serC.vida);
				labelSerC.setText(vida);
				System.out.println("Aumenta a viada ser A "+serC.vida);
			}

			if (serD.random(600) % 100 == 0) {
				labelSerD.setBounds(serD.moverX(serD.x, 10, 700), serD.y, 60, 85);
			} else if (serD.random(600) % 50 == 0) {
				labelSerD.setBounds(serD.x++, (serD.moverY(serD.y, 10, 500)), 60, 85);
			}

			Mundo.setLocation(0, 0);
			Mundo.setVisible(true);

			System.out.println("A " + serA.vida);
			System.out.println("B " + serB.vida);
			System.out.println("C " + serC.vida);

			Thread.sleep(10);
		}
	}
}