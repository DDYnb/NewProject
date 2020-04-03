## JDBC笔记

------

##### JDBC访问数据库的流程

​	加载驱动——建立连接——发送SQL语句——返回结果

##### Driver接口

​	由数据库厂家提供，程序中不需要直接访问，而是通过java.sql.DriverManager去调用。

##### DriverManager接口

​	管理跟踪驱动程序，在数据库和驱动程序之间建立连接。

##### 加载JDBC驱动

​	调用Class类的静态方法Class.forName，向其驱动的类名。如Class.forName("com.mysql.jdbc.Driver");

##### Connection接口

​	建立与特定数据库的连接，向数据库发送sql语句。

​	如建立与数据库的连接：

​		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc", "user",    		                                               	    "password");    

##### Statement接口

​	执行静态的sql语句并返回所生成结果的对象。

###### 	三种Statement类：

​		Statement：由方法createStatement创建，发送不带参数的sql语句。

​		PreparedStatement：继承自Statement接口，由方法prepareStatement创建，发送一个或多个的sql语句，											   比Statement效率高，可以防止sql注入。

​		CallableStatement：继承自PreparedStatement接口，由方法prePareCall创建，用于调用存储过程。

###### 	常用的Statement方法：

​		execute()：运行语句，返回是否有结果集。

​		executeQuery()：运行select语句，返回ResultSet结果集。

​		executeUpdate()：运行insert、update、delete语句，返回更新的行数。

##### ResultSet接口

​	Statement执行sql语句时返回ResultSet结果集。ResultSet接口提供检索不同类型字段的方法，如getInt()、	         	getSting()、getFloat()、getDate()、getBoolean()。