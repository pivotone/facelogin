package com.pivot.schoolvideos.utils;

import org.junit.jupiter.api.Test;

class ResultUtilsTest {
    @Test
    void success() {
        System.out.println(ResultUtils.success("success"));
    }

    @Test
    void error() {
        System.out.println(ResultUtils.error("1000","test is ok"));
    }

    @Test
    void testSuccess() {
        System.out.println(ResultUtils.success());
    }

    @Test
    void testSuccess1() {
        System.out.println(ResultUtils.success("yes","ok"));
    }
}