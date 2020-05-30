package com.gobeyond.hazelcast;

import com.hazelcast.core.Message;
import com.hazelcast.topic.ReliableMessageListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReliableTopicListener implements ReliableMessageListener<Object> {

	@Override
	public void onMessage(Message<Object> message) {

		log.info(" ::: reliable listener message ::: " + message.getMessageObject());

	}

	@Override
	public long retrieveInitialSequence() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void storeSequence(long sequence) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLossTolerant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTerminal(Throwable failure) {
		// TODO Auto-generated method stub
		return false;
	}

}
