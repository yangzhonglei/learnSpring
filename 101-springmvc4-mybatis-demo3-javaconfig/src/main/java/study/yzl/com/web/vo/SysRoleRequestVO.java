package study.yzl.com.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRoleRequestVO implements RequestVO{
	
	
	    private Integer id;

	    private String roleName;

	    private String roleDesc;

	    private Byte status;


}
