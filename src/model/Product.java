package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int productid;

	private String image;

	private float price;

	private String productdesc;

	private int productinv;

	private String productname;

	//bi-directional many-to-one association to Yuseritem
	@OneToMany(mappedBy="product")
	private List<Yuseritem> yuseritems;

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

	public List<Yuseritem> getYuseritems() {
		return this.yuseritems;
	}

	public void setYuseritems(List<Yuseritem> yuseritems) {
		this.yuseritems = yuseritems;
	}

	public Yuseritem addYuseritem(Yuseritem yuseritem) {
		getYuseritems().add(yuseritem);
		yuseritem.setProduct(this);

		return yuseritem;
	}

	public Yuseritem removeYuseritem(Yuseritem yuseritem) {
		getYuseritems().remove(yuseritem);
		yuseritem.setProduct(null);

		return yuseritem;
	}

}