<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE sqlMap PUBLIC "-//ibatis.apache.org//DTD SQL Map 2.0//EN" 
	"http://ibatis.apache.org/dtd/sql-map-2.dtd">
<sqlMap namespace="${tableName}Impl">
	<typeAlias alias="NtAsCampaignsToLizp" type="com.infohow.dcs.jms.to.aftersales.NtAsCampaignsTo" />
	
	<select id="query${tableName}List" parameterClass="${tableName}" resultClass="${tableName}">
		SELECT CP_ID,
		       SP_CODE,
		       COMPANY_ID,
		       CC_TYPE,
		       SP_NAME,
		       BASIC_UNIT,
		       QUANTITY,
		       REMARK_128
		  FROM DT_AS_CAMPAIGN_SP
		 WHERE CP_ID = #CP_ID#
		   AND SP_CODE = #SP_CODE#
	</select>
    
    
    <insert id="insert${tableName}" parameterClass="${tableName}">
		INSERT INTO DT_AS_CAMPAIGN_SI
		  (CP_ID,
		   SI_CODE,
		   MHN_CODE,
		   COMPANY_ID,
		   SI_NAME,
		   MAN_HOURS,
		   CC_TYPE,
		   REMARK_128,
		   CREATED_BY,
		   CREATED_TIME,
		   UPDATED_BY,
		   UPDATED_TIME,
		   VERSION,
		   IS_MAIN_ITEM)
		VALUES
		  (#CP_ID#,
		   #SI_CODE#,
		   #MHN_CODE#,
		   #COMPANY_ID#,
		   #SI_NAME#,
		   #MAN_HOURS#,
		   #CC_TYPE#,
		   #REMARK_128#,
		   #CREATED_BY#,
		   SYSDATE,
		   NULL,
		   NULL,
		   0,
		   #IS_MAIN_ITEM#)
	</insert>
	<update id="update${tableName}" parameterClass="${tableName}" >
	    UPDATE DT_AS_CAMPAIGN_VC
      SET TASK_STATUS        = #TASK_STATUS#,
       PR_INQUIRED_TIMES  = #PR_INQUIRED_TIMES#,	
       PR_INQUIRED_BY	  = #PR_INQUIRED_BY_N#,
       PR_INQUIRED_DATE	  = #PR_INQUIRED_DATE#,
       PR_INQUIRED_RESULT = #PR_INQUIRED_RESULT#,
       <isNotEmpty property="PR_REJECTED_CAUSE">
       PR_REJECTED_CAUSE  = #PR_REJECTED_CAUSE#,
       </isNotEmpty>	
       UPDATED_BY         = 0,
       UPDATED_TIME       = SYSDATE,
       VERSION            = VERSION +1
    WHERE CP_ID = #CP_ID#
      AND VEHICLE_ID = #VEHICLE_ID#
      AND DEALER_ID = #DEALER_ID#
	</update>

    <delete id="delete${tableName}" parameterClass="${tableName}">
    DELETE FROM　DT_AS_CAMPAIGN_VC WHERE 
     WHERE CP_ID = #CP_ID#
      AND VEHICLE_ID = #VEHICLE_ID#
      AND DEALER_ID = #PRE_DEALER_ID#　
    </delete>
</sqlMap>