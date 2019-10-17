package com.countdownlatch.cyclicbarrier.semaphore.enums;

/**
 * 枚举的使用
 * @author Jay
 * @create 2019-10-17 11:41
 */
public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"魏"),SIX(6,"赵");

    private Integer code;
    private String country;

    CountryEnum(Integer code, String country) {
        this.code = code;
        this.country = country;
    }

    public static CountryEnum forEach_CountryEnum(int index) {
        // 遍历枚举，找出和code一样的，返回
        CountryEnum[] values = CountryEnum.values();

        for (CountryEnum element : values) {
            if(element.getCode() == index) {
                return element;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getCountry() {
        return country;
    }
}
