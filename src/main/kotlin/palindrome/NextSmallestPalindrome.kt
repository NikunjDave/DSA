package palindrome

import java.lang.StringBuilder

object NextSmallestPalindrome {

    fun findNextSmallestPalindrome(number: String): String {
        val mid = number.length / 2
        val isEven = number.length % 2 == 0
        if(number.toInt() < 1)
            return "0"
        // handle power of 10, like 100,1000, should be 99,999
        if(number.toInt() > 9 && number.toInt() % 10 == 0){
            return (number.toInt() - 1).toString()
        }
        if (number.count { ch -> ch == '9' } == number.length) {
            val numOfZero = number.length - 1
            //val zeros = String('0',numOfZero)
            val sb = StringBuilder()
            for (i in 0..<numOfZero) {
                sb.append("0")
            }
            return StringBuilder().append("1", sb, "1").toString()
        }

        if (isEven) { //1004
            val leftHalf = number.substring(0, mid)
            val rightHalf = number.substring(mid)
            val revLeftHalf = leftHalf.reversed()
            if (revLeftHalf > rightHalf) {
                return leftHalf + revLeftHalf
            } else {
                val left = leftHalf.toInt() + 1
                return left.toString() + left.toString().reversed()
            }
        } else { // Handle odd case
            // if first half reverse is greater
            // than second half
            var leftHalf = number.substring(0, mid)
            val center = number.substring(mid, mid + 1)
            val rightHalf = number.substring(mid + 1)
            if (leftHalf.reversed() > rightHalf) {
                return leftHalf + center + leftHalf.reversed()
            } else {
                // increase left half with middle
                val left = ((leftHalf + center).toInt() + 1).toString()
                return left + left.substring(0, mid).reversed()
            }
        }
    }


    fun findClosestPalindrome(input: String) : String{
        val mid = input.length / 2
        val isEven = input.length % 2 == 0
        if(input.toInt() < 1)
            return "0"
        // handle power of 10, like 100,1000, should be 99,999
        if(input.toInt() > 9 && input.toInt() % 10 == 0){
            return (input.toInt() - 1).toString()
        }
        if (isEven) {
            val leftHalf = input.substring(0, mid)
            val pal1 = leftHalf + leftHalf.reversed()
            // if lower palindrome is found, increase by 1 or -1
            val offset = if (pal1 < input) 1 else -1
            val left2 = (leftHalf.toInt() + offset).toString()
            val pal2 = left2 + left2.reversed()
            if (Math.abs(pal1.toInt() - input.toInt()) < Math.abs(pal2.toInt() - input.toInt()))
                return pal1//println(pal1)
            else
                return pal2
        } else {
            var leftHalf = input.substring(0, mid)
            val center = input.substring(mid, mid + 1)
            // same find pal 1
            val pal1 = leftHalf + center + leftHalf.reversed()
            val offset = if (pal1 < input) 1 else -1
            //update offset in first half
            val left2 = (leftHalf + center).toInt() + offset
            val pal2 = left2.toString() + left2.toString().substring(0, mid).reversed()
            if (Math.abs(pal1.toInt() - input.toInt()) < Math.abs(pal2.toInt() - input.toInt()))
                return pal1
             else
                 return pal1
        }

    }

    //123 -> 131
    // 12 -> 22
    //1223 -> 2121
    //1004 ->
    fun findNextSmallestPalindrome2(number: String): String {
        val mid = number.length/2
        val isEven = number.length % 2 == 0

        if(isEven){
            var leftHalf = number.substring(0,mid)
            val rightHalf = number.substring(mid)
            if(leftHalf.reversed() > rightHalf){
                return leftHalf + leftHalf.reversed()
            }else{
                // increase left half by 1
                leftHalf = (leftHalf.toInt() + 1).toString()
                return leftHalf + leftHalf.reversed()
            }
        }else{
            val center = number.substring(mid, mid+1)
            var leftHalf = number.substring(0,mid)
            var rightHalf = number.substring(mid+1)
            if(leftHalf.reversed() > rightHalf){
                return leftHalf + center +rightHalf
            }else{
                // increase by 1
                var leftHalf = ((leftHalf + center).toInt() + 1).toString()
                val firstHalf  = leftHalf.substring(0,mid)
                return firstHalf+leftHalf.substring(mid,mid+1)+firstHalf.reversed()
            }
        }

    }
}