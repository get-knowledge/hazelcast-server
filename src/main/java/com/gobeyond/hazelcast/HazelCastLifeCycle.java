package com.gobeyond.hazelcast;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.hazelcast.config.Config;
import com.hazelcast.config.ListenerConfig;
import com.hazelcast.core.Client;
import com.hazelcast.core.ClientListener;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.LifecycleEvent;
import com.hazelcast.core.LifecycleListener;
import com.hazelcast.core.MemberAttributeEvent;
import com.hazelcast.core.MembershipEvent;
import com.hazelcast.core.MembershipListener;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HazelCastLifeCycle {

	@Bean
	public Config getConfig() {
		return new Config();
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {

		Config conf = getConfig();

		conf.addListenerConfig(new ListenerConfig(new LifecycleListener() {

			@Override
			public void stateChanged(LifecycleEvent event) {

				log.info(" Life Cycle state :: " + event.getState());
			}
		}));

		conf.addListenerConfig(new ListenerConfig(new MembershipListener() {

			@Override
			public void memberRemoved(MembershipEvent membershipEvent) {

				log.info(" Member removed :: " + membershipEvent.getMember().getUuid());

			}

			@Override
			public void memberAttributeChanged(MemberAttributeEvent memberAttributeEvent) {

				log.info(" Member Attribute :: " + memberAttributeEvent.getMember().getUuid());
			}

			@Override
			public void memberAdded(MembershipEvent membershipEvent) {

				log.info(" Member Added :: " + membershipEvent.getMember().getUuid());
			}
		}));

		conf.addListenerConfig(new ListenerConfig(new ClientListener() {

			@Override
			public void clientDisconnected(Client client) {
				log.info(" Member Disconnected :: " + client.getUuid() + " client name " + client.getName());

				HazelcastInstance hz1 = Hazelcast.getHazelcastInstanceByName("_hzInstance_2_dev");

				IMap<Object, Object> orderMap = hz1.getMap("order-map");

				log.info(" order details :::" + orderMap.get(client.getUuid()).toString());

			}

			@Override
			public void clientConnected(Client client) {
				log.info(" Client Connected :: " + client.getUuid() + " client name " + client.getName());
			}
		}));

		HazelcastInstance hz = Hazelcast.newHazelcastInstance(conf);

		return hz;
	}

}
