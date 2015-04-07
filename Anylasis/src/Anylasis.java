import java.io.IOException;

import com.kb.config.ExplainConf;
import com.kb.config.StaticConf;
import com.kb.logs.ExplainLogDir;
import com.kb.read.ReadFile;


public class Anylasis {
	public static void main(String[] args) throws IOException{
		ReadFile rf = null;
		rf = new ReadFile();
		
		String dir = "./config/anylasis.conf";
		if(args.length>=1){dir = args[0];}
		
		//load config file
		String conffile = rf.readFile(dir);
		StaticConf.conf = ExplainConf.explain(conffile);
		
		//read logs file
		ExplainLogDir el = new ExplainLogDir();
		el.readEveryLogDir();
	}
}