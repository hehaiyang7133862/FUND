package com.laungee.proj.api.web.action;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import com.laungee.proj.common.core.BaseAction;
import com.laungee.proj.common.model.TbUnAlumni;
import com.laungee.proj.common.model.TbZcotherOrder;
import com.laungee.proj.common.model.TbZcprojOrder;
import com.laungee.proj.common.util.DateUtil;

public class ZcOtherOrderBeanAction extends BaseAction {
	// 其他众筹项目捐赠单详情
	public String execute() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = null;
		// 其他众筹项目捐赠单ID
		String orderId = request.getParameter("id");
		if(orderId!=null && !"".equals(orderId)){
			try{
				bean = (TbZcotherOrder)this.getCommonBo().get(TbZcotherOrder.class, new Long(orderId));
			}catch(Exception e){}
		}
		if(bean==null){
			// 参数错误
			request.setAttribute("result", "error");
			// 返回
			return ERROR;
		}
		request.setAttribute("bean", bean);
		// 返回
		return SUCCESS;
	}
	
	// 其他众筹项目捐赠单新增
	public String insert() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 系统当前时间
		Date dateNow = this.getCommonBo().getSysDate();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = new TbZcotherOrder();
        // 其他众筹项目
        String projName = request.getParameter("projName");
        if(projName==null || "".equals(projName)){
        	// 返回状态：参数错误
        	request.setAttribute("result", "projError");
        	// 返回
        	return ERROR;
        }
        bean.setProjName(projName);
        // 其他众筹项目详情URL
        String projUrl = request.getParameter("projUrl");
        bean.setProjUrl(projUrl);
		// 捐赠单总金额
		BigDecimal orderAmoutD = null;
		String orderAmout = request.getParameter("orderAmout");
		if(orderAmout!=null && !"".equals(orderAmout)){
			try{
				orderAmoutD = new BigDecimal(orderAmout).setScale(2, 4);
			}catch(Exception e){}
		}
		if(orderAmoutD==null || orderAmoutD.doubleValue()<=0){
			// 返回状态：参数错误
			request.setAttribute("result", "orderAmoutError");
			// 返回
			return ERROR;
		}
    	bean.setOrderAmount(orderAmoutD);
        // 捐赠币种
        bean.setOrderAmountType("人民币");
        // 捐赠币种金额
        bean.setOrderAmountView(bean.getOrderAmount());
        // 捐赠币种金额计量单位
        bean.setOrderAmountUnit("元");
        // 捐赠单支付方式
    	String orderType = request.getParameter("orderType");
		bean.setOrderType(orderType);
        // 捐赠单支付状态
		bean.setOrderStatus("0");
        // 捐赠单提交时间
		bean.setOrderTime(dateNow);
        // 捐赠是否需要证书
    	String needZhengshu = request.getParameter("needZhengshu");
    	if(needZhengshu==null || !"1".equals(needZhengshu)){
    		needZhengshu = "0";
    	}
		bean.setNeedZhengshu(needZhengshu);
        // 捐赠是否需要发票
    	String needFapiao = request.getParameter("needFapiao");
    	if(needFapiao==null || !"1".equals(needFapiao)){
    		needFapiao = "0";
    	}
		bean.setNeedFapiao(needFapiao);
		// 捐赠人信息
		// 捐赠人类型(默认个人)
		bean.setPersonType("1");
		// 捐赠人数(默认1)
		bean.setPersonCount(new Long(1));
		// 捐赠人姓名
    	String personName = request.getParameter("personName");
		if(personName==null || "".equals(personName)){
			personName = "匿名";
		}
		bean.setPersonName(personName);
		// 匿名捐赠
    	String niMing = request.getParameter("niMing");
		if(niMing==null || !"1".equals(niMing)){
			niMing = "0";
		}
		bean.setNiMing(niMing);
		// 捐赠人IP
    	String personIp = request.getParameter("personIp");
    	if(personIp!=null){
    		bean.setPersonIp(personIp);
    	}
		// 捐赠人性别
    	String personSex = request.getParameter("personSex");
    	if(personSex!=null && ("1".equals(personSex) || "2".equals(personSex))){
    		bean.setPersonSex(personSex);
    	}
		// 捐赠人邮箱
    	String personEmail = request.getParameter("personEmail");
    	if(personEmail!=null){
    		bean.setPersonEmail(personEmail);
    	}
		// 捐赠人手机
    	String personPhone = request.getParameter("personPhone");
    	if(personPhone!=null){
    		bean.setPersonPhone(personPhone);
    	}
		// 捐赠人电话
    	String personTel = request.getParameter("personTel");
    	if(personTel!=null){
    		bean.setPersonTel(personTel);
    	}
		// 地址信息
    	// 地址邮编
    	String addressZip = request.getParameter("addressZip");
    	if(addressZip!=null){
    		bean.setAddressZip(addressZip);
    	}
    	// 地址省
    	String addressSheng = request.getParameter("addressSheng");
    	if(addressSheng!=null){
    		bean.setAddressSheng(addressSheng);
    	}
    	// 地址市
    	String addressShi = request.getParameter("addressShi");
    	if(addressShi!=null){
    		bean.setAddressShi(addressShi);
    	}
    	// 地址区
    	String addressQu = request.getParameter("addressQu");
    	if(addressQu!=null){
    		bean.setAddressQu(addressQu);
    	}
    	// 地址详情
    	String addressDetail = request.getParameter("addressDetail");
    	if(addressDetail!=null){
    		bean.setAddressDetail(addressDetail);
    	}
    	// 校友信息
    	// 是否校友
    	String alumniFlag = request.getParameter("alumniFlag");
    	if(alumniFlag==null || !"1".equals(alumniFlag)){
    		alumniFlag = "0";
    	}
    	bean.setAlumniFlag(alumniFlag);
    	// 校友社区用户
    	TbUnAlumni beanUnAlumni = null;
    	String unAlumniId = request.getParameter("alumniUn");
    	if(unAlumniId!=null && !"".equals(unAlumniId)){
        	try{
        		beanUnAlumni = (TbUnAlumni)this.getCommonBo().get(TbUnAlumni.class,new Long(unAlumniId));
        	}catch(Exception e){}
        }
    	if(beanUnAlumni!=null){
    		bean.setUnAlumniId(beanUnAlumni.getUnAlumniId());
    	}
    	// 入学年
    	String studyYearin = request.getParameter("studyYearin");
    	if(studyYearin!=null){
        	bean.setStudyYearin(studyYearin);
    	}
    	// 离校年
    	String studyYearover = request.getParameter("studyYearover");
    	if(studyYearover!=null){
        	bean.setStudyYearover(studyYearover);
    	}
    	// 院系
    	String studyAcademy = request.getParameter("studyAcademy");
    	if(studyAcademy!=null){
        	bean.setStudyAcademy(studyAcademy);
    	}
    	// 专业
    	String studyMajor = request.getParameter("studyMajor");
    	if(studyMajor!=null){
        	bean.setStudyMajor(studyMajor);
    	}
    	// 班级
    	String studyClass = request.getParameter("studyClass");
    	if(studyClass!=null){
        	bean.setStudyClass(studyClass);
    	}
    	// 学号
    	String studyNum = request.getParameter("studyNum");
    	if(studyNum!=null){
        	bean.setStudyNum(studyNum);
    	}
    	// 学历（校友身份）
    	String studyDegree = request.getParameter("studyDegree");
    	if(studyDegree!=null){
        	bean.setStudyDegree(studyDegree);
    	}
    	// 工作信息
    	// 工作单位
    	String workCompany = request.getParameter("workCompany");
    	if(workCompany!=null){
        	bean.setWorkCompany(workCompany);
    	}
    	// 工作部门
    	String workDepart = request.getParameter("workDepart");
    	if(workDepart!=null){
        	bean.setWorkDepart(workDepart);
    	}
    	// 工作职能
    	String workDuty = request.getParameter("workDuty");
    	if(workDuty!=null){
        	bean.setWorkDuty(workDuty);
    	}
    	// 捐赠单备注信息
    	String orderMemo = request.getParameter("orderMemo");
    	if(orderMemo!=null){
        	bean.setOrderMemo(orderMemo);
    	}
        // 保存
    	try{
    		bean = (TbZcotherOrder)this.getCommonBo().save(bean);
            // 单号
    		String orderNum = bean.getOrderId().toString();
    		int orderLen = orderNum.length();
            for(int i=0; i<17-orderLen; i++){  
            	orderNum = "0"+orderNum;  
            }
            orderNum = DateUtil.format(dateNow,"yyyyMMdd")+"002"+orderNum;
            bean.setOrderNum(orderNum);
            bean = (TbZcotherOrder)this.getCommonBo().update(bean);
    		request.setAttribute("bean", bean);
    		// 返回
        	return SUCCESS;
    	}catch(Exception e){}
		// 返回状态：保存失败
		request.setAttribute("result", "failure");
		// 返回
    	return ERROR;
	}
	
	// 其他众筹项目捐赠单更新编辑
	public String update() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = null;
		// 其他众筹项目捐赠单ID
		String orderId = request.getParameter("id");
		if(orderId!=null && !"".equals(orderId)){
			try{
				bean = (TbZcotherOrder)this.getCommonBo().getEvict(TbZcotherOrder.class, new Long(orderId));
			}catch(Exception e){}
		}
		if(bean==null){
    		// 返回状态：参数错误
    		request.setAttribute("result", "error");
    		// 返回
        	return ERROR;
		}
		// 待付款捐赠单，方可修改更新相关信息
		if(bean.getOrderStatus()==null || !"1".equals(bean.getOrderStatus())){
	        // 其他众筹项目
	        String projName = request.getParameter("projName");
	        if(projName!=null){
	        	if("".equals(projName)){
	            	// 返回状态：参数错误
	            	request.setAttribute("result", "projError");
	            	// 返回
	            	return ERROR;
	            }
		        bean.setProjName(projName);
	        }
	        // 其他众筹项目详情URL
	        String projUrl = request.getParameter("projUrl");
	        if(projUrl!=null){
	        	bean.setProjUrl(projUrl);
	        }
			// 捐赠单总金额
			String orderAmout = request.getParameter("orderAmout");
			if(orderAmout!=null){
				if("".equals(orderAmout)){
					// 返回状态：参数错误
					request.setAttribute("result", "orderAmoutError");
					// 返回
					return ERROR;
				}
				BigDecimal orderAmoutD = null;
				try{
					orderAmoutD = new BigDecimal(orderAmout).setScale(2, 4);
				}catch(Exception e){}
				if(orderAmoutD==null || orderAmoutD.doubleValue()<=0){
					// 返回状态：参数错误
					request.setAttribute("result", "orderAmoutError");
					// 返回
					return ERROR;
				}
				bean.setOrderAmount(orderAmoutD);
			}
	        // 捐赠币种
	        bean.setOrderAmountType("人民币");
	        // 捐赠币种金额
	        bean.setOrderAmountView(bean.getOrderAmount());
	        // 捐赠币种金额计量单位
	        bean.setOrderAmountUnit("元");
	        // 捐赠单支付方式
	    	String orderType = request.getParameter("orderType");
	    	if(orderType!=null){
	    		bean.setOrderType(orderType);
	    	}
	    	// 是否更新捐赠单提交时间
			String orderTimeUpdate = request.getParameter("orderTimeUpdate");
			if(orderTimeUpdate!=null && ("1".equals(orderTimeUpdate) || "true".equals(orderTimeUpdate))){
				// 系统当前时间
				Date dateNow = this.getCommonBo().getSysDate();
		    	bean.setOrderTime(dateNow);
			}
	        // 捐赠是否需要证书
	    	String needZhengshu = request.getParameter("needZhengshu");
	    	if(needZhengshu!=null){
	    		if(!"1".equals(needZhengshu)){
	        		needZhengshu = "0";
	        	}
	    		bean.setNeedZhengshu(needZhengshu);
	    	}
	        // 捐赠是否需要发票
	    	String needFapiao = request.getParameter("needFapiao");
	    	if(needFapiao!=null){
	    		if(!"1".equals(needFapiao)){
	    			needFapiao = "0";
	        	}
	    		bean.setNeedFapiao(needFapiao);
	    	}
			// 捐赠人信息
			// 捐赠人姓名
	    	String personName = request.getParameter("personName");
	    	if(personName!=null){
	    		if("".equals(personName)){
	    			personName = "匿名";
	    		}
	    		bean.setPersonName(personName);
	    	}
			// 匿名捐赠
	    	String niMing = request.getParameter("niMing");
	    	if(niMing!=null){
	    		if(!"1".equals(niMing)){
	    			niMing = "0";
	        	}
	    		bean.setNiMing(niMing);
	    	}
			// 捐赠人IP
	    	String personIp = request.getParameter("personIp");
	    	if(personIp!=null){
	    		bean.setPersonIp(personIp);
	    	}
			// 捐赠人性别
	    	String personSex = request.getParameter("personSex");
	    	if(personSex!=null && ("1".equals(personSex) || "2".equals(personSex))){
	    		bean.setPersonSex(personSex);
	    	}
			// 捐赠人邮箱
	    	String personEmail = request.getParameter("personEmail");
	    	if(personEmail!=null){
	    		bean.setPersonEmail(personEmail);
	    	}
			// 捐赠人手机
	    	String personPhone = request.getParameter("personPhone");
	    	if(personPhone!=null){
	    		bean.setPersonPhone(personPhone);
	    	}
			// 捐赠人电话
	    	String personTel = request.getParameter("personTel");
	    	if(personTel!=null){
	    		bean.setPersonTel(personTel);
	    	}
			// 地址信息
	    	// 地址邮编
	    	String addressZip = request.getParameter("addressZip");
	    	if(addressZip!=null){
	    		bean.setAddressZip(addressZip);
	    	}
	    	// 地址省
	    	String addressSheng = request.getParameter("addressSheng");
	    	if(addressSheng!=null){
	    		bean.setAddressSheng(addressSheng);
	    	}
	    	// 地址市
	    	String addressShi = request.getParameter("addressShi");
	    	if(addressShi!=null){
	    		bean.setAddressShi(addressShi);
	    	}
	    	// 地址区
	    	String addressQu = request.getParameter("addressQu");
	    	if(addressQu!=null){
	    		bean.setAddressQu(addressQu);
	    	}
	    	// 地址详情
	    	String addressDetail = request.getParameter("addressDetail");
	    	if(addressDetail!=null){
	    		bean.setAddressDetail(addressDetail);
	    	}
	    	// 校友信息
	    	// 是否校友
	    	String alumniFlag = request.getParameter("alumniFlag");
	    	if(alumniFlag!=null){
	    		if(!"1".equals(alumniFlag)){
	    			alumniFlag = "0";
	        	}
	    		bean.setAlumniFlag(alumniFlag);
	    	}
	    	// 入学年
	    	String studyYearin = request.getParameter("studyYearin");
	    	if(studyYearin!=null){
	        	bean.setStudyYearin(studyYearin);
	    	}
	    	// 离校年
	    	String studyYearover = request.getParameter("studyYearover");
	    	if(studyYearover!=null){
	        	bean.setStudyYearover(studyYearover);
	    	}
	    	// 院系
	    	String studyAcademy = request.getParameter("studyAcademy");
	    	if(studyAcademy!=null){
	        	bean.setStudyAcademy(studyAcademy);
	    	}
	    	// 专业
	    	String studyMajor = request.getParameter("studyMajor");
	    	if(studyMajor!=null){
	        	bean.setStudyMajor(studyMajor);
	    	}
	    	// 班级
	    	String studyClass = request.getParameter("studyClass");
	    	if(studyClass!=null){
	        	bean.setStudyClass(studyClass);
	    	}
	    	// 学号
	    	String studyNum = request.getParameter("studyNum");
	    	if(studyNum!=null){
	        	bean.setStudyNum(studyNum);
	    	}
	    	// 学历（校友身份）
	    	String studyDegree = request.getParameter("studyDegree");
	    	if(studyDegree!=null){
	        	bean.setStudyDegree(studyDegree);
	    	}
	    	// 工作信息
	    	// 工作单位
	    	String workCompany = request.getParameter("workCompany");
	    	if(workCompany!=null){
	        	bean.setWorkCompany(workCompany);
	    	}
	    	// 工作部门
	    	String workDepart = request.getParameter("workDepart");
	    	if(workDepart!=null){
	        	bean.setWorkDepart(workDepart);
	    	}
	    	// 工作职能
	    	String workDuty = request.getParameter("workDuty");
	    	if(workDuty!=null){
	        	bean.setWorkDuty(workDuty);
	    	}
		}
		// 无视捐赠单状态，满足条件即可更新
    	// 校友社区用户
    	TbUnAlumni beanUnAlumni = null;
    	String unAlumniId = request.getParameter("alumniUn");
    	if(unAlumniId!=null && !"".equals(unAlumniId)){
        	try{
        		beanUnAlumni = (TbUnAlumni)this.getCommonBo().get(TbUnAlumni.class,new Long(unAlumniId));
        	}catch(Exception e){}
        }
    	if(beanUnAlumni!=null){
    		bean.setUnAlumniId(beanUnAlumni.getUnAlumniId());
    	}
    	// 捐赠单备注信息
    	String orderMemo = request.getParameter("orderMemo");
    	if(orderMemo!=null){
        	bean.setOrderMemo(orderMemo);
    	}
    	// 捐赠单回执信息
    	String receipt = request.getParameter("receipt");
    	if(receipt!=null){
        	bean.setReceipt(receipt);
    	}
        // 保存
    	try{
    		bean = (TbZcotherOrder)this.getCommonBo().update(bean);
    		request.setAttribute("bean", bean);
    		// 返回
        	return SUCCESS;
    	}catch(Exception e){}
		// 返回状态：保存失败
		request.setAttribute("result", "failure");
		// 返回
    	return ERROR;
	}
	
	// 其他众筹项目捐赠单付款状态修改为已付款
	public String setStatusOk() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = null;
		// 其他众筹项目捐赠单ID
		String orderId = request.getParameter("id");
		if(orderId!=null && !"".equals(orderId)){
			try{
				bean = (TbZcotherOrder)this.getCommonBo().getEvict(TbZcotherOrder.class, new Long(orderId));
			}catch(Exception e){}
		}
		if(bean==null){
    		// 返回状态：参数错误
    		request.setAttribute("result", "error");
    		// 返回
        	return ERROR;
		}
		if(bean.getOrderStatus()!=null && "1".equals(bean.getOrderStatus())){
    		// 返回状态：已付款
    		request.setAttribute("result", "payed");
    		// 返回
        	return ERROR;
		}
		try{
			// 支付方式
			String orderType = request.getParameter("orderType");
			if(orderType!=null && !"".equals(orderType)){
				bean.setOrderType(orderType);
			}
			// 捐赠单状态修改为已付款
			bean.setOrderStatus("1");
			// 系统时间
			Date dateNow = this.getCommonBo().getSysDate();
			// 捐赠单付款完成时间
			bean.setOrderOkTime(dateNow);
			// 保存
    		bean = (TbZcotherOrder)this.getCommonBo().update(bean);
    		request.setAttribute("bean", bean);
    		// 返回
        	return SUCCESS;
    	}catch(Exception e){}
		// 返回状态：保存失败
		request.setAttribute("result", "failure");
		// 返回
    	return ERROR;
	}
	
	// 其他众筹项目捐赠单添加回执信息
	public String addReceipt() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = null;
		// 其他众筹项目捐赠单ID
		String orderId = request.getParameter("id");
		if(orderId!=null && !"".equals(orderId)){
			try{
				bean = (TbZcotherOrder)this.getCommonBo().getEvict(TbZcotherOrder.class, new Long(orderId));
			}catch(Exception e){}
		}
		if(bean==null){
    		// 返回状态：参数错误
    		request.setAttribute("result", "error");
    		// 返回
        	return ERROR;
		}
		try{
			// 需要添加的回执信息
			String receipt = request.getParameter("receipt");
			if(receipt!=null && !"".equals(receipt)){
				String receiptOld = bean.getReceipt();
				if(receiptOld==null){
					receiptOld = "";
				}
				// 回执信息追加位置
				String position = request.getParameter("position");
				if(position==null || !"top".equals(position)){
					bean.setReceipt(receiptOld+receipt);
				}else{
					bean.setReceipt(receipt+receiptOld);
				}
				// 保存
	    		bean = (TbZcotherOrder)this.getCommonBo().update(bean);
	    		request.setAttribute("bean", bean);
			}
    		// 返回
        	return SUCCESS;
    	}catch(Exception e){}
		// 返回状态：保存失败
		request.setAttribute("result", "failure");
		// 返回
    	return ERROR;
	}
	
	// 其他众筹项目待付款状态捐赠单删除
	public String delete() throws Exception {
		HttpServletRequest request = this.getRequest();
		// 其他众筹项目捐赠单
		TbZcotherOrder bean = null;
		// 其他众筹项目捐赠单ID
		String orderId = request.getParameter("id");
		if(orderId!=null && !"".equals(orderId)){
			try{
				bean = (TbZcotherOrder)this.getCommonBo().get(TbZcotherOrder.class, new Long(orderId));
			}catch(Exception e){}
		}
		if(bean==null){
    		// 返回状态：参数错误
    		request.setAttribute("result", "error");
    		// 返回
        	return ERROR;
		}
		if(bean.getOrderStatus()!=null && "1".equals(bean.getOrderStatus())){
    		// 返回状态：已付款
    		request.setAttribute("result", "payed");
    		// 返回
        	return ERROR;
		}
		try{
			// 删除
			this.getCommonBo().delete(bean);
    		request.setAttribute("bean", bean);
    		// 返回
        	return SUCCESS;
    	}catch(Exception e){}
		// 返回状态：删除失败
		request.setAttribute("result", "failure");
		// 返回
    	return ERROR;
	}
}