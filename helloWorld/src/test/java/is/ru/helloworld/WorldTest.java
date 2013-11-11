package is.ru.helloworld;

import static org.junit.Assert.assertEqual;

import org.junit.Test

public class WorldTest{
	@Test
	public void greetResultInHello(){
		World world = new World();
		assertEquals("Hello World!", world.greet());
	}
}
