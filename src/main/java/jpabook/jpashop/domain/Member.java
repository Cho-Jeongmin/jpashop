package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  private String name;

  @Embedded
  private Address address;

  @OneToMany(mappedBy = "member") // Member : Order = 일대다, mappedBy: 연관관계의 주인이 아니라는 뜻 (읽기 전용)
  private List<Order> orders = new ArrayList<>();
}
