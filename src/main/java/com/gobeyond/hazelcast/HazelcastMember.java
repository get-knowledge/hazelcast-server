package com.gobeyond.hazelcast;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HazelcastMember implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();

		log.info(hz.getName() + " group name " + hz.getConfig().getGroupConfig().getName());

		IMap<Object, Object> map = hz.getMap("gebeyond-map");

		map.put("name", "gobeyond");
		map.put("type", "cache");

		log.info("map the data :: " + map.toString());

		map.put("age", "31");
		map.put("address", "new delhi");

		log.info("map the data :: " + map.toString());

	}

}
