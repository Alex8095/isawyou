/**
 * 
 */
package com.frogorf.isawyou.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.frogorf.domain.BaseEntity;

/** @author Tsurkin Alex
 * @version */
@Entity
@Table(name = "user")
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "first_name")
	@NotEmpty(message = "{validation.firstname.NotEmpty.message}")
	@Size(min = 3, max = 60, message = "{validation.firstname.Size.message}")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "{validation.lastname.NotEmpty.message}")
	@Size(min = 1, max = 60, message = "{validation.lastname.Size.message}")
	private String lastName;

	@Column(name = "birth_date")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private DateTime birthDate;

	@Column(name = "visit_date")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private DateTime visitDate = new DateTime();

	@Column(name = "registration_date")
	@Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm")
	private DateTime registrationDate;

	@Column
	private String description;

	@Column
	@NotEmpty(message = "{validation.login.NotEmpty.message}")
	@Size(min = 3, max = 60, message = "{validation.login.Size.message}")
	private String login;

	@Column
	@NotEmpty(message = "{validation.password.NotEmpty.message}")
	@Size(min = 6, max = 60, message = "{validation.password.Size.message}")
	private String password;

	@Column
	@NotEmpty(message = "{validation.telephone.NotEmpty.message}")
	@Digits(fraction = 0, integer = 10)
	private String telephone;

	public User() {
		if (this.isNew())
			registrationDate = new DateTime();
	}

	@Override
	public String toString() {
		return String.format("User[id=%s, firstName='%s', lastName='%s']", id, firstName, lastName);
	}

	/** @return the firstName */
	public String getFirstName() {
		return firstName;
	}

	/** @param firstName the firstName to set */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** @return the lastName */
	public String getLastName() {
		return lastName;
	}

	/** @param lastName the lastName to set */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** @return the birthDate */
	public DateTime getBirthDate() {
		return birthDate;
	}

	/** @param birthDate the birthDate to set */
	public void setBirthDate(DateTime birthDate) {
		this.birthDate = birthDate;
	}

	/** @return the visitDate */
	public DateTime getVisitDate() {
		return visitDate;
	}

	/** @return the description */
	public String getDescription() {
		return description;
	}

	/** @param description the description to set */
	public void setDescription(String description) {
		this.description = description;
	}

	/** @return the login */
	public String getLogin() {
		return login;
	}

	/** @param login the login to set */
	public void setLogin(String login) {
		this.login = login;
	}

	/** @return the password */
	public String getPassword() {
		return password;
	}

	/** @param password the password to set */
	public void setPassword(String password) {
		this.password = password;
	}

	/** @return the telephone */
	public String getTelephone() {
		return telephone;
	}

	/** @param telephone the telephone to set */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
