/**
Given two strings, write a method to decide if one is a permutation of the other
*/
def checkAnagram(str1, str2):
    str1_dict = {}
    
    if(len(str1) != len(str2)):    # comparing the length of the string
        print "Not a Permutation"
      
    else:
        for i in str1:            # storing str1 characters in dictionary
            if str1_dict.has_key(i):
                str1_dict[i] = str1_dict[i] + 1
            else:
                str1_dict[i] = 1
                  
        for i in str2:          # compare string2 with elements in dictionary(string1)
            if i in str1_dict:
                str1_dict[i] -= 1
                if str1_dict[i] == 0:
                  str1_dict.pop(i)
    return str1_dict

dict = checkAnagram(str1,str2)
if dict=={}:                    # checks if the dictionary is empty
    print "Permutation of the other string"
else:
    print "Not a permutation"

      
Input: str1 = "eat" str2 = "ate" Output: Permutation of the other string
Input: str1 = "sit" str2 = "set" Output: Not a permutation
Input: str1 = "sit" str2 = "sets" Output: Not a permutation
