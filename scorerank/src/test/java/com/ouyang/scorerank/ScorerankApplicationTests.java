package com.ouyang.scorerank;

import org.joda.time.format.DateTimeFormat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ScorerankApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
    void test1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String time = simpleDateFormat.format(new Date());
        Date current = simpleDateFormat.parse(time);
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println(current);
    }

}
