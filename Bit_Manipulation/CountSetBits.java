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
int countSetBits(unsigned int n)
{
  unsigned char lookup_t[256] = {0}; 
  int i, count = 0;
 
// generate the lookup table
  for (i = 0; i < 256; i++)
  {
    lookup_t[i] = (i & 1) + lookup_t[i / 2];
  }
 
  /* Get sie of int program by size of operator. 
     It makes the solution consistent for different word sizes */
  for (i = 1; i <= sizeof(int) && n; i++)
  {
    count += lookup_t[n & 255];
    n >>= 8;
  }
 
  return count;
}


//generating lookup table using macros c++
static const unsigned char lookup_t[256] =
{
#   define B2(n) n,     n+1,     n+1,     n+2
#   define B4(n) B2(n), B2(n+1), B2(n+1), B2(n+2)
#   define B6(n) B4(n), B4(n+1), B4(n+1), B4(n+2)
    B6(0), B6(1), B6(1), B6(2)
};

//Using divide and conquer strategy
int countSetBits(unsigned int n)
{
  n = n - ((n >> 1) & 0x55555555);
  n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
  n = (n + (n >> 4)) & 0x0F0F0F0F;
  n = n + (n >> 8);
  n = n + (n >> 16);
  return n & 0x0000003F;
}

