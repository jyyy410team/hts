/**
 * <p>ClassName:I${tableName}</p>
 * <p>Title:</p>
 * <p>Description:</p>
 * <p>Copyright:Copyright (c) 2010</p>
 * <p>Company:易泓咨询管理公司</p>
 * <p>Date:${date}</p>
 * <p>Modify:</p>
 * <p>Bug:</p>
 * <p>@author ${name} </p>
 * <p>@version 1.0</p>	 
 * 
 */
@Published
public interface I${tableName}{

    //查询 by jyy
	public void query${tableName}List(${tableName} vo,HttpContext context);
	//保存 by jyy
	public void save${tableName}(${tableName} vo,HttpContext context) ;
	//查询明细
	public void query${tableName}Detail(${tableName} vo,HttpContext context) ;
	}