package study.yzl.com.web.vo;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.yzl.com.web.vo.validateGroup.Login;
import study.yzl.com.web.vo.validateGroup.Logout;
import study.yzl.com.web.vo.validateGroup.UserAddUser;
import study.yzl.com.web.vo.validateGroup.UserFindByConditionPaged;
import study.yzl.com.web.vo.validateGroup.UserUpdateUser;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="DifferentModel", description="Sample model for the documentation")
public class UserRequestVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6010360758571411669L;
	
	@NotNull(groups = {UserUpdateUser.class} ,message = "id不可为空")
	@Digits(groups = {UserUpdateUser.class}  ,integer = 7,fraction = 0)
	private Integer id ;
	
	@NotBlank(groups = {UserAddUser.class} , message = "code不可为空" )
    private String code;
	
	@NotBlank(groups = {UserAddUser.class} ,message = "name不可为空")
    private String name;
	
	@NotNull(groups = {UserAddUser.class} ,message = "sex不可为空")
	@Digits(groups = {UserAddUser.class} ,integer = 1,fraction = 0)
	@Range(groups = {UserAddUser.class} ,min=0, max=2,message = "sex值须为 0、1 、2其中之一") 
    private Integer sex;
	
	
    private String dept;

    private String tel;

    
    private String cellphone;
    
    @Email(groups = {UserAddUser.class} ,message = "email必须为邮箱格式")
    private String email;

    private String userAddr;
    
    
}
