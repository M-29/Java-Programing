#### MultiTasking
Executing several task simultaneously is known as multitasking.<br>
Types of multitasking<br>
a) Process based multitasking : Executing several task simultaneously where each task is a seperate independent program.  It is best suite for OS level.<br>
eg Typing a java program, Downloading a file, Listening a music are eg of process based multi tasking because each task is seperate independent process. <br>
b) Thread based multitasking <br>
Executing several task simultaneously where each task is a seperate independent part of a same program this type of multitasking is called thread based multitasking Each independent part is called thread<br>
-It is best suite for programatic level<br>
Main objective of multitasking is to reduce response time of a system and improve performance

###### Thread 
A thread is a flow of execution is known as thread. <br>
For every thread a seperate independent job is their.<br>
we can define a thread in two ways:-<br>
a)By extending thread class<br>
b)By implementing runnable interface<br>

Thread Scheduler :- is responsible to schedule the threads i.e.; if multiple threads are waiting for execution then in which order threads will execute is decided by the Thread Scheduler.
-It is a part of JVM
-we can excpect thread execution order and exact output hence it is varried from JVM to JVM 

**Difference b/w t.start() and t.run()** <br>
a) t.start() :- <br>
-It is used to create new thread and that thread is responsible to execute run method.<br>
-It is responsible to register thread with thread scheduler<br>

b) t.run() :- <br>
-Our run method is executed as a normal method call so main thread is responsible to execute the job

```Java
  public class Mythread extends Thread{
    public void run(){
      for(int i = 0; i< 10; i++){
        System.out.println("Child Thread");
      }
    }
  }

public class Main{
  public static void main(String[] args){
    Mythread myth = new Mythread();
    myth.start(); // is responsible to create child thread and execute run method
  }
}
```
**Overloading of run method**<br>
Overloading of run method is always possible but thread class start method can invoke no argument run method the other overloaded method we have to call explicitly like a normal method call.<br>
**Example:-**
```Java
  public class Mythread extends Thread{
    public void run(){
        System.out.println("Child Thread");
      }
      public void run(int i){      
        System.out.println(i);
    }
  }

public class Main{
  public static void main(String[] args){
    Mythread myth = new Mythread();
    myth.start(); // O/P is Child Thread
  }
}
```

**Not overrriding run method**<br>
If we are not overriding run method then thread class run method will be executed which has empty implementation hence we will not get any output.
```Java
  public class Mythread extends Thread{
    
  }
public class Main{
  public static void main(String[] args){
    Mythread myth = new Mythread();
    myth.start(); // O/P No output
  }
}
```
**Overriding start method**
If we override start method then our start method will be executed just like a normal method call new thread will not be created.<br>
-It is not recommended to override the start method 
**Example:-**
```Java
  public class Mythread extends Thread{
    public void run(){
        System.out.println("Child Thread");
      }
      public void start(){      
        System.out.println("Start Method");
    }
  }

public class Main{
  public static void main(String[] args){
    Mythread myth = new Mythread();
    myth.start(); 
    System.out.println("Main Method"); //  O/P is Start Method
                                      // Main method
  }
}
```
After starting a thread if you are trying to start a thread again you will get runtime exception saying illegal thread state exception.<br>

#### Implementing thread class using runnable interface
- Runnable interface present in Java.lang package
- It contains only one method
  ```Java
  public void run()
  ```
**Example:-**<br>
```Java
  public class Myrunable implements Runnable{
    public void run(){
      System.out.println("Child Thread");
    }
  }
  puvlic class Main(){
    public static void main(String[] args){
      Myrunable r = new Myrunable();
      r.run();
      System.out.println("Main Thread");
    }
  }
```
- In above code we will get mixed output we can predict the exact output.<br>

##### Case Studies <br>
Myrunable r = new Myrunable();<br>
Thread t1 = new Thread();<br>
Thread t2 = new Thread(r)<br>
**Case 1 :-** t1.start(); <br>
A new thread will be created which is responsible for execution of thread class run method. which has empty implemetation.<br>
**Case 2 :-** t1.run(); <br>
No new thread will be created and thread class run method will be executed just like a normal method call
**Case 3 :-** t2.start(); <br>
A new thread will be created which is resposible for execution of Myrunnable class run method.<br>
**Case 4 :-** t2.run(); <br>
A new thread won't be created and myrunable will be executed just like a normal method call.<br>
**Case 5 :-** r.start(); <br>
We will get compile time error saying my runnable class doesn't have start capacity<br>
**Case 6 :-** r.run(); <br>
No new thread will be created and myrunnable run method will be executed like a normal method call<br>

**Why runnable approach is better than thread class**
With Implementing runnable interface we can extend classess but with extending thread class we can't get the benifit for inheritance so that's why implementing runnable interface is recommended.<br>

### Synchronization<br>
Synchronize is modifier applied only for methods and blocks but not for classes and variable.<br>
If a multiple thread are operating on a same java object then there may be chance of data inconsistency problem to overcome this problem we are using synchronize keyword.<br>
If a method or block declared as a synchronised then at a time only one thread is allowed to execute that method or block on a given object so that data inconsistency problem is resolved.<br>
**Advantage**:- resolve data inconsistency problem.<br>
**Disadvantage**:- increases waiting time of threads and create performace problem.<br>
- Internally synchronization concept is applicable using lock. Every object in java have a unique lock. Whenever we are using synchronize keyword then only lock concept comes in the picture.<br>
- If a thread want to execute synchronize method on a given method first it has to getlock of that object. Once thread got the lock then it is allowed to execute any synchronize method on that object.<br>
-Once method execution completes thread release a lock<br>
-Internally aquiring and releasing lock internally takes care by JVM and programer is not responsible for this.<br>
-A thread executing synchronised method on a given object the remaining thread are not allowed to execute any synchronised method simultaneously on a same thread. But remaining threads are allowed to execute non synchronised method simultaneously<br>
-Lock concept is implemented based on object not based on method
