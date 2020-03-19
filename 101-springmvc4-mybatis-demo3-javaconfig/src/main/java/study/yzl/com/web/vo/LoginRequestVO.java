package study.yzl.com.web.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.yzl.com.web.vo.validateGroup.Login;
import study.yzl.com.web.vo.validateGroup.Logout;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestVO implements Serializable{

	private static final long serialVersionUID = 5832650370943858368L;
	
	@NotBlank(message = "acct不可为空" ,groups = { Login.class ,Logout.class })
	private String acct ;
	
	
	@NotBlank(message = "password不可为空",groups = Login.class )
	private String password ;

}
