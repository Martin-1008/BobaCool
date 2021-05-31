package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.DBConnect;

public class BarangDAO {

	Connection connection;
	
	public BarangDAO() {
		try {
			initDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initDB() throws SQLException {
		connection = DBConnect.connect();
		if(connection == null) {
			throw new SQLException("connection");
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String sql = "select * from barang";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vector<String> row = new Vector<>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				data.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void insertBarang(String kode, String nama, String harga, String stok) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "insert into barang values ('"+ kode +"', '"+ nama +"', '"+ harga +"', '"+ stok +"')";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateBarang(String kode, String nama, String harga, String stok, String tanda) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "update barang set kode='" + kode + "',nama='" + nama + "',harga='"+ harga +"',stok='"+ stok +"' where kode='" + tanda + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBarang(String tanda) {
		try {
			Statement stmt = connection.createStatement();
			String sql = "delete from barang where kode='" + tanda + "'";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}