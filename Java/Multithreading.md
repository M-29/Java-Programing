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
- Once method execution completes thread release a lock<br>
- Internally aquiring and releasing lock internally takes care by JVM and programer is not responsible for this.<br>
- A thread executing synchronised method on a given object the remaining thread are not allowed to execute any synchronised method simultaneously on a same thread. But remaining threads are allowed to execute non synchronised method simultaneously<br>
- Lock concept is implemented based on object not based on method
##### Java Object<br>
Have two parts :- <br>
a) **Non-Synchronised Area** :- This area can be accessed by multiple thread simultaneously eg:- Read operations<br>
b) **Synchronised Area** :- This area can be accessed by one thread at a time eg:- All update, write delete operations we can perform here
**Case Studies**
Even though which method is synchronise we will get irregular output because threads are operating on different java object.
If multiple thread are operating on same java object then synchronization is required.<br>
If multiple threads are operating on different java object then synchronization is not required.<br>
### Class Level Lock<br>
Every class in java has a unique lock which is nothing but class level lock. If a thread wants to execute a static synchronize method then thread require class level lock. Once a class got a lock then it is allowed to execute any static synchronize method of class.<br>
### Synchronized block<br>
If very few lines of code required synchronization then it is not recommended to declare method as synchronized we have to enclose those few lines of code by using synchronised block.
**We can declare synchronised block as follow**<br>
```Java
Synchronised(this){
  //This is used to get a lock of current object then only this is allowed to execute this area
}
Synchronised(obj){
  //This is used to get a lock of particular object then only this is allowed to execute this area
}
Synchronised(Display.class){
  //This is used to get a class level lock then only this is allowed to execute this area
}
```
- Synchronised keyword is not used for primitive vaue
#### Race Condition<br>
If multiple threads are operating simultaneously on same java object then there may be chance for data inconsistency problem this is called race condition. We can overcome this problem by synchronised keyword.<br>

###### Is a thread can acquire multiple locks?<br>
Yes a thread can acquire multiple lock from different object<br>
###### What is synchronised statement?
A statements present in synchronised method or synchronised block is called synchronised statement.

### Inter Thread Commmunication<br>
Two thread can communicate with each other by using wait(), notify() and notifyAll().<br>
**wait():-** The thread which is expecting updation is responsible to call wait() then immediately thread will enter into waiting state.<br>
**notify():-** Thread which is responsible to perform updation after performing updation it is responsible to call notify().<br>
**notifyAll():** Then waiting thread will get notification and continue its execution with those updated items <br>
- These methods are present in object class but not in thread class because thread can call these methods on any java object <br>
- To  call wait(), notify(), and notifyAll() methods on any object, thread should be owner of that object i.e thread should has lock of that object i.e., thread should be in synchronised area. Hence these methods are only called from synchronised area. otherwise will get IllegalMonitor state exception.<br>
- If a thread calls wait() method on any object it immediately releases the lock of that particular object and entered into waiting state.<br>
- If a thread call notify() method on any object it may or may not immediately releases the lock of the particular object and entered into waiting state. <br>
#### Producer and Consumer Problem<br>
Producer thread is responsible to produce item to the queue and consumer thread is responsible to consume item from the queue. If a queue is empty the consumer thread will call wait method and enter into the waiting state. After producing items to the queue producer thread is responsible to call notify method then waiting consumer will get the notification and continue its executuion with updated items.<br>
##### Difference b/w notify() and notifyAll()<br>
- We can use notify() to give notification for only one waiting thread if multiple threads are waiting then only one threads will be notify and the remaining thread have to wait for further notification. Which thread will be notify it depends on JVM.<br>
 - We can use notifyAll() to give notification for all waiting thread of a particular object. Even though multiple thread will be notify but execution will be perform one by one because every thread require a lock.<br>
- On which method we are calling the wait() method thread required the lock of particular method. If we are calling wait method on s1 then we have to get lock of s1 object but not s2 method.<br>
```Java
synchronized(s1){
  s2.wait();  // It will through RuntimeException IllegalMonitorStateException
}
synchronized(s1){
  s1.wait();  
}
```
##### Problems with synchronise keyword<br>
Synchronise keyword is only reason for deadlock situation hence while using synchronise keyword we have to take special care. There is no resolution techique for deadlock but several prevention technique are available.<br>
#### Deadlock v/s Starvation<br>
Deadlock:- A long waiting of thread where waiting never ends this type of situation is called deadlock.<br>
Starvation:- A long of thread where waiting ends at certain point this type of situation is called starvation.<br>

##### Daemon Thread <br>
- The threads which are executing in the background are called daemon thread eg:- Garbage collector, signal dispatcher etc;<br>
- The main objective for daemon thread is to provide support non daemon thread(Main thread). Eg,. If main thread runs with low memory then JVM run garbage collector to destroy useless object so that number of free memory will be improved with this free memory main thread can continue execution.<br>
- Usually daemon threads have kow priority but based on our requirement daemon thread can run on high priority.<br>
- We can check daemon nature of a thread by using isDaemon() of thread class. 
```Java
public boolean isDaemon();
public void setDaemon(boolean b);
```
- But changing daemon nature is possible before starting of a thread only. But after starting if you are trying to change the nature you will get runtime exception IllegalThreadException.<br>
- By default main thread is always is non-daemon and for all remaing thread daemon nature is inherited from parent to child i.e., If parent class is daemon then automatically child class is also non-daemon.<br>
- It is impossible to change daemon nature of main thread because it is already started by JVM at the begining<br>
- Whenever last non daemon thread will be terminates automatically all daemon threads will be terminated irrespective of their position.<br>

#### Two models to implement multithreading in Java<br>
a) Green Thread Model :- Thread which is managed completely by JVM without taking underline OS support is called Green thread. It is depricated and not recommended to use.<br>
b) Native OS Model :- The thread which is managed by JVM with the help of underline OS, is called native OS Model. All windows based OS provide support for native os model.<br> 

## Thread Group<br>
