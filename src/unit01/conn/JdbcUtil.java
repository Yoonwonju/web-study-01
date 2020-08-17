package unit01.conn;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    public static Connection getConnection() {
        Connection conn = null;
        String proptiesPath = "db.properties";
        try (InputStream is = ClassLoader.getSystemResourceAsStream(proptiesPath)) {
//            Properties props = new Properties();
//            props.load(is);
//            System.out.println(props);
            try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            String url = "jdbc:oracle:thin:@localhost:1521:orcl?useSSL=false";
            String user = "erd_study";
            String pwd = "rootroot";
//            System.out.printf("user = %s, password = %s, url = %s%n", user, password, url);
            conn = DriverManager.getConnection(url, user, pwd);
//            conn = DriverManager.getConnection(url, props);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
