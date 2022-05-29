package com.yandex;

public class Praktikum {

    public static void main(String[] args) {

        String name = "Тимоти Шаламе";

        Account account = new Account(name);
        if (account.checkNameToEmboss()) {
            System.out.println(name + " - фамилию и имя можно использовать для печати на банковской карте");
        } else {
            System.out.println(name + " - фамилию и имя нельзя использовать для печати на банковской карте");
        }
    }
}