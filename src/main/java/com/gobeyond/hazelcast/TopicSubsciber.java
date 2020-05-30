package com.gobeyond.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopicSubsciber {

	public static void main(String ars[]) {

		HazelcastInstance hz = HazelcastClient.newHazelcastClient();

		ITopic<Object> nTopic = hz.getTopic("normalTopic");

		log.info("::: subsciber topic messgae :::");
		
		nTopic.addMessageListener(new TopicListener());

	}

}
