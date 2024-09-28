#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3
class Solution:
    def minimizeCost(self, k, arr):
        # code here
        n = len(arr)
        dp = [float('inf')] * n
        dp[0] = 0
        for i in range(0, n):
            for j in range(i+1, i + k + 1):
                if(j >= n) :  break
                dp[j] = min(dp[i] + abs(arr[j] - arr[i]) , dp[j])
                
        return dp[n-1]

#{ 
 # Driver Code Starts.
#Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        k= int(input())
        arr = list(map(int, input().split()))
        ob = Solution()
        res = ob.minimizeCost(k,arr)
        print(res)
        t -= 1


# } Driver Code Ends