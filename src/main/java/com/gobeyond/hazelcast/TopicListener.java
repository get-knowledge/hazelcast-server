package com.gobeyond.hazelcast;

import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TopicListener implements MessageListener<Object> {

	@Override
	public void onMessage(Message<Object> message) {

		log.info(" ::: normal listener message ::: " + message.getMessageObject());
	}

	

}
