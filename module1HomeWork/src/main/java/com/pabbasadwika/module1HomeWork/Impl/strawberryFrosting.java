package com.pabbasadwika.module1HomeWork.Impl;

import com.pabbasadwika.module1HomeWork.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "frosting.type",havingValue = "strawberry")
public class strawberryFrosting implements Frosting {
    @Override
    public String getFrostingType() {

        return "Frosting : strawberry";

    }
}
