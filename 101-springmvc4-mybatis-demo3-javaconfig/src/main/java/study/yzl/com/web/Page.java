package study.yzl.com.web;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class Page<T> {
	
	
	@NotNull
	@Range(min = 1 ,max = 100)
	private Integer pageNo;
	@NotNull
	@Range(min = 1 ,max = 100)
	private Integer pageSize;
	
    private Integer total;
	
	private T object ;

}
