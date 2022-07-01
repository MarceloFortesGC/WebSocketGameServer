package com.rabbitmq.web;

import com.rabbitmq.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(allowCredentials = "*")
public class MessagingController {

  @Autowired
  private SimpMessagingTemplate simpMessagingTemplate;

  @MessageMapping("/move")
  @SendTo("/topic/move")
  public Player send(@Payload Player player)  {
    return player;
  }

  @MessageMapping("/position.{nome}")
  public void getUsersOnline(@Payload Player player, @DestinationVariable String nome){
    simpMessagingTemplate.convertAndSend("/topic/position."+ nome, player);
  }
}