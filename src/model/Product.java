package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productid;

	private String image;

	private float price;

	private String productdesc;

	private int productinv;

	private String productname;

	private Object Yuseritems;

	public Product() {
	}

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getProductdesc() {
		return this.productdesc;
	}

	public void setProductdesc(String productdesc) {
		this.productdesc = productdesc;
	}

	public int getProductinv() {
		return this.productinv;
	}

	public void setProductinv(int productinv) {
		this.productinv = productinv;
	}

	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	public List<Yuseritem> getYuseritem(){
		return this.getYuseritem();
	}
	public void setYuseritems(List<Yuseritem> yuseritems) {
		this.Yuseritems = Yuseritems;
	}

	public Yuseritem addSamitem(Yuseritem yuseritem) {
		getYuseritem().add(yuseritem);
		Yuseritem.setProduct(this);

		return yuseritem;
	}

	public Yuseritem removeSamitem(Yuseritem yuseritem) {
		getYuseritem().remove(yuseritem);
		yuseritem.setProduct(null);

		return yuseritem;
	}
}