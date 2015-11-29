import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JSSignTest {
	Random gen = new Random();

	@Before
	public void setUp() throws Exception {
		System.out.println("Create javascript with function sign, which return sign of number ");
		System.out.println("write this script in file sign.js and when finished, press Enter");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
	}

	@Test
	public void test() throws Exception {
		Integer[] etalon = { 1, -1, 0 };
		Integer[] res = new Integer[3];
		ScriptRunner scr = new ScriptRunner("sign.js", "javascript");
		res[0] = (Integer) scr.execute("sign", gen.nextInt(100)+1);
		scr = new ScriptRunner("sign.js", "javascript");
		res[1] = (Integer) scr.execute("sign", -gen.nextInt(100)-1);
		scr = new ScriptRunner("sign.js", "javascript");
		res[2] = (Integer) scr.execute("sign", 0);
		assertTrue(Arrays.equals(etalon, res));
	}

}
