package zx.soft.navie.bayes.data;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SinaJDBCTest {

	private SinaJDBC sina_jdbc;

	@Before
	public void init() {
		sina_jdbc = new SinaJDBC();
	}

	@After
	public void close() {
		sina_jdbc.dbClose();
	}

	@Test
	public void test() {
		System.out.println(sina_jdbc.toString());
		assertEquals(
				sina_jdbc.toString(),
				"SentJDBC:[db_url=jdbc:mysql://192.168.3.22:3306/weibo_sina?useUnicode=true&characterEncoding=utf-8,db_username=weibosina,db_password=OyiaV5M53qTqlZjmN0OOtA==]");

	}
}
