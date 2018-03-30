package com.rewardshoop.adminController;

import com.rewardshoop.service.LoginAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("loginAdmin")
public class LoginAdminController {

    @Autowired
    private LoginAdminService loginAdminService;

    /**
     * 登陆
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");
        int id = loginAdminService.login(adminName, password);
        if (id == 0) {
            mv.setViewName("index");
            mv.addObject("errMsg", "用户不存在!");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            mv.setViewName("main/main");
        }
        return mv;
    }

    /**
     * 登出,清除session中的Id
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "signOut", method = RequestMethod.GET)
    public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        mv.setViewName("index");
        return mv;
    }
}
