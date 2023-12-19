package edu.lingnan.luckycloud.luckycore.modules.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.lingnan.luckycloud.luckycore.modules.user.domain.dto.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends BaseMapper<User> {

}
