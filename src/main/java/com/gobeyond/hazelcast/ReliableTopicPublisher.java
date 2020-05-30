package com.gobeyond.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReliableTopicPublisher {

	public static void main(String are[]) {

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();

		ITopic<Object> rTopic = hz.getReliableTopic("reliableTopic");

		log.info("::: reliable topic messgae :::");

		rTopic.publish("Hello Java Student's");

		log.info("::: reliable topic messgae is publish :::");

	}

}
