package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the yuseritems database table.
 * 
 */
@Entity
@Table(name="yuseritems")
@NamedQuery(name="Yuseritem.findAll", query="SELECT y FROM Yuseritem y")
public class Yuseritem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int itemid;

	private String list;

	private float price;

	@Temporal(TemporalType.DATE)
	private Date purchasedate;

	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	//bi-directional many-to-one association to Yuser
	@ManyToOne
	@JoinColumn(name="yuserid")
	private Yuser yuser;

	public Yuseritem() {
	}

	public int getItemid() {
		return this.itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getList() {
		return this.list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getPurchasedate() {
		return this.purchasedate;
	}

	public void setPurchasedate(Date purchasedate) {
		this.purchasedate = purchasedate;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Yuser getYuser() {
		return this.yuser;
	}

	public void setYuser(Yuser yuser) {
		this.yuser = yuser;
	}

}