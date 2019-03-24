package primeTest;

public class PrintPrimes {
	public static int MAXPRIMES = 1000;

    public void printPrimes(int n) {
        int curPrime; //Value currently considered for primeness
        int numPrimes; // Number of primes found so far;
        boolean isPrime; //Is curPrime prime?
        int[] primes = new int[MAXPRIMES];// The list of primes.
        
        // Initialize 2 into the list of primes.
        primes[0] = 2;
        numPrimes = 1;
        curPrime = 2;
        while(numPrimes < n) {
            curPrime++; // next number to consider...
            isPrime = true;
            for(int i = 0; i <= numPrimes; i++ ) {
                //for each previous prime.
                if(isDivisible(primes[i],curPrime)) {
                    //Found a divisor, curPrime is not prime.
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                // save it!
                primes[numPrimes] = curPrime;
                numPrimes++;
            
            }
        }// End while
        
        // print all the primes out
        for(int i = 0; i < numPrimes; i++) {
            System.out.println("Prime: " + primes[i] );

        }
        
        
    }// End printPrimes.
    private static boolean isDivisible(int divisor, int divided){
        if(divisor != 0){
            return (divided % divisor) == 0;
        }
        return false;
    }

}
