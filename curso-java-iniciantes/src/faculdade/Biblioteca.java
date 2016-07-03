package faculdade;

import java.util.List;

public class Biblioteca extends Sala{

	public List<String> livros;
	public List<Funcionario> funcionarios;
	public List<Aluno> alunos;
	public List<Computador> computadores;
	
	@Override
	Integer quantidadeJanelas() {
		return 0;
	}
	@Override
	Integer quantidadePortas() {
		return 2;
	}
	@Override
	Integer quantidadeLampadas() {
		return 5;
	}
	
	
	
	
}
