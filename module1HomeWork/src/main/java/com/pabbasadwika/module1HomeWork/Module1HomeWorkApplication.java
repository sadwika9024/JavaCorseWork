package com.pabbasadwika.module1HomeWork;

import com.pabbasadwika.module1HomeWork.Impl.cakeBaker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Module1HomeWorkApplication implements CommandLineRunner {


	cakeBaker cakeBakerObj;

	public Module1HomeWorkApplication(com.pabbasadwika.module1HomeWork.Impl.cakeBaker cakeBakerObj) {
		this.cakeBakerObj = cakeBakerObj;
	}

	public static void main(String[] args) {
		SpringApplication.run(Module1HomeWorkApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		cakeBakerObj.bakeCake();
	}
}
