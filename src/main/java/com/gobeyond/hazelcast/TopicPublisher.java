package com.gobeyond.hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopicPublisher {

	public static void main(String are[]) {

		HazelcastInstance hz = Hazelcast.newHazelcastInstance();

		ITopic<Object> nTopic = hz.getTopic("normalTopic");

		log.info("::: topic messgae :::");

		nTopic.publish("Hello Java Student's");

		log.info("::: topic messgae is publish :::");

	}

}
