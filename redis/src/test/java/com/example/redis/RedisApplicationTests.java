package com.example.redis;

import com.example.redis.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

        connection.flushDb();

        redisTemplate.opsForValue().set("mykey", "this_is_my_key");

        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }

    @Test
    public void test() throws JsonProcessingException {

        User user = new User("yang",21);

        //String jsonUser = new ObjectMapper().writeValueAsString(user);

        redisTemplate.opsForValue().set("user", user);

        System.out.println(redisTemplate.opsForValue().get("user"));

    }

}
