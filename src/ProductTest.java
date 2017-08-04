import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.Product;
import util.DbProduct;

public class ProductTest {

	@Test
	public void test() {
		List<Product> products = null;
		products = DbProduct.getProducts();
		System.out.println(products.get(0).getProductid());
		assertTrue(products.get(0).getProductname().equals("Inga Indigo Yarn"));
	}

}
