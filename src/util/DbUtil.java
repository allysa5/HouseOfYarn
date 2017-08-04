package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbUtil {
private static final EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("HouseOfYarn2");
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
}
