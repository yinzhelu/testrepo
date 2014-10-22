import sys

def largest(list):
    if len(list) == 0:
        raise ValueError("Cannot call largest on empty list")
    max = -sys.maxint # "smallest" possible int
    #max = 0
    for index in range(len(list)):
        if (list[index] > max):
            max = list[index]
    return max

def smallest(list):
    if len(list) == 0:
        raise ValueError("Cannot call smallest on empty list")
    min = sys.maxint
    for index in range(len(list)):
        if (list[index] < min):
            min = list[index]
    return min
