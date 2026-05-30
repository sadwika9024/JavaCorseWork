package com.pabbasadwika.module1HomeWork.Impl;

import com.pabbasadwika.module1HomeWork.Frosting;
import com.pabbasadwika.module1HomeWork.Syrup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class cakeBaker {


    final Frosting frosting;
    final Syrup syrup;

    public cakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake(){
        System.out.println("cakeBaking using");
        System.out.println(frosting.getFrostingType());
        System.out.println("and");
        System.out.println(syrup.getSyrupType());
    }
}
