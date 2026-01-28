package com.molier.HealthCare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.molier.HealthCare.entities.*;
import com.molier.HealthCare.repository.*;
import com.molier.HealthCare.service.*;

@SpringBootApplication
public class HealthCareApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(HealthCareApplication.class, args);
		

	}

}
