#! pyhton3 Ackerman function
from datetime import datetime

def ack(m, n):
    ans = 0
    if m == 0:
        ans = n + 1;
    elif n == 0:
        ans = ack(m - 1, 1)
    else:
        ans = ack(m - 1, ack(m, n - 1))

    return ans


if __name__ == '__main__':
    print("Starting at " + str(datetime.now()))

    for i in range(7):
        for j in range(7):
            print(str(datetime.now()) + ": Start solving ackerman [" + str(i) + ", " + str(j) + "]")
            val = ack(i, j)
            print(str(datetime.now()) + ": Solved ackerman [" + str(i) + ", " + str(j) + "], its value is " + str(val))
