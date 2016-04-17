package tempVo;

   /**
    * about 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "about")
public class About{

	private Integer ID;

	private String title;

	private String entitle;

	private String content;

	private String encontent;

	private Integer paixu;

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
	@Column(name = "content")
	public String getContent(){
		return content;
	}
	public void setContent(String content){
	this.content=content;
	}
	@Column(name = "encontent")
	public String getEncontent(){
		return encontent;
	}
	public void setEncontent(String encontent){
	this.encontent=encontent;
	}
	@Column(name = "paixu")
	public Integer getPaixu(){
		return paixu;
	}
	public void setPaixu(Integer paixu){
	this.paixu=paixu;
	}
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
}

