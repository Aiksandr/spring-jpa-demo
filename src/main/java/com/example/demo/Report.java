package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Data
@Entity
@NoArgsConstructor
@Table(name = "report")
public class Report {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "createDate")
    private Timestamp createDate;

    public Report(String id) {
        this.id = id;
        this.createDate = Timestamp.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
    }
}
