package com.rabbitmq.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Player {
  private String name;
  private String nome;
  private Integer coordX;
  private Integer coordY;
  private String status;
  private String color;
}
