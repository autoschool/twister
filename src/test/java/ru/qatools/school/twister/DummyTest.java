package ru.qatools.school.twister;

import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;


public class DummyTest {
    @Test

    public void testRun() {
        stepOne();
        stepTwo();
        attach();
    }

    @Step
    public void stepOne() {

    }

    @Step
    public void stepTwo() {

    }

    @Attachment
    public String attach(){
        return "Привет Аллюр";
    }
}
