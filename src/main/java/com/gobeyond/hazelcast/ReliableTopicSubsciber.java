package com.gobeyond.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReliableTopicSubsciber {

	public static void main(String ars[]) {

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();

		ITopic<Object> nTopic = hz.getReliableTopic("reliableTopic");

		log.info("::: subsciber reliable topic messgae :::");

		nTopic.addMessageListener(new ReliableTopicListener());
		
		log.info(":::  reliable topic messgae subsciber done :::");

	}

}
