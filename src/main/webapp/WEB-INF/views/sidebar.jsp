<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--begin::Aside-->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="userDashboard">
		<div class="sidebar-brand-icon">
		</div>
		<div class="sidebar-brand-text mx-3">
			<img src="${pageContext.request.contextPath}/app-assets/img/TheShoppe-Footer-Logo.png" alt="The Shoppe">
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item active"><a class="nav-link" href="userDashboard">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>

	<hr class="sidebar-divider">

	<!-- Heading -->
	<div class="sidebar-heading">Addons</div>

	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item"><a class="nav-link" href="pendingInvoice"> <i
			class="fas fa-fw fa-table"></i> <span>Pending Invoice</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>