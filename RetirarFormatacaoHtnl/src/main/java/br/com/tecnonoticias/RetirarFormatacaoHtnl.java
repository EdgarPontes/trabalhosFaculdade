package br.com.tecnonoticias;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

public class RetirarFormatacaoHtnl extends HTMLEditorKit.ParserCallback{
	
	StringBuffer s;
	   // public Html2Text() {}
	    public void parse(Reader in) throws IOException {
	        s = new StringBuffer();
	        ParserDelegator delegator = new ParserDelegator();
	        // the third parameter is TRUE to ignore charset directive
	        delegator.parse(in, this, Boolean.TRUE);
	    }
	    public void handleText(char[] text, int pos) {
	        s.append(text);
			s.append("\n");
	    }
	    public String getText() {
	        return s.toString();
	    }
	    public static void main (String[] args) throws FileNotFoundException, IOException {
	            // the HTML to convert
	            FileReader in = new FileReader("/home/edgar/Downloads/lotofacil.html");
	            RetirarFormatacaoHtnl parser = new RetirarFormatacaoHtnl();
	            parser.parse(in);
	            in.close();
				
				FileWriter arq = new FileWriter("/home/edgar/Downloads/lotofacil.txt");
				PrintWriter gravarArq = new PrintWriter(arq);
				gravarArq.println(parser.getText());
	    
				arq.close();
				
	            System.out.println(parser.getText());
	    }

}
