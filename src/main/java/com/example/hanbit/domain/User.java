package com.example.hanbit.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Long id; // 순서
	
	// 회원 ID
	@Column(length = 50, nullable = false, unique = true)
	private String username; 
	
	// 회원 비밀번호
	@Column(length = 500, nullable = false)
	private String password; 
	
	// 이름
	@Column(nullable = false, length = 10)
	private String name;
	
	
	// 이메일
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	
	//가입날짜
	@CreationTimestamp
	@Column(nullable = false)
	private Timestamp createDate;
	
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	//비상 연락처
	@Column(nullable = false)
	private String tel;
	
	@Column(nullable = false)
	private boolean foreignYN;
	
	//Rolltype
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RoleType roleType = RoleType.MEMBER;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Review> reviews;
}