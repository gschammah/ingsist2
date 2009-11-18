package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 *
 * @author Fox-Hound
 */
public class IPReader {

    private static FileInputStream is;
    private static File f;
    private static String PATH;
    private static Properties prop;
  

    public static String getCoruniaIP(String path){
        PATH = path;
        f = new File(PATH);

		try {
			is = new FileInputStream(f);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
        prop = new Properties();
        try {
            prop.load(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return prop.getProperty("corunia");

    }


}
