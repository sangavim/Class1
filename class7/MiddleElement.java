/**
   Find Middle Element in the linkedlist in O(n) by navigating the linked list only once.
*/
class Node:
    def __init__(self,value,next=None):
        self.value=value
        self.next=next

def createList(listValues):
    linkedList=None
    next=None
    for x in listValues:
        linkedList=Node(x,next)
        next=linkedList
    print_list(linkedList)
    return linkedList

def findMidElement(linkedList):
    mid=linkedList
    cur=linkedList
    skip=True
    while (cur.next is not None):
        if (not skip):
                mid=mid.next
        cur=cur.next
        skip = not skip
    return mid.value

listValues=['a','b','c','d','e']
linkedList=createList(listValues)
print("\nMiddle Element: "+ findMidElement(linkedList))
                   
Output:
Middle Element: c
