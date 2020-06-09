package com.ignite.poc;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.lang.IgniteRunnable;
import org.apache.ignite.resources.IgniteInstanceResource;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class IgniteDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(IgniteDemoApplication.class, args);
		/*
		try (Ignite ignite = Ignition.start("D:\\apache-ignite-2.8.1-bin\\examples\\config\\example-ignite.xml")) {
			// Put values in cache.
			IgniteCache<Integer, String> cache = ignite.getOrCreateCache("igCache");
			cache.put(1, "Apache Ignite\n");
			cache.put(2, "Testing !!");
			// Get values from cache
			// Broadcast 'Hello World' on all the nodes in the cluster.
			ignite.compute().broadcast(()->System.out.println(cache.get(1) + " " + cache.get(2)));

		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}*/
}}

