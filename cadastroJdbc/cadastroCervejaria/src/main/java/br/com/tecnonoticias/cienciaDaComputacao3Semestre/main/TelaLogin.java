package br.com.tecnonoticias.cienciaDaComputacao3Semestre.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.birosoft.liquid.LiquidLookAndFeel;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame implements ActionListener{
    	
     JPanel painel;
     
     JTextField user;
     JTextField senhaC;
     
     JPasswordField senha;
     
     JButton entra, cadastra ,salva ,login;
     JMenuBar barra;
     JMenu cadastro,consulta,sair;
     JMenuItem cliente,usuario,fornecedor, cCliente, cFornecedor, sair1;
     
     JLabel fundo;
     
     public TelaLogin(){
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    	setContentPane(new JLabel(new ImageIcon(getClass().getResource("/copo-de-cerveja.jpg"))));
    	
    	barra = new JMenuBar();  	
    	cadastro = new JMenu("Cadastro");
    	cliente = new JMenuItem("Cliente");
    	cliente.addActionListener(this);
    	cliente.setEnabled(false);
    	fornecedor = new JMenuItem("Fornecedor");
    	fornecedor.addActionListener(this);
    	fornecedor.setEnabled(false);
    	usuario = new JMenuItem("Usuario");
    	usuario.addActionListener(this);
    	usuario.setEnabled(false);
    	sair1 = new JMenuItem("Exit");
    	sair1.addActionListener(this);
    	sair = new JMenu("Sair");
    	sair.add(sair1);
    	cadastro.add(cliente);
    	cadastro.add(fornecedor);
    	cadastro.add(usuario);
    	cCliente = new JMenuItem("Cliente");
    	cCliente.addActionListener(this);
    	cCliente.setEnabled(false);
    	cFornecedor = new JMenuItem("Fornecedor");
    	cFornecedor.addActionListener(this);
    	cFornecedor.setEnabled(false);
    	consulta = new JMenu("Consulta");
    	consulta.add(cCliente);
    	consulta.add(cFornecedor);
    	barra.add(cadastro);
    	barra.add(consulta);
    	barra.add(sair);
    	setJMenuBar(barra);
    	
    	entra = new JButton("Entrar");
    	entra.setBounds(10, 110, 83, 50);
    	entra.addActionListener(this);

    	add(entra);
    	
    	setSize(800, 600);
    	setLocation(300, 200);    	
     }
     
     public static void main(String[] args) {
//    	try {
// 			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
// 			} catch (Exception ex) {
// 			ex.printStackTrace();
// 			}
//    	 lookandfeel();
		new TelaLogin();
	}

	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource()== entra){
		
		Login login = new Login();
		 	
		}else if (evento.getSource() == login){
			Login consulta = new Login();

			
		}else if (evento.getSource() == usuario){
//			JOptionPane.showConfirmDialog(null, "Deseja salvar o cadastro ? " );
			
			CadastroUsuario cadastro = new CadastroUsuario();
			
			
		}else if(evento.getSource() == cliente){
			Clientes cliente = new Clientes();
			cliente.setVisible(true);
			
		}else if(evento.getSource() == fornecedor){
			Fornecedor fornecedor = new Fornecedor();
			fornecedor.setVisible(true);
			
		}else if(evento.getSource() == cCliente){
			new BuscaCliente();
		
		}else if(evento.getSource() == cFornecedor){
			new BuscaFornecedor();
		
		}else if(evento.getSource() == sair1){
					int resposta;
					resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair", "Mensagem do programa", JOptionPane.YES_NO_OPTION);
					if (resposta == 0)
						System.exit(0);
						
		}
		
		
	}
	public static void lookandfeel() {
		try {
			/**
			 * "com.birosoft.liquid.LiquidLookAndFeel" tema mac
			 * "com.jtattoo.plaf.aero.AeroLookAndFeel" tema aero
			 * "com.jtattoo.plaf.hifi.HiFiLookAndFeel" black
			 * "com.jtattoo.plaf.acryl.AcrylLookAndFeel" tema acryl
			 * "com.jtattoo.plaf.mcwin.McWinLookAndFeel" tema mcWin
			 * "com.jtattoo.plaf.smart.SmartLookAndFeel" tema smart
			 */
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			LiquidLookAndFeel.setLiquidDecorations(true, "mac");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
}