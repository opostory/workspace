package com.kb.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ReadFile {
	public String readFile(String dir) throws IOException{
		File file = new File(dir);
		if(file.exists()){
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer sb = new StringBuffer();
			String tmp = null;
			while((tmp = br.readLine())!=null){
				sb.append(tmp+"\n");
			}
			br.close();
			return sb.toString();
		}
		return "";
	}
}
