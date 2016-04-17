package tempVo;

   /**
    * ask_class 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "ask_class")
public class Ask_class{

	private Integer ID;

	private String BigClass;

	private String enBigClass;

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

