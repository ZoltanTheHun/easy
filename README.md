# easy

easy is a Java based programming language.

The aim of this project is to draft some of the thoughts that I gathered while programming with Java. I would like to experiment with a few features and see if any of my ideas work out in practice without breaking Java. 

There are 3 design goals:
- Keep the language similar as similar to Java as possible
- While reducing it as much as possible
- And to introduce new keywords only when it is absolutely necessary

Some of the features I would like to try out:
- classes are always public
- no new keyword, only classes can and classes must start with capital letter
- void does not exist, instead of void, the class is used as return type
- there are no constructors, except a default and a copy constructor provided by the language
- all variables are private, but they are reachable through public getters/setters
- setters/getters are automatically generated
- default Shallow Immutablility
- mutable keyword can allow mutability 
- in future true immutable might be introduced with the strict keyword
- no inheritance, only interfaces


This project has a very simple interpreter, that can interpret a .easy file to a .java file, but it is very limited at the moment.

The current advantage, that a small code like this:
https://github.com/ZoltanTheHun/easy/blob/master/src/main/resources/easysrc/immutabletriangle.easy
```
package easy;
class ImmutableTriangle{
    int a;
    int b;
    int c;

    public int circumference(){
        return a + b + c;   
    }
}
```
In *easy* this is invoked like this:
```
ImmutableTriangle().a(1).b(2).c(3).circumference()
```
can be used from Java code like this:
```
new ImmutableTriangle().a(1).b(2).c(3).circumference()
```
