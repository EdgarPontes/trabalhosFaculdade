package br.com.tecnonoticias.estruturadedados.tabela;

public class totalisaCarrinho {

	public double totalisaCarrinho1(double valorCompra, double desconto, double valorFrete) {

		double compraDesconto = valorCompra / desconto;
		double valorAPagar = 0;
		if (compraDesconto < valorCompra / 2 && valorCompra > 500) {
			valorAPagar = compraDesconto;
		} else if (compraDesconto > valorCompra / 2) {
			valorAPagar = compraDesconto + valorFrete;
		}

		return valorAPagar;

	}

}
