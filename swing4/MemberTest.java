package swing4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberTest {

    public static void main(String[] args) {

        MemberService memberService = new MemberService();
        // String userName = memberService.getUserName("");
        // System.out.println(userName);       가져오기

        String userId = "a123";
        String userName = "이주현";
        String userPassword = "1234";

        memberService.addMember(userId, userName, userPassword);


    }
}
