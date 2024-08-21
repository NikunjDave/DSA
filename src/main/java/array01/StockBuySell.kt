package array01

import kotlin.math.max


/**
 * Given an n array of stock price on each day [6,7,8,9,5],
 * return the max profit can be made applying that you can buy or sell on single day
 *  for above example the max profit can be made is 3( buying at 6 and selling at 9)
 */
class StockBuySell {

    fun brutForceBuySell(stocks : IntArray) : Int{
        var maxProfit = 0
        for(i in stocks.indices){
            for (j in i+1 until stocks.size){
                if(stocks[j]-stocks[i] > maxProfit){
                    maxProfit = stocks[j] - stocks[i]
                }
            }
        }
        return maxProfit
    }


    fun getMaxProfit(stocks : IntArray) : Int{
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0
        for (i in stocks.indices){
            if(stocks[i] < minPrice){
             minPrice = stocks[i]
            } else if( (stocks[i] - minPrice) > maxProfit){
                maxProfit = stocks[i]-minPrice
            }
        }
        return maxProfit
    }


    fun getMaxProfit2(prices : IntArray){
        for (i in prices){


        }
    }
}