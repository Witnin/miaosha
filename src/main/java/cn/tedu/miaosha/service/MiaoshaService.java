package cn.tedu.miaosha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.miaosha.domain.MiaoshaUser;
import cn.tedu.miaosha.domain.OrderInfo;
import cn.tedu.miaosha.vo.GoodsVo;

@Service
public class MiaoshaService {
	
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	OrderService orderService;

	@Transactional
	public OrderInfo miaosha(MiaoshaUser user, GoodsVo goods) {
		//减库存 下订单 写入秒杀订单
		goodsService.reduceStock(goods);
		//order_info maiosha_order
		return orderService.createOrder(user, goods);
	}
	
}
