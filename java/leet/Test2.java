package leet;

public class Test2 {
    // 中位数 https://blog.csdn.net/qq_41014682/article/details/79812181
    // A: A[0] A[1] A[2]...... A[j-2] | A[j-1] ....A[m-3] A[m-2] A[m-1] j-1 | j+1
    //
    // B: B[0] B[1] B[2]....... B[i] | B[i+1].....B[n-3] B[n-2] B[n-1] i+1 | i-1

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length;
         int n = nums2.length;
         if(m > n){
            // 保证nums2比nums1长
             int[] temp = nums1;
             nums1 = nums2;
             nums2 = temp;
             int tep = m;
             m = n;
             n = tep;
         }
         int iMin = 0, iMax = m, halfLengh = (n + m + 1) / 2;
         while (iMin < iMax){
             int i = (iMin + iMax) / 2;
             int j = halfLengh - i;
             if (i < iMax && nums2[j - 1] > nums1[i]){
                 iMin = iMin + 1;
             }else if(i > iMin && nums1[i - 1] > nums2[j]){
                 iMax = iMax -1;
             }else {
                 int maxLeft=0;
                 if(i==0) {maxLeft=nums2[j-1];}
                 else if(j==0) {maxLeft=nums1[i-1];}
                 else {maxLeft=Math.max(nums1[i-1], nums2[j-1]);}
                 if((m+n)%2==1) {return maxLeft;}
                 int minRight=0;
                 if(i==m) {minRight=nums2[j];
                 }else if(j==n) {minRight=nums1[i];}
                 else {minRight=Math.min(nums2[j], nums1[i]);}
                 return (maxLeft+minRight)/2.0;
             }
         }
        return 0.0;
    }
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]= {2,3,4,5,6};
        Test2 l=new Test2();
        double c=l.findMedianSortedArrays(a,b);
        System.out.println(c);
    }
}
