package com.grupopat.practicafinal.modelTest;

import com.grupopat.practicafinal.model.UserModel;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class UserModelTest {
    @Test
    public void TestOk(){
        UserModel correct = new UserModel("marta12","marta", "lopez", "mujer");
        assertEquals(correct.getUsername(),"marta12");
        assertEquals(correct.getFirst_name(),"marta");
        assertEquals(correct.getLast_name(),"lopez");
        assertEquals(correct.getGender(),"mujer");
    } 
}



