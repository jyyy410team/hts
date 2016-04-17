获取数据库的所有表：（以MySQL和Oracle为例，其他类型的数据库接触不过，不做解释）
Connection接口中提供了DatabaseMetaData接口：
提供：getTables()方法，该方法需要传进4个参数：
第一个是数据库名称，对于MySQL，则对应相应的数据库，对于Oracle来说，则是对应相应的数据库实例，可以不填，也可以直接使用Connection的实例对象中的getCatalog()方法返回的值填充；
第二个是模式，可以理解为数据库的登录名，而对于Oracle也可以理解成对该数据库操作的所有者的登录名。对于Oracle要特别注意，其登陆名必须是大写，不然的话是无法获取到相应的数据，而MySQL则不做强制要求。
第三个是表名称，一般情况下如果要获取所有的表的话，可以直接设置为null，如果设置为特定的表名称，则返回该表的具体信息。
第四个是类型标准,以数组形式传值，有"TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS" 和 "SYNONYM"这几个经典的类型，一般使用”TABLE”，即获取所有类型为TABLE的表
它返回一个ResultSet对象，有10列，详细的显示了表的类型：
TABLE_CAT String => 表类别（可为 null）
TABLE_SCHEM String => 表模式（可为 null）
TABLE_NAME String => 表名称
TABLE_TYPE String => 表类型。
REMARKS String => 表的解释性注释
TYPE_CAT String => 类型的类别（可为 null）
TYPE_SCHEM String => 类型模式（可为 null）
TYPE_NAME String => 类型名称（可为 null）
SELF_REFERENCING_COL_NAME String => 有类型表的指定 "identifier" 列的名称（可为 null）
REF_GENERATION String
可根据需要使用
示例:
（MySQL）
DatabaseMetaData metaData = conn.getMetaData();
ResultSet rs = metaData.getTables(conn.getCatalog(), "root", null, new String[]{"TABLE"});
while(rs.next()) {
   System.out.println(rs.getString("TABLE_NAME"));
}
（Oracle）
DatabaseMetaData metaData = conn.getMetaData();
ResultSet rs = metaData.getTables(conn.getCatalog(), "SCOTT", null, new String[]{"TABLE"});
while(rs.next()) {
    System.out.println(rs.getString("TABLE_NAME"));
}