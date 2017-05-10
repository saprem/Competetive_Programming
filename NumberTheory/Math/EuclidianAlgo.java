Basic

int gcd(int n, int m) {
            if (n%m ==0) return m;
            if (n < m) swap(n, m);
            while (m > 0) {
                n = n%m;
                swap(n, m);
            }
            return n;
    }

int gcd(int a, int b) {
    if (a == 0)
        return b;
    return gcd(b%a, a);
}

Extended

int gcdExtended(int a, int b, int *x, int *y)
{
    // Base Case
    if (a == 0)
    {
        *x = 0;
        *y = 1;
        return b;
    }
 
    int x1, y1; // To store results of recursive call
    int gcd = gcdExtended(b%a, a, &x1, &y1);
 
    // Update x and y using results of recursive
    // call
    *x = y1 - (b/a) * x1;
    *y = x1;
 
    return gcd;
}
