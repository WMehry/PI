package com.example.microfinancepi;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@SpringBootApplication
@CrossOrigin("*")
@EnableScheduling
@EnableWebMvc
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, scheme = "bearer", bearerFormat = "JWT")
public class MicroFinancePiApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(MicroFinancePiApplication.class, args);
        /*
        final String url= "https://www.stb.com.tn/fr/site/bourse-change/historique-des-tmm/";
        try {
            final Document doc = Jsoup.connect(url).get();
            for (Element row : doc.select("table.cours-de-change tr")){
                if (row.select("td:nth-of-type(1)").text().equals("")){
                    continue;
                }else {
                    final String years = row.select("td:nth-of-type(1)").text();
                    final String month = row.select("td:nth-of-type(2)").text();
                    final String rate = row.select("td:nth-of-type(3)").text();
                    double tmmRate = Double.parseDouble(rate);
                    log.info(years + " " + month + " " + tmmRate);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

         */
    }
}