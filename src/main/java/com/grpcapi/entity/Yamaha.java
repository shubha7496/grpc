package com.grpcapi.entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Yamaha {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String model;

	private LocalDateTime date;

	private String BikeName;
	private Double price;

}
