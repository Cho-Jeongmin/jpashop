package jpabook.jpashop.domain.item;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글테이블 전략
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
public abstract class Item { // 추상 클래스

  @Id
  @GeneratedValue
  @Column(name = "item_id")
  private Long id;

  private String name;

  private int price;

  private int stockQuantity;

  @ManyToMany(mappedBy = "items")
  private List<Category> categories = new ArrayList<>();
}
