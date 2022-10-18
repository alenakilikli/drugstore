package com.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "prescription")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="drugname",nullable = false,unique = true,updatable = false)
    private String drugName;
    @Column(name = "prescriptedBy")
    @OneToOne()
    private Account prescribedBy;
    @OneToOne
    @Column(name = "prescriptedTo")
    private Account prescribedTo;
}
