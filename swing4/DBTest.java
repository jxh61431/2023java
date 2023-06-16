package swing4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBTest {

    public static void main(String[] args) {

        String ip = "localhost";
        int port = 3306;
        String id = "root";
        String password = "dongyang";
        String instance = "javadb";

        String url = String.format("jdbc:mysql://%s:%d/%s", ip, port, instance);

        try {
            // 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connection 객체 생성
            Connection connection = DriverManager.getConnection(url, id, password);

            String sql = "select user_id, user_name from member";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("user_id") + ","
                        + rs.getString("user_name"));
            }


        }catch (Exception e) {
            e.printStackTrace();
        }



        //5(ip, port, account, password, instance)
        // jdbc driver



    }
}
