package tempVo;

   /**
    * admin 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "admin")
public class Admin{

	private Integer ID;

	private String AdminUser;

	private String AdminPass;

	private String qq;

	private String dianhua;

	private String myemail;

	private String weburl;

	private Integer flag;

	private String ip;

	private String regtime;

	private String data;

	private float yue;

	private float tyue;

	private String headpic;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "AdminUser")
	public String getAdminUser(){
		return AdminUser;
	}
	public void setAdminUser(String AdminUser){
	this.AdminUser=AdminUser;
	}
	@Column(name = "AdminPass")
	public String getAdminPass(){
		return AdminPass;
	}
	public void setAdminPass(String AdminPass){
	this.AdminPass=AdminPass;
	}
	@Column(name = "qq")
	public String getQq(){
		return qq;
	}
	public void setQq(String qq){
	this.qq=qq;
	}
	@Column(name = "dianhua")
	public String getDianhua(){
		return dianhua;
	}
	public void setDianhua(String dianhua){
	this.dianhua=dianhua;
	}
	@Column(name = "myemail")
	public String getMyemail(){
		return myemail;
	}
	public void setMyemail(String myemail){
	this.myemail=myemail;
	}
	@Column(name = "weburl")
	public String getWeburl(){
		return weburl;
	}
	public void setWeburl(String weburl){
	this.weburl=weburl;
	}
	@Column(name = "flag")
	public Integer getFlag(){
		return flag;
	}
	public void setFlag(Integer flag){
	this.flag=flag;
	}
	@Column(name = "ip")
	public String getIp(){
		return ip;
	}
	public void setIp(String ip){
	this.ip=ip;
	}
	@Column(name = "regtime")
	public String getRegtime(){
		return regtime;
	}
	public void setRegtime(String regtime){
	this.regtime=regtime;
	}
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
	@Column(name = "yue")
	public float getYue(){
		return yue;
	}
	public void setYue(float yue){
	this.yue=yue;
	}
	@Column(name = "tyue")
	public float getTyue(){
		return tyue;
	}
	public void setTyue(float tyue){
	this.tyue=tyue;
	}
	@Column(name = "headpic")
	public String getHeadpic(){
		return headpic;
	}
	public void setHeadpic(String headpic){
	this.headpic=headpic;
	}
}

