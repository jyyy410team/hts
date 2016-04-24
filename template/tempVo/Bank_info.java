package tempVo;

   /**
    * bank_info 实体类
    * 2016-27-15 靳阳阳
    */ 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "bank_info")
public class Bank_info{

	private Integer ID;

	private String name;

	private String accnumber;

	private String bankname;

	private String propic;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public Integer getID(){
		return ID;
	}
	public void setID(Integer ID){
	this.ID=ID;
	}
	@Column(name = "name")
	public String getName(){
		return name;
	}
	public void setName(String name){
	this.name=name;
	}
	@Column(name = "accnumber")
	public String getAccnumber(){
		return accnumber;
	}
	public void setAccnumber(String accnumber){
	this.accnumber=accnumber;
	}
	@Column(name = "bankname")
	public String getBankname(){
		return bankname;
	}
	public void setBankname(String bankname){
	this.bankname=bankname;
	}
	@Column(name = "propic")
	public String getPropic(){
		return propic;
	}
	public void setPropic(String propic){
	this.propic=propic;
	}
}

