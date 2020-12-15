package com.wangong.goods_web.controller;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.wangong.common.domain.goods.GoodsPicture;
import com.wangong.common.service.GoodsPictureService;
import com.wangong.goods_web.config.UploadPeoperies;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品图片控制层
 */
@PropertySource("classpath:downloadIp.properties")
@RestController
@RequestMapping("/goodsPic")
public class GoodsPictureController {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadPeoperies prop;

    @Value("${downloadIp}")
    private String uploadImg;

    @Resource
    private GoodsPictureService goodsPictureService;

    /**
     *
     * @param files
     * @return
     */
    @PostMapping("/upload")
    public Map<Object, Object> uploadImg(@RequestParam("files")MultipartFile[] files) {
        Map<Object, Object> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        try {
            for (MultipartFile file: files) {
                String extensionName = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
                StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extensionName, null);
                String url = prop.getBaseUrl() + storePath.getFullPath();
                list.add(url);
            }
            map.put("result", "success");
            map.put("urls", list);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据商品id获取商品图片集合
     * @param goodsId
     * @return
     */
    @GetMapping("/getGoodsPicByGoodsId")
    public Map<Object, Object> getGoodsPicByGoodsId(@RequestParam("goodsId") String goodsId){
        Map<Object, Object> map = new HashMap<>();
        try {
            List<GoodsPicture> goodsPictures = goodsPictureService.getGoodsPicByGoodsId(goodsId);
            map.put("result", "success");
            map.put("goodsPictures", goodsPictures);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    @GetMapping("/getGoodsPicById")
    public Map<Object, Object> getGoodsPicById(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            GoodsPicture goodsPicture = goodsPictureService.getGoodsPicById(id);
            map.put("result", "success");
            map.put("goodsPictures", goodsPicture);
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 添加商品图片
     * @param goodsPicture
     * @return
     */
    @PostMapping("/add")
    public Map<Object, Object> addGoodsPic(@RequestBody GoodsPicture goodsPicture) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsPictureService.addGoodsPic(goodsPicture);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 更新商品图片
     * @param goodsPicture
     * @return
     */
    @PostMapping("/edit")
    public Map<Object, Object> editGoodsPic(@RequestBody GoodsPicture goodsPicture) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsPictureService.editGoodsPic(goodsPicture);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 删除商品图片
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public Map<Object, Object> deleteGoodsPic(@RequestParam("id") String id) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsPictureService.deleteGoodsPic(id);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

    /**
     * 根据商品id删除商品图片
     * @param goodsId
     * @return
     */
    @GetMapping("/deleteGoodsPicByGoodsId")
    public Map<Object,Object> deleteGoodsPicByGoodsId(@RequestParam("goodsId") String goodsId) {
        Map<Object, Object> map = new HashMap<>();
        try {
            goodsPictureService.deleteGoodsPicByGoodsId(goodsId);
            map.put("result", "success");
        }catch (Exception e) {
            map.put("result", "exception");
            map.put("exception", e.getMessage());
        }
        return map;
    }

}
