package practice;

import java.util.Arrays;

/**
 * 排序集合
 */
public class SortCollection {

    // 冒泡排序
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    // 插入排序
    public void myInsertionSort(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = i;
            while (temp > 0 && nums[i] < ans[temp - 1]) {
                ans[temp] = ans[temp - 1];
                temp--;
            }
            ans[temp] = nums[i];
        }
        Arrays.stream(ans).forEach(System.out::println);
    }

    public void insertionSort(int[] nums) {
        int min;
        for(int i=0; i<nums.length; i++)
        {
            min=i;
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[j] < nums[min])
                    min=j;
            }
            if(min != i) {
                int temp = nums[i];
                nums[i] = nums[min];
                nums[min] = temp;
            }
        }
        Arrays.stream(nums).forEach(System.out::println);
    }

    // 归并排序
    public void mergeSort(int[] nums) {
        int len = nums.length - 1;
        merge(nums, 0, len);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private void merge(int[] nums, int start, int end) {
        if (start == end) return;
        int mid = (start + end) / 2;
        merge(nums, start, mid);
        merge(nums, mid + 1, end);

        int[] temp = new int[nums.length];
        int k = 0;
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int x = 0; x <= end - start; x++) {
            nums[start + x] = temp[x];
        }
    }


    // 快速排序
    public void quickSort(int[] nums) {
        int len = nums.length - 1;
        quickSortMethod(nums, 0, len);
        Arrays.stream(nums).forEach(System.out::println);
    }

    private void quickSortMethod(int[] nums, int start, int end) {
        if (start > end) return;
        int temp = nums[start];
        int i = start, j = end;
        while (i != j) {
            while (nums[j] >= temp && j > i) j--;
            while (nums[i] <= temp && i < j) i++;
            if (j > i) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[start] = nums[i];
        nums[i] = temp;
        quickSortMethod(nums, 0, i - 1);
        quickSortMethod(nums, i + 1, end);
    }

    public static void main(String[] args) {
        int[] i = {3,7,6,4,2,1,9};
        SortCollection sortCollection = new SortCollection();
        sortCollection.mergeSort(i);
    }

}
