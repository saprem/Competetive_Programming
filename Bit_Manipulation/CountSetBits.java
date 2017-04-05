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
