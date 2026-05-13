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
It is optional to provide implementation in sub classes
**Synatax:-**
```Java
    Interface example{
        abstract void m1();
        default void m2(){
            //Body of amethod m2
        }
    }
```
