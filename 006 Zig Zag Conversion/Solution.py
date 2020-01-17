s = "WEHAVEADREAM"
numRows = 4
# The above two lines are only for testing

def convert():
    if numRows == 1 or numRows >= len(s):
        return s

    test = [[] for i in range(numRows)]
    row = 0
    step = 1
    for c in s:
        test[row] += c,
        if(row == 0):
            step = 1
        elif(row == numRows - 1):
            step = -1
        row += step

    result = ""
    for i in range(len(test)):
        result += "".join(test[i]) ## join can turn list to str
    return result

if __name__ == "__main__":
    convert()
