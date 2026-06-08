#### MultiTasking
Executing several task simultaneously is known as multitasking.
Types of multitasking
a) Process based multitasking : Executing several task simultaneously where each task is a seperate independent program
eg Typing a java program, Downloading a file, Listening a music are eg of process based multi tasking because each task is seperate independent process 
- It is best suite for OS level
b) Thread based multitasking
Executing several task simultaneously where each task is a seperate independent part of a same program this type of multitasking is called thread based multitasking Each independent part is called thread
-It is best suite for programatic level
Main objective of multitasking is to reduce response time of a system and improve performance

###### Thread 
A thread is a flow of execution is known as thread. 
For every thread a seperate independent job is their.
we can define a thread in two ways:-
a)By extending thread class
b)By implementing runnable interface

Thread Scheduler :- is responsible to schedule the threads i.e.; if multiple threads are waiting for execution then in which order threads will execute is decided by the Thread Scheduler.
-It is a part of JVM
-we can excpect thread execution order and exact output hence it is varried from JVM to JVM 

** Difference b/w t.start() and t.run() **
