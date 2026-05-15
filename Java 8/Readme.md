### Why Java 8?
1. Java 8 came to reduce boilerplate code and make java code shorter and more readable using lambda expression.
2. It become more readable using lambda expression.<br>
**Before Java 8**
```Java
    Collections.sort(list, new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
});
```
**After Java 8**
```Java 
  Collections.sort(list, (a, b) -> a - b);
```
3. It introduce stream api to process collections more easily.<br>
**Before Java 8**
```Java
List<Integer> result = new ArrayList<>();

for(int n : list) {
    if(n % 2 == 0) {
        result.add(n);
    }
}
```
**After Java 8**
```Java
list.stream()
    .filter(n -> n % 2 == 0)
    .forEach(System.out::println);
```
4. It support parallel processing.<br>
**Before Java 8**
```Java
parallelStream()
```
**After Java 8**
```Java
list.parallelStream().forEach(System.out::println);
```
5. It modernized java with feature like functional programming, better Date/Time API and default methods in interface

#### Topics need to be cover
![Logo](Images/Java8TopicList.png)

## Default Methods
##### Why we need default methods
Before Java 8 an interface contain one abstract method m1 and sub class A nd sub class B who are implementing that interface need to provide implementation of that method. After sometime class A need another method m2 so we declared the abstract method in interface so class B forcefully need to provide the implementation of m2 here the default method came into the picture.  

###### Default Method :- 
It is an interface method that has implementation body.<br>
It is optional to provide implementation in sub classes.<br>
**Synatax:-**
```Java
    Interface example{
        abstract void m1();
        default void m2(){
            //Body of amethod m2
        }
    }
```
###### Functional Programing
By using functional programing we can pass function as an argument to a method.

### Functional Interface
An interface which has only one abstract method is called functional interface.<br>
**Example:-** <br>
```Java
    interface abc{
        public abstract void add(int a, int b);
    }
```
- It is also known as SAM interface **Single Abstract Method**. <br>
- If an interface has only one abstarct method compiler consider it as a functional interface. Then compiler allow us to create  lambda expression  from this interface. <br>
- If an interface has more than one abstract method then compiler will not consider it as a functional interface. Then compiler will not allow us to create lambda expression.

### Methods allowed using @FunctionalInterface Annotation
a) public void add(int a, int b); only one abstract method is allowed.<br>
b) public static final int a = 10; Multiple static final methods are allowed<br>
c) public static class A {} Multiple inner classes are allowed <br>
d) public default void m1(){} Multiple default methods are allowed <br>
e) public static void m3(){} multiple static methods are allowed <br>
f) private static void m1(){} private static methods are not allowed till version 8 in version 9 it is allowed<br>
g) public abstract int hashCode(){} Java.lang.object class methods are allowed as abstract method in functional interface<br>
h) public default String toString(){
    return "HK";   // Java.lang.object class method are not allowed as a default method are not allowed as default method in functional interface
}<br>
**Important Points**
- If a functional interface deriving from another functional interface and it is creating another abstract method then it is not allowed
```Java
    @FunctionalInterface
    interface A {
        void m1() {} //abstract method
    }
    @FunctionalInterface
    interface B extends A{
        void m2() {} // It will give compile time error  because if you mark it as a functional interface the it contain only one functional interface
    } 
```
- If a non-functional interface extending functional interface then multiple abstract methods are allowed
```Java
    @FunctionalInterface
    interface A{
        void m1(){}
    }
    interface B extends A{
        void m2(){} // No compile time error because this interface is not a functional interface.
    }
```
