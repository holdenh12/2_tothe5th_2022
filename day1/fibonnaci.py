# cerner_2tothe5th_2022
# 
# Day 1

# Return the Fibonnaci term at the given index
def fibAtIndex(i):
    # Base case, retun index for 1.
    if (i <= 1) :
        return i    
    else :
        return fibAtIndex(i-1) + fibAtIndex(i-2)

# Return the Fibonnaci sequence of a given length
def getFibonnaciSequence(fibTerms):
    for i in range(fibTerms+1) :
        # skip 0 index
        if (i == 0) : continue
        print('{}{}'.format(i, "."), fibAtIndex(i))

# Take in user input
selectedNumTerms = int(input("\nHow many terms of the Fibonnaci sequence would you like to see now? "))

print("Just kidding, that could get crazy! In honor of programming day, and the 2^5 competition, here are the first 32 terms of the Fibonnaci Sequence:")
thirtyTwoTerms = pow(2,5)
getFibonnaciSequence(thirtyTwoTerms)