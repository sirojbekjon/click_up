package com.example.clickup.entity;

import com.example.clickup.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attachment extends AbstractUUIDEntity {

    private String name;

    private String orginalName;

    private String longSize;

    private String contentType;
}
