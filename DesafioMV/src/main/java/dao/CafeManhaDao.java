package dao;

import java.util.List;

import entidade.CafeManha;

public interface CafeManhaDao {
	
	public void inserir(CafeManha cafeManha);
	public void atualizar(CafeManha cafeManha);
	public void remover(String opcao);
	public CafeManha consultar(String opcao);
	public List<CafeManha> listarTodos();

}
