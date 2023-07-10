<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%-- <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %> --%>

   <!--begin::Aside-->
				<div class="aside aside-left aside-fixed d-flex flex-column flex-row-auto" id="kt_aside">
					<!--begin::Brand-->
					<div class="brand flex-column-auto" id="kt_brand">
					
						<!--begin::Logo-->
						<a href="dashboardDefiner" class="brand-logo  pt-6">
						<img class="img-fluid" alt="Logo" src="assets/media/logos/e-pharma_logo.png" /> 
						</a>
						<!--end::Logo-->
						
						<div class="favicon"><img src="assets/media/logos/e-pharma_favicon.png" /></div>

					</div>
					<!--end::Brand-->
					
					
					
					
			
					
					
					
					
					
					<!--begin::Aside Menu-->
					<div class="aside-menu-wrapper flex-column-fluid" id="kt_aside_menu_wrapper">
					<div>
						<input type="hidden" id="partyTypeSideBar" name="partyTypeSideBar" >
						</div>
						<!--begin::Menu Container-->
						<div id="kt_aside_menu" class="aside-menu my-4" data-menu-vertical="1" data-menu-scroll="1" data-menu-dropdown-timeout="500">
							<!--begin::Menu Nav-->
							
							<!--end::Menu Nav-->
							<ul class="menu-nav">
									<li id="profileCompanyDetailsPageLI"  class="menu-item" aria-haspopup="true">
										<a href="profileCompanyDetailsPage" class="menu-link">
											<i class="icon-xxl mr-4 la la-user-circle"></i>
											<span class="menu-text"> Profile  </span>
										</a>
									</li>
	
					
									<li class="menu-item" aria-haspopup="true">
										<a href="#" id="kt_quick_notifications_toggle" data-toggle="tooltip" data-placement="right" data-container="body" data-boundary="window" title="" class="menu-link">
											<!-- <i class="icon-xxl mr-4 far fa-bell"></i> -->
											<i class="icon-xl   ml-1 mr-4 fas fa-bell"></i>
											<span class="menu-text"> Notifications  </span>
											<span class="label label-sm label-danger  label-rounded font-weight-bolder position-absolute top-0  mt-2 ml-6 d-none" id="mainNotificationCount"></span>
										</a>
									</li>								

						
									<li class="menu-item  text-danger" aria-haspopup="true" data-menu-toggle="hover">
										<a href="javascript:void(0)" onclick="logout()" class="menu-link menu-toggle">
											<i class="icon-xxl mr-4 text-danger la la-power-off"></i>
											<span class="menu-text text-danger "> Sign Out </span>
										</a>
									</li>
							</ul>
						</div>
						
						<!--end::Menu Container-->
					</div>
					<!--end::Aside Menu-->
					
					<!--begin::Brand-->
					<div class="brand flex-column-auto pl-5" id="kt_brand">
				
						
						<span class="text-muted font-weight-bold mr-2 sidebar_copyright mb-4	"><i class="la la-copyright mt-1"></i>Topia Technologies </span>
						
				
						<!--begin::Toggle-->
						<button class="brand-toggle btn btn-sm px-0 pt-0"  id="kt_aside_toggle">
							<span class="svg-icon svg-icon svg-icon-xl">
								<!--begin::Svg Icon | path:assets/media/svg/icons/Navigation/Angle-double-left.svg-->
								<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="24px" height="24px" viewBox="0 0 24 24" version="1.1">
									<g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
										<polygon points="0 0 24 0 24 24 0 24" />
										<path d="M5.29288961,6.70710318 C4.90236532,6.31657888 4.90236532,5.68341391 5.29288961,5.29288961 C5.68341391,4.90236532 6.31657888,4.90236532 6.70710318,5.29288961 L12.7071032,11.2928896 C13.0856821,11.6714686 13.0989277,12.281055 12.7371505,12.675721 L7.23715054,18.675721 C6.86395813,19.08284 6.23139076,19.1103429 5.82427177,18.7371505 C5.41715278,18.3639581 5.38964985,17.7313908 5.76284226,17.3242718 L10.6158586,12.0300721 L5.29288961,6.70710318 Z" fill="#14c4bc" fill-rule="nonzero" transform="translate(8.999997, 11.999999) scale(-1, 1) translate(-8.999997, -11.999999)" />
										<path d="M10.7071009,15.7071068 C10.3165766,16.0976311 9.68341162,16.0976311 9.29288733,15.7071068 C8.90236304,15.3165825 8.90236304,14.6834175 9.29288733,14.2928932 L15.2928873,8.29289322 C15.6714663,7.91431428 16.2810527,7.90106866 16.6757187,8.26284586 L22.6757187,13.7628459 C23.0828377,14.1360383 23.1103407,14.7686056 22.7371482,15.1757246 C22.3639558,15.5828436 21.7313885,15.6103465 21.3242695,15.2371541 L16.0300699,10.3841378 L10.7071009,15.7071068 Z" fill="#14c4bc" fill-rule="nonzero" opacity="0.3" transform="translate(15.999997, 11.999999) scale(-1, 1) rotate(-270.000000) translate(-15.999997, -11.999999)" />
									</g>
								</svg>
								<!--end::Svg Icon-->
							</span>
						</button>
						<!--end::Toolbar-->
					</div>
					<!--end::Brand-->
					
				</div>
				<!--end::Aside-->
				
				 <!-- Start Pre-loader -->
				  <div id="preLoader" class="pre-loader-wrap" style="display: none !important;">
				    <div class="pre-loader triangle">
				      <svg viewBox="0 0 86 80">
				        <polygon points="43 8 79 72 7 72"></polygon>
				      </svg>
				      <!-- <span>Loading...</span> -->
				    </div>
				  </div>
				  <!-- End Pre-loader -->
				
				
				
				
				
						<!-- begin::Notifications Panel-->
		<div id="kt_quick_notifications" class="offcanvas offcanvas-left p-10">
			<!--begin::Header-->
			<div class="offcanvas-header d-flex align-items-center justify-content-between mb-10">
				<h3 class="font-weight-bold m-0">Notifications
				<small class="text-muted font-size-sm ml-2" id="mainInnerCount"></small></h3>
				<a href="javascript:void(0)" class="btn btn-light btn-hover-primary	" id="kt_quick_notifications_close">
					Close
				</a>
			</div>
			<!--end::Header-->
			<!--begin::Content-->
			
			<div id='manNotificationContent'>
			</div>
			
			<!--end::Content-->
			<div class="" id="clearAllNotificationBtn">
				<a href="javascript:void(0)"	class="btn btn-light-danger btn-hover-danger"	onclick='removeAllNotification();'>Clear</a>
			</div>
		</div>
		<!-- end::Notifications Panel-->
				

	

		


		
   