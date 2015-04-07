import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class Pt {
	public static void main(String[] args) throws IOException{
		Of o = new Of();
		String g = "C:/Apps/okay/temp";
		String str1 = o.readFile(g+"/1.txt");
		String str2 = o.readFile(g+"/json");
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		for(int i=0;i<1000;i++){
			sb1.append(str1);
			//sb1.append("#");
			sb2.append(str2);
			//sb2.append("$");
		}
		o.ot(sb1.toString(), g+"/1.txt");
		o.ot(sb2.toString(), g+"/json");
	}
}
class Of{
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
	public void ot(String str, String dir){
		File f = new File(dir);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}