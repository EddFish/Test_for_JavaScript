import java.io.FileReader;

import javax.script.*;


public class ScriptRunner {
	private ScriptEngineManager manager = new ScriptEngineManager();
	private ScriptEngine engine = manager.getEngineByName("javascript");

	public Object execute(String fileName, String functionName, Object arg) throws Exception {
		FileReader fr = new FileReader(fileName);
		engine.eval(fr);
		if (engine instanceof Invocable) {
			Invocable invEngine = (Invocable) engine;
			Object result = invEngine.invokeFunction(functionName, arg);
			return result;

		} else
			return null;

	}

}
