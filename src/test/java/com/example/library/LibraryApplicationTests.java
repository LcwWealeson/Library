package com.example.library;

import com.example.library.dao.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class LibraryApplicationTests {

	@Autowired
	DataSource dataSource;

	UserMapper userMapper;

	@Test
	void contextLoads() throws SQLException {
		//测试数据库连接
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		System.out.println(userMapper==null);

	}

}
