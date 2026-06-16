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

Ques :- What If Business Does Not Want to Reject Requests?<br>
Instead of returning HTTP 429, place excess requests in a queue.

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
