package br.com.tecnonoticias.estruturadedados.vinteUm;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import javax.swing.ImageIcon;

public class Baralho extends PilhaComandos{
	
	 int boundX = 10;               
     int boundY = 10;
     

	private Object[] baralho = { "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "QC", "JC", "KC",
			"AO", "2O", "3O", "4O", "5O", "6O", "7O", "8O", "9O", "10O", "QO", "JO", "KO", "AE", "2E", "3E", "4E", "5E",
			"6E", "7E", "8E", "9E", "10E", "QE", "JE", "KE", "AP", "2P", "3P", "4P", "5P", "6P", "7P", "8P", "9P",
			"10P", "QP", "JP", "KP" };

	/**
	 * @return the baralho
	 */
	public Object[] getBaralho() {
		return this.baralho;
	}

	public Object valor(Object cartaNaipe) {

		if (this.baralho[0].equals(cartaNaipe)) {
			return 1;
		} else if (this.baralho[1].equals(cartaNaipe)) {
			return 2;
		} else if (this.baralho[2].equals(cartaNaipe)) {
			return 3;
		} else if (this.baralho[3].equals(cartaNaipe)) {
			return 4;
		} else if (this.baralho[4].equals(cartaNaipe)) {
			return 5;
		} else if (this.baralho[5].equals(cartaNaipe)) {
			return 6;
		} else if (this.baralho[6].equals(cartaNaipe)) {
			return 7;
		} else if (this.baralho[7].equals(cartaNaipe)) {
			return 8;
		} else if (this.baralho[8].equals(cartaNaipe)) {
			return 9;
		} else if (this.baralho[9].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[10].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[11].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[12].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[13].equals(cartaNaipe)) {
			return 1;
		} else if (this.baralho[14].equals(cartaNaipe)) {
			return 2;
		} else if (this.baralho[15].equals(cartaNaipe)) {
			return 3;
		} else if (this.baralho[16].equals(cartaNaipe)) {
			return 4;
		} else if (this.baralho[17].equals(cartaNaipe)) {
			return 5;
		} else if (this.baralho[18].equals(cartaNaipe)) {
			return 6;
		} else if (this.baralho[19].equals(cartaNaipe)) {
			return 7;
		} else if (this.baralho[20].equals(cartaNaipe)) {
			return 8;
		} else if (this.baralho[21].equals(cartaNaipe)) {
			return 9;
		} else if (this.baralho[22].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[23].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[24].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[25].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[26].equals(cartaNaipe)) {
			return 1;
		} else if (this.baralho[27].equals(cartaNaipe)) {
			return 2;
		} else if (this.baralho[28].equals(cartaNaipe)) {
			return 3;
		} else if (this.baralho[29].equals(cartaNaipe)) {
			return 4;
		} else if (this.baralho[30].equals(cartaNaipe)) {
			return 5;
		} else if (this.baralho[31].equals(cartaNaipe)) {
			return 6;
		} else if (this.baralho[32].equals(cartaNaipe)) {
			return 7;
		} else if (this.baralho[33].equals(cartaNaipe)) {
			return 8;
		} else if (this.baralho[34].equals(cartaNaipe)) {
			return 8;
		} else if (this.baralho[35].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[36].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[37].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[38].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[39].equals(cartaNaipe)) {
			return 1;
		} else if (this.baralho[40].equals(cartaNaipe)) {
			return 2;
		} else if (this.baralho[41].equals(cartaNaipe)) {
			return 3;
		} else if (this.baralho[42].equals(cartaNaipe)) {
			return 4;
		} else if (this.baralho[43].equals(cartaNaipe)) {
			return 5;
		} else if (this.baralho[44].equals(cartaNaipe)) {
			return 6;
		} else if (this.baralho[45].equals(cartaNaipe)) {
			return 7;
		} else if (this.baralho[46].equals(cartaNaipe)) {
			return 8;
		} else if (this.baralho[47].equals(cartaNaipe)) {
			return 9;
		} else if (this.baralho[48].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[49].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[50].equals(cartaNaipe)) {
			return 10;
		} else if (this.baralho[51].equals(cartaNaipe)) {
			return 10;
		}
		return 0;
	}
	public String nome(Object baralho) {

		if (this.baralho[0].equals(baralho)) {
			return "asCopas.png";
		} else if (this.baralho[1].equals(baralho)) {
			return "doisCopas.png";
		} else if (this.baralho[2].equals(baralho)) {
			return "tresCopas.png";
		} else if (this.baralho[3].equals(baralho)) {
			return "quatroCopas.png";
		} else if (this.baralho[4].equals(baralho)) {
			return "cincoCopas.png";
		} else if (this.baralho[5].equals(baralho)) {
			return "seisCopas.png";
		} else if (this.baralho[6].equals(baralho)) {
			return "seteCopas.png";
		} else if (this.baralho[7].equals(baralho)) {
			return "oitoCopas.png";
		} else if (this.baralho[8].equals(baralho)) {
			return "noveCopas.png";
		} else if (this.baralho[9].equals(baralho)) {
			return "dezCopas.png";
		} else if (this.baralho[10].equals(baralho)) {
			return "damaCopas.png";
		} else if (this.baralho[11].equals(baralho)) {
			return "valeteCopas.png";
		} else if (this.baralho[12].equals(baralho)) {
			return "reisCopas.png";
		} else if (this.baralho[13].equals(baralho)) {
			return "asOuro.png";
		} else if (this.baralho[14].equals(baralho)) {
			return "doisOuro.png";
		} else if (this.baralho[15].equals(baralho)) {
			return "tresOuro.png";
		} else if (this.baralho[16].equals(baralho)) {
			return "quatroOuro.png";
		} else if (this.baralho[17].equals(baralho)) {
			return "cincoOuro.png";
		} else if (this.baralho[18].equals(baralho)) {
			return "seisOuro.png";
		} else if (this.baralho[19].equals(baralho)) {
			return "seteOuro.png";
		} else if (this.baralho[20].equals(baralho)) {
			return "oitoOuro.png";
		} else if (this.baralho[21].equals(baralho)) {
			return "noveOuro.png";
		} else if (this.baralho[22].equals(baralho)) {
			return "dezOuro.png";
		} else if (this.baralho[23].equals(baralho)) {
			return "damaOuro.png";
		} else if (this.baralho[24].equals(baralho)) {
			return "valeteOuro.png";
		} else if (this.baralho[25].equals(baralho)) {
			return "reisOuro.png";
		} else if (this.baralho[26].equals(baralho)) {
			return "asEspada.png";
		} else if (this.baralho[27].equals(baralho)) {
			return "doisEspada.png";
		} else if (this.baralho[28].equals(baralho)) {
			return "tresEspada.png";
		} else if (this.baralho[29].equals(baralho)) {
			return "quatroEspada.png";
		} else if (this.baralho[30].equals(baralho)) {
			return "cincoEspada.png";
		} else if (this.baralho[31].equals(baralho)) {
			return "seisEspada.png";
		} else if (this.baralho[32].equals(baralho)) {
			return "seteEspada.png";
		} else if (this.baralho[33].equals(baralho)) {
			return "oitoEspada.png";
		} else if (this.baralho[34].equals(baralho)) {
			return "noveEspada.png";
		} else if (this.baralho[35].equals(baralho)) {
			return "dezEspada.png";
		} else if (this.baralho[36].equals(baralho)) {
			return "damaEspada.png";
		} else if (this.baralho[37].equals(baralho)) {
			return "valeteEspada.png";
		} else if (this.baralho[38].equals(baralho)) {
			return "reisEspada.png";
		} else if (this.baralho[39].equals(baralho)) {
			return "asPaus.png";
		} else if (this.baralho[40].equals(baralho)) {
			return "doisPaus.png";
		} else if (this.baralho[41].equals(baralho)) {
			return "tresPaus.png";
		} else if (this.baralho[42].equals(baralho)) {
			return "quatroPaus.png";
		} else if (this.baralho[43].equals(baralho)) {
			return "cincoPaus.png";
		} else if (this.baralho[44].equals(baralho)) {
			return "seisPaus.png";
		} else if (this.baralho[45].equals(baralho)) {
			return "setePaus.png";
		} else if (this.baralho[46].equals(baralho)) {
			return "oitoPaus.png";
		} else if (this.baralho[47].equals(baralho)) {
			return "novePaus.png";
		} else if (this.baralho[48].equals(baralho)) {
			return "dezPaus.png";
		} else if (this.baralho[49].equals(baralho)) {
			return "damaPaus.png";
		} else if (this.baralho[50].equals(baralho)) {
			return "valetePaus.png";
		} else if (this.baralho[51].equals(baralho)) {
			return "reisPaus.png";
		}
		return "";
	}

    public ImageIcon getImagem(String nome) throws MalformedURLException{  
        String caminhoDaImagem = "/media/edgar/309A4BF49A4BB4DE/Git/faculdade/trabalhosFaculdade/vinteUm/src/main/java/br/com/tecnonoticias/estruturadedados/imagens/baralho/" + nome ;  
        Image img = Toolkit.getDefaultToolkit().getImage(caminhoDaImagem);
		Image menor = img.getScaledInstance(80, 100, Image.SCALE_DEFAULT);
		ImageIcon icone = new ImageIcon(menor);  
		return icone;  
    }  
    
	public void jogador(){
		
	}
	
	public static void main(String[] args) {
		
		Baralho play = new Baralho();
		System.out.println(play.getBaralho()[51]);
		System.out.println(play.nome("2C"));
	}
}