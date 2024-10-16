package com.user.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UsersData")
public class Users {
	@Id
	@Column(name = "UserId")
	private String userId;
	@Column(name = "Name")
	private String name;
	@Column(name = "EmailId")
	private String email;
	@Transient
	private List<Ratings> ratings;
}
