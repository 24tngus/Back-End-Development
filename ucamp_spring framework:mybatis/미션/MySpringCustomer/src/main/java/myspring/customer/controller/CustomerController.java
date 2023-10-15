package myspring.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.customer.sevice.CustomerService;
import myspring.customer.vo.CustomerVO;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	public CustomerController() {
		System.out.println(this.getClass().getName() + "생성자 호출됨");
	}
	
	// db에서 가져오고 화면에 보이는 것도 함께 설정 
	// View와 Model을 한꺼번에 전달하는 방법
	@RequestMapping("/customerList.do")
	public ModelAndView customerList() {
		// service 불러와서 리스트로 받기
		// 뿌려줄 jsp 페이지를 ModelAndView 객체에 담음 (viewName=jsp파일 이름(jsp확장자 없이 이름만 기재), modelName=키값(forEach구문의 items), modelList=서비스에서 받아온 list 기재)
		// key 값(customerList)과 일치하여 list 변수명 바꾸기 
		List<CustomerVO> customerVOList = customerService.getCustomerList();
		// ModelAndView(viewName, keyName, valueObject)
		return new ModelAndView("customerList", "customerList", customerVOList);
	}
	
	//getUser.do?id=dooly
	// View와 Model을 분리해서 전달하는 방법
	@RequestMapping("/getUser.do")
	public String getUser(@RequestParam("id") String userId, Model model) {
		// @requestparam을 이용하여 ?(쿼리 스트링) 다음의 id 값 가져올 수 있음
		// 받아온 customerVO를 model에 담아줌
		CustomerVO userVO = customerService.getUser(userId);
		model.addAttribute("customer", userVO);
		// 페이지 이름 return 
		return "customerInfo";
	}
	
}
