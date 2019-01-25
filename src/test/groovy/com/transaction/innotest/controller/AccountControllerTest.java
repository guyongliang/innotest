package com.transaction.innotest.controller

import com.transaction.innotest.InnotestApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class AccountControllerTest extends NoWebEnvironmentTestBase {

    @Autowired
    AccountController accountController

    @Test
    void test(){
        accountController.findOne(1)
    }
}