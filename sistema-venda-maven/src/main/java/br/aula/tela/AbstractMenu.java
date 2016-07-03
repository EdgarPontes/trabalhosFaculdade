package br.aula.tela;

public abstract class AbstractMenu 
        extends javax.swing.JDialog 
        implements Botoes {

    @Override
    public void novo() {
        limpaCampo();
//        habilitaCampos();
    }

    @Override
    public void salvar() {
        System.out.println("salva o objeto");
        System.out.println("mostrar mensagem");
        System.out.println("Limpe as tela");
//        dezabilitaCampos();
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
//        habilitaCampos();
        salvar();
    }

    @Override
    public void excluir() {
        consultar();
        System.out.println("exclui");
        System.out.println("mostra mensagem");
        limpaCampo();
//        dezabilitaCampos();
    }

    @Override
    public void sair() {
        limpaCampo();
//        dezabilitaCampos();
        System.out.println("fecha ");
    }
    
    public abstract void limpaCampo();
    
    public abstract void habilitaCampos(boolean isEnable);

}
