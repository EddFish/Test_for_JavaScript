import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class JavaScriptTest {
	private static final int CHAR_FROM = 48;
	private static final int CHAR_TO = 57;
	private static final int MIN_LENGTH = 20;
	private static final int MAX_LENGTH = 40;
	private static final int MIN_QUANTITY_CH = 3;

	Random gen = new Random();
	
	Character ch = (char) (CHAR_FROM + gen.nextInt(CHAR_TO-CHAR_FROM+1));

	@Before
	public void setUp() throws Exception {
		System.out.println(
				"Create javascript with function trim that takes a string and returns this string without the symbol '"
						+ ch + "'");
		System.out.println("write this script in file trim.js and when finished, press Enter");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
	}

	@Test
	public void test() throws Exception {
		String str=getControlString();
		ScriptRunner scr = new ScriptRunner("trim.js","javascript");
		String res = (String) scr.execute("trim", str);
		str=str.replaceAll(ch.toString(),"");
		assertEquals(str, res);
	}

	private String getControlString() {
		char[] symbols=new char[MIN_LENGTH+gen.nextInt(MAX_LENGTH-MIN_LENGTH+1)];
		for (int i = 0; i < symbols.length; i++) {
			symbols[i]=(char) (CHAR_FROM + gen.nextInt(CHAR_TO-CHAR_FROM+1));
		}
		for (int i = 0; i < MIN_QUANTITY_CH; i++) {
			symbols[gen.nextInt(symbols.length)]=ch;
			
		}
		return new String(symbols);
	}

}
