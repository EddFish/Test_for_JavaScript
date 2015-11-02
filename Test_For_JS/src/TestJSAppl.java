import java.io.*;

import javax.script.*;

public class TestJSAppl {

	public static void main(String[] args) throws Exception{
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine=manager.getEngineByName("javascript");
		// Run InvScript.js
        /*Reader scriptReader = new InputStreamReader(
        		TestJSAppl.class.getResourceAsStream("tests.js"));
        try {
            engine.eval(scriptReader);
        } finally {
            scriptReader.close();
        }*/
        FileReader fr = new FileReader("tests.js");
        engine.eval(fr);

        // Invoke a JavaScript function
        String str1="Hello!     ";
        System.out.println(str1.length());
        if (engine instanceof Invocable) {
            Invocable invEngine = (Invocable) engine;
            Object result = invEngine.invokeFunction("trim",str1);
            System.out.println("[Java] result: " + result);
            /*System.out.println("    Java object: "
                    + result.getClass().getName());*/
            String str2=(String) result;
            System.out.println(str2.length());
        } else
            System.out.println("NOT Invocable");
        
		
		
		/*FileReader fr = new FileReader("tests.js");
		Bindings bindings = new SimpleBindings();
		bindings.put("text", "Hello!     ");
		Object obj=engine.eval(fr, bindings);
		//String str=(String) obj;
		System.out.println(obj);*/
		
	}


}
