-- 删除数据库
drop database [if exists] database_name ; 
-- 显示当前数据库
show databases;
-- 使用数据库
use database_name ; 
-- 显示当前表
show tables ; 
-- 查看表结构
desc table_name ;
-- 数据库约束(constraint) not null, unique , primary key , foreign key check
-- 创建数据库
create table test(
id int primary key auto_increment,
name varchar(255) ,
constraint tt2 unique(name)
);
-- 修改表结构
alter table test 
add column(
	 password varchar(16)
);
alter table test
modify password int ;
alter table test
drop column password;
drop table test ;

create table dept (
	id int primary key auto_increment,
	info varchar(18)
);

create table emp (
	id int primary key auto_increment,
	name varchar(18) not null,
	tel varchar(18) not null , 
	dept_id int ,
	constraint fk_test foreign key(dept_id) references dept(id) [on delete cascade|restrict|set null],
	constraint uq_1 unique(name) ,
	constraint uq_2 unique(tel)
);


-- 建立索引
create index index_1
on emp(name);
-- 删除索引
drop index index_1 on emp ;

-- 创建视图
create or replace view view 
as 
select * from emp 
with check option 

--insert into 
insert into dept(info) values("No.1");
insert into dept(info) values("No.2");


insert into emp(name,tel,dept_id) values('John','8366628',1);
insert into emp(name,tel,dept_id) values('Peter','8362328',1);
insert into emp(name,tel,dept_id) values('Tank','8234328',1);

insert into emp(name,tel,dept_id) values('Rose','2321228',2);
insert into emp(name,tel,dept_id) values('Lucy','2321231',2);

create or replace view emp_view 
as 
select id ID ,name 姓名 , tel 电话号 from emp 
with check option ;

update emp 
set dept_id = 2 
where name = 'Tank' ; 

delete from dept 
where id = 1 ; 

select concat(name,'ABC') from emp ; 
select concat(name,null) from emp ; 
select concat(name,null) as MYID from emp ; 
select distinct 5 from emp ;
select 5+5 from dual ;

-- 注意 SQL中判断两个值相等的比较运算符是单等号
-- 判断不相等的是<> 
-- 赋值是:=

select * from emp where id between 2 and 3;
select * from emp where id in(2,3,4);
select * from emp where name like 'T%';
select * from emp where name is null ;
select * from emp where name like '____';
select * from emp where name like '____%';
select * from emp where name like '%';

select * from emp where name like '\_' ;
select * from emp where name like '\_' ;
select * from emp where name not like '\_' ;
select * from emp where not name not like 'Tank' ;

select * from emp order by id desc ;
select * from emp order by id asc ;
select * from emp order by name asc ;

-- arg1 == null ? arg2 : arg1 ; 
select ifnull(null,'1234');
-- arg1 == arg2 ? null : arg1 ; 
select nullif(1,1) ; 
-- arg1 == null ? true : false ;
select isnull(null) ; 
-- arg1 ? arg2 : arg3
select if(true,2,3);

alter table emp add column hashCode int ;

update emp set hashCode = 123 where id >= 4 ;
update emp set hashCode = 343 where id < 4 ;

alter table emp modify hashCode int not null ;
alter table emp add constraint check(hashCode>100) ;

select avg(hashCode) from emp ; 
select avg(distinct hashCode) from emp ; 
select count(*) from emp ; 
select count(*) from emp group by dept_id; 
select count(*) , dept_id from emp group by dept_id; 
select count(*) , dept_id from emp group by dept_id having count(*)>2; 

select emp.* , dept.* from emp , dept ;
select * from emp mgr, emp emp;
select * from emp cross join dept ; -- 广义笛卡尔积
select * from emp natural join dept  ; -- 同列名
select * from emp join dept using(id) ; -- id 
select * from emp join dept on dept.id = emp.dept_id ;


show create procedure proc1 ;
show create function func1 ;

-- 1 存储过程与函数的区别 
	-- 函数必须有返回值
	-- 存储过程没有返回值 
	-- 存储过程的参数可以是IN,OUT,INOUT 类型, 函数的参数只能是IN
-- 2 存储过程与函数的有点
	-- 存储过程只在创建时进行编译,SQL语句每执行一次就编译一次,所以存储过程可以提高数据库执行速度
	-- 简化复杂操作,结合事务一起封装
	-- 复用性
	-- 安全性高,可指定存储过程的使用权
	
-- 3 创建和调用存储过程
	-- 创建语法
		-- create procedure procedure_name(args) 
		-- [特性...] 过程体
		-- 示例:
			delimiter //
			create procedure proc1(out result int)
			begin
			select count(*) into result from emp ; 
			end //
			delimiter ;
			call proc1(@a);
			select @a ; 
			
-- 4 创建和调用函数
	-- 示例:
		delimiter $$
		create function func1(s char(20)) returns char(50) 
		return concat('hello',s,'!') ; 
		$$ 
		delimiter ; 
		select func1('P') ; 
-- 5 查看存储过程或函数
	select `name` from mysql.proc where db = 'test' and `type` = 'PROCEDURE';
	select `name` from mysql.proc where db = 'test' and `type` = 'FUNCTION'
	show procedure status;
	show function status ; 
	show create procedure proc1 ;
	show create function func1 ;

-- 6 删除存储过程和函数
	drop procedure proc1; 
	drop function func1;
	
-- 7 变量的定义
	-- declare var type default value ;
	-- set var = value ;
	-- select 列名 into var from 表名
	-- @var 用户变量(弱类型)
	
	delimiter $
	create procedure proc2()
	begin 
	declare x int default 1 ;
	select * from emp where id = x ;
	end $
	delimiter ; 

-- 8 流程控制
	-- IF
	-- IF 条件表达式 THEN
	-- SQL 
	-- [ELSEIF 条件表达式 THEN SQL]
	-- [ELSE SQL]
	-- END IF ;
	
	delimiter //
	create procedure proc1(in param int)
	begin 
	if param = 2 then
		select * from emp ; 
		select * from dept ;
	else if param = 1 then 
		select * from emp ; 
	end if;
	end if;
	end // 
	delimiter ; 
	
	-- CASE 语句
		-- case 表达式
		-- when 值1 then SQL 
		-- [when 值2 then SQL ]
		-- [else SQL ]
		-- end case ;
	
	-- 循环语句LOOP
	-- [开始标注:]LOOP
	-- 语句块
	-- END LOOP[结束标语]
	-- 除非'开始标注'存在,否则'结束标注'不能被给出
	-- LEAVE == break
	-- ITERATE == continue 
	
	
-- 创建触发器
	-- create trigger name
	-- {BEFORE|AFTER} 
	-- {INSERT|UPDATE|DELETE}
	-- ON 表名 FOR EACH ROW 要触发的SQL语句
	-- 使用别名OLD NEW
	
	
	