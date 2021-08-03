package com.rong;

import com.rong.util.JedisUtils;
import redis.clients.jedis.Jedis;

public class JedisTest {
    public static void main(String[] args) {
        //1.获取连接对象
//        Jedis jedis = new Jedis("127.0.0.1",6379);
        Jedis jedis = JedisUtils.getJedis();
        //2.执行操作
//        jedis.set("name","rongqi");
        String name = jedis.get("name");
        System.out.println(name);
        //3.关闭连接
        jedis.close();
    }
}
