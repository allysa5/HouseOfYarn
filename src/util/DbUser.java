package util;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Yuser;


/**
 * @author djw
 * DbUser class contains helper methods for working with Bhusers
 *
 */
public class DbUser {
/**
 * Gets a Bhuser from the database
 * @param userID - primary key from database. Must be type long
 * @return Bhuser
 */
	public static Yuser getUser(int userID)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		Yuser user = em.find(Yuser.class, userID);
		return user;		
	}
	
	public static void insert(Yuser sUser) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		//System.out.println("DbBullhorn: begin transaction");
		try {
			trans.begin();
			em.persist(sUser);
			em.flush();
			//System.out.println("DbBullhorn: commit transaction");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("DbBullhorn: rollback transaction");
			trans.rollback();
		} finally {
			//System.out.println("DbBullhorn: close em");
			em.close();
		}
	}
	
	/**
	 * Updates the data in a Bhuser
	 * Pass the method a Bhuser with all the values set to your liking and 
	 * this method will update the database with these values.
	 * This method doesn't actually return anything but the good feeling
	 * that your update has been completed. If it can't be completed then 
	 * it won't tell you. Sounds like something needs to be added in the future. Hmmm.
	 * @param bhUser
	 */
	public static void update(Yuser sUser) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(sUser);
			em.flush();
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}

	/**
	 * Removes a Bhuser from the database.
	 * Not sure why you'd want to delete a Bhuser from the database but this
	 * method will do it for you. This method does not explicitly remove the user's
	 * posts but most likely you've set up the database with cascading deletes which
	 * will take care of that.Gives no feedback.
	 * @param bhUser that you never want to see again
	 */
	public static void delete(Yuser sUser) {
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(em.merge(sUser));
			trans.commit();
		} catch (Exception e) {
			System.out.println(e);
			trans.rollback();
		} finally {
			em.close();
		}
	}


	/**
	 * Gets a user given their email address.
	 * You've got the email when they log in but you really need the 
	 * user and all its related information This method will find the user
	 * matching that email. The database should ensure that you can't have two users
	 * with the same email. Otherwise there's no telling what you'd get.
	 * @param email
	 * @return Bhuser with that unique email address
	 */
	public static Yuser getUserByEmail(String yuseremail)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select u from Yuser u "
				+ "where u.yuseremail = :yuseremail";
		TypedQuery<Yuser> q = em.createQuery(qString, Yuser.class);
		q.setParameter("yuseremail", yuseremail);
		Yuser yuser = null;
		try {
			yuser = q.getSingleResult();
		}catch (NoResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		return yuser;
		
	}
	
	/**
	 * Is this user valid? This method has the answer for you.
	 * Checks the database and counts the number of users with this
	 * username and password. If it returns 0 then either the username
	 * or password don't exist in the database. If it returns 1 then you have found 
	 * the user with that username and password. If it returns >1 then you need to 
	 * fix your database first.
	 * @param user of type Bhuser
	 * @return true or false indicating the user exists or doesn't
	 */
	public static boolean isValidUser(Yuser yuser)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.yuserid) from Yuser b "
			+ "where b.yuseremail = :yuseremail and b.yuserpassword = :yuserpass";
		TypedQuery<Long> q = em.createQuery(qString,Long.class);
		boolean result = false;
		q.setParameter("yuseremail", yuser.getYuseremail());
		q.setParameter("yuserpass", yuser.getYuserpassword());
		
		try{
			long yuserId = q.getSingleResult();
			if (yuserId > 0)
			{
				result = true;
				
			}
		}catch (Exception e){
			
			result = false;
		}
		finally{
				em.close();		
		}	
		return result;
			
	}
	
	public static boolean isValidUser(String yuseremail, String yuserpassword)
	{
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String qString = "Select count(b.yuserid) from Yuser b "
			+ "where b.yuseremail = :yuseremail and b.yuserpassword = :yuserpass";
		TypedQuery<Long> q = em.createQuery(qString,Long.class);
		boolean result = false;
		q.setParameter("yuseremail", yuseremail);
		q.setParameter("yuserpass", yuserpassword);
		
		try{
			long yuserId = q.getSingleResult();
			if (yuserId > 0)
			{
				result = true;
			}
		}catch (Exception e){
			
			result = false;
		}
		finally{
				em.close();		
		}	
		return result;
			
	}
	
}
