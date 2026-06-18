**1. if a an application have a rate limit of 40 requests but 100 requests are coming how it will handle in java**<br>
**Ans :-** Some strategies are :- <br>
a) **Reject Extra Requests**<br>
- Allowed: 40 requests<br>
- Rejected: 60 requests<br>
The rejected requests usually receive:<br>
- HTTP Status: 429 Too Many Requests
- Optional header: Retry-After indicating when to retry.
b) **Queue the Extra Requests**<br>
- Instead of rejecting them immediately, the application can place the excess requests into a queue.<br>
- If the queue becomes full, additional requests may still be rejected.<br>
c) **Token Bucket Algorithm**<br>
- A bucket holds tokens.<br>
- Tokens are added to the bucket at a constant rate (e.g., 10 tokens/second).<br>
- The bucket has a maximum capacity.<br>
- To send a packet or process a request, a token must be removed from the bucket.<br>
- If enough tokens are available, the request is allowed.<br>
- If not, the request is delayed or rejected.<br>
d) **Leaky Bucket Algorithm**<br>
- Water (incoming requests) is poured into the bucket.<br>
- Water leaks out at a constant speed.<br>
- If water enters faster than it leaks and the bucket becomes full, the extra water overflows and is discarded.<br>
**Suppose**<br>
- Bucket capacity = 10 requests.<br>
- Leak rate = 2 requests/second.<br>
- If 15 requests arrive at the same time:<br>
- The first 10 requests are stored in the bucket.<br>
- The remaining 5 requests are rejected because the bucket is full.<br>
- The stored requests are processed at a steady rate of 2 per second.<br>
e) **Fixed Window Rate Limiting**<br>
The Fixed Window Algorithm is one of the simplest rate-limiting strategies. It divides time into fixed intervals (windows) and counts how many requests arrive in each window.<br>
If the count exceeds the configured limit, additional requests are rejected until the next window starts.<br>
**Problem with Fixed Window**<br>
The boundary burst problem occurs in the Fixed Window algorithm because the request counter resets at the start of each window. A client can send the maximum allowed requests just before the window ends and then immediately send the maximum again after the reset. For example, with a limit of 100 requests per minute, 100 requests at 12:00:59 and another 100 at 12:01:00 result in 200 requests in about two seconds, creating a traffic spike despite technically staying within each fixed window.<br>
**Eg:** Think of a movie theater that allows 100 people per hour.<br>
- At 2:59 PM, 100 people enter.<br>
- At 3:00 PM, the counter resets and another 100 people enter immediately.<br>
Now 200 people are inside almost at the same time, creating congestion even though each hourly window respected its limit.<br>
f) **Sliding Window**<br>
A Sliding Window rate limiter tracks requests over a rolling time period rather than fixed intervals. For example, with a limit of 100 requests per minute, every incoming request is checked against the previous 60 seconds of activity. This avoids the boundary burst problem seen in Fixed Window algorithms and provides fairer, more accurate rate limiting, at the cost of maintaining recent request history.<br>

#### API Gateway-Level Rate Limiting<br>
            100 Requests.<br>
                     |
                     v
          +----------------------+
          |     API Gateway      |
          | Rate Limit: 40/sec   |
          +----------------------+
              |              |
         40 Allowed      60 Rejected
              |
              v
         Spring Boot Services

Advantages:<br>
Backend services receive only valid traffic.<br>
Centralized configuration.<br>
Easier monitoring and management.<br>
Reduces unnecessary resource usage.<br>

**Ques :- What If Business Does Not Want to Reject Requests**?<br>
Instead of returning HTTP 429, place excess requests in a queue.
```Java

             100 Requests
                   |
                   v
            API Gateway
                   |
        +----------+----------+
        |                     |
   40 Processed         60 Queued
                              |
                              v
                    Kafka / RabbitMQ
                              |
                              v
                      Worker Processes
```
This is suitable for asynchronous operations such as:<br>
1. Email sending<br>
2. Report generation<br>
3. Notification delivery<br>
4. Background data processing<br>
For real-time APIs, immediate rejection with HTTP 429 is usually preferred.<br>

**Ques: How would you implement rate limiting in Spring Boot**?<br>
Possible approaches:<br>
- Bucket4j<br>
- Resilience4j<br>
- API Gateway filters<br>
- Redis-backed custom implementation<br>
**Ques: why local rate limiting fails in distributed systems**<br>
Local rate limiting means each application instance enforces its own independent limit. If I have three instances with a limit of 40 requests per second each, the system can accept up to 120 requests per second. If the business requires a global limit of 40 requests per second across all instances, local counters are insufficient because they don't share state. In that case, I use a shared store like Redis or enforce the limit at the API Gateway so all instances coordinate using the same counter or token bucket.<br>
#### Load Balancer<br>
A load balancer distribute incoming request across multiple application instance to improve scalability, availability and fault tolerance. In a Spring Boot microservices environment, a load balancer sits in front of multiple service instances so the system can handle higher traffic and continue operating even if one instance becomes unavailable.<br>
**Common Load Balancer Algorithms**<br>
1) **Round Robin**<br>
Requests are distributed one after another.<br>
Request 1 -> Server A<br> Request 2 -> Server B<br> Request 3 -> Server C<br> Request 4 -> Server A<br> Request 5 -> Server B<br>
2) **Least Connection**<br>
Least Connections is a load-balancing algorithm where the next incoming request is sent to the server with the fewest active connections.<br>
3) **Weighted Round Robin**<br>
More powerful servers receive more traffic.<br>
#### Spring Actuator<br>
Spring Boot Actuator is a production-ready module used to monitor and manage Spring Boot applications. It exposes endpoints such as /actuator/health, /actuator/metrics, /actuator/info, and /actuator/beans. In production, it's commonly used by load balancers and Kubernetes to perform health checks, while monitoring systems use it to collect metrics. It also supports custom HealthIndicator implementations so applications can report the status of external dependencies like payment services or messaging systems.<br>
**Ques :- if there are 4 thread doing operation on concurrenthasmap thread 1 and tread 2 is performing read and thread 3 and thread 4 performing write operation how we will manage thread safety and what is the execution process for concurrent hashmap**
Ans :-  Reads are generally lock-free.<br>
Thread-1 and Thread-2 can read simultaneously.<br>
They do not block each other.<br>
**for write:-**<br>
ConcurrentHashMap does not lock the entire map.<br>
It locks only the affected bucket/node internally.<br>
**Case 1:** Different Keys, Different Buckets<br>
Thread-3 locks Bucket 2<br>
Thread-4 locks Bucket 8<br>
Both writes happen in parallel<br>

**Case 2:** Same Bucket<br>
Thread-3 acquires Bucket 2 lock<br>
Thread-4 waits<br>
Thread-3 releases lock<br>
Thread-4 proceeds<br>

**case 3:** Read During Write<br>
Suppose:<br>
Thread-1 → get(1)<br>
Thread-3 → put(1, "A")<br>
ConcurrentHashMap uses:<br>
            volatile variables<br>
            CAS (Compare-And-Swap)<br>
            internal synchronization when required to ensure:<br>
            No corrupted data<br>
            No inconsistent state<br>
Reader may see:<br>
old value, or<br>
new value<br>
but never a partially written value.<br>

**Ques: what are checked and unchecked exception**<br>
Compile Time<br>
- Happens before execution.<br>
- Code is converted into bytecode (.class files).<br>
- Compiler checks syntax, types, and checked exceptions.<br>
- Errors found here are called compile-time errors.<br>

Runtime:-<br>
- Happens when JVM executes the program.<br>
- Runtime exceptions occur while the application is running.<br>
- Examples: NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException.<br>
**Ques: How microservices communicate with each other**?<br>
In microservice architectures, communication can be synchronous or asynchronous. For synchronous communication, I commonly use REST APIs over HTTP or gRPC when the caller needs an immediate response, such as validating a payment or fetching user details. For asynchronous communication, I use message brokers like Kafka or RabbitMQ so services can exchange events without blocking each other. In production, I often combine both approaches—for example, using REST for critical request-response operations and Kafka for notifications, analytics, or background processing. To make communication resilient, I configure timeouts, retries for transient failures, circuit breakers, and health checks, and I avoid sharing databases directly between services to keep them loosely coupled and independently deployable.<br>
**Ques: if we are doing transaction user received msg for cash debit but other user does not receive credit msg and service failed in between how do you handle this transaction**?<br>
In a money transfer system, I would avoid relying on a distributed transaction across microservices. Instead, I would implement the transfer using the Saga pattern, where each service performs its own local transaction and compensating actions are available if a later step fails. To ensure reliable communication, I would publish events through a broker such as Kafka or RabbitMQ and make consumers idempotent so retries do not create duplicate credits. I would also use the Outbox Pattern so that database updates and event publication remain consistent even if the application crashes. Finally, I would send user notifications only after the business operation reaches the appropriate state, preventing situations where a debit message is delivered even though the overall transfer has not completed successfully.<br>
**Saga Pattern**<br>
- The Saga Pattern is a way to manage distributed transactions across multiple microservices.<br>
- If one step fails, it executes compensating transactions to undo the completed work.<br>
**How Saga works**<br>
```Java
Step 1: Debit User A       ✅
Step 2: Credit User B      ❌ Failed

Compensation:
Step 3: Credit User A back ✅
```
**Two Ways to Implement Saga:-** <br>
1. Choreography (Event-Based) :-<br>
- No central coordinator. <br>
- Each service publishes events and reacts to events.<br>
```Java
Order Service
      |
      | OrderCreated
      v
Kafka
      |
      v
Inventory Service
      |
      | InventoryReserved
      v
Kafka
      |
      v
Payment Service
      |
      | PaymentCompleted
      v
Kafka
      |
      v
Shipping Service
```
2. Orchestration (Central Coordinator)<br>
A dedicated orchestrator controls the workflow.<br>
```Java
            Saga Orchestrator
                  |
      ----------------------------
      |            |             |
      v            v             v
 Order       Inventory      Payment
 Service      Service       Service
```
**Ques:- what is difference between single rollback and saga other than distributed system what is the difference did saga also do rollback ?** <br>
1. Single transaction rollback (@Transactional) → The database undoes uncommitted changes automatically.<br>
Suppose you have one database with two accounts.<br>
```Java
User A = ₹10000
User B = ₹5000

BEGIN
Debit A      ✅
Credit B     ❌
ROLLBACK
```
**@Transactional Flow**<br>
```Java
BEGIN
   |
Debit A
   |
Credit B
   |
COMMIT

The database automatically discards all uncommitted changes.
```
What happened?<br>
The database never permanently saved the debit because the transaction was not committed.<br>

2. Saga Pattern → The database does not roll back committed changes. Instead, the application performs compensating business actions to reverse the effect.<br>
Now suppose each service has its own database.<br>
```Java
Transfer Service DB
Account Service DB
Notification Service DB

Debit A         ✅
Credit B        ❌
Compensation:
Credit A back   ✅
```
**Saga Flow**<br>
```Java
Debit A  ✅ (Committed)
    |
    v
Credit B ❌
    |
    v
Compensation
    |
    v
Credit A back ✅
The original debit is not rolled back. A new transaction restores the business state.
```
**Ques what is compensating transaction?** <br>
A new business operation that reverse the business effect of the earlier step.<br>

**What are the mehods for RestTemplate**
```Java
| Method              | HTTP Method | Returns          | Typical Use                             |
| ------------------- | ----------- | ---------------- | --------------------------------------- |
| `getForObject()`    | GET         | Response body    | Fetch data                              |
| `getForEntity()`    | GET         | `ResponseEntity` | Fetch data with status and headers      |
| `postForObject()`   | POST        | Response body    | Create resource                         |
| `postForEntity()`   | POST        | `ResponseEntity` | Create resource with status and headers |
| `postForLocation()` | POST        | `URI`            | Get location of created resource        |
| `put()`             | PUT         | `void`           | Update resource                         |
| `delete()`          | DELETE      | `void`           | Delete resource                         |
| `exchange()`        | Any         | `ResponseEntity` | Full request/response control           |
| `execute()`         | Any         | Custom           | Advanced processing                     |

```
**Ques:- Map and flatMap** <br>
map() is used when each input element is transformed into a single output value. flatMap() is used when the transformation itself returns another container or stream, such as a Stream, Optional, or Mono, and you want to avoid nested structures. In Java Streams, flatMap() is commonly used to flatten nested collections. In reactive programming with Mono or Flux, it is used to chain asynchronous operations that already return reactive types. A simple way to remember it is: map() transforms, while flatMap() transforms and flattens.<br>

**Ques: Authentication v/s Authorization** <br>
Authentication verifies the identity of a user—confirming who they are, such as by checking a username and password or validating a token. Authorization determines what that authenticated user is allowed to do, based on roles or permissions. Authentication happens first; authorization is evaluated afterward to decide whether access to a resource should be granted.<br>
- 401 Unauthorized (despite the name, it generally means authentication is missing or invalid): the client has not successfully authenticated.<br>
- 403 Forbidden: the client is authenticated but does not have permission to access the requested resource.<br>
