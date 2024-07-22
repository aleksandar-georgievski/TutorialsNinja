package com.w2a.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddCustomerTest {

    @Test(dataProvider = "getData")
    public void addCustomer(String firstName, String lastName, String postCode) {

    }

    @DataProvider
    public Object[][] getData() {
        int rows = excel.getRowCount();
        int cols = excel.getColumnCount();

        Object[][] data = new Object[rows-1][cols];

        for (int rowNum = 2; rowNum <= rows; rowNum++) {
            for (int colNum = 0; colNum < cols; colNum++) {
                data[rowNum - 2][colNum] = excel.getCellData();
            }
        }
    }
}
