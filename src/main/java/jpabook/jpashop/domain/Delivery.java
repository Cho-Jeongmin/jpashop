package jpabook.jpashop.domain;

import static jakarta.persistence.FetchType.*;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Delivery {

  @Id
  @GeneratedValue
  @Column(name = "delivery_id")
  private Long id;

  @OneToOne(mappedBy = "delivery", fetch = LAZY)
  private Order order;

  @Embedded
  private Address address;

  @Enumerated(EnumType.STRING) //EnumType.ORDINAL 절대 쓰지 말 것. 중간에 타입 하나 더 생기면 숫자가 쭈루룩 밀려버림
  private DeliveryStatus status; //READY, COMP
}
