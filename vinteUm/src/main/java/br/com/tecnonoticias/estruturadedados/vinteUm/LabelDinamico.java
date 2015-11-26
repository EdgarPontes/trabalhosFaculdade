package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class LabelDinamico {
	
	 public static void main(String[] args) {
         
         JFrame janela = new JFrame("Inserindo labels dinamicamente");
         janela.setBounds(0,0,1000,500);
         janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         janela.setLayout(null);
        
         // Diretório contendo as imagens
         File diretorio = new File("/media/edgar/VICTOR/WorkspaceNew/vinteUm/src/main/java/br/com/tecnonoticias/estruturadedados/imagens/baralho");  
         File[] arquivos = diretorio.listFiles();
        
         // Posicionamento dos labels
         int boundX = 10;               
         int boundY = 10;

        
         // Adicionando labels dinamicamente
         for (int x = 0; x < arquivos.length; x++){
                
                 // Declara uma imagem com o arquivo na posição do vetor
                 final ImageIcon imagem = new ImageIcon(((File)arquivos[x]).getAbsolutePath());
                
                 // Declara o label
                 JLabel lbImagem = new JLabel()
                 // Esse bloco é para inserir a imagem
                 //e  esticar de acordo com o tamanho label
                 {
                         public void paintComponent (Graphics g) {
                         super.paintComponent (g);
                                 // Esses 5 sendo subtraídos é pra dar um espaço entre as imagens
                             g.drawImage (imagem.getImage(), 0, 0, getWidth()-5 , getHeight()-5 , null);
                         }
                 };

                 // Posiciona a imagem
                 lbImagem.setBounds(boundX, boundY, 70, 70);
                
                 // Seta o nome com o caminho da imagem
                 // Será usado depois para retornar o caminho quando clidado
                 lbImagem.setName(((File)arquivos[x]).getAbsolutePath());

                 // Adiciona um listener
                 lbImagem.addMouseListener(new MouseListener() {
                         public void mouseReleased(MouseEvent arg0) {}
                         public void mousePressed(MouseEvent arg0) {}
                         public void mouseExited(MouseEvent arg0) {}
                         public void mouseEntered(MouseEvent arg0) {}
                         public void mouseClicked(MouseEvent arg0) {
                                
                                 // Pega o label que foi clicado
                                 JLabel lb = (JLabel) arg0.getSource();
                                 // Mosta o caminho da imagem clicada
                                 JOptionPane.showMessageDialog(null, "O caminho da imagem é " + lb.getName(), "Imagem", JOptionPane.INFORMATION_MESSAGE);
                         }
                 });
                
                 // Prepara a posição x do próximo label
                 boundX += 70;
                
                 // Verifica se estourou o limite
                 if (boundX >= janela.getWidth() - 70)
                 {
                         // Desce uma fila
                         boundY += 70;
                         boundX = 10;
                 }

                 //Adiciona o label
                 janela.add(lbImagem);
         }
        
         // Pegando todos os componentes
         Component[] labels = new Component[janela.getContentPane().getComponents().length];
         labels = janela.getContentPane().getComponents();
        
         for (int x = 0; x < labels.length; x++){
                 if (labels[x] instanceof JLabel)
                 {
                         // Mostra todos os text dos labels
                         System.out.println(((JLabel)labels[x]).getName());
                 }
         }

         janela.setVisible(true);
 }

}
