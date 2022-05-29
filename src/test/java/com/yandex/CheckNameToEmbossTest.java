package com.yandex;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)

public class CheckNameToEmbossTest {

    private Account account;
    private final String name;
    private final boolean expected;


    public CheckNameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Before
    public void setUp(){
        account = new Account(name);
    }

    @Parameterized.Parameters(name = "{index}: для имени: {0} метод checkNameToEmboss возвращает {1} ")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{

                        // 2 знака без пробела
                        {"ТМ", false},
                        // 3 знака без пробела
                        {"ТМФ", false},
                        // 3 знака из них 1 пробел (не в начале и не в конце строки)
                        {"Т Ш", true},
                        // 3 знака из них 1 пробел (в конце строки)
                        {"ТШ ", false},
                        // 3 знака из них 1 пробел (в начале строки)
                        {" ТШ", false},
                        //3 пробела
                        {"   ", false},
                        // 4 знака из них 2 пробела
                        {"Т  Ш ", false},
                        //14 знаков без пробелов
                        {"ТимотейШевроле", false},
                        // 19 знаков без пробелов
                        {"ТимотейШевролееееее", false},
                        //19 знаков с 2 пробелами
                        {"Тимотей Шевроле еее", false},
                        //19 знаков с пробелом посередине
                        {"Тимоти Шаламенннннн", true},
                        //20 знаков с пробелом посередине
                        {"Тимоти Шаламеннннннн", false},
                        //20 знаков без пробелов
                        {"ТимотииШаламеннннннн", false},
                        //проверка с null
                        {null, false},
                        //ввод пустой строки
                        {"", false},
                }
        );
    }

    @Test
    @DisplayName("method checkNameToEmboss")
    @Description("Метод проверяет, можно ли напечатать строку на карте")
    public void accountFirstNameAndLastNameTest() {
        Assert.assertEquals(account.checkNameToEmboss(),expected);
    }
}
