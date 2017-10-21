#! Python 3
import time
import sys

def check_if_prime(n):
    n = int(n)
    for k in range(n - 2, 1, -2):
        if n % k == 0:
            return False

    return True


if __name__ == '__main__':
    if len(sys.argv) == 2:
        if check_if_prime(sys.argv[1]):
            print(sys.argv[1] + " is prime!")
        else:
            print(sys.argv[1] + " is not prime!")
    elif len(sys.argv) > 2:
        print "Printing all primes starting from " + sys.argv[1] + " to " + sys.argv[2]
        n = int(sys.argv[1])
        while n < int(sys.argv[2]):
            if check_if_prime(n):
                print time.strftime("%x") + " - " + time.strftime("%X") + ": " + str(n) + " is prime!"
            n += 1
    else:
        print "Printing all primes starting from 1"
        n = 1
        while true:
            if check_if_prime(n):
                print time.strftime("%x") + " - " + time.strftime("%X") + ": " + str(n) + " is prime!"
            n += 1
