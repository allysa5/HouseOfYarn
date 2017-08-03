package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the yuser database table.
 * 
 */
@Entity
@NamedQuery(name="Yuser.findAll", query="SELECT y FROM Yuser y")
public class Yuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int yuserid;

	private String address;

	private String yuseremail;

	private String yusername;

	private String yuserpassword;

	//bi-directional many-to-one association to Yuseritem
	@OneToMany(mappedBy="yuser")
	private List<Yuseritem> yuseritems;

	public Yuser() {
	}

	public int getYuserid() {
		return this.yuserid;
	}

	public void setYuserid(int yuserid) {
		this.yuserid = yuserid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getYuseremail() {
		return this.yuseremail;
	}

	public void setYuseremail(String yuseremail) {
		this.yuseremail = yuseremail;
	}

	public String getYusername() {
		return this.yusername;
	}

	public void setYusername(String yusername) {
		this.yusername = yusername;
	}

	public String getYuserpassword() {
		return this.yuserpassword;
	}

	public void setYuserpassword(String yuserpassword) {
		this.yuserpassword = yuserpassword;
	}

	public List<Yuseritem> getYuseritems() {
		return this.yuseritems;
	}

	public void setYuseritems(List<Yuseritem> yuseritems) {
		this.yuseritems = yuseritems;
	}

	public Yuseritem addYuseritem(Yuseritem yuseritem) {
		getYuseritems().add(yuseritem);
		yuseritem.setYuser(this);

		return yuseritem;
	}

	public Yuseritem removeYuseritem(Yuseritem yuseritem) {
		getYuseritems().remove(yuseritem);
		yuseritem.setYuser(null);

		return yuseritem;
	}

}