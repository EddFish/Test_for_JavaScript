

import static org.junit.Assert.*;
import org.junit.Test;

public class myTest{

	@Test
	public void test() throws Exception{
String str = "87769324633911031040410132017741243543";
ScriptRunner scr = new ScriptRunner("trim.js","javascript");
String res = (String) scr.execute("trim", str);
str=str.replaceAll("3","");
assertEquals(str, res);
}
}