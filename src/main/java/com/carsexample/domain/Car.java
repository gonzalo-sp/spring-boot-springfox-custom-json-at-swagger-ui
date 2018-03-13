package com.carsexample.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="\"Car\"", catalog="postgres", schema="public")
public @NoArgsConstructor @Getter @Setter class Car {
	
	@Id
	@GenericGenerator(name = "carSequenceGenerator", strategy = "increment")
	@GeneratedValue(generator = "carSequenceGenerator")
	private Long id;
	
	@JsonProperty("id_car")
	@Column(name="id_car", nullable = false)
	@NotNull
	private Long idCar;
	
	@JsonProperty("id_user")
	@Column(name="id_user", nullable = false)
	@NotNull
	private Long idUser;
	
	@JsonProperty("brand")
	@Column(name="brand", nullable = false)
	@NotEmpty
	private String brand;
	
	@JsonProperty("model")
	@Column(name="model", nullable = false)
	@NotEmpty
	private String model;
	
	@JsonProperty("is_default")
	@Column(name="is_default", nullable = true)
	private Boolean isDefault = true;
	
	@JsonProperty("created_at")
	@Column(name="created_at", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable=false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
}
