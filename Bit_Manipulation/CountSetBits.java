//Simple O(n) method

Note: In GCC, we can directly count set bits using __builtin_popcount(). 
    So we can avoid a separate function for counting set bits.

// Brian Kernighan’s O(log(n))
int count_one (int n)
    {
        while(n)
        {
            n = n & (n-1);
            count++;
        }
        return count;
}

//O(1) using lookup table
