package hashmap

/**
 * Problem statement
 *  For the given stream of message requests and their timestamps as input,
 *  you must implement a logger rate limiter system that decides whether the current message request is displayed.
 *  The decision depends on whether the same message has already been displayed in the last
 *  seconds. If yes, then the decision is FALSE, as this message is considered a duplicate. Otherwise, the decision is TRUE.
 *
 */
class RateLimiter(val timelimit : Int) {
    val hashMap = HashMap<String,Int>()
    fun messageRequestDecision(timestamp:Int,request : String) : Boolean {
        // enter message to hashmap if not present
        if(!hashMap.containsKey(request)){
            hashMap[request] = timestamp
            return true
        }else {
            // in case if key already exist, check time of that request with time limit
            val requestTime = hashMap[request]
            if(timestamp - requestTime!! >= timelimit){
                hashMap[request] = timestamp
                return true
            }
        }
       return false
    }
}


fun main(){

    val times = intArrayOf(1,5,6,7,15)
    val messages = arrayOf("good morning",
        "hello world",
        "good morning",
        "good morning",
        "hello world")

    val rateLimiter = RateLimiter(7)
    for(i in messages.indices){
        print(i + 1);
        println(".\tTime, message: {" + times[i] + ", '" + messages[i] + "'}");
        println("\tMessage request decision: " + rateLimiter.messageRequestDecision(times[i], messages[i]));
        repeat(100){ print("-") }
        println()
    }

}