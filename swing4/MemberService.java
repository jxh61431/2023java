package swing4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberService {
    //https://me2.kr/WNiBj
    // 20221660
    public String getUserName(String userId) {

        String userName = "";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //step2 - connection 객체 생성
            connection = getConnection();

            String sql = " select user_id, user_name, user_password from member where user_id = ? ";

            //step3 - statement가져오기
            preparedStatement = connection.prepareStatement(sql);

            //step4 - 쿼리 실행
            ResultSet rs = preparedStatement.executeQuery();
            preparedStatement.setString(1, userId);

            if(rs.next()) {
                userName = rs.getString("user_name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }

        return userName;

    }

    public void addMember(String userId, String userName, String userPassword) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //step2 - connection 객체 생성
            connection = getConnection();

            String sql = " insert into member2 (user_id, user_name, user_password, reg_dt) values ( ?, ?, ?, now() ) ";

            //step3 - statement가져오기
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, userPassword);

            //step4 - 쿼리 실행
            int affected = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
            close(connection);
        }

    }

    Connection getConnection() {

        String ip = "172.16.204.102";
        int port = 3306;
        String id = "root";
        String password = "dongyang";
        String instance = "javadb";

        String url = String.format("jdbc:mysql://%s:%d/%s", ip, port, instance);

        Connection connection = null;

        try {
            //step1 - 드라이버 로드
            Class.forName("com.mysql.jdbc.Driver");

            //step2 - connection 객체 생성
            connection = DriverManager.getConnection(url, id, password);

        } catch (Exception e) {
        }

        return connection;
    }

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (Exception e){
        }
    }

    private void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch(Exception e) {
        }
    }


}