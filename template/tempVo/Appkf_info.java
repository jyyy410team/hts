package tempVo;

   /**
    * appkf_info 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "appkf_info")
public class Appkf_info{

	private Integer ID;

	private String VipUser;

	private String owner;

	private Integer mid;

	private String order_id;

	private String title;

	private String medianame;

	private String weburl;

	private Integer price;

	private String content;

	private String reason;

	private String dreason;

	private String data;

	private String fbtime;

	private Integer flag;

	private Integer yn;

	private Integer dyn;

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
	@Column(name = "owner")
	public String getOwner(){
		return owner;
	}
	public void setOwner(String owner){
	this.owner=owner;
	}
	@Column(name = "mid")
	public Integer getMid(){
		return mid;
	}
	public void setMid(Integer mid){
	this.mid=mid;
	}
	@Column(name = "order_id")
	public String getOrder_id(){
		return order_id;
	}
	public void setOrder_id(String order_id){
	this.order_id=order_id;
	}
	@Column(name = "title")
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
	this.title=title;
	}
	@Column(name = "medianame")
	public String getMedianame(){
		return medianame;
	}
	public void setMedianame(String medianame){
	this.medianame=medianame;
	}
	@Column(name = "weburl")
	public String getWeburl(){
		return weburl;
	}
	public void setWeburl(String weburl){
	this.weburl=weburl;
	}
	@Column(name = "price")
	public Integer getPrice(){
		return price;
	}
	public void setPrice(Integer price){
	this.price=price;
	}
	@Column(name = "content")
	public String getContent(){
		return content;
	}
	public void setContent(String content){
	this.content=content;
	}
	@Column(name = "reason")
	public String getReason(){
		return reason;
	}
	public void setReason(String reason){
	this.reason=reason;
	}
	@Column(name = "dreason")
	public String getDreason(){
		return dreason;
	}
	public void setDreason(String dreason){
	this.dreason=dreason;
	}
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
	@Column(name = "fbtime")
	public String getFbtime(){
		return fbtime;
	}
	public void setFbtime(String fbtime){
	this.fbtime=fbtime;
	}
	@Column(name = "flag")
	public Integer getFlag(){
		return flag;
	}
	public void setFlag(Integer flag){
	this.flag=flag;
	}
	@Column(name = "yn")
	public Integer getYn(){
		return yn;
	}
	public void setYn(Integer yn){
	this.yn=yn;
	}
	@Column(name = "dyn")
	public Integer getDyn(){
		return dyn;
	}
	public void setDyn(Integer dyn){
	this.dyn=dyn;
	}
}

