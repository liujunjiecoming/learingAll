package vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName PageVO
 * @Description 分页
 * @Author JJLiu
 * @Date 19-8-12 上午10:58
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageVO {

    private Integer page;

    private Integer pageSize;


}
