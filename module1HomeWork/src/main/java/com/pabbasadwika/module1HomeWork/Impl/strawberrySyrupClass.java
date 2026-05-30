package com.pabbasadwika.module1HomeWork.Impl;

import com.pabbasadwika.module1HomeWork.Syrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup.type",havingValue = "strawberry")

public class strawberrySyrupClass implements Syrup {
    @Override
    public String getSyrupType() {
        return "Syrup : strawberry";
    }
}
