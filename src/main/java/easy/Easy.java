/*
 * Copyright (c) 2017, ZoltanTheHun
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package easy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Easy {

    private Map<String,String> variables = new HashMap<>();
    private boolean mutable = false ;
    private String className;
    
    public static void main(String[] args) throws FileNotFoundException {
            new Easy().easy();
            Triangle test = new Triangle().a(3);
            System.out.println("Circumference: " + new Triangle(test).b(2).c(3).circumference());
    }
    
    public void easy() throws FileNotFoundException{
        ClassLoader classLoader = getClass().getClassLoader();
	File file = new File(classLoader.getResource("easysrc/immutabletriangle.easy").getFile());
        Scanner sc = new Scanner(file);
        String output = "";

        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.contains("class")){
                line = classDefinition(line);
            }else {
                StringTokenizer st = new StringTokenizer(line);
                line = "";
                int i = 0;
                String variableType = null;
                while (st.hasMoreTokens()){
                    String token  = st.nextToken();
                    if(isType(token) && i == 0){
                        variableType = token;
                        token ="private " + token;
                    } 
                    if(i == 1  && variableType != null) {
                        String variableName = token.substring(0, token.length() - 1 );
                        variables.put(variableName, variableType);
                    }
                    
                    line = line + token + " ";
                    i++;
                    
                }
            }
            output = output + line + System.lineSeparator();
        }
        output = generate(new Scanner(output));
        System.out.println(output);
    }
    
    private String classDefinition(String line){
        StringTokenizer st = new StringTokenizer(line);
        while(st.hasMoreTokens()){
            String next = st.nextToken();
            switch (next){
                case "class" : break;
                case "mutable" : mutable = true; break;
                default : {
                   if(next.contains("{")) next = next.substring(0, next.length()-1);
                   className = next;
                }
            }
        }
        return "public class " + className + "{";
    }
    private boolean isType(String token){
        switch(token){
            case "int": return true;
            default: return false;
        }
    }
    private String generate(Scanner sc){
        sc.reset();
        String out = "";
        while(sc.hasNext()){
            String line = sc.nextLine();
            if(line.startsWith("public class ")){
                line = line + System.lineSeparator() +
                        defaultConstructor() + System.lineSeparator() +
                        copyConstructor() + System.lineSeparator() + 
                        setters() + System.lineSeparator() + 
                        getters();
            } 
            out = out + line + System.lineSeparator();
        }
        return out;
    }
    
    private String defaultConstructor(){
        return "public " + className + "(){}";
    }
    
    private String copyConstructor(){
        String constr = "public " + className + "("+ className +" copy){" + System.lineSeparator();
        for(String varName : variables.keySet()){
            constr = constr + "this." + varName + " = copy." + varName + ";" + System.lineSeparator();
        }
        return constr + "}";
    }
        
    private String setters(){
        String setters = "";
        for(String varName : variables.keySet()){
            String type = variables.get(varName);
            setters = setters + "public " + className + " " + varName + "(" + type + " " + varName+ "){" + System.lineSeparator() ;
            setters = setters + "this." + varName + " = " + varName + ";"  + System.lineSeparator();
            setters = setters + "return this;" + System.lineSeparator();
            setters = setters + "}" + System.lineSeparator();
        }
        return setters;
    }
    
    private String getters(){
        String getters = "";
        for(String varName : variables.keySet()){
            String type = variables.get(varName);
            getters = getters + "public " + type + " " + varName + "(){" + System.lineSeparator() ;
            getters = getters + "return " + varName + ";"  + System.lineSeparator();
            getters = getters + "}" + System.lineSeparator();
        }
        return getters;
    }
          
}
