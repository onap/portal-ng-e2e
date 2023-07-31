/*
 *   Copyright (c) 2023. Deutsche Telekom AG
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 *   SPDX-License-Identifier: Apache-2.0
 *
 */

package org.onap.portal.e2e.test.steps.common;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Optional;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.util.stream.Collectors.toList;
import static org.onap.portal.e2e.test.pages.PageWithTable.*;

public class TableSteps {

    public static Optional<SelenideElement> findRowWithText(String text, boolean exactMatch) {
        return findRowsWithText(text, exactMatch, false).stream().findAny();
    }

    public static List<SelenideElement> findRowsWithText(String text, boolean exactMatch, boolean isContaining) {
        $(TABLE_ROWS).should(exist);
        List<SelenideElement> foundedRows = findRowsOnActivePage(text, exactMatch, isContaining);
        while (foundedRows.isEmpty() && hasNextPage()) {
            goToNextPage();
            foundedRows = findRowsOnActivePage(text, exactMatch, isContaining);
        }
        return foundedRows;
    }

    public static boolean hasNextPage() {
        return $(PAGINATION).exists() && $(NEXT_PAGE).has(not(cssClass("disabled")));
    }

    public static void goToNextPage() {
        Selenide.executeJavaScript("arguments[0].click()", $(NEXT_PAGE).$(By.xpath("a")).getWrappedElement());
        CommonSteps.spinnerShouldDisappear();
    }


    public static int countRowsOnAllPages() {
        int numberOfRows = Selenide.$$(TABLE_ROWS).size();
        while (hasNextPage()) {
            goToNextPage();
            numberOfRows += Selenide.$$(TABLE_ROWS).size();
        }
        return numberOfRows;
    }

    private static List<SelenideElement> findRowsOnActivePage(String text, boolean exactMatch, boolean isContaining) {
        return $$(TABLE_ROWS).stream()
                .filter(row -> {
                    ElementsCollection rowValues = row.$$(ROW_CELLS);
                    String textInRow = getTextFromCell(rowValues.first());
                    if (exactMatch) {
                        return text.equals(textInRow);
                    } else if (isContaining) {
                        return textInRow.contains(text);
                    } else {
                        return textInRow.startsWith(text);
                    }
                }).collect(toList());
    }

    private static String getTextFromCell(SelenideElement cell) {
        SelenideElement anchor = cell.find(By.xpath("a"));
        if (anchor.exists()) {
            return anchor.getText();
        } else {
            return cell.getText();
        }
    }

}
