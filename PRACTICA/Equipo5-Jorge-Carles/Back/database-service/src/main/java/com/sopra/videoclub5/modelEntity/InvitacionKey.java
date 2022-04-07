package com.sopra.videoclub5.modelEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.sql.rowset.serial.SerialArray;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvitacionKey implements Serializable {
	
	@Column(name = "num_socio")
	private Integer numSocio;

}
