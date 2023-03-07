# 【基础知识】

### 背包问题基础

**01 背包 & 完全背包**

- 01 背包：有 n 种物品，每种物品只有一个；
- 完全背包：有 n 种物品，每种物品有无数个；

暴力搜索（回溯算法实现）

> **背包问题：**
>
> ① 背包的容量
>
> ② 物品的重量
>
> ③ 物品的价值

> **二维dp 数组的含义:**
>
> dp[i] [j] 表示的是 [0, i] 物品任取然后放进容量为 j 的背包
>
> 1.不放物品i, 那么此时的 dp[i] [j] = dp[i - 1] [j]
>
> 2.放物品i, 那么此时的 dp[i] [j] = dp[i - weight[i]] [j] + value[i]
>
> **递推公式（状态转移方程）:**
>
> dp[i] [j] = Math.max(dp[i - 1] [j], dp[i - weight[i]] [j] + value[i]);
>
> **dp数组初始化**
>
> 
>
> **遍历顺序**(两层循环的遍历顺序是可以颠倒的)
>
> // 物品
>
> for ()
>
> ​	// 重量
>
> ​	for ()



> **一维数组的含义**
>
> dp[j]：表示容量为 j 的背包所能装下的最大的重量为 dp[j]
>
> 1.不放物品i，那么此时的 dp[j] = dp[j];
>
> 2.放物品i，那么此时的 dp[j] = dp[j - nums[i]] + value[i];
>
> **递推公式（状态转移方程）:**
>
> dp[j] = max(dp[j], dp[j - nums[i]] + value[i]);
>
> **dp数组初始化**
>
> 全部初始化为0即可
>
> **遍历顺序**
>
> // 物品
>
> for ()
>
> ​	// 重量，倒叙遍历是01，正序遍历是完全
>
> ​	for()

```java
// 一维数组，01背包的遍历顺序
for (int i = 0; i < nums.length; i++){// 物品
    for (int j = target; j >= nmus[i]; j--){// 背包，每个物品只能放一次(倒序遍历)
        dp[j] = max(dp[j], dp[j - nums[i] + value[i]);
    }
}
```



# 【LeetCode】

### 【动态规划】62.不同路径

链接：https://leetcode.cn/problems/unique-paths/description/

难度：中等

```java
class Solution {
    public int uniquePaths(int m, int n) {

        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++){
            arr[i][0] = 1;
        }

        for (int i = 0; i < n; i++){
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[m - 1][n - 1];
    }
}
```



### 【动态规划】63.不同路径ii

链接：https://leetcode.cn/problems/unique-paths-ii/description/

难度：中等

```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int xLen = obstacleGrid.length, yLen = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[xLen - 1][yLen - 1] == 1){
            return 0;
        }
        int[][] arr = new int[xLen][yLen];

        for (int i = 0; i < xLen && obstacleGrid[i][0] == 0; i++){
            arr[i][0] = 1;
        }

        for (int j = 0; j < yLen && obstacleGrid[0][j] == 0; j++){
            arr[0][j] = 1;
        }

        for (int i = 1; i < xLen; i++){
            for (int j = 1; j < yLen; j++){
                if (obstacleGrid[i][j] == 1){
                    continue;
                }
                arr[i][j] = arr[i -1][j] + arr[i][j - 1];
            }
        }

        return arr[xLen - 1][yLen - 1];
    }
}
```



### 【动态规划】70.爬楼梯

链接：https://leetcode.cn/problems/climbing-stairs/description/

难度：简单

```java
class Solution {
    public int climbStairs(int n) {

        if (n < 2){
            return 1;
        }
        
        int f1 = 1, f2 = 2;

        for (int i = 2; i < n; i++){
            int temp = f2;
            f2 = f1 + f2;
            f1 = temp;
        }

        return f2;
    }
}
```



### 【动态规划】96.不同的二叉搜索树

链接：https://leetcode.cn/problems/unique-binary-search-trees/

难度：中等z

```java
class Solution {
    public int numTrees(int n) {
        
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= i; j++){

                dp[i] += dp[j - 1] * dp[i - j];

            }

        }

        return dp[n];
    }
}
```



### 【动态规划】343.整数拆分

链接：https://leetcode.cn/problems/integer-break/description/

难度：中等

```java
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++){
            for (int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }
}
```



### 【动态规划、背包问题】416.分割等和子集

[题目链接](https://leetcode.cn/problems/partition-equal-subset-sum/)

难度：中等

```java
class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        
        for (int num : nums){
            sum += num;
        }

        if (sum % 2 != 0){
            return false;
        }

        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int i = 0; i < nums.length; i++){
            for (int j = target; j >= nums[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        return dp[target] == target;
    }
}
```



### 【动态规划】474.一和零

[题目链接](https://leetcode.cn/problems/ones-and-zeroes/description/)

难度：中等

```java
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs){

            int zeroNum = 0, oneNum = 0;

            for (char c : str.toCharArray()){
                if (c == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
			// 两个背包
            for (int i = m; i >= zeroNum; i--){
                for (int j = n; j >= oneNum; j--){
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
```



### 【回溯、动态规划】494.目标和

[题目链接](https://leetcode.cn/problems/target-sum/description/)

难度：中等

```java
// 回溯解答算法
class Solution {
    
    private int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return res;
    }

    public void backtrack(int[] nums, int i, int sum, int target){
        if (i == nums.length){
            if (sum == target){
                res++;
            }
            return;
        }

        sum += nums[i];
        backtrack(nums, i + 1, sum, target);
        sum -= nums[i];

        sum -= nums[i];
        backtrack(nums, i + 1, sum, target);
        sum += nums[i];
    }
}
```

```java
// 动态规划算法解答
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums){
            sum += num;
        }

        if (Math.abs(target) > sum){
            return 0;
        }
        if ((target + sum) % 2 != 0){
            return 0;
        }

        // 这里表示的是加法总的集合的值
        int mostBig = (target + sum) / 2;
        int[] dp = new int[mostBig + 1];
        dp[0] = 1;

        for (int i = 0; i < nums.length; i++){
            for (int j = mostBig; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[mostBig];
    }
}
```



### 【动态规划】746.使用最小花费爬楼梯

链接：https://leetcode.cn/problems/min-cost-climbing-stairs/description/

难度：简单

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int len = cost.length;
        int[] dp = new int[len + 1];

        for (int i = 2; i <= cost.length; i++){
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }

        return dp[len];
    }
}
```

### 【动态规划、背包问题】1049.最后一块石头的重量 ii

[题目链接](https://leetcode.cn/problems/last-stone-weight-ii/description/)

难度：中等

```java
class Solution {
    public int lastStoneWeightII(int[] stones) {
    
        int sum = 0;

        for (int stone : stones){
            sum += stone;
        }

        int target = sum >> 1;
        int[] dp = new int[target + 1];

        for (int i = 0; i < stones.length; i++){
            for (int j = target; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - (dp[target] * 2);
    }
}
```



# 【剑指offer】

### 【动态规划】剑指 Offer 10- I. 斐波那契数列

链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/description/

难度：简单

```java
class Solution {
    public int fib(int n) {

        int f0 = 0, f1 = 1;

        for (int i = 1; i <= n; i++){
            int temp = f1;
            f1 = (f0 + f1)%(1000000007);
            f0 = temp;
        }

        return f0;
    }
}
```

