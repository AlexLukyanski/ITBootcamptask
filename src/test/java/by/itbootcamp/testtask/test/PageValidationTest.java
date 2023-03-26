package by.itbootcamp.testtask.test;

import by.itbootcamp.testtask.model.service.validation.PageValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PageValidationTest {

    @Test
    public void should_ReturnFalse_When_PageNumber_LessThanZero() {

        //given
        int page = -99;
        int size = 10;
        int userCount = 10;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnFalse_When_PageSize_LessThanZero() {

        //given
        int page = 0;
        int size = -2;
        int userCount = 5;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnFalse_When_PageSize_EqualsZero() {

        //given
        int page = 0;
        int size = 0;
        int userCount = 5;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnFalse_When_UserCount_LessThanZero() {

        //given
        int page = 0;
        int size = 10;
        int userCount = -5;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnFalse_When_UserCount_EqualsZero() {

        //given
        int page = 0;
        int size = 10;
        int userCount = 0;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnFalse_When_PageNumber_isBiggerThan_PagesAmount() {

        //given
        int page = 3;
        int size = 10;
        int userCount = 12;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertFalse(isPageExist);
    }

    @Test
    public void should_ReturnTrue_When_PageNumber_isLesserThan_PagesAmount() {

        //given
        int page = 1;
        int size = 10;
        int userCount = 12;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertTrue(isPageExist);
    }

    @Test
    public void should_ReturnTrue_When_PageNumber_isEquals_PagesAmount() {

        //given
        int page = 1;
        int size = 10;
        int userCount = 10;

        //when
        boolean isPageExist = new PageValidation.PageValidationBuilder()
                .isPageExist(page, size, userCount)
                .build()
                .isPageExist();

        //then
        assertTrue(isPageExist);
    }
}