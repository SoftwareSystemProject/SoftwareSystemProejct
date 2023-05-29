package com.example.withus.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.withus.domain.Cart;
import com.example.withus.domain.CartItem;
import com.example.withus.domain.GroupItem;
import com.example.withus.domain.Order;
import com.example.withus.domain.User;
import com.example.withus.service.CartService;
import com.example.withus.service.GroupItemService;
import com.example.withus.service.OrderService;
import com.example.withus.service.OrderValidator;


@RestController
@SessionAttributes({"sessionCart", "orderForm"})
public class OrderController {
	//@Autowired
	//private PetStoreFacade petStore; //나중에 userService로 바꾸기
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderValidator orderValidator;
	@Autowired
	private GroupItemService groupItemService;
	
	@Autowired
	private CartService cartService;
	
	@GetMapping("/orderTest")
	public String orderTest(Model model, String user) {
      model.addAttribute("user", "users");
      model.addAttribute("groupItem", "items");
      return "/groupItem";
	}
	
	@GetMapping("/groupItem")
	public List<GroupItem> groupItemList(){
		List<GroupItem> groupItem = groupItemService.getGroupItemList();
		System.out.println(groupItem);
		return groupItem;

	}
	
	@GetMapping(value = "/groupItem/detail/{groupItem_id}")
    public GroupItem getGroupItem(@PathVariable("groupItem_id") int groupItem_id) {
		GroupItem groupItem = groupItemService.getGroupItem(groupItem_id);
		System.out.println(groupItem);
        return groupItem;
    }
	
	@ModelAttribute("orderForm")
	public OrderForm createOrderForm() {
		return new OrderForm();
	}
	
	 @GetMapping(value = "/order")
	  public String createForm(HttpServletRequest request,
				@ModelAttribute("orderForm") OrderForm orderForm, Model model) {
		 UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		 List<GroupItem> groupItems = groupItemService.getGroupItemList();
	     model.addAttribute("user", userSession.getAccount());
	     model.addAttribute("groupItems", groupItems);
	     return "order/orderForm";
	    }
	

	 @PostMapping("/order") 
		public String initNewOrder(HttpServletRequest request,
				@ModelAttribute("orderForm") OrderForm orderForm,
				Model model
				) throws ModelAndViewDefiningException {
			UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
			//User user = petStore.getAccount(userSession.getAccount().getUsername());
			Order order = orderForm.getOrder();
			order.setUser_id(userSession.getAccount().getUser_id());
			model.addAttribute("order", order);
			return "order/confirmOrder";	
		}
	
	
	
	//카트->주문하기
		 @RequestMapping("/cart/order")
		    public String index(HttpServletRequest request,
					@ModelAttribute("sessionCart") Cart cart,
					@ModelAttribute("orderForm") OrderForm orderForm,
					Model model
					) throws ModelAndViewDefiningException {		
			 if (cart != null) {
		        // 현재 사용자
				 UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
		        // 카트에 담은 상품들
		        Cart carts = cartService.getCart();
		        carts.getSubTotal();
		        Order order = orderForm.getOrder();
		        order.setUser_id(userSession.getAccount().getUser_id());
		        model.addAttribute("order", order);
		        return "order/confirmOrder";
		    }
			 else{
					ModelAndView modelAndView = new ModelAndView("Error");
					modelAndView.addObject("message", "장바구니에 상품이 존재하지 않습니다.");
					throw new ModelAndViewDefiningException(modelAndView);
				}
				 
		 }
		 

	 @RequestMapping("/order/confirmOrder.do")
		protected ModelAndView confirmOrder(
				@ModelAttribute("orderForm") OrderForm orderForm, 
				SessionStatus status) {
		    orderService.insertOrder(orderForm.getOrder());
			ModelAndView mav = new ModelAndView("ViewOrder");
			mav.addObject("order", orderForm.getOrder());
			mav.addObject("message", "주문해주셔서 감사합니다.");
			status.setComplete(); 
			return mav;
		}
	
	 //주문 취소
		@PostMapping(value = "/orders/{order_id}/cancel")
	    public String cancelOrder(@PathVariable("order_id") int order_id) {
	        orderService.cancelOrder(order_id);
	        return "redirect:/orders";
	    }
		
		//주문 목록
		 @GetMapping("/orders")
		  public String orderList(@ModelAttribute("userSession") UserSession userSession, Model model){
		      List<Order> orders = orderService.getOrdersByUserId(userSession.getAccount().getUser_id());
		      model.addAttribute("orders", orders);
		      return "order/orderList";
		  }
		
			
		 
	@RequestMapping("/shop/newOrderSubmitted.do")
	public String bindAndValidateOrder(HttpServletRequest request,
			@ModelAttribute("orderForm") OrderForm orderForm, 
			BindingResult result) {
		if (orderForm.didShippingAddressProvided() == false) {	
			// from NewOrderForm
			orderValidator.validateCreditCard(orderForm.getOrder(), result);
			orderValidator.validateBillingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "order/orderForm";
			
			if (orderForm.isShippingAddressRequired() == true) {
				orderForm.setShippingAddressProvided(true);
				return "ShippingForm";
			}
			else {			
				return "ConfirmOrder";
			}
		}
		else {		// from ShippingForm
			orderValidator.validateShippingAddress(orderForm.getOrder(), result);
			if (result.hasErrors()) return "ShippingForm";
			return "ConfirmOrder";
		}
	}
	
	
}
