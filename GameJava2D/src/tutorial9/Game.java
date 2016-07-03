package tutorial9;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
 
public class Game extends JFrame {
 
 BufferedImage backBuffer; 
 int FPS = 30;
 int janelaW = 500;
 int janelaH = 500;
  
 //EU REMOVI O VILÃO 2 QUE TINHA AQUI...
 //E MUDEI A IMAGEM DO FUNDO, MAS ISSO É UM MERO DETALHE!!!
 Sprite vilao = new Sprite(3, 200, 300);
 
 ImageIcon fundo = new ImageIcon("src/tutor9/fundo.jpg");
 boolean vai = true;  //ESSA VARIÁVEL PODERIA ESTAR NA CLASSE Sprite
 boolean volta = false; //ESSA VARIÁVEL PODERIA ESTAR NA CLASSE Sprite
  
 //TENTE ENTENDER O CÓDIGO ABAIXO:
 //ESSE MÉTODO SERÁ RESPONSÁVEL POR FAZER O OBJETO IR E VOLTAR
 //ESSE MÉTODO TAMBÉM PODERIA ESTAR NA CLASSE SPRITE!!!
 //DEPENDENDO DO QUE SE PRETENDER FAZER, ESSE MÉTODO PODERIA SER MAIS COMPLEXO!!
 public void mover(){
  if(vai){  vilao.x += 5;  }
  if(volta){  vilao.x -= 5;  }
   
  if(vilao.x>400){ vai = false; volta = true; }
  if(vilao.x<100){ vai = true; volta = false; }
 }
  
 //AGORA DEVEMOS CHAMAR ESSE MÉTODO AQUI
 //PARA QUE ELE SEJA EXECUTADO O TEMPO INTEIRO
 public void atualizar() {
  mover();//AQUI CHAMAMOS O MÉTODO MOVER!
 }
 
 public void desenharGraficos() {
  Graphics g = getGraphics(); //ISSO JÁ ESTAVA AQUI
  Graphics bbg = backBuffer.getGraphics();//ISSO TAMBÉM JÁ ESTAVA AQUI...
  //AQUI VAMOS MANDAR DESENHAR ALGUNS IMAGENS NA TELA
  bbg.drawImage(fundo.getImage(),0,0,500,500,this);//QUI DESENHAMOS O FUNDO
  //AS DIMENSÕES ORIGINAIS DO FUNDO SÃO: 500X500 QUE É O TAMANHO DA NOSSA TELA!
   
   
  bbg.drawImage(vilao.cenas[vilao.cena].getImage(), vilao.x, vilao.y,this);
  vilao.animar();
   
   
  //================================================================================== 
  g.drawImage(backBuffer, 0, 0, this);//OBS: ISSO DEVE FICAR SEMPRE NO FINAL!
 }
 
 public void inicializar() {
  setTitle("Titulo do Jogo!");
  setSize(janelaW, janelaH);
  setResizable(false);
  setDefaultCloseOperation(EXIT_ON_CLOSE);
  setLayout(null);
  setVisible(true);
  backBuffer = new BufferedImage(janelaW, janelaH, BufferedImage.TYPE_INT_RGB);
 
  vilao.cenas[0] = new ImageIcon("src/tutor8/s1.gif");
  vilao.cenas[1] = new ImageIcon("src/tutor8/s2.gif");
  vilao.cenas[2] = new ImageIcon("src/tutor8/s3.gif");
 }
 
 public void run() {
  inicializar();
  while (true) {
   atualizar();
   desenharGraficos();
    try {
     Thread.sleep(1000/FPS);
    } catch (Exception e) {
     System.out.println("Thread interrompida!");
    }
  }
 }
 public static void main(String[] args) {
  Game game = new Game();
  game.run();
 }
}