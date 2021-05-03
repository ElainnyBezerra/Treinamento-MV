package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.PessoaDao;
import entidade.Pessoa;
import util.JpaUtil;

public class PessoaDaoImpl implements PessoaDao {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void inserir(Pessoa pessoa) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.createNativeQuery("INSERT INTO PESSOA (CPF, NOME) VALUES (?,?)").setParameter(1, pessoa.getCpf())
					.setParameter(2, pessoa.getNome()).executeUpdate();
			et.commit();
			System.out.println("Pessoa inserida com Sucesso!!");

		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public void atualizar(Pessoa pessoa) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.createNativeQuery("UPDATE PESSOA SET NOME = ? WHERE CPF = ?").setParameter(1, pessoa.getNome())
					.setParameter(2, pessoa.getCpf()).executeUpdate();
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}

	}

	@Override
	public void remover(String cpf) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Pessoa.class, cpf));
			et.commit();
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public Pessoa consultar(String cpf) {

		Pessoa pessoa = new Pessoa();

		try {
			this.em = JpaUtil.getEntityManager();
			pessoa = em.find(Pessoa.class, cpf);
		} catch (Exception e) {
			if (em.isOpen()) {
				et.rollback();
			}
			System.out.println("Erro transação");
		} finally {
			if (em.isOpen()) {
				em.close();
			}
		}
		return pessoa;
	}

	@Override
	public List<Pessoa> listarTodos() {

		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Pessoa e");
		List<Pessoa> listaPessoa = query.getResultList();
		em.close();
		return listaPessoa;
	}

}
