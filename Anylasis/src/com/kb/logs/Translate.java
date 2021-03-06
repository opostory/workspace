package com.kb.logs;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.kb.config.StaticConf;

public class Translate {
	/*
	 * @map 日志文件分析后生成的map表
	 * @table 日志对应的表
	 * @list 回调list
	 * return 将map转换成sql字符串
	 */
	public List<String> tsSql(Map<String, String> map, String table, List<String> list){
		Iterator<Entry<String, String>> it = map.entrySet().iterator();
		StringBuffer sb = new StringBuffer();
		sb.append("insert into ");
		sb.append(table);
		sb.append(" (");
		StringBuffer key = new StringBuffer();
		StringBuffer value = new StringBuffer();
		while(it.hasNext()){
			Entry entry = it.next();
			String key3 = (String) entry.getKey();
			key.append(key3.trim().replaceAll("\r|\n", ""));
			key.append(",");
			value.append("\'");
			String key4 = (String) entry.getValue();
			value.append(key4.replaceAll("\r|\n", ""));
			value.append("\',");
		}
		String keys = key.toString();
		String values = value.toString();
		keys = keys.substring(0, keys.length()-1);
		values = values.substring(0, values.length()-1);
		sb.append(keys);
		sb.append(") values (");
		sb.append(values);
		sb.append(");");
		System.out.println(sb.toString());
		list.add(sb.toString());
		return list;
	}
}
