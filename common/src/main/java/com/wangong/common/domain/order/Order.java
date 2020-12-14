package com.wangong.common.domain.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wangong.common.domain.receiver.Receiver;
import com.wangong.common.domain.seller.Seller;
import com.wangong.common.domain.user.User;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单实体类
 */
@Data
public class Order implements Serializable {

    String id;
    BigDecimal payment;//实付价格
    String paymentType;//支付类型
    String postFee;//邮费
    String status;//状态 1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭,7、待评价
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date updateTime;//更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date paymentTime;//付款时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date consignTime;//发货时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date endTime;//交易完成时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    Date closeTime;//交易关闭时间
    String shippingName;//物流名称
    String shippingCode;//物流单号
    Integer userId;//用户id
    User user;//用户
    String buyerMessage;//买家留言
    String buyerRate;//m买家是否评价
    String receiverId;//收货人id
    Receiver receiver;//收货人
    String sourceType;//订单来源
}
