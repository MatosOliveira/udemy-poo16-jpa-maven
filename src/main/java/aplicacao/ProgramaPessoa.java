/**
 * 
 */
package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

/**
 * @author Matos
 *
 */
public class ProgramaPessoa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pessoa p1 = new Pessoa(null, "Sergio", "sergio@gmail.com");
		Pessoa p2 = new Pessoa(null, "Eusebio", "eusebio@gmail.com");
		Pessoa p3 = new Pessoa(null, "Marx", "marx@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		 * em.getTransaction().begin(); 
		 * em.persist(p1); 
		 * em.persist(p2); 
		 * em.persist(p3);
		 * em.getTransaction().commit();
		 */
		
		//Pesquisa no banco
		Pessoa p = em.find(Pessoa.class, 3);
		//System.out.println(p);
		
		//Removendo uma pessoa (monitorada)
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto!");
		
		em.close();
		emf.close();

	}

}
