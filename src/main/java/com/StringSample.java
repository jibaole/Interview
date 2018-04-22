package com;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/4/15
 */

public class StringSample {
    public static void main(String[] args) {
        String str="dhwoiuqhduwqdddddddhwjdassssssssddd";
        int i = countMatches( str, "wj" );
        System.out.println(i);
    }


   public static int countMatches(String str,String f){
        int count=0;
        if(null == str || str.length()==0 || null == f || f.length()==0){
            return count;
        }
        int idx=0;
        while((idx=str.indexOf(f, idx)) != -1){
            count++;
            idx+=f.length();
        }

      return count;
   }

}
