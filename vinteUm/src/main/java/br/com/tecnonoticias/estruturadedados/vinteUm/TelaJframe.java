package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class TelaJframe extends Baralho {

	private JFrame janela;
	public static JLabel[] jlJogador = new JLabel[9];
	private JTextField [] jtSoma = new JTextField[9];
	private JLabel jlEmbaralhar, jlRetirar;
	private JLabel[] cartas = new JLabel[51];
	private JLabel[] jlNomes = new JLabel[9];
	private JButton btEmbaralhar, btBotao, btPlay, btNew;
	public Object[] qtdJogadores = { 2, 3, 4, 5, 6, 7, 8 };
	private int posCX = 10, posCartaRetiraX = 10, posCartaRetiraY = 390, posJtX = 10;
	private Object jogadores;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JComboBox jcJogadores = new JComboBox(qtdJogadores);
	protected boolean click;
	protected int c = 0;
	private String[] nomesJogadores = new String[9];
	private int posNX;
	private int jts = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new TelaJframe();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaJframe() throws MalformedURLException {
		janela = new JFrame("Black Jack");
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		janela.setBounds(100, 100, 1098, 703);
		janela.setContentPane(new JLabel(new ImageIcon(getClass().getResource("/blackjack1.png"))));
		janela.getContentPane().setLayout(null);
		janela.setVisible(true);

		btBotao = new JButton();
		btBotao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				click = true;
				
				if (c <= 50) {
					while (click) {
						Object cartaNaipe = desempilhar();
						String cartaRetira = nome(cartaNaipe.toString());
						System.out.println(cartaNaipe);

						cartas[c] = new JLabel();
						try {
							cartas[c].setIcon(getImagem(cartaRetira));
						} catch (MalformedURLException e) {
							e.printStackTrace();
						}
						if (posCartaRetiraX < posCX) {
							
							cartas[c].setBounds(posCartaRetiraX += 100, posCartaRetiraY, 100, 150);
							jtSoma[jts].setText(String.valueOf((valor(cartaNaipe))));
							jts++;
//							System.out.println(posCartaRetiraX +" soma");
						}else{
							jts-=jts;
							posCartaRetiraX -= posCX-10;
//							System.out.println(posCartaRetiraX + " Subitrai" + posCX);
							posCartaRetiraY -= 35;
						}
						janela.add(cartas[c]);
						janela.repaint();

						cartas[c].setVisible(true);
						click = false;
						c++;
				
					}
				} else {
					JOptionPane.showMessageDialog(null, "Acabaram as cartas");
				}
			}
		});

		btBotao.setBounds(195, 40, 75, 95);
		btBotao.setVisible(true);
		btBotao.setIcon(getImagem("fundoBaralho.png"));
		janela.add(btBotao);

		btEmbaralhar = new JButton();
		btEmbaralhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				embaralhar();
				btEmbaralhar.setVisible(false);
			}
		});
		btEmbaralhar.setBounds(740, 30, 70, 95);
		btEmbaralhar.setVisible(true);
		btEmbaralhar.setIcon(getImagem("fundoBaralho.png"));
		janela.add(btEmbaralhar);

		jlEmbaralhar = new JLabel("Embaralhar");
		jlEmbaralhar.setVisible(true);
		jlEmbaralhar.setBounds(740, 90, 90, 95);
		jlEmbaralhar.setForeground(Color.yellow);
		janela.add(jlEmbaralhar);

		jlRetirar = new JLabel("Retirar");
		jlRetirar.setVisible(true);
		jlRetirar.setBounds(190, 100, 90, 95);
		jlRetirar.setForeground(Color.yellow);
		janela.add(jlRetirar);

		jcJogadores.setBounds(10, 50, 70, 20);
		janela.add(jcJogadores);

		btPlay = new JButton("Play");
		btPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogadores = jcJogadores.getSelectedItem();
				for (int i = 0; i < jogadores.hashCode(); i++) {

					nomesJogadores[i] = JOptionPane.showInputDialog("Qual o seu nome?");
					if (nomesJogadores[i] == null || nomesJogadores[i].equals("")) {
						JOptionPane.showMessageDialog(null, "Você não respondeu a pergunta.");
						nomesJogadores[i] = JOptionPane.showInputDialog("Qual o seu nome?");
					}
					jlNomes[i] = new JLabel(nomesJogadores[i]);
					jlNomes[i].setForeground(Color.yellow);
					jlNomes[i].setBounds(posNX += 110, 570, 70, 105);
					jlNomes[i].setVisible(false);
					janela.add(jlNomes[i]);
					
					jtSoma[i] = new JTextField();
					jtSoma[i].setBounds(posJtX += 100, 630, 30, 30);
					jtSoma[i].setVisible(false);
					jtSoma[i].setEditable(false);
					janela.add(jtSoma[i]);

					jlJogador[i] = new JLabel();
					try {
						jlJogador[i].setIcon(getImagem("fundoBaralho.png"));
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
					jlJogador[i].setBounds(posCX += 100, 510, 70, 105);
					jlJogador[i].setVisible(false);
					janela.add(jlJogador[i]);
					janela.repaint();

					jlNomes[i].setVisible(true);
					jtSoma[i].setVisible(true);
					jlJogador[i].setVisible(true);
					System.out.println(nomesJogadores[i]);
				}
				btPlay.setEnabled(false);
			}
		});
		btPlay.setBounds(10, 70, 70, 20);
		janela.add(btPlay);
		
		btNew =  new JButton("N.Jogo");
		btNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					new TelaJframe();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btNew.setBounds(10, 140, 90, 20);
		janela.add(btNew);
	}
}
