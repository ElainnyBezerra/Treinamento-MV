package dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.CafeManhaDao;
import entidade.CafeManha;
import util.JpaUtil;

public class CafeManhaDaoImpl implements CafeManhaDao {

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public void inserir(CafeManha cafeManha) {
		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.createNativeQuery("INSERT INTO CAFEMANHA (OPCAO, CPF_PESSOA) VALUES (?,?)")
					// .setParameter(1,cafeManha.getCod_opcao())
					.setParameter(1, cafeManha.getOpcao()).setParameter(2, cafeManha.getPessoa().getCpf())
					.executeUpdate();
			et.commit();

			System.out.println("Opção de Café da manhã inserida com Sucesso!!");

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
	public void atualizar(CafeManha cafeManha) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.createNativeQuery("UPDATE CAFEMANHA SET CPF_PESSOA = ? WHERE OPCAO = ?")
					.setParameter(2, cafeManha.getOpcao()).setParameter(1, cafeManha.getPessoa().getCpf())
					.executeUpdate();
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
	public void remover(String opcao) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.createNativeQuery(
					"DELETE FROM CAFEMANHA WHERE COD_OPCAO = (SELECT COD_OPCAO FROM CAFEMANHA WHERE OPCAO = ?)")
					.setParameter(1, opcao).executeUpdate();
			et.commit();
			System.out.println("Opção removida com Sucesso!!");
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
	public CafeManha consultar(String opcao) {

		CafeManha cafeManha = new CafeManha();

		try {
			this.em = JpaUtil.getEntityManager();
			cafeManha = em.find(CafeManha.class, opcao);
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
		return cafeManha;
	}

	@Override
	public List<CafeManha> listarTodos() {

		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from CafeManha e");
		List<CafeManha> listaCafeManha = query.getResultList();
		em.close();
		return listaCafeManha;
	}

}
