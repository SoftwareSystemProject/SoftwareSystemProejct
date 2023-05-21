package com.example.withus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.withus.domain.Cart;


@Controller
@SessionAttributes("sessionCart")
public class RemoveItemFromCartController { 

	@RequestMapping("/shop/removeItemFromCart.do")
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") String workingItemId,
			@ModelAttribute("sessionCart") Cart cart
		) throws Exception {
		cart.removeItemById(workingItemId);
		return new ModelAndView("Cart", "cart", cart);
	}
}
