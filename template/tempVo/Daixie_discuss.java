package tempVo;

   /**
    * daixie_discuss 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "daixie_discuss")
public class Daixie_discuss{

	private Integer ID;

	private String VipUser;

	private String order_id;

	private String recontent;

	private String data;

	private Integer flag;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "VipUser")
	public String getVipUser(){
		return VipUser;
	}
	public void setVipUser(String VipUser){
	this.VipUser=VipUser;
	}
	@Column(name = "order_id")
	public String getOrder_id(){
		return order_id;
	}
	public void setOrder_id(String order_id){
	this.order_id=order_id;
	}
	@Column(name = "recontent")
	public String getRecontent(){
		return recontent;
	}
	public void setRecontent(String recontent){
	this.recontent=recontent;
	}
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
	@Column(name = "flag")
	public Integer getFlag(){
		return flag;
	}
	public void setFlag(Integer flag){
	this.flag=flag;
	}
}

