package com.pabbasadwika.module1HomeWork.Impl;

import com.pabbasadwika.module1HomeWork.Frosting;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@ConditionalOnProperty(name = "frosting.type",havingValue = "choco")
public class chocolateFrosting implements Frosting {
    @Override
    public String getFrostingType() {
        return "Frosting : chocolate";
    }
}
