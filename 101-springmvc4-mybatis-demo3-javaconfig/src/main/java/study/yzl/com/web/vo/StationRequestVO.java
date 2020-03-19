package study.yzl.com.web.vo;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.annotations.ApiIgnore;
import study.yzl.com.web.vo.validateGroup.StationAddOne;
import study.yzl.com.web.vo.validateGroup.StationControllerAddOne;
import study.yzl.com.web.vo.validateGroup.StationControllerCreate;
import study.yzl.com.web.vo.validateGroup.StationControllerUpdateById;
import study.yzl.com.web.vo.validateGroup.UserAddUser;
import study.yzl.com.web.vo.validateGroup.UserUpdateUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "station 请求对象")
public class StationRequestVO implements RequestVO {

	@NotBlank(groups = { StationControllerAddOne.class, StationControllerCreate.class }, message = "code不可为空")
	@NotBlank(groups = { StationControllerCreate.class }, message = "code不可为空")
//	@NotBlank(message = "code22不可为空")
	@ApiModelProperty(example = "100", required = true, value = "用户编号")
	private String code;
	@NotBlank(groups = { StationControllerAddOne.class, StationControllerCreate.class }, message = "name不可为空")
	private String name;

	@NotNull(groups = { StationControllerCreate.class }, message = "status不可为空")
	@Digits(groups = { StationControllerCreate.class }, integer = 1, fraction = 0)
	@Range(groups = { StationControllerCreate.class }, min = 0, max = 2, message = "status值须为 0、1 、2其中之一")
	private Integer status;

	@NotNull(groups = { StationControllerUpdateById.class }, message = "id不可为空")
	@Digits(groups = { StationControllerUpdateById.class }, integer = 7, fraction = 0)
	@ApiModelProperty(allowEmptyValue = true)
	private Integer id;

//	@NotNull(groups = { StationControllerUpdateById.class }, message = "createdAt不可为空")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date createdAt;
//	@NotNull(groups = { StationControllerUpdateById.class }, message = "updatedAt不可为空")
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	private Date updatedAt;
	

}
