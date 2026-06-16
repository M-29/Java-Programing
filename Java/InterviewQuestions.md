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
c) **Leaky Bucket Algorithm**<br>
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
