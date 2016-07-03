package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Tela extends JFrame{
	
	private Container telaPrincipal;
	
	private JButton tabuleiro;
	JPanel tela;
	private ImageIcon jogador1A;
	private JLabel jogador1Nome, fundo, telaIcom, jogador2, jogador3,jogador4,jogador5,jogador6,jogador7,jogador8;
	private String nome1;
	private JTextField tf8,tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	protected Component playerEsquerda;
	private boolean abrir;
	private JPanel jogador1;
	
	public Tela(){
		super("Tela");
		Container telaPrincipal = getContentPane();
		telaPrincipal.setLayout(new BorderLayout());
		tela = new JPanel();
		tabuleiro = new JButton("Jogadores");
		tabuleiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				if(evento.getSource() == tabuleiro)	{	
					nome1="Edgar";
					System.out.println(nome1);
				}
			}
		});
		Icon tab = new ImageIcon("/media/edgar/VICTOR/WorkspaceNew/vinteUm/baralho/jogar-baralho1.jpg");
		telaIcom = new JLabel("Símbolo do Java", tab, SwingConstants.CENTER); 
		telaIcom.setHorizontalTextPosition( SwingConstants.CENTER );
		telaIcom.setVerticalTextPosition( SwingConstants.BOTTOM );
		telaIcom.add(tabuleiro);
//		tela.add(telaIcom);
		
		telaPrincipal.add(BorderLayout.CENTER, telaIcom);
		
		
		Container playerEsquerda = new JPanel();
		
        tf1 = new JTextField(10);
        tf1.setEditable(false);
        tf1.setText("Edgar");
        tf1.setBorder(null);
        tf2 = new JTextField(10);
        tf2.setEditable(false);
        tf2.setText("Edgar");
        tf2.setBorder(null);
        tf3 = new JTextField(10);
        tf3.setEditable(false);
        tf3.setText("Edgar");
        tf3.setBorder(null);
        tf4 = new JTextField(10);
        tf4.setEditable(false);
        tf4.setText("Edgar");
        tf4.setBorder(null);
        tf5 = new JTextField(10);
        tf5.setEditable(false);
        tf5.setText("Edgar");
        tf5.setBorder(null);
        tf6 = new JTextField(10);
        tf6.setEditable(false);
        tf6.setText("Edgar");
        tf6.setBorder(null);
        tf7 = new JTextField(10);
        tf7.setEditable(false);
        tf7.setText("Edgar");
        tf7.setBorder(null);
        tf8 = new JTextField(10);
        tf8.setEditable(false);
        tf8.setText("Edgar");
        tf8.setBorder(null);
//        tf.setBackground(Color.WHITE);
        
		jogador1 = new JPanel();
//		jogador1.add(tf);
		jogador1.add(fundo = new JLabel(getImagem("FundoJogador.png")));
		fundo.add(tf1);
		jogador2 = new JLabel("Jogador2");
		jogador3 = new JLabel("Jogador3");
		jogador4 = new JLabel("Jogador4");
		jogador5 = new JLabel("Jogador5");
		jogador6 = new JLabel("Jogador6");
		jogador7 = new JLabel("Jogador7");
		jogador8 = new JLabel("Jogador8");
				
		playerEsquerda.setLayout(new GridLayout(8, 1));
		playerEsquerda.setVisible(true);
		playerEsquerda.add(tf1);
		playerEsquerda.add(jogador1);
		playerEsquerda.add(tf2);
		playerEsquerda.add(jogador2);
		playerEsquerda.add(tf3);
		playerEsquerda.add(jogador3);
		playerEsquerda.add(tf4);
		playerEsquerda.add(jogador4);
		telaPrincipal.add(BorderLayout.WEST,playerEsquerda);
		
		Container playerDireita = new JPanel();
		playerDireita.setLayout(new GridLayout(8, 1));
		playerDireita.add(tf5);
		playerDireita.add(jogador5);
		playerDireita.add(tf6);
		playerDireita.add(jogador6);
		playerDireita.add(tf7);
		playerDireita.add(jogador7);
		playerDireita.add(tf8);
		playerDireita.add(jogador8);
		telaPrincipal.add(BorderLayout.EAST,playerDireita);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setLocation(300, 100);;
		setVisible(true);
	}
	public ImageIcon getImagem(String nome){  
        String caminhoDaImagem = "/media/edgar/VICTOR/WorkspaceNew/vinteUm/baralho/" + nome;  
        ImageIcon icone = new ImageIcon(caminhoDaImagem);  
        return icone;  
    }  
	
//	public void construtorTela(){
//		preparaTelaPrincipal();
//		preparaPlayerEsquerda();
//		preparaPlayerDireita();
//	}
//	
//	public void preparaTelaPrincipal(){
////		
//	}
//	
//	public void preparaPlayerEsquerda(){
//		
//		telaPrincipal.add(BorderLayout.WEST,playerEsquerda);
//	}
//	
//	public void preparaPlayerDireita(){
//		
//		
//		telaPrincipal.add(BorderLayout.EAST,playerDireita);
//	}
	
	public static void main(String[] args) {
		new Tela();
	}	
}