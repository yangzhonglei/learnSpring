package study.yzl.com.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenuRequestVO implements RequestVO{
	
	
	 private Integer id;

	    private String title;

	    private String url;

	    private Integer menuId;

	    private Integer ord;

	    private String icon;

	    private Byte leaf;

	    private Byte flag;


}
