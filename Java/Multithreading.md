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
