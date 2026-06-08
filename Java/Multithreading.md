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

**Difference b/w t.start() and t.run()**
