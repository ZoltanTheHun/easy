package easy; 
public class ImmutableTriangle{
public ImmutableTriangle(){}
public ImmutableTriangle(ImmutableTriangle copy){
this.a = copy.a;
this.b = copy.b;
this.c = copy.c;
}
public ImmutableTriangle a(int a){
ImmutableTriangle copy = new ImmutableTriangle(this);
copy.a = a;
return copy;}
public ImmutableTriangle b(int b){
ImmutableTriangle copy = new ImmutableTriangle(this);
copy.b = b;
return copy;}
public ImmutableTriangle c(int c){
ImmutableTriangle copy = new ImmutableTriangle(this);
copy.c = c;
return copy;}

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