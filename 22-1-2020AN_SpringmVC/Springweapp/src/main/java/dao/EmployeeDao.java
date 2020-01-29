package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import com.practice.models.Employee;
import com.practice.models.datasource;

@Configuration
@Component
public class EmployeeDao {
	private datasource dataSource;

	public void setDataSource(datasource dataSource) {
		this.dataSource = dataSource;
	}
     
	public String update(Employee employee) throws ClassNotFoundException {
		String query = "update employee set fname=?, lname=?, email=?,phone=? where empid=?";
		Connection con = null;
		PreparedStatement ps = null;
		String result="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.dataSource.getSqlurl(),this.dataSource.getUsername(),this.dataSource.getPassword());			ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getFname());
			ps.setString(2, employee.getLname());
			ps.setString(3, employee.getEmail());
			ps.setString(4, employee.getPhone());
			ps.setInt(5, employee.getId());
			int out = ps.executeUpdate();
			if(out !=0){
				result= "Employee updated with id="+employee.getId();
			}else result= "No Employee found with id="+employee.getId();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	public void save(Employee employee) throws ClassNotFoundException {
		String query = "insert into employee (empid, fname,lname,phone, email) values (?,?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.dataSource.getSqlurl(),this.dataSource.getUsername(),this.dataSource.getPassword());
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getFname());
			ps.setString(3, employee.getLname());
			ps.setString(4, employee.getPhone());
			ps.setString(5, employee.getEmail());

			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee saved with id="+employee.getId());
			}else System.out.println("Employee save failed with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Employee getById(int id) throws ClassNotFoundException {
		String query = "select empid, fname,lname,phone,email from employee where empid = ?";
		Employee emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.dataSource.getSqlurl(),this.dataSource.getUsername(),this.dataSource.getPassword());			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp = new Employee();
				emp.setId(id);
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				System.out.println("Employee Found::"+emp);
			}else{
				System.out.println("No Employee found with id="+id);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}

	
	public String deleteById(int id) throws ClassNotFoundException {
		String query = "delete from employee where empid=?";
		Connection con = null;
		PreparedStatement ps = null;
		String result="";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.dataSource.getSqlurl(),this.dataSource.getUsername(),this.dataSource.getPassword());			ps = con.prepareStatement(query);
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				result="Employee deleted with id="+id;
			}else result="No Employee found with id="+id;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	
	public List<Employee> getAll() throws ClassNotFoundException {
		String query = "select empid, fname,lname,phone, email from employee";
		List<Employee> empList = new ArrayList<Employee>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(this.dataSource.getSqlurl(),this.dataSource.getUsername(),this.dataSource.getPassword());				ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee();
				emp = new Employee();
				emp.setId(rs.getInt("empid"));
				emp.setFname(rs.getString("fname"));
				emp.setLname(rs.getString("lname"));
				emp.setEmail(rs.getString("email"));
				emp.setPhone(rs.getString("phone"));
				System.out.println("Employee Found::"+emp);
				empList.add(emp);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}
	
}
