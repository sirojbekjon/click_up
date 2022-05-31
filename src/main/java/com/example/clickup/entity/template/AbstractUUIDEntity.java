package com.example.clickup.entity.template;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class AbstractUUIDEntity extends AbsMainEntitiy{

    @Id
    @GeneratedValue(generator = "uuid2")
//    @Type(type = "org.hibernate.PostgresUUIDType")
//    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.UUIDGenerator")
    private UUID id;

}
