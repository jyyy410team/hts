/**
 * <p>ClassName:${tableName}</p>
 * <p>Title:</p>
 * <p>Description:${tableName}实现类</p>
 * <p>Copyright:Copyright (c) 2010</p>
 * <p>Company:易泓咨询管理公司</p>
 * <p>Date:${date}</p>
 * <p>Modify:</p>
 * <p>Bug:</p>
 * <p>@author ${name} </p>
 * <p>@version 1.0</p>	 
 * 
 */
@Service
public class ${tableName}Impl implements I${tableName} {

    @Autowired
	GeneralDAO dao;
	
    //查询 by jyy
    @Override
	public void query${tableName}List(${tableName} vo,HttpContext context){
	DtPvUsers user = (DtPvUsers)context.getUserLoginInfo().getInfo();
		vo.setCOMPANY_ID(user.getCOMPANY_ID());
		List<${tableName}> list=(List<${tableName}>) dao.queryForList("${tableName}Impl.query${tableName}List",vo);
		context.addResultList(list);
	}
	//保存 by jyy
	@Override
	public void save${tableName}(${tableName} vo,HttpContext context){
	 Date date = CommonService.getGeneralService().getSystemDate();
		  if(Constants.ACTION_UPDATE.equals(vo.getUPDATE_STATUS())){
			  vo.setUPDATED_BY(user.getUSER_ID());
			  vo.setUPDATED_TIME(date);
			  int updateCount = dao.updateObject("${tableName}Impl.update${tableName}", vo);
			  if(updateCount == 0) throw new OldDataException();
			}else if(Constants.ACTION_DELETE.equals(vo.getUPDATE_STATUS())){
			  dao.deleteObject("${tableName}Impl.delete${tableName}", vo);
			}else if(Constants.ACTION_INSERT.equals(vo.getUPDATE_STATUS())){
				vo.setINSURANCE_ID(CommonService.getSeqenceService().getSequenceNo(user.getCOMPANY_ID(), xx));
				vo.setCOMPANY_ID(user.getCOMPANY_ID());
				vo.setCREATED_BY(user.getUSER_ID());
				vo.setCREATED_TIME(date);
				dao.insertObject("${tableName}Impl.insert${tableName}", vo);
			}
		 context.addResultObject(vo);
	}
	//查询明细 by jyy
	@Override
	public void query${tableName}Detail(${tableName} vo,HttpContext context){
	DtPvUsers user = (DtPvUsers) context.getUserLoginInfo().getInfo();
		vo.setCOMPANY_ID(user.getCOMPANY_ID());
	    vo=(${tableName}) 	dao.queryObject("${tableName}Impl.query${tableName}Detail", vo);
		
	}
	}