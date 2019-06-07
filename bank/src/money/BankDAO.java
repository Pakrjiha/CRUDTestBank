package money;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class BankDAO {

	// insert(BankDTO dto), update = id를 받아서 tel을 바꿀수있게, select(단일검색) = id 받아서 검색 ,
	// delete = id받아서 삭제, select * from bank where id = ?

	String url = "jdbc:mysql://localhost:3306/bank";
	String user = "root";
	String password = "1234";
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public void insert(BankDTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		String sql = "insert into member values(?,?,?,?)";

		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());
		ps.setString(2, dto.getName());
		ps.setInt(3, dto.getAge());
		ps.setString(4, dto.getTel());

		ps.executeUpdate();

		JOptionPane.showMessageDialog(null, "입력이 완료되었습니다!");
		
		ps.close();
		con.close();
	}

	public void delete(BankDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		String sql = "delete from member where id = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());

		ps.executeUpdate();

		JOptionPane.showMessageDialog(null, "삭제가 완료되었습니다!");
		
		ps.close();
		con.close();
	}

	public void update(BankDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		String sql = "update member set tel = ? where id = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getTel());
		ps.setString(2, dto.getId());

		ps.executeUpdate();

		JOptionPane.showMessageDialog(null, "수정이 완료되었습니다!");
		
		ps.close();
		con.close();
	}

	public void selectAll(BankDTO dto) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		String sql = "select * from member";

		ps = con.prepareStatement(sql);

		rs = ps.executeQuery();
		while (rs.next()) {

			String id = rs.getString(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String tel = rs.getString(4);

			System.out.println(id + " " + name + " " + age + " " + tel);
			
		}
		
		JOptionPane.showMessageDialog(null, "검색이 완료되었습니다!");
		
		rs.close();
		ps.close();
		con.close();
		
	}

	public void select(BankDTO dto) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, user, password);

		String sql = "select * from member where id = ?";

		ps = con.prepareStatement(sql);
		ps.setString(1, dto.getId());

		rs = ps.executeQuery();
		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			int age = rs.getInt(3);
			String tel = rs.getString(4);

			
			JOptionPane.showMessageDialog(null, "Id : " + id + ", Name : " + name + ", Age :  " + age + ", Tel : " + tel);
			
		}
		JOptionPane.showMessageDialog(null, "검색이 완료되었습니다!");
		
		rs.close();
		ps.close();
		con.close();
	}

}
