package br.com.tecnonoticias.transferenciaArquivo;

import java.net.*;
import java.io.*;

/* Esta class cria uma Thread */
public class Arquivo extends Thread {

    /* declara variável e inicia com valor null */
    ServerSocket lista = null;
    /* declara o socket cliente e inicia com valor null */    
    Socket cliente = null;

    private final int port = 999;
    private final String filename = "teste.zip";

    private void IniciaServer(){

        /* tenta iniciar o listen do server, se não sai */
        try {
            lista = new ServerSocket(port);        
        }catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }

        /* while infinito , para que o server aceite várias conexões
         * em diferentes tempos . 
         */

        while (true) {

            try {

                /* pronto o servidor aceitou o cliente  */
                cliente = lista.accept();

                /* agora e so preparar o outputstream para enviar o arquivo */

                DataOutputStream out = new DataOutputStream (cliente.getOutputStream());

                /* abrir arquivo para o envio  */
                FileInputStream fin = new FileInputStream (filename);
                DataInputStream in = new DataInputStream (fin);

                /* cria um buffer de 512 bytes para o envio */
                byte buffer[] = new byte[512];            

                /* envia os dados :) */
                while (in.read(buffer) != -1)
                    out.write(buffer,0,buffer.length);

            }catch (Exception e){
                System.out.println(e);
                System.exit(0);
            } finally {

                /* tenta fechar o cliente  */
                try {
                    cliente.close();
                }catch (Exception e) {
                    System.exit(0);
                }

            }

        }

    }

    /* Método herdado de Thread
    * este metodo e chamado quando se iniciar a thread 
  */
    public void run(){
        IniciaServer();
    }
}