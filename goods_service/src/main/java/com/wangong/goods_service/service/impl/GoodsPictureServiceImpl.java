package com.wangong.goods_service.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.wangong.common.domain.goods.GoodsPicture;
import com.wangong.common.service.GoodsPictureService;
import com.wangong.goods_service.mapper.GoodsPictureMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 商品图片逻辑层实现
 */
@Slf4j
@Service
public class GoodsPictureServiceImpl implements GoodsPictureService {

    @Resource
    private GoodsPictureMapper goodsPictureMapper;

    /**
     * 根据商品id获取
     * @param goodsId
     * @return
     */
    @Override
    public List<GoodsPicture> getGoodsPicByGoodsId(String goodsId) {
        return goodsPictureMapper.getGoodsPicByGoodsId(goodsId);
    }

    /**
     * 根据id获取商品图片
     * @param id
     * @return
     */
    @Override
    public GoodsPicture getGoodsPicById(String id) {
        return goodsPictureMapper.getGoodsPicById(id);
    }

    /**
     * 添加商品图片
     * @param goodsPicture
     */
    @Override
    public void addGoodsPic(GoodsPicture goodsPicture) {
        goodsPicture.setId(UUID.randomUUID().toString());
        goodsPicture.setCtime(new Date());
        goodsPictureMapper.addGoodsPic(goodsPicture);
    }

    /**
     * 更新商品图片
     * @param goodsPicture
     */
    @Override
    public void editGoodsPic(GoodsPicture goodsPicture) {
        goodsPictureMapper.editGoodsPic(goodsPicture);
    }

    /**
     * 删除商品图片
     * @param id
     */
    @Override
    public void deleteGoodsPic(String id) {
        goodsPictureMapper.deleteGoodsPic(id);
    }

    /**
     * 根据商品id删除商品图片
     * @param goodsId
     */
    @Override
    public void deleteGoodsPicByGoodsId(String goodsId) {
        goodsPictureMapper.deleteGoodsPicByGoodsId(goodsId);
    }

    /**
     * 根据图片路径删除
     * @param picUrl
     */
    @Override
    public void deleteByPicUrl(String picUrl) {
        goodsPictureMapper.deleteByPicUrl(picUrl);

    }
}
