package com.lxisoft.carshowroom.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {

	@Id
	@Column(name = "role_name")
	private String roleName;

	@OneToMany(mappedBy = "role")
	private Set<CarUser> carUsers;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<CarUser> getCarUsers() {
		return carUsers;
	}

	public void setCarUsers(Set<CarUser> carUsers) {
		this.carUsers = carUsers;
	}
}
