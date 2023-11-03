package com.enocaProject.enocaProject.Entity;


import java.util.List;

import javax.persistence.*;
import lombok.*;


@Entity
@Table(name = "Kitaplar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kitap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ad;
	
	private String tipi;
	
	@ManyToOne
	@JoinColumn(name = "yazar_id")
	private Yazar yazari;
}
