package com.nexDew.SpringBootGraphQL.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {

    @Id
    private String orderId;
    private String orderName;
    private String orderDescription;
    private Double orderPrice;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
