<h2><a href="https://www.geeksforgeeks.org/problems/minimize-the-heights-i/1">Minimize the Heights I</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array <strong>arr[]</strong>&nbsp;denoting heights of <strong>N</strong> towers and a positive integer <strong>K</strong>, you have to modify the height&nbsp;of each&nbsp;tower either by increasing or decreasing them by <strong>K</strong> only once.<br>
Find out what could be the possible&nbsp;minimum difference of the height&nbsp;of shortest and longest towers after you have modified each tower.<br>
<strong>Note: </strong>Assume that height of the tower can be negative.</span><br>
<span style="font-size:18px">A slight modification of the problem can be found <a href="https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1" previewlistener="true">here</a>.&nbsp;</span></p>

<p><br>
<span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>K = 2, N = 4
Arr[] = {1, 5, 8, 10}
<strong>Output:</strong>
5
<strong>Explanation:</strong>
The array can be modified as 
{3, 3, 6, 8}. The difference between 
the largest and the smallest is 8-3 = 5.
</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
<strong>Output:</strong>
11
<strong>Explanation:</strong>
The array can be modified as
{6,&nbsp;12,&nbsp;9,&nbsp;13,&nbsp;17}. The difference between 
the largest and the smallest is 17-6 = 11.&nbsp;
</span></pre>

<p><br>
<span style="font-size:18px"><strong>Your Task:</strong><br>
You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>getMinDiff()</strong>&nbsp;which takes the <strong>arr[], n</strong>&nbsp;and&nbsp;<strong>k&nbsp;</strong>as input parameters and returns an integer&nbsp;denoting the minimum difference.</span></p>

<p><br>
<span style="font-size:18px"><strong>Expected Time Complexity:</strong>&nbsp;O(N*logN)<br>
<strong>Expected Auxiliary Space:</strong>&nbsp;O(N)<br>
<br>
<strong>Constraints</strong><br>
1 ≤ K&nbsp;≤ 10<sup>4</sup><br>
1 ≤ N&nbsp;≤ 10<sup>5</sup><br>
1 ≤ Arr[i] ≤ 10<sup>5</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Adobe</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>two-pointer-algorithm</code>&nbsp;<code>Arrays</code>&nbsp;<code>Greedy</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;