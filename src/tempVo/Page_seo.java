package tempVo;

   /**
    * page_seo 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "page_seo")
public class Page_seo{

	private Integer ID;

	private String BigClass;

	private String enBigClass;

	private String Title;

	private String enTitle;

	private String KeyWords;

	private String enKeyWords;

	private String Descr;

	private String enDescr;

	private Integer paixu;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "BigClass")
	public String getBigClass(){
		return BigClass;
	}
	public void setBigClass(String BigClass){
	this.BigClass=BigClass;
	}
	@Column(name = "enBigClass")
	public String getEnBigClass(){
		return enBigClass;
	}
	public void setEnBigClass(String enBigClass){
	this.enBigClass=enBigClass;
	}
	@Column(name = "Title")
	public String getTitle(){
		return Title;
	}
	public void setTitle(String Title){
	this.Title=Title;
	}
	@Column(name = "enTitle")
	public String getEnTitle(){
		return enTitle;
	}
	public void setEnTitle(String enTitle){
	this.enTitle=enTitle;
	}
	@Column(name = "KeyWords")
	public String getKeyWords(){
		return KeyWords;
	}
	public void setKeyWords(String KeyWords){
	this.KeyWords=KeyWords;
	}
	@Column(name = "enKeyWords")
	public String getEnKeyWords(){
		return enKeyWords;
	}
	public void setEnKeyWords(String enKeyWords){
	this.enKeyWords=enKeyWords;
	}
	@Column(name = "Descr")
	public String getDescr(){
		return Descr;
	}
	public void setDescr(String Descr){
	this.Descr=Descr;
	}
	@Column(name = "enDescr")
	public String getEnDescr(){
		return enDescr;
	}
	public void setEnDescr(String enDescr){
	this.enDescr=enDescr;
	}
	@Column(name = "paixu")
	public Integer getPaixu(){
		return paixu;
	}
	public void setPaixu(Integer paixu){
	this.paixu=paixu;
	}
}

