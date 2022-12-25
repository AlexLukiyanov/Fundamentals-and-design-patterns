package com.geekbrains.spring.web.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<OrderItem> items;

    private Integer totalPrice;

    private String address;

    private String phone;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Order(Builder builder) {
        setId(builder.id);
        setUsername(builder.username);
        setItems(builder.items);
        setTotalPrice(builder.totalPrice);
        setAddress(builder.address);
        setPhone(builder.phone);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder newBuilder(Order copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.username = copy.getUsername();
        builder.items = copy.getItems();
        builder.totalPrice = copy.getTotalPrice();
        builder.address = copy.getAddress();
        builder.phone = copy.getPhone();
        builder.createdAt = copy.getCreatedAt();
        builder.updatedAt = copy.getUpdatedAt();
        return builder;
    }

    public static final class Builder {
        private Long id;
        private String username;
        private List<OrderItem> items;
        private Integer totalPrice;
        private String address;
        private String phone;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder items(List<OrderItem> items) {
            this.items = items;
            return this;
        }

        public Builder totalPrice(Integer totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
