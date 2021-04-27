package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Cleiton
 * 
 *  A classe JpaUtil tem a funcionalidade de disponibilizar as EntityManager(Conexões com o banco de dados)
 *  Também é uma classe sington, só vai existir uma instância dessa classe no projeto todo.
 *
 */
public class JpaUtil {
	
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory("TURMAMV");
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void close() {
		factory.close();
	}

}
