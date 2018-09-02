package com.zr7;

import jdk.nashorn.internal.runtime.FindProperty;

/**
 * @Author zhangrun 【macmanboy@foxmail.com】
 * @Date 2018/8/31
 * @Time:23:28
 * @Description：
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数
 */
public class binarySearch {

    public boolean Find(int target,int [][]array){
        int row=0;
        int col=array[0].length-1;
        int mid=array[0].length/2;
        while(row<=array.length-1&&col>=0){
            if(target == array[row][col]){
                return true;
            }
            else if(target>array[row][col]){
                row++;
            }else{
                /*if(target>array[row][mid]&&col>mid){
                   col--;
                }else if(col==mid){
                    return  false;
                } else{
                    if(col>mid){
                       col=0;
                    }else{
                        col++;
                    }
                }*/
                col--;
            }
        }
        return  false;
    }
    public static void main(String []args){
        binarySearch bs = new binarySearch();
        // int [ ][ ]  arr={{9,10,15,16,19},{20,21,22,23,27},{28,31,32,37,40}};
        int [ ][ ]  arr={{1,2,8,9},{2,4,9,12},{4,7,8,10,13},{6,8,11,15}};
        System.out.println(""+bs.Find(7,arr));
    }
}