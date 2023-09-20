package com.sky.dog.demo.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.dog.demo.domain.Dog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc //tells spring to set up a MockMvc object
@Sql(scripts = {"classpath:dog-schema.sql", "classpath:dog-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class DogIntegrationTest {

    @Autowired //tells spring to put the mockmvc bean into this class
    private MockMvc mvc; //sends requests and receives responses (like postman)

    @Autowired
    private ObjectMapper mapper; //converts JSON to java and vice versa

    @Test
    void testCreate() throws Exception {
        Dog testDog = new Dog("Rex", 2, "brown", "labrador");
        String reqBody = this.mapper.writeValueAsString(testDog);

//        System.out.println("Dog: " + testDog);
//        System.out.println("JSON: " + reqBody);

        //below equivalent to RequestBuilder req = MockMvcRequestBuilders.post("/create").content("JSON DATA").contentType(MediaType.APPLICATION_JSON);
        RequestBuilder req = post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON);

        ResultMatcher checkStatus = status().isCreated();
        testDog.setId(4);
        String resBody = this.mapper.writeValueAsString(testDog);

//        System.out.println("Saved Dog: " + testDog);
//        System.out.println("RES JSON: " + resBody);

        ResultMatcher checkBody = content().json(resBody);

        mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
    }

    @Test
    void testCreateCondensed() throws Exception { // Same as above, but condensed
        String reqBody = this.mapper.writeValueAsString(new Dog("Rex", 2, "brown", "labrador"));
        String resBody = this.mapper.writeValueAsString(new Dog(4, "Rex", 2, "brown", "labrador"));

        mvc.perform(post("/create").content(reqBody).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(resBody));
    }

//    @Test
//    void testGetAll() throws Exception {
//        String test = this.mapper.writeValueAsString(new Dog(1, "Rex", 2, "brown", "labrador"));
//        mvc.perform(post("/create").content(test).contentType(MediaType.APPLICATION_JSON));
//        ResultMatcher checkBody = content().json("[" + test + "]");
//
//
//        mvc.perform(get("/getall"))
//                .andExpect(status().isOk())
//                .andExpect(checkBody);
//    } // uses @DirtiesContext

    @Test
    void testGet() throws Exception {
        mvc.perform(get("/get/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(new Dog(1, "Rex", 1, "brown", "dachshund"))));
    }

    @Test
    void testGetAll() throws Exception {
        mvc.perform(get("/getall"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(
                        new Dog[]{
                                new Dog(1, "Rex", 1, "brown", "dachshund"),
                                new Dog(2, "Lucky", 2, "brown", "labrador"),
                                new Dog(3, "Millie", 3, "black", "pit bull")
                        }
                        )
                ));
    }

    @Test
    void testRemove() throws Exception {
        mvc.perform(delete("/remove/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Dog with id 3 removed."));
    }

    @Test
    void testUpdate() throws Exception {
        mvc.perform(patch("/update?id=3&age=100"))
                .andExpect(status().isOk())
                .andExpect(content().json(this.mapper.writeValueAsString(
                        new Dog(3, "Millie", 100, "black", "pit bull")
                )));
    }
}
