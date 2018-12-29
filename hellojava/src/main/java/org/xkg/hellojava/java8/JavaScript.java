package org.xkg.hellojava.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author : Xiangkui Guo
 * @date : 2018/12/29
 */

//Calling JavaScript from Java with Nashorn
public class JavaScript {
    public static void main(String args[]) {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("Nashorn");

        String name = "Haha";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        } catch(ScriptException e) {
            System.out.println("Error executing script: "+ e.getMessage());
        }
        System.out.println(result.toString());
    }
}
