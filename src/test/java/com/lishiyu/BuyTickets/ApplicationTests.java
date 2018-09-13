package com.lishiyu.BuyTickets;

import com.lishiyu.BuyTickets.entity.Order;
import com.lishiyu.BuyTickets.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private OrderSender orderSender;

	@Test
	public void testOrderSend() throws Exception {
		Order order = new Order();
		order.setId("2018091200000000001");
		order.setName("测试订单");
		order.setMessageId(System.currentTimeMillis() + "_" + UUID.randomUUID().toString());

		orderSender.send(order);
	}

}
