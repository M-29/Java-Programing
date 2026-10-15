//Approach 1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n != 0){
            for(int i = 0; i < n; i++){
            int k = m;
            if(m == 0){
                    nums1[i] = nums2[i];
            }else if(m != 0){
                while(k > 0 && nums1[k-1] > nums2[i]){
                    k--;
                }
                for(int j = m; j > k; j--){                   
                    nums1[j] = nums1[j-1];                    
                }                
                nums1[k] = nums2[i];
                m++;
            }
        }
        }
        
    }
}
