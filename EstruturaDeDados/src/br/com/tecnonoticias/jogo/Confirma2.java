package br.com.tecnonoticias.jogo;

import javax.swing.JOptionPane;

public class Confirma2 extends Confirma3{	

	Confirma4 macaco = new Confirma4();
	
    public void eummacaco(){
    	

        int retorno = JOptionPane.showConfirmDialog( null, "O animal que você pensou é um ?" + 
        noDireito.animal, "Jogo do Animais", JOptionPane.YES_NO_OPTION );
        
        if( retorno == JOptionPane.YES_OPTION ) {
        	
        	AcertarOAnimal();
//            JOptionPane.showMessageDialog( null, "Acertei de novo!", "Jogo dos Animais", JOptionPane.OK_OPTION );
            
        }else {
        	
           macaco.naoemacaco();
        }
    }	
}