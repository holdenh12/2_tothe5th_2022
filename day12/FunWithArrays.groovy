/* 
    cerner_2tothe5th_2022
    cerner_2^5th_2022

    Day 12: First time with Groovy, seems like a maybe a more intuitive Java? It's syntax and styling seems like 
        they would be very easy to pick up. May need to do some more coding with Groovy!

    Online compiler: https://www.tutorialspoint.com/execute_groovy_online.php
 */

class FunWithArrays {
    void dotEach(List list) {
        list.each {
            print("$it ")
        }
        println("")
    }
    void itemInArray(List list) {
        for (item in list) {
            print("$item ")
        }
    }
    static void main(String[] args) {
        def nums1 = [1,2,3]
                    println('Testing some looping in groovy\n')
                    println('\nList.each Method')
                    dotEach(nums1)
                    println('\nFor item in Method')
                    itemInArray(nums1)
    }
}