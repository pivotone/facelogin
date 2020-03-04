package com.pivot.schoolvideos.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MD5Test {

    MD5 md5 = new MD5();
    @Test
    void getCiphertext() {
        System.out.println(md5.getCiphertext("123456"));
    }

    @Test
    void verify() {
        System.out.println(md5.verify("13456","be56e057f20f883ee10adc3949ba59ab"));
    }
}