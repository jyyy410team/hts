package tempVo;

   /**
    * media_class 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "media_class")
public class Media_class{

	private Integer ID;

	private Integer BigID;

	private String SmallClass;

	private String enSmallClass;

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
	@Column(name = "BigID")
	public Integer getBigID(){
		return BigID;
	}
	public void setBigID(Integer BigID){
	this.BigID=BigID;
	}
	@Column(name = "SmallClass")
	public String getSmallClass(){
		return SmallClass;
	}
	public void setSmallClass(String SmallClass){
	this.SmallClass=SmallClass;
	}
	@Column(name = "enSmallClass")
	public String getEnSmallClass(){
		return enSmallClass;
	}
	public void setEnSmallClass(String enSmallClass){
	this.enSmallClass=enSmallClass;
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

