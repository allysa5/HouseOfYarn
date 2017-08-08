import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Product;
import model.Yuser;
import util.DbProduct;
import util.DbUser;

public class ProductTest {

	@Test
	public void test() {
		List<Product> products = null;
		products = DbProduct.getProducts();
		System.out.println(products.get(0).getProductid());
		assertTrue(products.get(0).getProductname().equals("Inga Indigo Yarn"));
	}
@Test
public void test2(){
	boolean isValidUser=DbUser.isValidUser("toma@toes.com", "pass");
	assertTrue(isValidUser);
}
@Test
public void test3(){
	Yuser u = DbUser.getUserByEmail("toma@toes.com");
	assertTrue(u.getYuseremail().equals("toma@toes.com"));
}
}
