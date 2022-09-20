import scala.io.StdIn.readLine

/*
    cerner_2tothe5th_2022
    cerner_2^5th_2022

    Day 6 submission is in Scala. First time with scala as well so tried out a Leetcode problem for this. This is Leetcode problem #1480.
    To Run on Leetcode, remove the main method.
*/
object RunningSum {

    // Kickstart recursion
    def runningSum(nums: Array[Int]): Array[Int] = {
        if (nums.length == 1) return nums;
        return calculateRunningSum(nums, new Array[Int](nums.length), 0);
    }

    // Recur until the final array of sums is calculated
    def calculateRunningSum (nums:Array[Int], sums:Array[Int], index:Int ): Array[Int]= {
        if (index == nums.length-1) {
            sums(index) = calculateSum(nums, index);
            return sums;
        }
      
        sums(index) = calculateSum(nums, index);
        return calculateRunningSum(nums, sums, (index+1));
    }

    // find the sum of the given array up until a given point.
    def calculateSum(nums:Array[Int], maxPoint:Int ): Int= {
        var sum = 0;
        var x = 0;
        for (x <- 0 to maxPoint) {
            sum = sum + nums(x);
        }
        return sum;
    }

    def main(args: Array[String]): Unit = {
        println("\nProgram that will take your input array and calculate the sum of all the values up until the current index." +
            "\nExamples: \n\tinput={1,1,1,1} output={1,2,3,4}\n\tinput={5,10,5,30} output={5,15,20,50}\n\tinput={1} output={1}");
        while (true) {
            print("Enter values as a comma separated list(Ex. 1,2,3,4): ");
            var input = readLine().split(",").map(_.toInt);
            println(runningSum(input).mkString(", "));
        }
    }
}