import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.*;

public class TestJSAppl {

	public static void main(String[] args) throws ScriptException, FileNotFoundException {
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("javascript");
		FileReader fr = new FileReader("tests.js");
		Bindings bindings = new SimpleBindings();
		bindings.put("text", "Hello!     ");
		Object obj=engine.eval(fr, bindings);
		//String str=(String) obj;
		System.out.println(obj);
		
	}


}
