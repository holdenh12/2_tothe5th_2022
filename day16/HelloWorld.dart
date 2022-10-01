import 'dart:math';
/* 
    cerner_2tothe5th_2022
    cerner_2^5th_2022

    Day 16: Dart submission. It is definitely a "Java" flavored language, but I like the somewhat more lightweight feel.

    Online Compiler: https://dartpad.dev/?
*/
void main(){
  for (int i = 1; i <= pow(2,5); i++) {
    print(i.toString() + ". Cerner Cares 2^5 times and more!");
  }
}