package easy; 
public class Triangle{
public Triangle(){}
public Triangle(Triangle copy){
this.a = copy.a;
this.b = copy.b;
this.c = copy.c;
}
public Triangle a(int a){
this.a = a;
return this;
}
public Triangle b(int b){
this.b = b;
return this;
}
public Triangle c(int c){
this.c = c;
return this;
}

public int a(){
return a;
}
public int b(){
return b;
}
public int c(){
return c;
}

private int a; 
private int b; 
private int c; 

public int circumference(){ 
return a + b + c; 
} 
} 