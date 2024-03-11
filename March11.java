package march;
public class March11 {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int count = 0 ;
        int i = 0 , j = 0 , k= n-1 , l = n-1 ;
        while (i<n && k >= 0) {
            if(mat1[i][j] + mat2[k][l] == x){
                count++;

                //update pointer of first matrix
                if(j==n-1){
                    i++;
                    j=0;
                }else j++;

                // update pointer of second matrix
                if(l==0){
                    k--;
                    l = n-1;
                } else l--;
            } else if(mat1[i][j] + mat2[k][l] < x){
                     //update pointer of first matrix
                if(j==n-1){
                    i++;
                    j=0;
                }else j++;
            } else if (mat1[i][j] + mat2[k][l] > x)  {
                 // update pointer of second matrix
                 if(l==0){
                    k--;
                    l = n-1;
                } else l--;
            }
        }
        return count;
    }
}
