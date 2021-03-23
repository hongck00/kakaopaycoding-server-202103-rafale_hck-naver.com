package com.kakaopay.invest;

import com.kakaopay.invest.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);

        for (String arg: args) System.out.println(arg);
        String url = System.getProperty("datasources.url");
        String db = System.getProperty("datasources.db");
        String dbuser = System.getProperty("datasources.user");
        String password = System.getProperty("datasources.password");
        System.out.println(url + ", " + db + ", " + dbuser + ", " + password);


        try(Connection con = DriverManager.getConnection(
                "jdbc:mariadb://" + url + ":3306/" + db,
                dbuser,
                password
        )) {
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("con >> " + con);
        } catch (Exception ex) {
            System.err.println("에러 : " + ex);
        }

        char ch1 = 'd';
        char[] ch2 = {'d', 'a'};
        String str1 = "";
        String str2 = null;
        int int1 = 0;
        Integer int2 = null;
        long long1 = 0;
        Long long2 = null;

        if (StringUtils.hasText(str1)) System.out.println("str1 OK");
        if (StringUtils.hasText(str2)) System.out.println("str2 OK");
        if (ObjectUtils.isEmpty(str1)) System.out.println("Object str1 OK");
        if (ObjectUtils.isEmpty(str2)) System.out.println("Object str2 OK");
        if (ObjectUtils.isEmpty(int1)) System.out.println("int1 OK");
        if (ObjectUtils.isEmpty(int2)) System.out.println("int2 OK");
        if (ObjectUtils.isEmpty(long1)) System.out.println("long1 OK");
        if (ObjectUtils.isEmpty(long2)) System.out.println("long2 OK");

        var user1 = Optional.ofNullable(getUser())
                .isPresent()
                ;
        System.out.println("user >> " + user1);


        long start1 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (UserInfoModel user : getUsers()) {
            if (user.getUserId() != null
                    && user.getName() != null
                    && user.getUserSeq() != null) {
                sb.append(user.getName());
            }
        }
        long end1 = System.currentTimeMillis();
        long result1 = end1 - start1;
        System.out.println("첫번째 : " + result1);
        System.out.println("첫번째 결과값 : " + sb.toString());

        long start2 = System.currentTimeMillis();
        StringBuffer sb2 = new StringBuffer();
        for (UserInfoModel user : getUsers()) {
            Optional.ofNullable(user)
                    .filter(o -> o.getName() != null
                            && o.getUserSeq() != null
                            && o.getUserId() != null)
                    .ifPresent(e -> {
                        sb2.append(e.getName());
                    });
        }
        long end2 = System.currentTimeMillis();
        long result2 = end2 - start2;
        System.out.println("두번째 : " + result2);
        System.out.println("두번째 결과값 : " + sb2.toString());
    }

    private static UserInfoModel getUser() {
        return null;
    }

    private static List<UserInfoModel> getUsers() {
        return Arrays.asList(
                new UserInfoModel(1L, "A", "a1"),
                new UserInfoModel(2L, "B", "b2"),
                new UserInfoModel(3L, "C", "c3"),
                new UserInfoModel(4L, "D", "d4"),
                new UserInfoModel(5L, "E", "e5"),
                new UserInfoModel(6L, "F", "f6"),
                new UserInfoModel(7L, "G", "g7"),
                new UserInfoModel(8L, "H", "asdf"),
                new UserInfoModel(9L, "I", "BBBasef222"),
                new UserInfoModel(10L, "J", "BBB2asef22"),
                new UserInfoModel(11L, "K", "BBB2asef22"),
                new UserInfoModel(12L, "L", "BBB22asef2"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22"),
                new UserInfoModel(13L, "M", "BBB2asef22")
        );
    }
}
