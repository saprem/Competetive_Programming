return (n > 0) && ((n & (n - 1)) == 0)

// basic method 
Math.log(n)/Math.log(2)==(int)Math.log(n)/Math.log(2)

//
boolean isPowerOfTwo(int n)
{
  if (n == 0)
    return false;
  while (n != 1)
  {
    if (n%2 != 0)
      return false;
    n = n/2;
  }
  return true;
}
