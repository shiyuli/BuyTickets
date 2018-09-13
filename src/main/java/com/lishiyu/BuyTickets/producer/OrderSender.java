package com.lishiyu.BuyTickets.producer;

import com.lishiyu.BuyTickets.entity.Order;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception {
        CorrelationData correlationData = new CorrelationData(order.getMessageId());

        rabbitTemplate.convertAndSend(
                "order-exchange", //exchange
                "order.default", //routingKey
                order, //消息体内容
                correlationData //correlationData 消息UID
            );
    }
}
