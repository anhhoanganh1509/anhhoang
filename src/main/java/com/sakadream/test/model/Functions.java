package com.sakadream.test.model;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.servlet.http.HttpSession;

import com.sakadream.test.bean.Category;
import com.sakadream.test.bean.Employee;
import com.sakadream.test.bean.Product;

public class Functions {
    Connection conn;
    Statement stmt;

    private void connect() throws Exception {
    	 Class.forName("org.postgresql.Driver");
         URI dbUri = new URI(System.getenv("DATABASE_URL"));

         String username = dbUri.getUserInfo().split(":")[0];
         String password = dbUri.getUserInfo().split(":")[1];
         String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

         conn = DriverManager.getConnection(dbUrl, username, password);
    	/*Class.forName("com.mysql.jdbc.Driver");
    	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoanganh", "root", "Hoang123@");*/
    }

    public Category getListCategory(int chaid, String name) throws Exception { 
        connect();
		StringBuilder query = new StringBuilder();
		query.append("select * from public.category where");
		if(chaid == 1) {
			if(name == null) { 
				query.append(" chaid is not null ");
			}else {
				query.append(" chaid is not null ");
				query.append(" and categoryname like '%"+name+"%' ");
			}
		}else{
			if(name == null) {
				query.append(" chaid is null ");
			}else {
				query.append(" chaid is null ");
				query.append(" and categoryname like '%"+name+"%' ");
			}
		}
		query.append(" AND daxoa = 0 order by categoryid desc ");
		String sql = query.toString();
		Class.forName("org.postgresql.Driver");
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Category c = new Category(); 
		while(rs.next()) {
			c.setCategoryName(username);
			c.setNguoiTao(password);
			c.setNguoiSua(dbUrl);
		} 
		return c;     
	}

    public ArrayList<Product> getListProduct() throws Exception {
	    connect();
	    StringBuilder query = new StringBuilder();
	    query.append("select c.categoryname,p.productid,p.productma,p.productname,p.productimage,p.productprice,p.productdescription,p.sanid,p.ngaytao,p.nguoitao,p.ngaysua,p.nguoisua ");
	    query.append(" from public.category c join public.product p on c.categoryid = p.productma where ");
	    
	    	query.append(" c.chaid = 1 and p.sanid is not null ");
	    
		String sql = query.toString();
	    stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		ArrayList<Product> list = new ArrayList<>();
	    try  {
	        while (rs.next()) {
	        	Product p = new Product(); 
	            Blob blob = rs.getBlob("productimage");
	            InputStream inputStream = blob.getBinaryStream();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            byte[] buffer = new byte[4096];
	            int bytesRead = -1;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputStream.write(buffer, 0, bytesRead);                  
	            }
	            byte[] imageBytes = outputStream.toByteArray();
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            inputStream.close();
	            outputStream.close();
	            p.setBase64Image(base64Image);
	            p.setProductId(rs.getLong("productid"));
	            p.setProductMa(rs.getLong("productma"));
	            p.setProductName(rs.getString("productname"));
	            p.setProductPrice(rs.getString("productprice"));
	            p.setProductDescription(rs.getString("productdescription"));
	            p.setSanId(rs.getLong("sanid"));
	            p.setNgayTao(rs.getTimestamp("ngaytao"));
				p.setNguoiTao(rs.getString("nguoitao"));
				p.setNgaySua(rs.getTimestamp("ngaysua"));
				p.setNguoiSua(rs.getString("nguoisua"));
	            p.setCategoryName(rs.getString("categoryname"));
	            list.add(p);
	        }          
	    } catch (Exception ex) {
	        ex.printStackTrace();
	        throw ex;
	    }      
	    return list;
	}

    public Boolean checkLogin(String username, String password, HttpSession session) throws Exception {
        connect();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users " 
            + " WHERE \"useremail\" LIKE '" + username + "' AND \"userpass\" LIKE '" + password + "'");
        while(rs.next()) {
            session.setAttribute("username", username);
            return true;
        }
        return false;
    }

    public List<Employee> showAllEmployees() throws Exception {
        List<Employee> list = new ArrayList<>();
        connect();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"EMPLOYEES\" ORDER BY \"ID\" ASC");
        while (rs.next()) {
            Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                    rs.getInt(6));
            list.add(e);
        }
        return list;
    }

    public Employee getEmployee(int id) throws Exception {
        connect();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.\"EMPLOYEES\" WHERE \"ID\" = " + id);
        while(rs.next()) {
            return new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
        }
        throw new RuntimeException();
    }

    public Employee getEmployee1(int id) throws Exception {
        connect();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM public.EMPLOYEES WHERE ID = " + id);
        Employee e = new Employee();
        while(rs.next()) {
            e.setId(rs.getInt("ID"));
            e.setFullName(rs.getString("FULLNAME"));
            e.setAddress(rs.getString("ADDRESS"));
            e.setEmail(rs.getString("EMAIL"));
            e.setPhone(rs.getString("PHONE"));
            e.setSalary(rs.getInt("SALARY"));
        }
        return e;
    }
    public void add(Employee e) throws Exception {
        connect();
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO public.\"EMPLOYEES\" (\"FULLNAME\", \"ADDRESS\", \"EMAIL\", \"PHONE\", \"SALARY\") "
            + "VALUES " 
            + "('" + e.getFullName() + "', '" + e.getAddress() + "', '" + e.getEmail() + "', '" + e.getPhone() + "', '" + e.getSalary() + "')");
        cleanConnection();
    }

    public void edit(int id, Employee e) throws Exception {
        connect();
        stmt = conn.createStatement();
        stmt.executeUpdate("UPDATE \"EMPLOYEES\" "
            + "SET \"FULLNAME\" = '" + e.getFullName() + "', \"ADDRESS\" = '" + e.getAddress() + "', \"EMAIL\" = '" + e.getEmail() + "', "
            + "\"PHONE\" = '" + e.getPhone() + "', \"SALARY\" = " + e.getSalary() + " "
            + "WHERE \"ID\" = " + id);
        cleanConnection();
    }

    public void delete(int id) throws Exception {
        connect();
        stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM public.\"EMPLOYEES\" WHERE \"ID\" = " + id);
        cleanConnection();
    }

    public void cleanConnection() throws Exception {
        conn.close();
        stmt.close();
    }

    public void echoQuery(String query) {
        System.out.println(query);
    }

    public Boolean checkSession(HttpSession session) {
        return (session.getAttribute("username") != null) ? true : false;
    }
}