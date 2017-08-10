package util;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Product;
import model.Yuseritem;
import model.Yuser;

public class DbItems {
		public static void insert(Yuseritem cartitem) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.persist(cartitem);
				System.out.println(cartitem.getItemid()+" inserted");
				em.flush();
				trans.commit();
			} catch (Exception e) {
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void update(Yuseritem cartitem) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.merge(cartitem);
				trans.commit();
			} catch (Exception e) {
				trans.rollback();
			} finally {
				em.close();
			}
		}

		public static void delete(Yuseritem cartitem) {
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			EntityTransaction trans = em.getTransaction();
			try {
				trans.begin();
				em.remove(em.merge(cartitem));
				trans.commit();
			} catch (Exception e) {
				System.out.println(e);
				trans.rollback();
			} finally {
				em.close();
			}
		}


		public static List<Yuseritem> getCartitems (int id){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select p from Yuseritem p where p.yuser.yuserid = " + id + " and p.list='CART'";
			
			
			List<Yuseritem>cartitem = null;
			try{
				TypedQuery<Yuseritem> query = em.createQuery(qString,Yuseritem.class);
				
				cartitem = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				em.close();
			}
			return cartitem;
		}

		public static Yuseritem getItem (int id){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select p from Yuseritem p where p.itemid = " + id + " and p.list='CART'";
			
			
			Yuseritem cartitem = null;
			try{
				TypedQuery<Yuseritem> query = em.createQuery(qString,Yuseritem.class);
				
				cartitem = query.getSingleResult();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				em.close();
			}
			return cartitem;
		}
		
		public static List<Yuseritem> searchPurchased (int id, String search){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select p from Yuseritem p where p.yuser.yuserid = " + id + " and p.list='PURC' and p.product.productname like :search order by p.purchasedate desc";
			
			
			List<Yuseritem>cartitem = null;
			try{
				TypedQuery<Yuseritem> query = em.createQuery(qString,Yuseritem.class);
				query.setParameter("search","%" + search + "%");
				cartitem = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				em.close();
			}
			return cartitem;
		}
		
		public static List<Yuseritem> getPurchased (int id){
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			String qString = "select p from Yuseritem p where p.yuser.yuserid = " + id + " and p.list='PURC' order by p.purchasedate desc";
			
			
			List<Yuseritem>cartitem = null;
			try{
				TypedQuery<Yuseritem> query = em.createQuery(qString,Yuseritem.class);
				cartitem = query.getResultList();

			}catch (Exception e){
				e.printStackTrace();
			}
			finally{
				em.close();
			}
			return cartitem;
		}
		
	/*	public static Yuseritem getCartitem(int pID)
		{
			EntityManager em = DbUtil.getEmFactory().createEntityManager();
			Yuseritem cartitem = em.find(Yuseritem.class, pID);
			return cartitem;		
		}
	*/
		/*
			public static List<Product> postsofUser(long userid)
			{
				EntityManager em = DbUtil.getEmFactory().createEntityManager();
				List<Bhpost> userposts = null;
				String qString = "select b from Bhpost b where b.bhuser.bhuserid = :userid";

				try{
					TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
					query.setParameter("userid", userid);
					userposts = query.getResultList();
				}catch (Exception e){
					e.printStackTrace();
				}
				finally{
						em.close();
					}
				return userposts;	
			}
			public static List<Bhpost> postsofUser(String useremail)
			{
				EntityManager em = DbUtil.getEmFactory().createEntityManager();
				List<Bhpost> userposts = null;
				String qString = "select b from Bhpost b "
						+ "where b.bhuser.useremail = :useremail";

				try{
					TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
					query.setParameter("useremail", useremail);
					userposts = query.getResultList();
				}catch (Exception e){
					e.printStackTrace();
				}
				finally{
						em.close();
					}
				return userposts;	
			}

			public static List<Bhpost> searchPosts (String search)
			{
				EntityManager em = DbUtil.getEmFactory().createEntityManager();
				List<Bhpost> searchposts = null;
				String qString = "select b from Bhpost b "
						+ "where b.posttext like :search";

				try{
					TypedQuery<Bhpost> query = em.createQuery(qString,Bhpost.class);
					query.setParameter("search", "%" + search + "%");
					searchposts = query.getResultList();
				}catch (Exception e){
					e.printStackTrace();
				}finally{
					em.close();
				}return searchposts;
			}
		 */

	



}
