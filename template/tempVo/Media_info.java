package tempVo;

   /**
    * media_info 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "media_info")
public class Media_info{

	private Integer ID;

	private String VipUser;

	private Integer sh;

	private Integer nav_id;

	private Integer class_id;

	private Integer small_id;

	private String medianame;

	private String medialx;

	private String weburl;

	private String anliurl;

	private String linkurl;

	private String xinwenyuan;

	private String zhmh;

	private String diqu;

	private Integer fans;

	private Integer price;

	private Integer dlprice;

	private Integer scprice;

	private String content;

	private String neirong;

	private String data;

	private Integer flag;

	private String tj;

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
	@Column(name = "sh")
	public Integer getSh(){
		return sh;
	}
	public void setSh(Integer sh){
	this.sh=sh;
	}
	@Column(name = "nav_id")
	public Integer getNav_id(){
		return nav_id;
	}
	public void setNav_id(Integer nav_id){
	this.nav_id=nav_id;
	}
	@Column(name = "class_id")
	public Integer getClass_id(){
		return class_id;
	}
	public void setClass_id(Integer class_id){
	this.class_id=class_id;
	}
	@Column(name = "small_id")
	public Integer getSmall_id(){
		return small_id;
	}
	public void setSmall_id(Integer small_id){
	this.small_id=small_id;
	}
	@Column(name = "medianame")
	public String getMedianame(){
		return medianame;
	}
	public void setMedianame(String medianame){
	this.medianame=medianame;
	}
	@Column(name = "medialx")
	public String getMedialx(){
		return medialx;
	}
	public void setMedialx(String medialx){
	this.medialx=medialx;
	}
	@Column(name = "weburl")
	public String getWeburl(){
		return weburl;
	}
	public void setWeburl(String weburl){
	this.weburl=weburl;
	}
	@Column(name = "anliurl")
	public String getAnliurl(){
		return anliurl;
	}
	public void setAnliurl(String anliurl){
	this.anliurl=anliurl;
	}
	@Column(name = "linkurl")
	public String getLinkurl(){
		return linkurl;
	}
	public void setLinkurl(String linkurl){
	this.linkurl=linkurl;
	}
	@Column(name = "xinwenyuan")
	public String getXinwenyuan(){
		return xinwenyuan;
	}
	public void setXinwenyuan(String xinwenyuan){
	this.xinwenyuan=xinwenyuan;
	}
	@Column(name = "zhmh")
	public String getZhmh(){
		return zhmh;
	}
	public void setZhmh(String zhmh){
	this.zhmh=zhmh;
	}
	@Column(name = "diqu")
	public String getDiqu(){
		return diqu;
	}
	public void setDiqu(String diqu){
	this.diqu=diqu;
	}
	@Column(name = "fans")
	public Integer getFans(){
		return fans;
	}
	public void setFans(Integer fans){
	this.fans=fans;
	}
	@Column(name = "price")
	public Integer getPrice(){
		return price;
	}
	public void setPrice(Integer price){
	this.price=price;
	}
	@Column(name = "dlprice")
	public Integer getDlprice(){
		return dlprice;
	}
	public void setDlprice(Integer dlprice){
	this.dlprice=dlprice;
	}
	@Column(name = "scprice")
	public Integer getScprice(){
		return scprice;
	}
	public void setScprice(Integer scprice){
	this.scprice=scprice;
	}
	@Column(name = "content")
	public String getContent(){
		return content;
	}
	public void setContent(String content){
	this.content=content;
	}
	@Column(name = "neirong")
	public String getNeirong(){
		return neirong;
	}
	public void setNeirong(String neirong){
	this.neirong=neirong;
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
	@Column(name = "tj")
	public String getTj(){
		return tj;
	}
	public void setTj(String tj){
	this.tj=tj;
	}
}

