package ru.urscorp.dao.jpa;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.urscorp.dao.dto.UserDto;
import ru.urscorp.dao.entity.Ip;
import ru.urscorp.dao.entity.User;
import ru.urscorp.dao.util.DaoUtils;

public class UtilJpaImpl implements UtilJpa {
	
	EntityManager em;
	
	@PersistenceContext(unitName="urscorp-dao")
	public void setEntityManager(EntityManager em){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("urscorp-dao", System.getProperties());
        this.em = factory.createEntityManager();
		//this.em = em;
	}
	public String test(){
		try {
			em.getTransaction().begin();
			//Query q = em.createQuery("SELECT u FROM User u");
			//List<User> res = q.getResultList();
			User u = new User();
			
			u.setHash("new_hash23");
			u.setTs(DaoUtils.getTs());

			em.persist(u);
			em.getTransaction().commit();
			return "ok";
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		return "failed";
	}
	
	public void addUser (UserDto userDto){
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT a FROM Ip a WHERE a.ip = :ip");
		q.setParameter("ip", userDto.getIp());
		List<Ip> ipRes;
		Ip ip;
		if((ipRes=q.getResultList()).size()!=1){
			ip = new Ip();
			em.persist(ip);
			ip.setIp(userDto.getIp());
			ip.setTs(DaoUtils.getTs());
			ip.setPort(userDto.getPort());
		}
		User user;
		if(userDto.getHash()!=null){
			q = em.createQuery("SELECT u FROM User u WHERE u.hash = :hash");
			q.setParameter("hash", userDto.getHash());
			try {
				user = (User) q.getSingleResult();
			} catch (Exception e) {
				user = new User();
				user.setHash(""); //TODO generate hash
				user.setTs(DaoUtils.getTs());
				
			}
			
		}
		
		em.getTransaction().commit();
	}

}
