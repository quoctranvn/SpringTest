package com.pages;

import com.BasePage;
import com.annoatation.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@PageObject
public class LoginPage extends BasePage {
    @FindBy(linkText = "Sign in")
    private WebElement lnk_Signin;

    @FindBy(name = "email")
    private WebElement input_email;

    @FindBy(id = "passwd")
    private WebElement input_pass;

    @FindBy(id = "SubmitLogin")
    private WebElement btn_Submit;

    @FindBy(css = ".info-account")
    private WebElement lbl_info;

    public void goToLogin() {
        lnk_Signin.click();
    }

    public void doLogin(String user, String pass) {
        input_email.sendKeys(user);
        input_pass.sendKeys(pass);
        btn_Submit.click();
    }

    public void checkInfo() {
        String exp_message = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actual = lbl_info.getText();
        Assert.assertEquals(exp_message, actual);
    }
}
