package com.dragon.hei.wsth.promote.algorithm;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

public class AlgorithmFunction {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(Arrays.asList(moveZero())));
    }

    /***
     * *题目描述：
     * 给定一个数组nums，将数组中的0挪到末尾，同时保持非0元素的相对位置
     * *示例：
     * 输入[0,1,3,0,5,0,12]
     * 输出[1,3,5,12,0,0,0]
     * *说明：
     * 必须在原数组上操作，不能拷贝新数组
     * 尽量减少遍历次数
     */
    private static int[] moveZero(){
        int data[] = {0,1,3,0,5,0,12};
        int length = data.length;
        int j = 0;
        for(int i = 0; i < length; i++){
            if(data[i] != 0){
                data[j] = data[i];
                if(i != j){
                    data[i] = 0;
                }
                j++;
            }
        }
        return data;
    }

    /***
     * 求一个数组长度为N的最大递增子序列的长度，可以不连续
     * *思路：
     * 如果第N个数字大于前N-1个数字中的最大值，
     * 则f(N) = f(N-1) + 1
     * 否则f(N) = f(N-1)
     *
     */
    private static int[] maxAscSubs(){
        int a[] = {1,5,6,7,2,4,8,3,10};
        for(int i=a.length-1;i>=0;i--){
            for(int j=0;j<i;j++){

            }
        }
        return null;
    }

    public static int maxArea(int[] height){
        int leftIndex =  0;
        int rightIndex = height.length - 1;
        int max = 0;
        while (leftIndex < rightIndex){

            int area = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            max = Math.max(area, max);
            if(height[leftIndex] <= height[rightIndex]){
                leftIndex++;
            }else{
                rightIndex--;
            }
        }
        return max;
    }


}
