package dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import dao.SorveteDao;
import entidade.Sorvete;
import util.JpaUtil;

public class SorveteDaoImpl implements SorveteDao {

	private EntityManager em;
	private EntityTransaction et;

	public void inserir(Sorvete sorvete) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.persist(sorvete);
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

	public void remover(String nome) {

		try {
			this.em = JpaUtil.getEntityManager();
			et = em.getTransaction();
			et.begin();
			em.remove(em.find(Sorvete.class, nome));
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

	public List<Sorvete> listarTodos() {

		this.em = JpaUtil.getEntityManager();
		Query query = em.createQuery("from Sorvete e");
		List<Sorvete> listaSorvete = query.getResultList();
		em.close();
		return listaSorvete;
	}
}
