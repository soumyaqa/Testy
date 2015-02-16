package com.sdl.weblocator.bootstrap.form;

import com.sdl.bootstrap.form.DatePicker;
import com.sdl.bootstrap.form.Form;
import com.sdl.weblocator.InputData;
import com.sdl.weblocator.TestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DatePickerTest extends TestBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatePickerTest.class);

    Form form = new Form(null, "Form Title");
    DatePicker datePicker = new DatePicker(form, "dp3");

    @BeforeClass
    public void startTests() {
        driver.get(InputData.BOOTSTRAP_URL);
    }

    @Test
    public void selectDate() {
        datePicker.select("19/02/2013");
        assertTrue("19-02-2013".equals(datePicker.getDate()));
    }

    @Test
    public void selectOldDate() {
        datePicker.select("11/08/2009");
        assertTrue("11-08-2009".equals(datePicker.getDate()));
    }
}
