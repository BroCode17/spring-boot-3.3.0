package com.efrimpon.lesson.practices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SayService {

    private Say say;

    //constructor inject
    @Autowired
    public SayService(
          @Qualifier("gree") Say say
    ) {
        this.say = say;
    }



    public String Time(){
        return say.Greet();
    }
}
