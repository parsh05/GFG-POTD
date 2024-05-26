<h2><a href="https://www.geeksforgeeks.org/problems/you-and-your-books/1">You and your books</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 20px;">You have <strong>n</strong> stacks of books. Each stack of books has some nonzero height <strong>arr</strong>[i] equal to the number of books on that stack ( considering all the books are identical and each book has a height of 1 unit ). In one move, you can select any number of consecutive stacks of books such that the height of each selected stack of books arr[i] &lt;= <strong>k</strong>. Once such a sequence of stacks is chosen, You can collect any number of books from the chosen sequence of stacks.<br>What is the maximum number of books that you can collect this way?</span></p>
<p><strong><span style="font-size: 20px;">Example 1</span></strong></p>
<pre><span style="font-size: 20px;"><strong>Input</strong><br>8 1<br>3 2 2 3 1 1 1 3<br><strong>Output</strong><br>3<br></span><span style="font-size: 20px;"><strong>Explanation&nbsp;</strong></span><span style="font-size: 20px;"><br>We can collect maximum books from consecutive stacks numbered 5, 6, and 7 having height less than equal to K.</span></pre>
<p><strong><span style="font-size: 20px;">Example 2</span></strong></p>
<pre><span style="font-size: 20px;"><strong>Input</strong><br>8 2<br>3 2 2 3 1 1 1 3<br><strong>Output</strong><br>4<br></span><span style="font-size: 20px;"><strong>Explanation</strong><br>We can collect maximum books from consecutive stacks numbered 2 and 3 having height less than equal to K.</span></pre>
<p><strong><span style="font-size: 18px;">Your Task:</span></strong><br><span style="font-size: 18px;"><span style="font-size: 18px;">You don't have to read input or print anything. Your task is to complete the function&nbsp;<strong>max_Books</strong></span><strong style="font-size: 18px;">() </strong><span style="font-size: 18px;">which takes the integer arr, n, and k</span><span style="font-size: 18px;"> returns the </span></span><span style="font-size: 20px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;">maximum number of books you can collect.</span></p>
<p><span style="font-size: 20px; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;"><strong>Expected Time Complexity:</strong>&nbsp;O(n)<br><strong>Expected Space Complexity:&nbsp;</strong>O(1)</span></p>
<p><strong style="font-size: 20px;">Constraints:</strong><br style="font-size: 20px;"><span style="font-size: 20px;">1 &lt;= n &lt;=&nbsp;</span><span style="font-size: 20px;">10</span><sup>5</sup><br style="font-size: 20px;"><span style="font-size: 20px;">1 &lt;= k &lt;=&nbsp;</span><span style="font-size: 20px;">10</span><sup>9</sup><br style="font-size: 20px;"><span style="font-size: 20px;">1 &lt;= arr[i] &lt;= 10<sup>9</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Junglee Games</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Dynamic Programming</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Algorithms</code>&nbsp;