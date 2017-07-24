package easy; 
public class MutableTriangle{
public MutableTriangle(){}
public MutableTriangle(MutableTriangle copy){
this.a = copy.a;
this.b = copy.b;
this.c = copy.c;
}
public MutableTriangle a(int a){this.a = a;return this;}
public MutableTriangle b(int b){this.b = b;return this;}
public MutableTriangle c(int c){this.c = c;return this;}

public int a(){return a;}
public int b(){return b;}
public int c(){return c;}

private int a; 
private int b; 
private int c; 

public int circumference(){ 
return a + b + c; 
} 
} 