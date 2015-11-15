import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JavaScriptTest {
	String str;
	ScriptRunner scr;
	Character ch;

	@Before
	public void setUp() throws Exception {
		Random gen = new Random();
		ch = (char) (48 + gen.nextInt(10));
		System.out.println(
				"Write javascript with function trim that takes a string and returns this string without the symbol '"
						+ ch + "'");
		System.out.println("edit file test.js and when finished, press Enter");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		str = "01234567890123456789";
		scr = new ScriptRunner("tests.js","javascript");
	}

	@Test
	public void test() throws Exception {
		String res = (String) scr.execute("trim", str);
		str=str.replaceAll(ch.toString(),"");
		assertEquals(str, res);
	}

}
