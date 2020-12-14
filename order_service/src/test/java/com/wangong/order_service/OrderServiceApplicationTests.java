package com.wangong.order_service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {OrderServiceApplicationTests.class})
class OrderServiceApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from w_order ");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Array array = resultSet.getArray(1);
            System.out.println(array);
        }

    }

}
