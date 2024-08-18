package jpabook.jpashop.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
public class Address {

  private String city;
  private String street;
  private String zipcode;

  // jpa가 Address를 생성할 때, 기본 생성자가 필요함
  // protected로 해두면 아 그냥 jpa 스펙상 해놓은 거구나. 손대지 말자.
  // 아니면 주석을 달아놔도 되고. 함부로 new 하지 말라고.
  protected Address() {
  }

  // 값 타입은 처음 생성한 후 변경 불가능해야 함(Setter X)
  public Address(String city, String street, String zipcode) {
    this.city = city;
    this.street = street;
    this.zipcode = zipcode;
  }
}
