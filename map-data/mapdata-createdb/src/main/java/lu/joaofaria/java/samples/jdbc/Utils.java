package lu.joaofaria.java.samples.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Utils {
	public static Properties loadPropFile(String propFile) {
		Properties appProps = new Properties();
		try {
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			String appConfigPath = rootPath + propFile;
			appProps.load(new FileInputStream(appConfigPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return appProps;
	}

	public static String readFromInputStream(String filePath) {

		try {
			String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
			InputStream inputStream = new FileInputStream(rootPath + filePath);
			StringBuilder resultStringBuilder = new StringBuilder();
			try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
				String line;
				while ((line = br.readLine()) != null) {
					resultStringBuilder.append(line).append("\n");
				}
			}
			return resultStringBuilder.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
