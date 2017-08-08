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

	private int productid;

	@Temporal(TemporalType.DATE)
	private Date purchasedate;

	private int quantity;

	//bi-directional many-to-one association to Yuser
	@ManyToOne
	@JoinColumn(name="YUSERID")
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

	public int getProductid() {
		return this.productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
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

	public Yuser getYuser() {
		return this.yuser;
	}

	public void setYuser(Yuser yuser) {
		this.yuser = yuser;
	}

	public void setProduct(Product newCartItem) {
		// TODO Auto-generated method stub
		
	}

}