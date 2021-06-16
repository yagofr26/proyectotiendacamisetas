package com.backend.yago.modelo;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="camisetas")
public class CamisetaVO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcamiseta;
	private String nombre;
	private String precio;
	private String image;

}
