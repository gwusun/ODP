/**
 * @auther gsunwu@163.com
 * @create 2021 04 11 15:50
 */

package cn.test;

public enum EnumFamily {
    TEXT("text");
    private String family;
    EnumFamily(String family){
        this.family=family;
    }
    public String getFamily(){
        return this.family;
    }

}
