package br.com.tecnonoticias.Aula4;

public abstract class AbstractMenu implements Botoes{

	@Override
    public void novo() {
        System.out.println("Limpe as telas");
        System.out.print("Habilitar campos");
    }

    @Override
    public void salvar() {
        System.out.println("salve o objeto");
        System.out.print("mostrar mensagem");
        System.out.println("limpe as telas");
        System.out.print("desabilite os campos");
    }

    @Override
    public void consulta() {
        System.out.println("Abre a tela de consulta");
        System.out.print("executa consulta");
        System.out.print("monstra resultados");
    }

    @Override
    public void editar() {
        consulta();
        System.out.println("habilite os campos");
        salvar();
    }

    @Override
    public void excluir() {
    	
    	consulta();
        System.out.println("excluir");
        System.out.println("Excluido com sucesso!");
        System.out.println("limpa os campos");
        System.out.println("desabilita os campos");
        
    } 
	
}
