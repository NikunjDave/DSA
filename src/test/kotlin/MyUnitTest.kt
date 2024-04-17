import array01.*
import array02.*
import data.createTree
import hashmap.RansomNote
import hashmap.ValidAnagram
import hashmap.WordPattern
import matrices.RotateMatrices
import matrices.RowColZero
import matrices.SpiralMatrices
import stack.Calculator
import stack.RemoveDuplicates
import stack.RemoveParenthesis
import stack.StackQueue
import threading.TestMultiThreading
import tree.InorderTraversal
import tree.PostOderTraversal
import tree.PreOderTraversal
import linkedlist.LruCache
import matrices.Sudoku
import org.junit.jupiter.api.Test
import palindrome.NextSmallestPalindrome
import puzzles.PeopleInCircleSword
import string01.*
import threading.ProducerConsumerMain
import threading.TestEvenOddPrint
import twopointer.*
import kotlin.test.assertEquals

class MyUnitTest {
@Test
fun testDuplicateString(){
    val output = RemoveDuplicates().removeDuplicates("abbdde".toCharArray())
    println("output is "+output)
}
    @Test
    fun test_stack_queue(){
        val stackQueue = StackQueue()
        stackQueue.push(1)
        stackQueue.peek()
        stackQueue.push(2)
        stackQueue.push(3)
        stackQueue.push(4)
        stackQueue.push(5)

        // the output should be 1,2,3
        val stringBuilder = StringBuilder()
        while (!stackQueue.isEmpty()){
            stringBuilder.append(stackQueue.pop())
        }
        println(stringBuilder.toString())

    }

    @Test
    fun  rotateMatrices(){
        val input = RotateMatrices.getMatrices(3)
        println("input is "+RotateMatrices.printMatrices(input))
        val result = RotateMatrices.rotateMatrices(input)
        println("output is "+RotateMatrices.printMatrices(result))
    }

    @Test
    fun  testSpiralMatrices(){
        val input = RotateMatrices.getMatrices(3)
        println("input is "+RotateMatrices.printMatrices(input))
        val result = SpiralMatrices().spiralElement(input)
        println("output is "+result.joinToString())
    }

    @Test
    fun remove_invalid_parenthesis(){
        val result = RemoveParenthesis().minRemoveParenthesis("abc)dd(edf)((")
        println("output is $result")
    }

    @Test
    fun calculate_expression(){
        val result = Calculator().calculateExpression("26+(4-5)+9")
        println("output is $result")
    }

    @Test
    fun two_sum(){
        val result = TwoSum().twoSumInUnsorted(intArrayOf(3,2,4),6)
        println("output is ${result?.joinToString(",")}")
    }

    @Test
    fun tree_inorder_traversal(){
        val list = InorderTraversal().inorderTraversal(createTree())
        println("in-order traversal is ${list.joinToString(" ") }")
    }

    @Test
    fun tree_preOrder_traversal(){
        val list = PreOderTraversal().preOrderStart(createTree())
       println("pre-order traversal is ${list.joinToString(" ") }")
    }

    @Test
    fun tree_postOrder_traversal(){
        val list = PostOderTraversal().postOrderTraversal(createTree())
        println("pre-order traversal is ${list.joinToString(" ") }")
    }

    @Test
    fun test_multi_threading(){
        val test = TestMultiThreading().printNumber()
    }

    @Test
    fun test_multi_stock(){
        val stocks = intArrayOf(7,1,5,3,6,4)
        val output = StockBuySell().getMaxProfit(stocks)
        println("max profit is $output")
        assertEquals(output,5)
    }

    @Test
    fun test_matrices_zero(){
        val input = arrayOf(intArrayOf(0,2,3),intArrayOf(4,5,0),intArrayOf(7,8,9))
        val output = RowColZero().turnZeroIfAny2(input)
        RotateMatrices.printMatrices(output)
    }

    @Test
    fun test_remove_k_element(){
        val output = RemoveElement().removeElement(intArrayOf(0,1,2,2,3,0,4,2),2)
        println("output is ${output.joinToString()}")
    }

    @Test
    fun remove_duplicate_from_sorted_array(){
        val output = RemoveDuplicateFromSortedArray().removeDuplicate(intArrayOf(1,1,2))
        println(output.joinToString())
    }

    @Test
    fun remove_duplicate_from_sorted_array_up_to_two(){
        val output = RemoveDuplicateFromSortedArray().removeDuplicateTwice(intArrayOf(1,1,1,2,2,3))
        println(output.joinToString())
    }

    @Test
    fun find_majority_element_from_array(){
        val output = MajorityElement.findMajorityElement(intArrayOf(1,2,3,2,2))
        println("Majority element is $output")
    }

    @Test
    fun find_first_non_repeating_char(){
        val output = NonRepeatingChar().firstUniqueCharSecond("asdasd")
        println("non repeating is $output")
    }

    @Test
    fun find_sub_array_sum(){
        val output = SubArraySum.findSubArrayOfGivenSumEffective(intArrayOf(1,2,3,1,1,4),6)
        output.forEach {
            println("${it.first},${it.second}")
        }
    }

    @Test
    fun findNextPalindrome(){
        val input  = "9"
        val next = NextSmallestPalindrome.findNextSmallestPalindrome2(input)
        println("next palindrome of $input is $next")
    }

    @Test
    fun lruCache(){
        val lruCache = LruCache(2)
        lruCache.put(1,10)
        lruCache.put(2,12)
        lruCache.put(3,20)
        val value = lruCache.get(1)
        println(value)
    }

    @Test
    fun sudoku(){
        val isValid = Sudoku.isValidSudoku(Sudoku.buildSudoku())
        println("isValid sudoku "+isValid)
    }

    @Test
    fun testRotateArray(){
        val output = RotateArray.rotate2(intArrayOf(1,2,3,4,5,6),3)
        println("output is ${output.joinToString() }")
    }

    @Test
    fun maxProfit2(){
        val max = StockBuySell2.makeProfit(intArrayOf(7,6,4,3,1))
        println(max)
    }

    @Test
    fun jumpGame(){
        //val canReach = JumpGame.canReachLast(intArrayOf(2,0))
        val canReach = JumpGame.canReachLast(intArrayOf(2,3,1,1,4))
        println("can reach $canReach")
    }

    @Test
    fun jumpGame2(){
        val step = JumpGame2.findMinJum(intArrayOf(2,3,0,1,4))
        println("step taken are $step")
    }

    @Test
    fun test_producer_consumer(){
        ProducerConsumerMain().testMultiThread()
    }

    @Test
    fun convert_roman_int(){
        val intNum = RomanToInteger.convertToRomanToInt("MCMXCIV")
        println("number is $intNum")
    }

    @Test
    fun convert_int_roman(){
        val roman = IntegerToRoman.intToRoman(20)
        println("number is $roman")
    }

    @Test
    fun length_of_last_word(){
        val length = LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  ")
        println("length is $length")
    }

    @Test
    fun find_common_longest_prefix(){
        val prefix = LongestCommonPrefix.findCommonPrefix2(arrayOf("flower","flower"))
        println("prefix is $prefix")
    }

    @Test
    fun find_first_index_of_word(){
        val index = IndexOfFirstOccurrence.findFirstOccurrence("mississippi","issip")
        println("index is $index")
    }

    @Test
    fun test_string_palindrome(){
        val isPalindrome = Palindrome().isPalindrome2("0P")
        println("palindrom : $isPalindrome")
    }

    @Test
    fun test_is_sub_sequence(){
        val isSubSequence = SubSequence.isSubsequence("","")
        println("is subsequence : $isSubSequence")
    }

    @Test
    fun test_vowel_present(){
        val vowels = VowelString.findVowel("ias","dsfsdiaas")
        println("vowel is : $vowels")
    }

    @Test
    fun test_ransom_note(){
        val ransom = RansomNote.canConstruct("aa","ab")
        println("can construct $ransom")
    }
    @Test
    fun test_word_pattern(){
        val isMatching = WordPattern.wordPattern("abba","dog dog dog dog")
        println("is matching $isMatching")
    }
    @Test
    fun test_is_anagram(){
        val isAnagram = ValidAnagram.isAnagram("rat","cat")
        println("is valid anagram $isAnagram")
    }

    @Test
    fun test_lru_cache(){
        val lruCache = LruCache(2)
        lruCache.put(2,1)
        lruCache.put(1,1)
        lruCache.put(2,3)
        lruCache.put(4,1)
        val out1 = lruCache.get(1)
        val out2 = lruCache.get(2)
        println("$out1 $out2")
    }

    @Test
    fun test_h_index(){
        val citation = HIndex.findHIndex(intArrayOf(11,15))
        println("output is $citation")
    }

    @Test
    fun test_product_array_self(){
        val result = ProductOfArray.productExceptSelf(intArrayOf(1,2,3,4))
        println("output is ${result.joinToString()}")
    }

    @Test
    fun test_swap_even_to_start(){
        val result = EvenOddArray.separateEvenOdd(intArrayOf(13,10,21,20))
        println("output is ${result.joinToString()}")
    }

    @Test
    fun test_reverse_words(){
        val result = ReverseWord.reverseWords("a good   example")
        println("output is $result")
    }

    @Test
    fun test_container_with_most_water(){
       // val result = ContainerWithWater.maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
        val result = ContainerWithWater.maxArea(intArrayOf(1,1))
        println("area is $result")
    }

    @Test
    fun odd_even_print(){
        //TestMultiThreading().printNumber()
       TestEvenOddPrint().startPrinting()
    }

    @Test
    fun test_rotate_matrix(){
        val result = RotateMatrices.rotateMatrices(arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6),intArrayOf(7,8,9)))
        result.forEach {
            print(it.joinToString( ))
            println()
        }

    }

    @Test
    fun test_num_of_person_left(){
        val left = PeopleInCircleSword.findLastPersonLeft(5)
        println(left)
    }

    @Test
    fun gas_station_problem(){
        val startIndex = GasStation.canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3))
        println("start index is $startIndex")
    }

    @Test
    fun convert_phone_number(){
        val phoneNumber = FormatNumber.convertToPhoneNumber("1.800.GOT.JUNK ")
        println("output is $phoneNumber")
    }

    @Test
    fun test_min_platform(){
       // val platfrom = MinimumPlatform()
    }
}