package com.enocaProject.enocaProject.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



import lombok.*;


@Entity
@Table(name = "Yazarlar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Yazar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ad;
	
	private String soyad; 
	
	@OneToMany(mappedBy = "yazari")
	private final List<Kitap> insertedBook = new ArrayList<>();
	
	
}
