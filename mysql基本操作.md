## mysql基本操作

#### 1.查询数据库服务器中所有的数据库

​	show databases;

#### 2.选中某个数据库

​	use 库名；

#### 3.退出数据库服务器

​	exit;

#### 4.在数据库服务器中创建数据库

​	create database 库名;

#### 5.查看数据库中的所有数据表

​	show tables;

#### 6.创建一个数据表

​	create table 表名 {

​		字段 数据类型(),

​		字段 数据类型(),

​		......

​	};

#### 7.查看数据表的结构

​	describe 表名;

#### 8.查看记录

​	查看所有记录：select * from 表名;

​	查看特定记录：select * from 表名 where 条件;

#### 10.添加数据记录

​	insert into 表名(列名，列名，列名）values(	,	,	);

#### 11.删除数据

​	delete from 表名 where	;

#### 12.修改数据

​	update  表名 set	where	；