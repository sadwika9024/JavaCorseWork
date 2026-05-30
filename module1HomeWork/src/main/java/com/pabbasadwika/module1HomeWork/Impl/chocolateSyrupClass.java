package com.pabbasadwika.module1HomeWork.Impl;

import com.pabbasadwika.module1HomeWork.Syrup;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "syrup.type",havingValue = "choco")
@Primary
public class chocolateSyrupClass implements Syrup {
    @Override
    public String getSyrupType() {
        return "Syrup : Chocolate";
    }
}
