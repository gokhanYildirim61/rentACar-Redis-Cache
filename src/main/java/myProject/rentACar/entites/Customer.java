package myProject.rentACar.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.rentACar.core.entites.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customers")
public class Customer extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="surName")
    private String surName;

    @Column(name="birthDate")
    private Integer birthDate;

    @Column(name="tcNo")
    private long tcNo;


}
