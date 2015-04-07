package com.kb.logs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kb.config.StaticConf;
import com.kb.errors.Errors;
import com.kb.read.ReadFile;

public class ExplainLogDir {

	private ReadFile rf = null;
	
	public void readEveryLogDir(){
		String[] logs = StaticConf.conf.get("logdir").split(",");
		String[] rule = StaticConf.conf.get("rule").split(",");
		String[] table = StaticConf.conf.get("table").split(",");
		
		if(logs.length != rule.length || logs.length != table.length ){Errors.exit("日志文件地址和规则、表不匹配!");}
		ExplainLog el = new ExplainLog(logs, rule, table);
		el.readLog();
		
	}
}
