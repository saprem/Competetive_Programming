1. Using the temporary variable

    void swap(int &a, int &b)
    {
        int temp = a;
        a = b;
        b = temp;
    }

2. Without using temporary variable, with addition-subtraction

    void swap(int &a, int &b)
    {
        a = a + b;
        b = a - b;
        a = a - b;
    }

 3. Without using temporary variable, with multiplication-division

    void swap(int &a, int &b)
    {
        a = a * b;
        b = a / b;
        a = a / b;
    }

 4. Without using temporary variable, with XOR operation

    void swap(int &a, int &b)
    {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
    }

 5. One liner with addition-subtraction

    void swap(int &a, int &b)
    {
        a = a + b - (b = a);
    }

 6. One liner with multiplication-division

    void swap(int &a, int &b)
    {
        a = a * b / (b = a);
    }

 7. One liner with XOR

    void swap(int &a, int &b)
    {
        a ^= b ^= a ^= b;
    }

8. Using a temporary variable, with a macro:

    #define swap(type,a,b) type temp;temp=a;a=b;b=temp;
