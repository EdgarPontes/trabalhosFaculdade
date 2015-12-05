package br.aula.tela;

public abstract class AbstractMenu 
        extends javax.swing.JDialog 
        implements Botoes {

    @Override
    public void novo() {
        System.out.println("Limpe as tela");
        System.out.println("Habilite os campos");
    }

    @Override
    public void salvar() {
        System.out.println("salva o objeto");
        System.out.println("mostrar mensagem");
        System.out.println("Limpe as tela");
        System.out.println("desabilite os campos");
    }

    @Override
    public void consultar() {
        System.out.println("Abre tela de consulta");
        System.out.println("executa consulta");
        System.out.println("retorna resultado");
    }

    @Override
    public void editar() {
        consultar();
        System.out.println("habilite os campos");
        salvar();
    }

    @Override
    public void excluir() {
        consultar();
        System.out.println("exclui");
        System.out.println("mostra mensagem");
        System.out.println("limpa campos");
        System.out.println("desabilita campos");
    }

    @Override
    public void sair() {
        System.out.println("limpa as tela");
        System.out.println("desabilita os campos");
        System.out.println("fecha ");
    }

}
