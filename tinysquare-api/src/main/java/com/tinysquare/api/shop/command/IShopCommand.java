package com.tinysquare.api.shop.command;

import com.tinysquare.commons.vo.ResponseVo;

public interface IShopCommand {

	/**
	 * 店铺详情
	 * 
	 * @param id
	 * @return
	 */
	public ResponseVo detail(Long id);

	/**
	 * 更新店铺信息
	 * @param token
	 * @param avator
	 * @param name
	 * @param tel
	 * @param brief
	 * @param address
	 * @param imgs
	 * @return
	 */
	public ResponseVo update(String token, String avator, String name, String tel, String brief, String address, String[] imgs);

	/**
	 * 修改店铺名称
	 * 
	 * @param token
	 * @param name
	 * @return
	 */
	public ResponseVo updateName(String token, String name);

	/**
	 * 修改店铺电话号码
	 * 
	 * @param token
	 * @param tel
	 * @return
	 */
	public ResponseVo updateTel(String token, String tel);

	/**
	 * 修改店铺简介
	 * 
	 * @param token
	 * @param brief
	 * @return
	 */
	public ResponseVo updateBrief(String token, String brief);

	/**
	 * 修改店铺地址
	 * 
	 * @param token
	 * @param address
	 * @return
	 */
	public ResponseVo updateAddress(String token, String address);

	/**
	 * 修改店铺头像
	 * 
	 * @param token
	 * @param avator
	 * @return
	 */
	public ResponseVo updateAvator(String token, String avator);

	/**
	 * 修改店铺照片
	 * 
	 * @param token
	 * @param imgs
	 *            店铺的全部图片地址
	 * @return
	 */
	public ResponseVo updateImgs(String token, String[] imgs);

}
