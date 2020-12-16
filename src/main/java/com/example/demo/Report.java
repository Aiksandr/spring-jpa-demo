package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@AllArgsConstructor
@Table(name = "report")
public class Report {

    @Id
    private String id;

    private LocalDateTime createDate;

}
