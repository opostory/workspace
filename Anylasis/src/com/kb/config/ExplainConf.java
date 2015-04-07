package com.kb.config;

import java.util.HashMap;
import java.util.Map;

import com.kb.errors.Errors;

public class ExplainConf {
	/*
	 * load logs configure 
	 * return map
	 */
	public static Map<String, String> explain(String conf){
		if(conf.length() <= 0){Errors.exit("配置文件加载失败");}
		
		String[] line = conf.split("\n");
		Map<String, String> map = new HashMap<String, String>();
		
		for(String i : line){
			if(i.length() <= 0){continue;}
			char shap = i.charAt(0);
			if(shap != '#'){
				i = i.trim(); 
				String[] va = i.split("=");
				if(va.length == 1){
					map.put(va[0].trim(), "");
				}else{
					String vatmp = va[1].trim();
					if(va[1].trim().equals("eq")){
						vatmp = "=";
					}
					map.put(va[0].trim(), vatmp);
				}
			}
		}
		return map;
	}
}