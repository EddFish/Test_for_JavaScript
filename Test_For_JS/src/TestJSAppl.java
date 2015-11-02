import java.io.*;
import java.util.Random;

import javax.script.*;

public class TestJSAppl {

	public static void main(String[] args) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		FileReader fr = new FileReader("tests.js");
		Random gen = new Random();
		Character ch = (char) (48 + gen.nextInt(10));
		System.out.println(
		"Write javascript with function trim that takes a string and returns this string without the symbol '"
						+ ch + "'");
		System.out.println("edit file test.js and when finished, press Enter");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in.readLine();
		engine.eval(fr);

		// Invoke a JavaScript function
		String str1 = "0123456789";
		System.out.println(str1);
		if (engine instanceof Invocable) {
			Invocable invEngine = (Invocable) engine;
			Object result = invEngine.invokeFunction("trim", str1);
			System.out.println("[Java] result: " + result);

		} else
			System.out.println("NOT Invocable");

	}

}
