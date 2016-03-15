/**
 * @package com.controller
 * @author cuiyueyang
 * @date 2016-3-1 下午5:35:50
 * @todo TODO
 */
package com.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.com.Timer;
import com.domain.BusinessModel;
import com.domain.DetailModel;
import com.domain.UserModel;
import com.domain.WeeklyModel;
import com.service.UserService;
import com.service.WeeklyService;

/**
 * @author cuiyueyang
 * @data 2016-3-1 下午5:35:50
 * @todo TODO
 */
@Controller
@RequestMapping("")
public class WeeklyController {

	@Autowired
	private UserService userService;
	@Autowired
	private WeeklyService weeklyService;
	
	/**
	 * 登陆页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login.html")
	public String login(HttpSession session){
		return "login";
	}
	
	/**
	 * 全局404页面
	 * @return
	 */
	@RequestMapping(value = "/global-error-404.html")
	public String error404(){
		return "common/global-error-404";
	}
	
	/**
	 * 退出页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login-out.html")
	public ModelAndView loginOut(HttpSession session){
		session.invalidate();
		return new ModelAndView(new RedirectView("login.html"));
	}
	
	/**
	 * 登陆是否成功的跳转
	 * @param request
	 * @param session username和error
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/login-success.html", method = RequestMethod.POST)
	public ModelAndView loginSuccess(HttpServletRequest request, HttpSession session){
		try{
			request.setCharacterEncoding("UTF-8");
			String username = request.getParameter("username");
			boolean loginSuccess = userService.hasMatchUser(username);
			if(true == loginSuccess){
				session.setAttribute("username", username);
				return new ModelAndView(new RedirectView("show-my-weekly.html"));
			}else{
				session.setAttribute("error", "\""+ username + "\"用户名信息不存在");
				return new ModelAndView(new RedirectView("login-out.html"));
			}
		}catch(Exception e){
			return new ModelAndView(new RedirectView("global-error-404.html"));
		}
	}
	
	/**
	 * 展示我的所有周报
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/show-my-weekly.html")
	public ModelAndView showMyWeekly(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String username = (String) session.getAttribute("username");
		UserModel userModel = userService.findUserByName(username);
		List<WeeklyModel> models = weeklyService.findWeeklysByName(username);
		mav.addObject("usermodel", userModel);
		mav.addObject("models", models);
		return mav;
	}
	
	/**
	 * 展示本周所有人提交的周报
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/show-this-weekly.html")
	public ModelAndView showThisWeekly(HttpSession session){
		ModelAndView mav = new ModelAndView();
		String username = (String) session.getAttribute("username");
		UserModel userModel = userService.findUserByName(username);
		List<WeeklyModel> models = weeklyService.findWeeklysByThis();
		mav.addObject("usermodel", userModel);
		mav.addObject("models", models);
		return mav;
	}
	
	/**
	 * 根据weeklyid来展示周报的详细内容
	 * @param request
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value  = "/show-my-detail.html", method = RequestMethod.GET)
	public ModelAndView showMyDetail(HttpServletRequest request, HttpSession session){
		String username = (String) session.getAttribute("username");
		if(true == userService.hasMatchUser(username)){
			ModelAndView mav = new ModelAndView();
			String weeklyId = request.getParameter("weeklyid");
			UserModel userModel = userService.findUserByName(username);
			WeeklyModel weeklyModel = weeklyService.findWeeklyByWeeklyid(weeklyId);
			DetailModel detailModel = weeklyService.findDetailById(weeklyId);
			JSONArray jsonArray = JSONArray.fromObject(detailModel.getBusiness());
			List<BusinessModel> list = (List<BusinessModel>)JSONArray.toCollection(jsonArray, BusinessModel.class);
			mav.addObject("usermodel", userModel);
			mav.addObject("weeklymodel", weeklyModel);
			mav.addObject("detailmodel", detailModel);
			mav.addObject("Businessmodel", list);
			return mav;
		}else{
			return new ModelAndView(new RedirectView("login-out.html")); 
		}
	}
	
	/**
	 * 构建创建周报的页面
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/create-weekly.html")
	public ModelAndView createWeekly(HttpSession session){
		Date now = new Date();
		ModelAndView mav = new ModelAndView();
		String username = (String) session.getAttribute("username");
		if(true == userService.hasMatchUser(username)){
			UserModel userModel = userService.findUserByName(username);
			if("0".equals(userModel.getType())){
				mav.addObject("type", "个人");
			}else{
				mav.addObject("type", "团队");
			}
			mav.addObject("usermodel", userModel);
			mav.addObject("weekstart", Timer.getStartTime(now));
			mav.addObject("weekend", Timer.getEndTime(now));
			mav.addObject("startday", Timer.getStartDay(now));
			mav.addObject("endday", Timer.getEndDay(now));
			return mav;
		}else{
			return new ModelAndView(new RedirectView("login-out.html")); 
		}
	}
	
	/**
	 * 创建周报，允许创建空周报，每周只能创建一次周报
	 * @param request
	 * @param session
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	@RequestMapping(value = "/addweekly.html", method = RequestMethod.POST)
	public ModelAndView addWeekly(HttpServletRequest request,HttpSession session){
		try{
			request.setCharacterEncoding("UTF-8");
			Date now = new Date();
			WeeklyModel weeklyModel = new WeeklyModel();
			DetailModel detailModel = new DetailModel();
			String username = (String) session.getAttribute("username");
			UserModel userModel = userService.findUserByName(username);
			weeklyModel.setTitle(userModel.getRealname()+"的"+
					request.getParameter("type")+"周报"+"("+request.getParameter("datepicker")+")");
			weeklyModel.setType(userModel.getType());
			weeklyModel.setUsername(username);
			if(Timer.checkTime(request.getParameter("datepicker"), now)){
				weeklyModel.setIslatesubmit("0");
			}else{
				weeklyModel.setIslatesubmit("1");
			}
			weeklyModel.setDatepicker(request.getParameter("datepicker"));
			detailModel.setMembers(request.getParameter("members"));
			detailModel.setImportant(request.getParameter("important"));
			detailModel.setTasknum("".equals(request.getParameter("tasknum"))?0:Integer.valueOf(request.getParameter("tasknum")));
			detailModel.setOnlinenum("".equals(request.getParameter("onlinenum"))?0:Integer.valueOf(request.getParameter("onlinenum")));
			detailModel.setRunnum("".equals(request.getParameter("runnum"))?0:Integer.valueOf(request.getParameter("runnum")));
			detailModel.setBugnum("".equals(request.getParameter("allbugnum"))?0:Integer.valueOf(request.getParameter("allbugnum")));
			List<BusinessModel> list = new LinkedList<BusinessModel>();
			for(int i=1;;i++){
				if(request.getParameter("businessname"+String.valueOf(i)) == null){
					break;
				}
				BusinessModel bm = new BusinessModel();
				bm.setBusinessname(request.getParameter("businessname"+String.valueOf(i)));
				bm.setProductname(request.getParameter("productname"+String.valueOf(i)));
				bm.setPriority(request.getParameter("priority"+String.valueOf(i)));
				bm.setProgress(request.getParameter("progress"+String.valueOf(i)));
				bm.setBugnum(request.getParameter("bugnum"+String.valueOf(i)));
				bm.setPerson(request.getParameter("person"+String.valueOf(i)));
				bm.setBusinessdescription(request.getParameter("businessdescription"+String.valueOf(i)));
				list.add(bm);
			}
			detailModel.setBusiness(JSONArray.fromObject(list).toString());
			detailModel.setDescription(request.getParameter("description"));
			detailModel.setNext(request.getParameter("next"));
			weeklyService.addWeekly(weeklyModel, detailModel);
			return new ModelAndView(new RedirectView("show-my-weekly.html"));
		}catch(Exception e){
			return new ModelAndView(new RedirectView("global-error-404.html"));
		}
	}
	
	/**
	 * 获取更新页面
	 * @param request
	 * @param session
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/update-weekly.html", method = RequestMethod.GET)
	public ModelAndView getUpdateWeekly(HttpServletRequest request, HttpSession session){
		String username = (String) session.getAttribute("username");
		if(true == userService.hasMatchUser(username)){
			ModelAndView mav = new ModelAndView();
			String weeklyId = request.getParameter("weeklyid");
			UserModel userModel = userService.findUserByName(username);
			WeeklyModel weeklyModel = weeklyService.findWeeklyByWeeklyid(weeklyId);
			DetailModel detailModel = weeklyService.findDetailById(weeklyId);
			JSONArray jsonArray = JSONArray.fromObject(detailModel.getBusiness());
			List<BusinessModel> list = (List<BusinessModel>)JSONArray.toCollection(jsonArray, BusinessModel.class);
			mav.addObject("usermodel", userModel);
			mav.addObject("weeklymodel", weeklyModel);
			mav.addObject("detailmodel", detailModel);
			mav.addObject("Businessmodel", list);
			return mav;
		}else{
			return new ModelAndView(new RedirectView("login-out.html")); 
		}
	}
	
	/**
	 * 更新周报信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateweekly.html", method = RequestMethod.POST)
	public ModelAndView updateWeekly(HttpServletRequest request){
		try{
			request.setCharacterEncoding("UTF-8");
			DetailModel detailModel = new DetailModel();
			detailModel.setWeeklyid(Integer.valueOf(request.getParameter("weeklyid")));
			detailModel.setImportant(request.getParameter("important"));
			detailModel.setTasknum("".equals(request.getParameter("tasknum"))?0:Integer.valueOf(request.getParameter("tasknum")));
			detailModel.setOnlinenum("".equals(request.getParameter("onlinenum"))?0:Integer.valueOf(request.getParameter("onlinenum")));
			detailModel.setRunnum("".equals(request.getParameter("runnum"))?0:Integer.valueOf(request.getParameter("runnum")));
			detailModel.setBugnum("".equals(request.getParameter("allbugnum"))?0:Integer.valueOf(request.getParameter("allbugnum")));
			List<BusinessModel> list = new LinkedList<BusinessModel>();
			for(int i=1;;i++){
				if(null == request.getParameter("businessname"+String.valueOf(i))){
					break;
				}
				BusinessModel bm = new BusinessModel();
				bm.setBusinessname(request.getParameter("businessname"+String.valueOf(i)));
				bm.setProductname(request.getParameter("productname"+String.valueOf(i)));
				bm.setPriority(request.getParameter("priority"+String.valueOf(i)));
				bm.setProgress(request.getParameter("progress"+String.valueOf(i)));
				bm.setBugnum(request.getParameter("bugnum"+String.valueOf(i)));
				bm.setPerson(request.getParameter("person"+String.valueOf(i)));
				bm.setBusinessdescription(request.getParameter("businessdescription"+String.valueOf(i)));
				list.add(bm);
			}
			detailModel.setBusiness(JSONArray.fromObject(list).toString());
			detailModel.setDescription(request.getParameter("description"));
			detailModel.setNext(request.getParameter("next"));
			weeklyService.updateDetail(detailModel);
			return new ModelAndView(new RedirectView("show-my-weekly.html"));
		}catch(Exception e){
			return new ModelAndView(new RedirectView("global-error-404.html"));
		}
	}
	
}
