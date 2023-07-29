package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WeatherApplicationTests {

	@Test
	public void equalTest() throws Exception {
		int i = 1;
		assertEquals(1, i);
	}

	@Test
	public void nullTest() throws Exception {
		assertNull(null);
	}

	@Test
	public void trueTest() throws Exception {
		assertTrue(1==1);
	}
}
