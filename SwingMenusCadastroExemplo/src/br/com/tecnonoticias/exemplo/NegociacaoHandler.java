package br.com.tecnonoticias.exemplo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NegociacaoHandler extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		// aqui voce é avisado, por exemplo
		// do inicio da tag "<preco>"
	}

	@Override
	public void characters(char[] chars, int offset, int len) throws SAXException {
		// aqui voce seria avisado do inicio
		// do conteudo que fica entre as tags, como por exemplo 30
		// de dentro de "<preco>30</preco>"

		// para saber o que fazer com esses dados, voce precisa antes ter
		// guardado em algum atributo qual era a negociação que estava
		// sendo percorrida
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		// aviso de fechamento de tag
	}
}