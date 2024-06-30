package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @JsonIgnore
    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "member")             //Order 클래스의 맴버 객체
    private List<Order> orders = new ArrayList<>();
}
