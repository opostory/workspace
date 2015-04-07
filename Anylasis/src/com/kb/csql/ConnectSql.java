package com.kb.csql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

import com.kb.config.StaticConf;

public class ConnectSql {
	public void connect(List<String> list){
		String driver = "com.mysql.jdbc.Driver";
		StringBuffer url = new StringBuffer();
		url.append("jdbc:mysql://");
		url.append(StaticConf.conf.get("mysqlhost"));
		url.append(":");
		url.append(StaticConf.conf.get("mysqlport"));
		url.append("/");
		url.append(StaticConf.conf.get("mysqldb"));
		url.append("?useUnicode=true&characterEncoding=UTF8");
		String user = StaticConf.conf.get("mysqluser");
		String password = StaticConf.conf.get("mysqlpwd");
		
		try{
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url.toString(), user, password);
			Statement stat = conn.createStatement();
			conn.setAutoCommit(false);
			for(String i : list){
				stat.addBatch(i);
			}
			stat.executeBatch();
			conn.commit();
			conn.close();
		}catch(Exception e){}
	}
}
