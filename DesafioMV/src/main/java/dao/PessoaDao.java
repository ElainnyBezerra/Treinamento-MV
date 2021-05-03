package dao;

import java.util.List;

import entidade.Pessoa;

public interface PessoaDao {
	
	public void inserir(Pessoa pessoa);
	public void atualizar(Pessoa pessoa);
	public void remover(String cpf);
	public Pessoa consultar(String cpf);
	public List<Pessoa> listarTodos();

}
