package com.skbh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.skbh.model.Circle;

@Component
public class JdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("deprecation")
	public int CountRecord(){
		String sql="select count(*) from circle";
		//jdbcTemplate.setDataSource(getDataSource()); // its done at this.jdbcTemplate=new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForInt(sql);
		
	}
	
	public String getCircleByName(String circleid){
		String sql="select name from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object [] {circleid}, String.class);
		
	}
	
	public Circle getCircleById(int circleid){
		String sql="select * from circle where id=?";
		return jdbcTemplate.queryForObject(sql, new Object [] { circleid }, new CircleMapper());
	}
	
	public void insertCircle(Circle circle){
		String sql="insert into circle (id,name) values (?,?)";
		jdbcTemplate.update(sql, new Object[] {circle.getId(), circle.getName()});
	}
	
	public void deleteCircle(int circleid){
		String sql="delete from circle where id = ?";
		jdbcTemplate.update(sql, new Object[] {circleid});
	}
	
	public void updateCircle(int circleid,String circlename){
		String sql="update circle set name= ? where id = ?";
		jdbcTemplate.update(sql, new Object[] {circlename,circleid});
		
	}
	
	public List<Circle> getAllCircle(){
		String sql="select * from circle";
		return jdbcTemplate.query(sql, new CircleMapper());
		
	}
	
	private static final class CircleMapper implements RowMapper<Circle>{

		@Override
		public Circle mapRow(ResultSet resultSet, int rowNo) throws SQLException {
			Circle circle=new Circle();
			circle.setId(resultSet.getInt("ID"));
			circle.setName(resultSet.getString("NAME"));
			return circle;
		}
		
	}
	
	
	public Circle getCircle(int circleid){
		
		Connection con=null;
		Circle circle=null;
		try {
			
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			con=dataSource.getConnection();
			 ps=con.prepareStatement("select * from circle where id=?");
			 ps.setInt(1,circleid);
			 rs=ps.executeQuery();
			 while(rs.next()){
				 circle=new Circle(circleid,rs.getString("name"));
			 }
			 ps.close();
			 rs.close();
			 return circle;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return circle;
		
		
			
		
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		//this.dataSource=dataSource;
	}


	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
