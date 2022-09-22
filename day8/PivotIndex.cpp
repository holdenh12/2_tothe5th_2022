#include <bits/stdc++.h>
#include <iostream>
#include <numeric>
#include <vector>
/*
    cerner_2tothe5th_2022
    cerner_2^5th_2022

    Day 8 : Decided to write some c plus plus for this one just to touch base with the roots! This program can be used as a (non-elegant) solution to the
            LeetCode problem #724 : Find Pivot Index
            
        Problem Statement:
            Given an array of integers nums, calculate the pivot index of this array.The pivot index is the index where the sum of all the numbers strictly to
            the left of the index is equal to the sum of all the numbers strictly to the index's right.If the index is on the left edge of the array, then the
            left sum is 0 because there are no elements to the left. This also applies to the right edge of the array. Return the leftmost pivot index. 
            If no such index exists, return -1.

            Examples:
                Input: nums = [1,7,3,6,5,6]
                Output: 3
                Explanation:
                The pivot index is 3.
                Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
                Right sum = nums[4] + nums[5] = 5 + 6 = 11

                Input: nums = [1,2,3]
                Output: -1
                Explanation:
                There is no index that satisfies the conditions in the problem statement.

                Input: nums = [2,1,-1]
                Output: 0
                Explanation:
                The pivot index is 0.
                Left sum = 0 (no elements to the left of index 0)
                Right sum = nums[1] + nums[2] = 1 + -1 = 0
*/
using namespace std;
int pivotIndex(vector<int>& nums) {
    for (int i = 0; i <= nums.size()-1; i++) {
        int lSum = (i == 0 ) ? 0 : accumulate(nums.begin(), (nums.begin() + (i)), 0);
        int rSum = accumulate(nums.rbegin(), (nums.rbegin() + (nums.size()-1-i)), 0);
        if (lSum == rSum) {
            return i;
        }
    }
    return -1;
}
vector<int> parseInput(string values) {
    stringstream ss(values); vector<int> toReturn;
    for (int i; ss >> i;) {
        toReturn.push_back(i);
        if (ss.peek() == ',')
            ss.ignore();
    }
    return toReturn;
}
int main() {
    vector<int>parseInput(string); vector<int> testCase; string input;
    cout<<"The program will return the ZERO BASED INDEX of the array that has a balanced left and right sum(calculated from array.start to index-1, and from index + 1 to array.end).\n-1 is returned on no solution.\nPlease enter a comma separated array: "; cin >> input;
    testCase = parseInput(input);
    cout << pivotIndex(testCase) << endl;
    return 0;
}