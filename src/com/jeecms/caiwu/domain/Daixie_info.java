package com.jeecms.caiwu.domain;

/**
 * daixie_info 实体类
 * 2016-27-15 靳阳阳
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "daixie_info")
public class Daixie_info {

	private Integer ID;

	private String VipUser;

	private String order_id;

	private String title;

	private Integer pianshu;

	private Integer price;

	private String content;

	private String encontent;

	private String data;

	private Integer flag;

	private Integer yn;

	private Integer dyn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	@Column(name = "VipUser")
	public String getVipUser() {
		return VipUser;
	}

	public void setVipUser(String VipUser) {
		this.VipUser = VipUser;
	}

	@Column(name = "order_id")
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "pianshu")
	public Integer getPianshu() {
		return pianshu;
	}

	public void setPianshu(Integer pianshu) {
		this.pianshu = pianshu;
	}

	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "encontent")
	public String getEncontent() {
		return encontent;
	}

	public void setEncontent(String encontent) {
		this.encontent = encontent;
	}

	@Column(name = "data")
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Column(name = "flag")
	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Column(name = "yn")
	public Integer getYn() {
		return yn;
	}

	public void setYn(Integer yn) {
		this.yn = yn;
	}

	@Column(name = "dyn")
	public Integer getDyn() {
		return dyn;
	}

	public void setDyn(Integer dyn) {
		this.dyn = dyn;
	}
}
