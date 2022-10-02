package com.assignment.cosmos;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java11Test {
    @Test
    public void test_java_11_features() {
        assert ("".isBlank());
        String text = "Hello\nWorld\nIt is a great day!\nGo outside!";
        System.out.println(text);
        var textList = text.lines() //lines() method creates a stream.
                .collect(Collectors.toList());
        System.out.println(textList);
        assertEquals(4, textList.size());
    }
}