<%@ page language="java" pageEncoding="UTF-8"%><%@ include file="../common/include.jsp"%><% String basePath = request.getScheme()+"://"+request.getServerName(); if(("http".equals(request.getScheme().toLowerCase()) && request.getServerPort()==80) || ("https".equals(request.getScheme().toLowerCase()) && request.getServerPort()==443)){ basePath += request.getContextPath()+"/"; }else{ basePath += ":"+request.getServerPort()+request.getContextPath()+"/"; } %>
{
	result:'success',
	count:'<c:out value="${count}"/>',
	page:'<c:out value="${page}"/>',
	<c:choose>
	<c:when test="${page=='1'}">
	pageSize:'<c:out value="${pageSize}"/>',
	pageCount:'<c:out value="${pageCount}"/>',
	pageNum:'<c:out value="${pageNum}"/>',
	</c:when>
	<c:otherwise>
	num:'<c:out value="${num}"/>',
	size:'<c:out value="${size}"/>',
	</c:otherwise>
	</c:choose>
	type:'<c:out value="${type}"/>',
	alumniUn:'<c:out value="${alumniUn}"/>',
	orderStatus:'<c:out value="${orderStatus}"/>',
	order:'<c:out value="${order}"/>',
	orderType:'<c:out value="${orderType}"/>',
	list:[
	<c:forEach items="${beanList}" var="temp" varStatus="status">
	<c:set var="tempDetail" value="${temp.tbOrder}"/>
	<c:if test="${status.index>0}">,</c:if>
	{
		type:'<c:out value="${temp.orderType}"/>',
		<c:choose>
		<c:when test="${temp.orderType=='proj'}">
			id:'<c:out value="${tempDetail.orderId}"/>',
			proj:'<c:out value="${tempDetail.projId}"/>',
			projName:'<c:out value="${tempDetail.projName}"/>',
			projPic:'<c:if test="${not empty tempDetail.projPic}"><%=basePath%><c:out value="${tempDetail.projPic}"/></c:if>',
			option:'<c:out value="${tempDetail.optionId}"/>',
			optionName:'<c:out value="${tempDetail.optionName}"/>',
			optionCount:'<fmt:formatNumber value="${tempDetail.optionCount}" pattern="0" type="number"/>',
			orderAmountType:'<c:out value="${tempDetail.orderAmountType}"/>',
			orderAmountView:'<fmt:formatNumber value="${tempDetail.orderAmountView}" pattern="0.##" type="number"/>',
			orderAmountUnit:'<c:out value="${tempDetail.orderAmountUnit}"/>',
			orderAmount:'<fmt:formatNumber value="${tempDetail.orderAmount}" pattern="0.##" type="number"/>',
			orderNo:'<c:out value="${tempDetail.orderNum}"/>',
			orderType:'<c:out value="${tempDetail.orderType}"/>',
			orderStatus:'<c:out value="${tempDetail.orderStatus}"/>',
			orderTime:'<fmt:formatDate value="${tempDetail.orderTime}" pattern="yyyy-MM-dd HH:mm"/>',
			orderOkTime:'<fmt:formatDate value="${tempDetail.orderOkTime}" pattern="yyyy-MM-dd HH:mm"/>',
			suportIndex:'<c:out value="${tempDetail.suportIndex}"/>',
			needZhengshu:'<c:out value="${tempDetail.needZhengshu}"/>',
			needFapiao:'<c:out value="${tempDetail.needFapiao}"/>',
			personType:'<c:out value="${tempDetail.personType}"/>',
			personCount:'<c:out value="${tempDetail.personCount}" default="1"/>',
			personName:'<c:out value="${tempDetail.personName}"/>',
			niMing:'<c:out value="${tempDetail.niMing}" default="0"/>',
			personIp:'<c:out value="${tempDetail.personIp}"/>',
			personSex:'<c:out value="${tempDetail.personSex}"/>',
			personEmail:'<c:out value="${tempDetail.personEmail}"/>',
			personPhone:'<c:out value="${tempDetail.personPhone}"/>',
			personTel:'<c:out value="${tempDetail.personTel}"/>',
			addressZip:'<c:out value="${tempDetail.addressZip}"/>',
			addressDetail:'<c:if test="${not empty tempDetail.addressSheng}"><c:out value="${tempDetail.addressSheng}"/>（省）</c:if><c:if test="${not empty tempDetail.addressShi}"><c:out value="${tempDetail.addressShi}"/>（市）</c:if><c:if test="${not empty tempDetail.addressQu}"><c:out value="${tempDetail.addressQu}"/>（区）</c:if><c:if test="${not empty tempDetail.addressDetail}"><c:out value="${tempDetail.addressDetail}"/></c:if>',
			alumniFlag:'<c:out value="${tempDetail.alumniFlag}"/>',
			alumniUn:'<c:out value="${tempDetail.unAlumniId}"/>',
			studyYearin:'<c:out value="${tempDetail.studyYearin}"/>',
			studyYearover:'<c:out value="${tempDetail.studyYearover}"/>',
			studyAcademy:'<c:out value="${tempDetail.studyAcademy}"/>',
			studyMajor:'<c:out value="${tempDetail.studyMajor}"/>',
			studyClass:'<c:out value="${tempDetail.studyClass}"/>',
			studyNum:'<c:out value="${tempDetail.studyNum}"/>',
			studyDegree:'<c:out value="${tempDetail.studyDegree}"/>',
			workCompany:'<c:out value="${tempDetail.workCompany}"/>',
			workDepart:'<c:out value="${tempDetail.workDepart}"/>',
			workDuty:'<c:out value="${tempDetail.workDuty}"/>',
			orderMemo:'<my:escapeHtml value="${tempDetail.orderMemo}" removeTarget="false" changePath="false"/>',
			receipt:'<my:escapeHtml value="${tempDetail.receipt}" removeTarget="false" changePath="true"/>'
		</c:when>
		<c:when test="${temp.orderType=='other'}">
			id:'<c:out value="${tempDetail.orderId}"/>',
			projName:'<c:out value="${tempDetail.projName}"/>',
			projUrl:'<c:out value="${tempDetail.projUrl}"/>',
			orderAmountType:'<c:out value="${tempDetail.orderAmountType}"/>',
			orderAmountView:'<fmt:formatNumber value="${tempDetail.orderAmountView}" pattern="0.##" type="number"/>',
			orderAmountUnit:'<c:out value="${tempDetail.orderAmountUnit}"/>',
			orderAmount:'<fmt:formatNumber value="${tempDetail.orderAmount}" pattern="0.##" type="number"/>',
			orderNo:'<c:out value="${tempDetail.orderNum}"/>',
			orderType:'<c:out value="${tempDetail.orderType}"/>',
			orderStatus:'<c:out value="${tempDetail.orderStatus}"/>',
			orderTime:'<fmt:formatDate value="${tempDetail.orderTime}" pattern="yyyy-MM-dd HH:mm"/>',
			orderOkTime:'<fmt:formatDate value="${tempDetail.orderOkTime}" pattern="yyyy-MM-dd HH:mm"/>',
			suportIndex:'<c:out value="${tempDetail.suportIndex}"/>',
			needZhengshu:'<c:out value="${tempDetail.needZhengshu}"/>',
			needFapiao:'<c:out value="${tempDetail.needFapiao}"/>',
			personType:'<c:out value="${tempDetail.personType}"/>',
			personCount:'<c:out value="${tempDetail.personCount}" default="1"/>',
			personName:'<c:out value="${tempDetail.personName}"/>',
			niMing:'<c:out value="${tempDetail.niMing}" default="0"/>',
			personIp:'<c:out value="${tempDetail.personIp}"/>',
			personSex:'<c:out value="${tempDetail.personSex}"/>',
			personEmail:'<c:out value="${tempDetail.personEmail}"/>',
			personPhone:'<c:out value="${tempDetail.personPhone}"/>',
			personTel:'<c:out value="${tempDetail.personTel}"/>',
			addressZip:'<c:out value="${tempDetail.addressZip}"/>',
			addressDetail:'<c:if test="${not empty tempDetail.addressSheng}"><c:out value="${tempDetail.addressSheng}"/>（省）</c:if><c:if test="${not empty tempDetail.addressShi}"><c:out value="${tempDetail.addressShi}"/>（市）</c:if><c:if test="${not empty tempDetail.addressQu}"><c:out value="${tempDetail.addressQu}"/>（区）</c:if><c:if test="${not empty tempDetail.addressDetail}"><c:out value="${tempDetail.addressDetail}"/></c:if>',
			alumniFlag:'<c:out value="${tempDetail.alumniFlag}"/>',
			alumniUn:'<c:out value="${tempDetail.unAlumniId}"/>',
			studyYearin:'<c:out value="${tempDetail.studyYearin}"/>',
			studyYearover:'<c:out value="${tempDetail.studyYearover}"/>',
			studyAcademy:'<c:out value="${tempDetail.studyAcademy}"/>',
			studyMajor:'<c:out value="${tempDetail.studyMajor}"/>',
			studyClass:'<c:out value="${tempDetail.studyClass}"/>',
			studyNum:'<c:out value="${tempDetail.studyNum}"/>',
			studyDegree:'<c:out value="${tempDetail.studyDegree}"/>',
			workCompany:'<c:out value="${tempDetail.workCompany}"/>',
			workDepart:'<c:out value="${tempDetail.workDepart}"/>',
			workDuty:'<c:out value="${tempDetail.workDuty}"/>',
			orderMemo:'<my:escapeHtml value="${tempDetail.orderMemo}" removeTarget="false" changePath="false"/>',
			receipt:'<my:escapeHtml value="${tempDetail.receipt}" removeTarget="false" changePath="true"/>'
		</c:when>
		<c:when test="${temp.orderType=='comm'}">
			id:'<c:out value="${tempDetail.orderId}"/>',
			comm:'<c:out value="${tempDetail.commId}"/>',
			commName:'<c:out value="${tempDetail.commName}"/>',
			commPic:'<c:if test="${not empty tempDetail.commPic}"><%=basePath%><c:out value="${tempDetail.commPic}"/></c:if>',
			option:'<c:out value="${tempDetail.commDetailId}"/>',
			optionName:'<c:out value="${tempDetail.commDetailName}"/>',
			optionCostfee:'<fmt:formatNumber value="${tempDetail.commCostfee}" pattern="0.##" type="number"/>',
			optionSalefee:'<fmt:formatNumber value="${tempDetail.commSalefee}" pattern="0.##" type="number"/>',
			optionCount:'<fmt:formatNumber value="${tempDetail.commNum}" pattern="0" type="number"/>',
			shipType:'<c:out value="${tempDetail.shippingType}"/>',
			shipFee:'<fmt:formatNumber value="${tempDetail.shippingFee}" pattern="0.##" type="number"/>',
			shipCurFee:'<fmt:formatNumber value="${tempDetail.shippingCurfee}" pattern="0.##" type="number"/>',
			donationFee:'<fmt:formatNumber value="${tempDetail.donationFee}" pattern="0.##" type="number"/>',
			orderAmount:'<fmt:formatNumber value="${tempDetail.orderFee}" pattern="0.##" type="number"/>',
			orderNo:'<c:out value="${tempDetail.orderNo}"/>',
			orderSource:'<c:out value="${tempDetail.orderSource}"/>',
			orderType:'<c:out value="${tempDetail.orderType}"/>',
			orderStatus:'<c:out value="${tempDetail.orderStatus}"/>',
			orderTime:'<fmt:formatDate value="${tempDetail.orderTime}" pattern="yyyy-MM-dd HH:mm"/>',
			orderOkTime:'<fmt:formatDate value="${tempDetail.orderOkTime}" pattern="yyyy-MM-dd HH:mm"/>',
			suportIndex:'<c:out value="${tempDetail.suportIndex}"/>',
			personName:'<c:out value="${tempDetail.buyerName}"/>',
			niMing:'<c:out value="${tempDetail.niMing}" default="0"/>',
			personIp:'<c:out value="${tempDetail.buyerIp}"/>',
			personSex:'<c:out value="${tempDetail.buyerSex}"/>',
			personEmail:'<c:out value="${tempDetail.buyerEmail}"/>',
			personPhone:'<c:out value="${tempDetail.buyerMobile}"/>',
			personTel:'<c:out value="${tempDetail.buyerPhone}"/>',
			addressZip:'<c:out value="${tempDetail.buyerZipcode}"/>',
			addressDetail:'<c:if test="${not empty tempDetail.buyerSheng}"><c:out value="${tempDetail.buyerSheng}"/>（省）</c:if><c:if test="${not empty tempDetail.buyerShi}"><c:out value="${tempDetail.buyerShi}"/>（市）</c:if><c:if test="${not empty tempDetail.buyerQu}"><c:out value="${tempDetail.buyerQu}"/>（区）</c:if><c:if test="${not empty tempDetail.buyerAddress}"><c:out value="${tempDetail.buyerAddress}"/></c:if>',
			alumniFlag:'<c:out value="${tempDetail.alumniFlag}"/>',
			alumniUn:'<c:out value="${tempDetail.unAlumniId}"/>',
			studyYearin:'<c:out value="${tempDetail.studyYearin}"/>',
			studyYearover:'<c:out value="${tempDetail.studyYearover}"/>',
			studyAcademy:'<c:out value="${tempDetail.studyAcademy}"/>',
			studyMajor:'<c:out value="${tempDetail.studyMajor}"/>',
			studyClass:'<c:out value="${tempDetail.studyClass}"/>',
			studyNum:'<c:out value="${tempDetail.studyNum}"/>',
			studyDegree:'<c:out value="${tempDetail.studyDegree}"/>',
			workCompany:'<c:out value="${tempDetail.workCompany}"/>',
			workDepart:'<c:out value="${tempDetail.workDepart}"/>',
			workDuty:'<c:out value="${tempDetail.workDuty}"/>',
			orderMemo:'<my:escapeHtml value="${tempDetail.orderMemo}" removeTarget="false" changePath="false"/>',
			receipt:'<my:escapeHtml value="${tempDetail.receipt}" removeTarget="false" changePath="true"/>',
			starNum:'<fmt:formatNumber value="${tempDetail.starNum}" pattern="0" type="number"/>',
			starMemo:'<my:escapeHtml value="${tempDetail.starMemo}" removeTarget="false" changePath="false"/>',
			starTime:'<fmt:formatDate value="${tempDetail.starTime}" pattern="yyyy-MM-dd HH:mm"/>'
		</c:when>
		</c:choose>
	}
	</c:forEach>
	]
}