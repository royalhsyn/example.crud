package com.example.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String surname;
    private int age;
}
