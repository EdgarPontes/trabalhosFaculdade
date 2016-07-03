package tutor8;

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
	
	//ESSA É A NOSSA SPRITE!
	//VERIFIQUE AGORA O MÉTODO inicializar()
	//LÁ VAMOS INICIAR AS IMAGENS QUE VAMOS USAR NESSA SPRITE!
	//DEPOIS VERIFIQUE O MÉTODO desenharGraficos()
	//VEJA QUE ESSA SPRITE TEM 3 CENAS!!!
	Sprite vilao = new Sprite(3, 200, 300);
	Sprite vilao2 = new Sprite(3, 100, 200);
	
	ImageIcon fundo = new ImageIcon("src/tutor8/fundo.png");
	
	public void atualizar() {

	}

	public void desenharGraficos() {
		Graphics g = getGraphics();	//ISSO JÁ ESTAVA AQUI
		Graphics bbg = backBuffer.getGraphics();//ISSO TAMBÉM JÁ ESTAVA AQUI...
		//AQUI VAMOS MANDAR DESENHAR ALGUNS IMAGENS NA TELA
		bbg.drawImage(fundo.getImage(),0,0,this);//QUI DESENHAMOS O FUNDO
		//AS DIMENSÕES ORIGINAIS DO FUNDO SÃO: 500X500 QUE É O TAMANHO DA NOSSA TELA!
		
		//AQUI TO DESENHANDO A O NOSSO PERSONAGEM
		//VEJA QUE NOSSO vilão tem tudo que agente precisa!
		//SUAS COORDENADAS, LARGURA, ALTURA, E AS IMAGENS!!!
		bbg.drawImage(vilao.cenas[vilao.cena].getImage(), vilao.x, vilao.y, this);
		vilao.animar();	//AQUI CHAMEI O MÉTODO ANIMAR
		
		
		bbg.drawImage(vilao2.cenas[vilao2.cena].getImage(), vilao2.x, vilao2.y, this);
		vilao2.animarMaisLento();	//AQUI CHAMEI O MÉTODO ANIMAR MAIS LENTO
		
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
		
		//QUI CARREGAMOS AS IMAGENS DE NOSSA SPIRTE!!!!!!!
		//PARA O VETOR DE ImageIcon[] !!!
		vilao.cenas[0] = new ImageIcon("src/tutor8/s1.gif");
		vilao.cenas[1] = new ImageIcon("src/tutor8/s2.gif");
		vilao.cenas[2] = new ImageIcon("src/tutor8/s3.gif");
		vilao.largura = 100;	//LARGURA DO VILÃO
		vilao.altura =  200;	//ALTURA DO VILÃO , mas não vou usar isso agora..
		
		//QUI CARREGAMOS AS IMAGENS DE NOSSA SPIRTE!!!!!!!
		//PARA O VETOR DE ImageIcon[] !!!
		vilao2.cenas[0] = new ImageIcon("src/tutor8/s1.gif");
		vilao2.cenas[1] = new ImageIcon("src/tutor8/s2.gif");
		vilao2.cenas[2] = new ImageIcon("src/tutor8/s3.gif");
		vilao2.largura = 100;	//LARGURA DO VILÃO
		vilao2.altura =  200;	//ALTURA DO VILÃO , mas não vou usar isso agora..
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