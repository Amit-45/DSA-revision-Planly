Introduction to Dynamic Programming (DP)
1. What is DP?
Dynamic Programming is an optimization technique used to solve problems by:
- Breaking a problem into smaller subproblems.
- Storing the results of solved subproblems.
- Reusing stored results instead of calculating them again.
Why DP? To avoid repeated calculations and reduce time complexity.

DP is useful when a problem has:
1. Overlapping subproblems: Same subproblems are calculated repeatedly.
2. Optimal substructure: The final answer can be built using answers to smaller subproblems.
2. Example: Fibonacci
Given: Find the Nth Fibonacci number.

Formula:
\[
F(n)=F(n-1)+F(n-2)
\]

Base cases:
- F(0)=0
- F(1)=1
Example: n=5

0, 1, 1, 2, 3, 5

Answer = 5.
3. Three approaches to DP
--------------------------------------------------------------------------
A. Memoization (Top-Down)
------------------------------------------------------------------------------
Recursion + DP array
---------------------------------------------------------------------------
Thought process:
- Start from the main problem (f(n)).
- Break it into smaller problems using recursion.
- Before calculating, check if the answer is already stored.
- If stored, return it.
- Otherwise, calculate, store and return.
int f(int n,int[] dp) {
    if(n<=1) return n;

    if(dp[n]!=-1) return dp[n];

    return dp[n]=f(n-1,dp)+f(n-2,dp);
}


Memory triggers:
1. Create dp[] and fill with -1.
2. Write base case.
3. Check if already calculated.
4. Make recursive calls.
5. Store answer in dp[n].
6. Return answer.
--------------------------------------------------------------------
B. Tabulation (Bottom-Up)
--------------------------------------------------------------------
Iteration + DP array
--------------------------------------------------------------
Thought process:
- Start from the base cases.
- Calculate smaller answers first.
- Store answers in the DP array.
- Build towards the final answer.
int[] dp=new int[n+1];

dp[0]=0;
dp[1]=1;

for(int i=2;i<=n;i++) {
    dp[i]=dp[i-1]+dp[i-2];
}

return dp[n];


Memory triggers:
1. Create dp[].
2. Initialize base cases.
3. Run loop from 2 to n.
4. Calculate using previous DP values.
5. Return dp[n].
------------------------------------------------------
C. Space Optimization
------------------------------------------------------
Two variables instead of DP array
----------------------------------------------
Thought process:

Observe:

dp[i]=dp[i-1]+dp[i-2]

We only need the previous two values, not the entire array.

So replace the DP array with two variables.
int prev2=0;
int prev=1;

for(int i=2;i<=n;i++) {
    int curr=prev2+prev;
    prev2=prev;
    prev=curr;
}

return prev;


Memory triggers:
1. Initialize prev2=0, prev=1.
2. Calculate curr=prev2+prev.
3. Move prev into prev2.
4. Move curr into prev.
5. Return prev.
