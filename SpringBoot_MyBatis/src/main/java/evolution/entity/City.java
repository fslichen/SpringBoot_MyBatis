package evolution.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class City implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String state;
	private String country;
}
