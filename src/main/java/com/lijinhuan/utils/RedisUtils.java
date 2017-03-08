package com.lijinhuan.utils;

import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

/**
 * redis π§æﬂ¿‡
 * @author Administrator
 *
 */
public class RedisUtils {
	private static  Jedis jedis;
	public static void init(){
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxIdle(Integer.parseInt( PropertiesUtils.get("REDIS_MAX_IDLE")));
		config.setMaxWaitMillis(Long.parseLong(PropertiesUtils.get("REDIS_MAX_WAIT")));
		List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
		JedisShardInfo jedisShardInfo = new JedisShardInfo(PropertiesUtils.get("REDIS_ADDR"), Integer.parseInt(PropertiesUtils.get("REDIS_PORT")));
		list.add(jedisShardInfo);
		ShardedJedisPool pool = new ShardedJedisPool(config, list);
		//JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		//jedis = new Jedis(jedisShardInfo);
		jedis = new Jedis("192.168.44.128", 6379);
		jedis.auth("ljh910618");
	}
	
	public static void main(String[] args) {
		init();
		jedis.set("a", "a");
		System.out.println(jedis.get("a"));
	}
}
