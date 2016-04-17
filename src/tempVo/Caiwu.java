package tempVo;

   /**
    * caiwu 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "caiwu")
public class Caiwu{

	private Integer ID;

	private String order_id;

	private String trade_id;

	private String VipUser;

	private String operator;

	private String leixing;

	private float jine;

	private Integer flag;

	private String data;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "order_id")
	public String getOrder_id(){
		return order_id;
	}
	public void setOrder_id(String order_id){
	this.order_id=order_id;
	}
	@Column(name = "trade_id")
	public String getTrade_id(){
		return trade_id;
	}
	public void setTrade_id(String trade_id){
	this.trade_id=trade_id;
	}
	@Column(name = "VipUser")
	public String getVipUser(){
		return VipUser;
	}
	public void setVipUser(String VipUser){
	this.VipUser=VipUser;
	}
	@Column(name = "operator")
	public String getOperator(){
		return operator;
	}
	public void setOperator(String operator){
	this.operator=operator;
	}
	@Column(name = "leixing")
	public String getLeixing(){
		return leixing;
	}
	public void setLeixing(String leixing){
	this.leixing=leixing;
	}
	@Column(name = "jine")
	public float getJine(){
		return jine;
	}
	public void setJine(float jine){
	this.jine=jine;
	}
	@Column(name = "flag")
	public Integer getFlag(){
		return flag;
	}
	public void setFlag(Integer flag){
	this.flag=flag;
	}
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
}

