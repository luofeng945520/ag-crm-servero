package com.cn.ag.data.dao.interf;

import com.cn.ag.data.domain.sd.AgUsers;

import java.util.List;
import java.util.Map;

public interface AgUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AgUsers record);

    int insertSelective(AgUsers record);

    AgUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AgUsers record);

    int updateByPrimaryKey(AgUsers record);

    /**
     * 根据用户名(账号)查询
     * @author:faker
     * @dateTime:2018年9月14日上午8:42:11
     * @parem:AgUsers
     * @description:
     */
    AgUsers selectByUserName(String userName);

    int getDataTotalOfContions(Map<String, Object> args);

    AgUsers selectPrimaryKeySelective(AgUsers record);


    List<AgUsers> selectListAgUsers(String[] arry);

    /**
     * @Title: getListResident
     * @Description: 查询全部驻场设计师
     * @param @return    设定文件
     * @return List<AgUsers>    返回类型
     * @throws
     */
    List<AgUsers> getListResident(Map<String, Object> args);

    /**
     *
     * @Title: getListResident
     * @Description: 查询全部驻场设计师条数
     * @param @return    设定文件
     * @return List<AgUsers>    返回类型
     * @throws
     */
    int getListResidentNum(Map<String, Object> args);

    /**
     * @Title: getListResident
     * @Description: 查询全部驻场设计师(自画自审)  设计主管
     * @param @return    设定文件
     * @return List<AgUsers>    返回类型
     * @throws
     */
    List<AgUsers> getListResidents(Map<String, Object> args);

    /**
     * @Title: getListResident
     * @Description: 查询全部驻场设计师(自画自审)  设计主管条数
     * @param @return    设定文件
     * @return List<AgUsers>    返回类型
     * @throws
     */
    int getListResidentNums(Map<String, Object> args);

    /**
     *
     * @Title: selectAgUsersIn
     * @Description: 查询工厂方的角色
     * @param @return    设定文件
     * @return List<AgUsers>    返回类型
     * @throws
     */
    List<AgUsers> selectAgUsersIn();


    /**
     * @Title: selectPhone
     * @Description: 通过电话找用户
     * @param @param phone
     * @param @return    设定文件
     * @return AgUsers    返回类型
     * @date 2019年2月28日 上午11:06:52
     * @throws
     */
    AgUsers selectPhone(String phone);

    /**
     * @Title: selectQxUserByNameAndPass
     * @Description: 按 账号密码查询用户
     * @param record
     * @return    设定文件
     * 2019年3月6日 下午4:12:32
     * @throws
     */
    AgUsers selectQxUserByNameAndPass(AgUsers record);


    /**
     * @Title: selectDealerId
     * @Description: 通过经销商id进行查询
     * @param id
     * @return List<AgUsers>    返回类型
     * @date 2019年4月10日 上午9:47:03
     * @throws
     */
    List<AgUsers> selectDealerId(String id);

    /**
     * @Description: 通过ID查用户名称
     * @param id
     * @return String  
     * 2019年6月12日 下午10:35:51
     * @throws
     */
    String selectFullNameById(Long id);

    /**
     * @Title: selectAgUsersFullNameByddid
     * @Description: (通过钉钉id查询对应的人名)
     * @return
     * 2019年6月29日 下午12:43:53
     * @throws
     */
    String selectAgUsersFullNameByddid(String ddid);

    List<AgUsers> selectShopownerDdIdByOrderCode(String orderCode);

    AgUsers selectByDealerIdAndPhone(String id);

    /**
     * @Author: Simple
     * @Description: 根据门店id，查询门店店长
     * @Date:   2019/9/3  11:06
     * @param:
     * @return:
     */
    AgUsers selectStoreManager(Long storeId);

}