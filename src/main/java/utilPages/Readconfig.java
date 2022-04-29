package utilPages;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
		Properties prop;
	
		public Readconfig() {
		File f = new File("src\\main\\java\\cofiguration\\config.properties");
		try {
		FileInputStream fs = new FileInputStream(f);
	    prop = new Properties();
		prop.load(fs);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		public String getBrowser() {
			return prop.getProperty("browser");
}
		public String getChromeBrowserPath() {
			return prop.getProperty("chromepath");
}
		public String getFireFoxBrowserPath() {
			return prop.getProperty("firefoxpath");
}
		public String getIEBrowserPath() {
			return prop.getProperty("iepath");
}
		public String getBaseUrl() {
			return prop.getProperty("baseurl");
}
}
