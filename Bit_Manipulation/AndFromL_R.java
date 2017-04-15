long long step = 1;
 while(L!=R)
    {
        L/=2; R/=2; step*=2;
    }
    printf("%lld\n",L*step);
