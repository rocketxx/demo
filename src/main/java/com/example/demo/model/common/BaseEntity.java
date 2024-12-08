package com.example.demo.model.common;

import java.time.Instant;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    @Id                 private UUID id;
    @CreatedDate        private Instant createdAt;
    @LastModifiedDate   private Instant updatedAt;
                        private String  tenantId;
                        private boolean enabled = false;
    public BaseEntity(){}
}