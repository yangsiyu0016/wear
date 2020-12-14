package com.wangong.admin_web.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@SuppressWarnings(value = "all")
public class Response {

    /**
     * 默认成功响应码
     */
    private static final Integer DEAFAULT_SUCCESS_CODE = HttpStatus.OK.value();
    /**
     * 默认成功响应信息
     */
    private static final String DEAFAULT_SUCCESS_MSG = "请求/处理成功！";
    /**
     * 默认失败响应码
     */
    private static final Integer DEAFAULT_FAILURE_CODE = HttpStatus.INTERNAL_SERVER_ERROR.value();
    /**
     * 默认失败响应信息
     */
    private static final String DEAFAULT_FAILURE_MSG = "请求/处理失败！";

    @Getter
    private Meta meta;

    @Getter
    private Object data;


    /*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓成功↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/

    /**
     * 处理成功响应，返回自定义响应码、信息和数据。
     *
     * @param msg  处理结果信息
     * @return 响应对象
     */
    public Response success(String msg) {
        this.meta = new Meta(DEAFAULT_SUCCESS_CODE, msg);
        this.data = null;
        return this;
    }

    /**
     * 处理成功响应，返回自定义响应码、信息和数据。
     *
     * @param data 返回数据
     * @return 响应对象
     */
    public Response success(Object data) {
        this.meta = new Meta(DEAFAULT_SUCCESS_CODE, DEAFAULT_SUCCESS_MSG);
        this.data = data;
        return this;
    }

    /**
     * 处理成功响应，返回自定义响应码、信息和数据。
     *
     * @param msg  处理结果信息
     * @param data 返回数据
     * @return 响应对象
     */
    public Response success(String msg, Object data) {
        this.meta = new Meta(DEAFAULT_SUCCESS_CODE, msg);
        this.data = data;
        return this;
    }

    /**
     * 处理成功响应，返回自定义响应码、信息和数据。
     *
     * @param httpStatus HTTP 响应码
     * @param msg  处理结果信息
     * @param data 返回数据
     * @return 响应对象
     */
    public Response success(HttpStatus httpStatus, String msg, Object data) {
        this.meta = new Meta(httpStatus.value(), msg);
        this.data = data;
        return this;
    }


    /*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓失败↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/

    /**
     * 处理失败响应，返回自定义响应码、信息和数据。
     *
     * @param msg 处理结果信息
     * @return 响应对象
     */
    public Response failure(String msg) {
        this.meta = new Meta(DEAFAULT_FAILURE_CODE, msg);
        this.data = null;
        return this;
    }

    /**
     * 处理失败响应，返回自定义响应码、信息和数据。
     *
     * @param data 返回数据
     * @return 响应对象
     */
    public Response failure(Object data) {
        this.meta = new Meta(DEAFAULT_FAILURE_CODE, DEAFAULT_FAILURE_MSG);
        this.data = data;
        return this;
    }

    /**
     * 处理失败响应，返回自定义响应码、信息和数据。
     *
     * @param msg  处理结果信息
     * @param data 返回数据
     * @return 响应对象
     */
    public Response failure(String msg, Object data) {
        this.meta = new Meta(DEAFAULT_FAILURE_CODE, msg);
        this.data = data;
        return this;
    }

    /**
     * 处理失败响应，返回自定义响应码、信息和数据。
     *
     * @param httpStatus HTTP 响应码
     * @param msg  处理结果信息
     * @param data 返回数据
     * @return 响应对象
     */
    public Response failure(HttpStatus httpStatus, String msg, Object data) {
        this.meta = new Meta(httpStatus.value(), msg);
        this.data = data;
        return this;
    }

    /**
     * 元数据，包含响应码和信息。
     * 修改人： <br>
     * 修改时间： <br>
     * 修改备注： <br>
     * </p>
     */
    @Data
    @AllArgsConstructor
    private class Meta {

        /**
         * 处理结果代码，与 HTTP 状态响应码对应
         */
        private Integer code;

        /**
         * 处理结果信息
         */
        private String msg;
    }

}
