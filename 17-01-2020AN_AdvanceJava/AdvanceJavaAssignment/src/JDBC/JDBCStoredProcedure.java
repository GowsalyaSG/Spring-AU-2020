package JDBC;
/*
 create database db1
use db1
create table employee(
id int primary key,
name1 varchar(50),
gender varchar(50),
deptid int
);
insert into  employee values(1,'siva','male',3);
insert into  employee values(2,'hari','male',2);
insert into  employee values(3,'gowsalya','female',1);
insert into  employee values(4,'john','male',4);
insert into  employee values(5,'anitha','female',1);
select * from employee
create table dept2(
d_id int ,
deptname varchar(50)
);
delete from dept2;
insert into  dept2 values(1,'IT');
insert into  dept2 values(2,'CS');
insert into   dept2 values(3,'EEE');
insert into dept2 values(4,'DB');
select * from dept2;
select * from employee;
create procedure EmployeeDetail(in id int)
as  
select employee.id,employee.name1,employee.gender,dept2.deptname from employee join dept2 on employee.deptid = dept2.d_id;
where employee.id=id
*/ 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
 
public class JDBCStoredProcedure {
 
    public static  void getDetails(int Id) throws ClassNotFoundException {
       
        String query = "{ call EmployeeDetail(?) }";
        ResultSet result;
 
        try {
            Class.forName("com.mysql.jdbc.Driver");  
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");  
            CallableStatement s = conn.prepareCall(query) ;
 
                s.setInt(1, Id);
            System.out.println("employeeid ,employeeName,gender,DeptName");
                result= s.executeQuery();
                while (result.next()) {
            System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3)+" "+result.getString(4));
                }

            
        }

        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    public static void main(String[] args) throws ClassNotFoundException {
        getDetails(1);
    }
}