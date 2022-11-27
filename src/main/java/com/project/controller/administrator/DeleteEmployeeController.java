package com.project.controller.administrator;

import com.project.utility.ModelAndViewUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.LoginDao;
import com.project.dao.administrator.DeleteEmployeeDao;

@Controller
public class DeleteEmployeeController 
{
	@Autowired
	DeleteEmployeeDao dao;
	
	@Autowired
	LoginDao infoLog;

	@Autowired
	ModelAndViewUtility modelAndViewUtility;
	
	@RequestMapping("/deleteEmployee.html")
	public ModelAndView delete(@RequestParam("eid")String eid)
	{
		try
		{
			infoLog.logActivities("in DeleteEmployeeController-delete: got= "+eid);
			int res=dao.delete(eid);
			infoLog.logActivities("returned to DeleteEmployeeController-delete: got= "+res);
			
			if(res==1)
			{
				ModelAndView mv= new ModelAndView();
				return modelAndViewUtility.returnModelAndView("successPage",null,null);
			}
			else
			{   throw new Exception();  }
		}
		catch(Exception e)
		{
			infoLog.logActivities("in DeleteEmployeeController-delete: "+e);
			return modelAndViewUtility.returnModelAndView("failure","error",e);
		}
			
	}

}
