//  cerner_2tothe5th_2022
//  cerner_2^5th_2022
//
//  Day 10 : First time writing some rust code. Poking around with the syntax seemed intuitive so I decided to try a Leetcode problem with it.
//              This submission can be used as a solution to Problem #392 - Is Subsequence
//
//      Problem Statement: 
//             Given two strings s and t, return true if s is a subsequence of t, or false otherwise.A subsequence of a string is a new string that is formed
//             from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
//             (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


pub fn is_subsequence(s: String, t: String) -> bool {
    let mut index = 0;
    let mut counter = 0;
    
    while index < t.len() && counter < s.len() {
        if s.chars().nth(counter) == t.chars().nth(index) {
            counter = counter + 1;
        }
        index = index + 1;
    }

    return counter == s.len();
}

fn main() {
    let s = "abc";
    let t = "ahbgdc";
    let result = is_subsequence(s.to_owned(), t.to_owned());
    println!("{}", result);
}