package tempVo;

   /**
    * news_info 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "news_info")
public class News_info{

	private Integer ID;

	private Integer class_id;

	private String title;

	private String entitle;

	private Integer nd;

	private String content;

	private String encontent;

	private String data;

	private Integer tj;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "class_id")
	public Integer getClass_id(){
		return class_id;
	}
	public void setClass_id(Integer class_id){
	this.class_id=class_id;
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
	@Column(name = "nd")
	public Integer getNd(){
		return nd;
	}
	public void setNd(Integer nd){
	this.nd=nd;
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
	@Column(name = "data")
	public String getData(){
		return data;
	}
	public void setData(String data){
	this.data=data;
	}
	@Column(name = "tj")
	public Integer getTj(){
		return tj;
	}
	public void setTj(Integer tj){
	this.tj=tj;
	}
}

