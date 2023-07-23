package Layer.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import Layer.Entities.Entities;

@Repository
public class EmpDao {

	@Autowired
	JdbcTemplate template;

	public boolean register(Entities e) {

		try {

			Object[] args = { e.getName(), e.getPwd(), e.getMob(), e.getAdhar() };
			int a = template.update("insert into empdata(`name`,`password`,`mobile`,`adhar`) values(?,?,?,?)", args);

			System.out.println(a);

			if (a == 1) {

				return true;
			} else {
				return false;
			}

		} catch (Exception e2) {

		}
		return false;
	};

								// -----------------Update Dao-------------------------------//

	public boolean update(Entities e) {

		try {

			Object[] args = { e.getName(), e.getPwd(), e.getMob(), e.getAdhar(), e.getId() };
			int a = template.update("update empdata set name = ?, password = ?, mobile =?, adhar = ? where id = ?",
					args);

			System.out.println(a);

			if (a == 1) {

				return true;
			} else {
				return false;
			}

		} catch (Exception e2) {
		}
		return false;
	};

							// -----------------Delete Dao-------------------------------//

	public Entities delete(int id) {

		try {

			Object[] args = { id };

			int a = template.update("delete from empdata where id = ?", args);

			System.out.println(a);

		} catch (Exception e2) {
		}
		return null;

	};

									// -----------------Select Dao-------------------------------//
	
		

							public Entities select(int id) {
								
								 Entities e = null;
								
								try {
									 
								Object[] args = {id};
								
								e = template.queryForObject("select * from empdata where id = ?", args,
										new RowMapper<Entities>() {
									
											public Entities mapRow(ResultSet rs, int rowNum) throws SQLException { 
													return new Entities(rs.getString(1), rs.getString(2), rs.getString(3),
																		rs.getString(4), rs.getString(5));
											}

							        	});
									
								} catch (Exception e2) {
									
								}
								
								return e;
						};
						
						
						// -----------------Select All Dao-------------------------------//
						
						

						public List<Entities> selectAll() {
							
							List<Entities> list = null;
							
							try {
							
								list = template.query("select * from empdata", new RowMapper<Entities>(){

									public Entities mapRow(ResultSet rs, int rowNum) throws SQLException {
										
										return new Entities(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
									}
									
								});			
								
							} catch (Exception e2) {
								
							}
							
							return list;
					};

}





















