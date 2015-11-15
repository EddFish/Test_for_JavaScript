import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.*;

public class ScriptRunner {
	private ScriptEngineManager manager = new ScriptEngineManager();
	private ScriptEngine engine;
	private FileReader fr;

	public ScriptRunner(String fileName, String scriptName) {
		super();
		try {
			this.fr = new FileReader(fileName);
			engine = manager.getEngineByName(scriptName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object execute(String functionName, Object... arg) throws Exception {
		engine.eval(fr);
		if (engine instanceof Invocable) {
			Invocable invEngine = (Invocable) engine;
			Object result = invEngine.invokeFunction(functionName, arg);
			return result;

		} else
			return null;

	}

}
