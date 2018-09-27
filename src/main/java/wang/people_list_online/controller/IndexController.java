package wang.people_list_online.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import wang.people_list_online.pojo.SubmitPeople;
import wang.people_list_online.service.PeopleService;

@Controller
public class IndexController {
	private static final String AJAX_CHARSET="text/html;charset=UTF-8";
	@Autowired
	private PeopleService ps;
	
	//接收新增人员请求
	@RequestMapping("/insertPeople.do")
	public String insertPeople(HttpServletRequest request,String iname,String isex,Integer iage) {
		request.setAttribute("result", ps.doInsertPeople(iname, isex, iage));
		return "/showIndex.do";
	}
	@RequestMapping(value="/inertPeopleByAjax.ajax",produces=AJAX_CHARSET)
	public @ResponseBody String inertPeopleByAjax(SubmitPeople sp) {
		return ps.doInsertPeople(sp.getIname(), sp.getIsex(), sp.getIage());
	}
	
	@RequestMapping("/showIndex.do")
	public String showIndex(HttpServletRequest request) {
		request.setAttribute("people", ps.getAllPeoples());
		return "/index.jsp";
	}
	//使用Ajax得到所有People列表
		@RequestMapping(value="/showPeopleListByAjax.ajax",produces=AJAX_CHARSET)
		public @ResponseBody String showPeopleListByAjax() {
			return ps.getAllPeopleByJson();
		}
	
	@RequestMapping("/removePeople.do")
	public String removePeople(HttpServletRequest request,String peoplesId) {
		request.setAttribute("result", ps.doRemovePeople(peoplesId));
		return "/showIndex.do";
	}
	@RequestMapping(value="/removePeopleByAjax.ajax",produces=AJAX_CHARSET)
	public @ResponseBody String removePeopleByAjax(String peoplesId) {
		return ps.doRemovePeople(peoplesId);
	}
	
	public PeopleService getPs() {
		return ps;
	}

	public void setPs(PeopleService ps) {
		this.ps = ps;
	}

}