package evolution.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnyEntity {
	private Integer id;
	private String name;
	public AnyEntity(String name) {
		this.name = name;
	}
}
