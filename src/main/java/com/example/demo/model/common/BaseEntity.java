package com.example.demo.model.common;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {
    @Id                 private String id;
    @CreatedDate        private Instant createdAt;
    @LastModifiedDate   private Instant updatedAt;
                        private String  tenantId;
                        /* Il concetto di abilita/disabilita assume il suo significato sempre nel contesto specifico */
                        private boolean enabled = false;
    public BaseEntity(){}
}