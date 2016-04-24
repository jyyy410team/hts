package tempVo;

   /**
    * webinfo 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "webinfo")
public class Webinfo{

	private Integer webID;

	private String webname;

	private String enwebname;

	private String weburl;

	private String icp;

	private String enicp;

	private String cname;

	private String dianhua;

	private String fax;

	private String myemail;

	private String bgtel;

	private String qq;

	private String qyqq;

	private String msn;

	private String mob;

	private String address;

	private String enaddress;

	private String gcadd;

	private String engcadd;

	private String title;

	private String entitle;

	private String keyword;

	private String enkeyword;

	private String descr;

	private String endescr;

	private String banquan;

	private String enbanquan;

	private String about;

	private String enabout;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "webID")
	public Integer getWebID(){
		return webID;
	}
	public void setWebID(Integer webID){
	this.webID=webID;
	}
	@Column(name = "webname")
	public String getWebname(){
		return webname;
	}
	public void setWebname(String webname){
	this.webname=webname;
	}
	@Column(name = "enwebname")
	public String getEnwebname(){
		return enwebname;
	}
	public void setEnwebname(String enwebname){
	this.enwebname=enwebname;
	}
	@Column(name = "weburl")
	public String getWeburl(){
		return weburl;
	}
	public void setWeburl(String weburl){
	this.weburl=weburl;
	}
	@Column(name = "icp")
	public String getIcp(){
		return icp;
	}
	public void setIcp(String icp){
	this.icp=icp;
	}
	@Column(name = "enicp")
	public String getEnicp(){
		return enicp;
	}
	public void setEnicp(String enicp){
	this.enicp=enicp;
	}
	@Column(name = "cname")
	public String getCname(){
		return cname;
	}
	public void setCname(String cname){
	this.cname=cname;
	}
	@Column(name = "dianhua")
	public String getDianhua(){
		return dianhua;
	}
	public void setDianhua(String dianhua){
	this.dianhua=dianhua;
	}
	@Column(name = "fax")
	public String getFax(){
		return fax;
	}
	public void setFax(String fax){
	this.fax=fax;
	}
	@Column(name = "myemail")
	public String getMyemail(){
		return myemail;
	}
	public void setMyemail(String myemail){
	this.myemail=myemail;
	}
	@Column(name = "bgtel")
	public String getBgtel(){
		return bgtel;
	}
	public void setBgtel(String bgtel){
	this.bgtel=bgtel;
	}
	@Column(name = "qq")
	public String getQq(){
		return qq;
	}
	public void setQq(String qq){
	this.qq=qq;
	}
	@Column(name = "qyqq")
	public String getQyqq(){
		return qyqq;
	}
	public void setQyqq(String qyqq){
	this.qyqq=qyqq;
	}
	@Column(name = "msn")
	public String getMsn(){
		return msn;
	}
	public void setMsn(String msn){
	this.msn=msn;
	}
	@Column(name = "mob")
	public String getMob(){
		return mob;
	}
	public void setMob(String mob){
	this.mob=mob;
	}
	@Column(name = "address")
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
	this.address=address;
	}
	@Column(name = "enaddress")
	public String getEnaddress(){
		return enaddress;
	}
	public void setEnaddress(String enaddress){
	this.enaddress=enaddress;
	}
	@Column(name = "gcadd")
	public String getGcadd(){
		return gcadd;
	}
	public void setGcadd(String gcadd){
	this.gcadd=gcadd;
	}
	@Column(name = "engcadd")
	public String getEngcadd(){
		return engcadd;
	}
	public void setEngcadd(String engcadd){
	this.engcadd=engcadd;
	}
	@Column(name = "title")
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
	this.title=title;
	}
	@Column(name = "entitle")
	public String getEntitle(){
		return entitle;
	}
	public void setEntitle(String entitle){
	this.entitle=entitle;
	}
	@Column(name = "keyword")
	public String getKeyword(){
		return keyword;
	}
	public void setKeyword(String keyword){
	this.keyword=keyword;
	}
	@Column(name = "enkeyword")
	public String getEnkeyword(){
		return enkeyword;
	}
	public void setEnkeyword(String enkeyword){
	this.enkeyword=enkeyword;
	}
	@Column(name = "descr")
	public String getDescr(){
		return descr;
	}
	public void setDescr(String descr){
	this.descr=descr;
	}
	@Column(name = "endescr")
	public String getEndescr(){
		return endescr;
	}
	public void setEndescr(String endescr){
	this.endescr=endescr;
	}
	@Column(name = "banquan")
	public String getBanquan(){
		return banquan;
	}
	public void setBanquan(String banquan){
	this.banquan=banquan;
	}
	@Column(name = "enbanquan")
	public String getEnbanquan(){
		return enbanquan;
	}
	public void setEnbanquan(String enbanquan){
	this.enbanquan=enbanquan;
	}
	@Column(name = "about")
	public String getAbout(){
		return about;
	}
	public void setAbout(String about){
	this.about=about;
	}
	@Column(name = "enabout")
	public String getEnabout(){
		return enabout;
	}
	public void setEnabout(String enabout){
	this.enabout=enabout;
	}
}

