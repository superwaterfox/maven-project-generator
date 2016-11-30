package com.waterfox.junit;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.waterfox.common.BaseExample;
import com.waterfox.common.BaseExample.Criteria;
import com.waterfox.demo.User;
import com.waterfox.demo.UserMapper;

public class MybatisTest {
	private SqlSession sqlSession;

	public Connection getConnection() throws IOException {
		// 1加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
		// 2、根据配置文件创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3、SqlSessionFactory创建SqlSession
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession.getConnection();
	}

	// ----------------测试start---------------------
	@Before
	public void init() throws IOException {
		// 1加载配置文件
		InputStream inputStream = Resources.getResourceAsStream("mybatis/SqlMapConfig.xml");
		// 2、根据配置文件创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 3、SqlSessionFactory创建SqlSession
		sqlSession = sqlSessionFactory.openSession();
	}

	@After
	public void after() {
		// 切记：增删改操作时，要执行commit操作
		sqlSession.commit();
		// 5、关闭SqlSession
		sqlSession.close();
	}

	@Test
	public void test1() {
		/**
		 * 使用工厂Example进行操作
		 */
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		BaseExample example = new BaseExample();
		example.setDistinct(true);
		example.setOrderByClause("birthday desc");
		BaseExample.Criteria criteria = example.createCriteria();
		criteria.andColumnBetween("id", 1, 10);
		criteria.andColumnGreaterThanOrEqualTo("id", 1);
		// criteria.andColumnBetween("creta", value1, value2);

		criteria.andColumnLike("username", "%张%");
		List<User> users = userMapper.selectByExample(example);
		for (User user : users) {
			System.out.println(user);
		}
	}

	/**
	 * 使用原生mapper进行操作 start---------------------------------
	 */
	@Test
	public void test2() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user2 = new User();
		user2.setStart(0);
		user2.setPagesize(3);
		user2.setUsername("张");
		List<User> selectByUserName = userMapper.selectByUserName(user2);
		for (User user : selectByUserName) {
			System.out.println(user);
		}
	}

	/**
	 * ids方式一：使用String 1,23,2 进行ids搜索
	 */
	@Test
	public void test3() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		// user.setUsername("张三");
		user.setIds("10,16");
		List<User> list = userMapper.selectInIds(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}

	/**
	 * ids方式二：使用list来封装id，sql进行拼写上边的sql语句
	 */
	@Test
	public void test4() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		List<Integer> list = new ArrayList();
		list.add(10);
		list.add(16);
		List<User> list2 = userMapper.selectUsersByType(list);

	}

	@Test
	public void test5() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		BaseExample example = new BaseExample();
		Criteria criteria = example.createCriteria();
		criteria.andColumnEqualTo("id", 1);
		userMapper.updateByExampleSelective(user, example);
	}

	@Test
	public void test6() {
//		TblOrderForeclosureMapper backMapper = sqlSession.getMapper(TblOrderForeclosureMapper.class);
//		TblOrderForeclosure selectByPrimaryKey = backMapper.selectByPrimaryKey(1);
//		System.out.println(selectByPrimaryKey);
	}

}
