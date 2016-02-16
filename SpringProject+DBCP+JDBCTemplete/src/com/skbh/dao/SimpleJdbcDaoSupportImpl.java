package com.skbh.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

// TODO: Auto-generated Javadoc
/**
 * The Class SimpleJdbcDaoSupportImpl.
 */
public class SimpleJdbcDaoSupportImpl extends JdbcDaoSupport {

	/**
	 * Gets the countcircle.
	 * 
	 * @return the countcircle
	 */
	public int getCountcircle() {
		String sql = "select count(*) from circle";
		return this.getJdbcTemplate().queryForInt(sql);

	}
}
