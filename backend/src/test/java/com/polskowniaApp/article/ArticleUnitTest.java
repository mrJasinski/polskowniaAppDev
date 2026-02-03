package com.polskowniaApp.article;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import static org.junit.jupiter.api.Assertions.*;

class ArticleUnitTest
{
//    String covertTitleToLink(final String title)
//    {
//        var text = title.replaceAll(" ", "-");
//
//        var normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
//
//        var pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//
//        return pattern.matcher(normalized).replaceAll("").toLowerCase();
//    }


// trzy podstawowe typy testów pozytywny negatywny puste dane wejściowe

//    czy to na pewno dobry test?
    @Test
    void covertTitleToLink_shouldReturnStringWithWhiteSpacesReplacedByDash()
    {
//        given
        var title = "Żółty żółw źółcią";

//        system under test
        var toTest = new Article();

//        when
        var result = toTest.covertTitleToLink(title);

//        then
        assertEquals("zolty-zolw-zolcia", result);
    }

    @Test
    void covertTitleToLink_shouldNotContainWhiteSpaces()
    {
//        given
        var title = "Żółty żółw źółcią";

//        system under test
        var toTest = new Article();

//        when
        var result = toTest.covertTitleToLink(title);

//        then
        assertFalse(result.contains(" "));
    }

    @Test
    void covertTitleToLink_shouldReturnStringLowerCaseOnly()
    {
//        given
        var title = "Żółty żółw źółcią";

//        system under test
        var toTest = new Article();

//        when
        var result = toTest.covertTitleToLink(title);

//        then
        assertFalse(result.contains("\\p{Lu}"));
    }

}