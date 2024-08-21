package array01

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 *
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 *
 * Find and return the maximum profit you can achieve.
 */
object StockBuySell2 {
//Input: prices = [7,1,5,3,6,4]
    fun makeProfit(nums: IntArray): Int{
        var min = Int.MAX_VALUE
        var totalProfit = 0
        var maxProfit = 0
        for (i in nums.indices){
            if(nums[i] < min){ // buying stock
                min = nums[i]
            }
            else if(maxProfit < nums[i] -min) { //selling stock
                maxProfit = nums[i] - min
                totalProfit += maxProfit
                maxProfit = 0
                min = nums[i]
            }
        }
        return totalProfit
    }
}